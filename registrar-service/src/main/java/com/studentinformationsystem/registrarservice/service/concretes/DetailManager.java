package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.registrarservice.service.DetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailManager implements DetailService {
    @Override
    public DetailDto create(CreateDetailRequest request) {
        return null;
    }

    @Override
    public DetailDto delete(String detailId) {
        return null;
    }

    @Override
    public DetailDto update(UpdateDetailRequest request) {
        return null;
    }

    @Override
    public List<DetailDto> getAll() {
        return null;
    }

    @Override
    public DetailDto getById(String detailId) {
        return null;
    }
}
