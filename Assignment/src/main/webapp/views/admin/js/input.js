function validateRed(input) {
    // Lấy giá trị của trường nhập liệu và loại bỏ khoảng trắng thừa ở đầu và cuối chuỗi
    var ten = input.value.trim();

    // Kiểm tra xem trường nhập liệu có được điền đầy đủ hay không
    if (ten.length == 0) {
        // Thiết lập viền đỏ cho phần tử input
        input.style.borderColor = "red";
    } else {
        // Thiết lập lại màu viền cho phần tử input nếu đã điền đầy đủ
        input.style.borderColor = "";
    }
}


function validateForm(event, formId) {
    const form = document.getElementById(formId);
    let isValid = true;

    // Lặp qua các input và kiểm tra xem chúng có được điền đầy đủ thông tin không
    for (let i = 0; i < form.elements.length; i++) {
        const element = form.elements[i];
        switch (element.type) {
            case 'text':
            case 'email':
            case 'password':
                if (element.value.trim() === '') {
                    isValid = false;
                }
                break;
            case 'radio':
                if (!element.checked) {
                    isValid = false;
                }
                break;
            case 'select-one':
                if (element.value === 'false') {
                    isValid = false;
                }
                break;
            // Xử lý các loại input khác (nếu có)
            default:
                break;
        }
    }

    // Hiển thị thông báo nếu form không được điền đầy đủ thông tin
    if (!isValid) {
        alert('Vui lòng điền đầy đủ thông tin!');
        event.preventDefault(); // Ngăn chặn gửi form
    }

    return isValid;
}

function validateNumber(event) {
    var namSX = document.getElementsByName("namSX")[0];
    var soLuongTon = document.getElementsByName("soLuongTon")[0];
    var giaNhap = document.getElementsByName("giaNhap")[0];
    var giaBan = document.getElementsByName("giaBan")[0];
    if (namSX.value < 1 || soLuongTon.value < 1 || giaNhap.value < 1 || giaBan.value < 1) {
        alert("Giá trị số phải lớn hơn hoặc bằng 1!");
        event.preventDefault();
        return false;
    }
    return true;
}