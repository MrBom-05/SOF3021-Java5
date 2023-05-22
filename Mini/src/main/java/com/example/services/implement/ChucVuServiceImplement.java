package com.example.services.implement;

import com.example.repositories.ChucVuRepository;
import com.example.services.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChucVuServiceImplement implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;
}
