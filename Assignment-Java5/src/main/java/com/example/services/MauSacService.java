package com.example.services;

import com.example.models.MauSacViewModel;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    public List<MauSacViewModel> findAll();
    public void saveOrUpdate(MauSacViewModel mauSacViewModel);
    public void deleteById(UUID id);
    public MauSacViewModel findById(UUID id);
}
