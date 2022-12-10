package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;

import java.util.List;

public interface DetailService {
    DetailDto create (CreateDetailRequest request);
    DetailDto delete (String detailId);
    DetailDto update (UpdateDetailRequest request);
    List<DetailDto> getAll();
    DetailDto getById(String detailId);
}
