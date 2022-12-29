package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;

import java.util.List;

public interface DetailService {
    String createDefaultDetail();

    //void delete(String detailId);

    DetailDto update(UpdateDetailRequest request);

    List<DetailDto> getAll();

    DetailDto getById(String detailId);
}
