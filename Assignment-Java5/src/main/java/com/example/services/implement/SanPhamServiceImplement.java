package com.example.services.implement;

import com.example.entities.SanPham;
import com.example.infrastructure.converter.SanPhamConvert;
import com.example.infrastructure.request.SanPhamRequest;
import com.example.models.SanPhamViewModel;
import com.example.repositories.SanPhamRepository;
import com.example.services.SanPhamService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImplement implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamConvert sanPhamConvert;

    private SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();

    @Override
    public List<SanPhamViewModel> findAll() {
        return sanPhamConvert.mapEntityListToViewModelList(sanPhamRepository.findAll());
    }

    private String encodeImageToBase64(MultipartFile file) throws IOException {
        byte[] fileContent = file.getBytes();
        return Base64.encodeBase64String(fileContent);
    }

    @Override
    public void saveOrUpdate(SanPhamRequest sanPhamRequest, MultipartFile file) {
        try {
            // Chuyển đổi ảnh thành chuỗi base64
            String base64Image = encodeImageToBase64(file);

            // Lưu chuỗi base64 vào cơ sở dữ liệu
            SanPham sanPham = sanPhamConvert.requestToEntity(sanPhamRequest);
            sanPham.setAnh("data:image/png;base64," + base64Image);
            if (sanPhamRequest.getId() != null && sanPhamRepository.existsById(sanPhamRequest.getId())) {
                sanPhamRepository.save(sanPham);
            } else {
                sanPham.setMa(serialNumberGenerator.generateSerialNumber());
                sanPhamRepository.save(sanPham);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPhamViewModel findById(UUID id) {
        Optional<SanPham> optional = sanPhamRepository.findById(id);
        if (optional.isPresent()) {
            return sanPhamConvert.mapToViewModel(optional.get());
        } else {
            return null;
        }
    }
}
