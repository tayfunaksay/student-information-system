package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.detail.CreateDefaultDetailRequest;
import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;

public interface DetailService {
    String createDefaultDetail(CreateDefaultDetailRequest request);

    DetailDto update(UpdateDetailRequest request);

    DetailDto getById(String detailId);
}
