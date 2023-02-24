package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.detail.CreateDefaultDetailRequest;
import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.detailservice.model.Detail;

public interface DetailMapper {
    DetailDto toDetailDto(Detail from);

    Detail toDefaultDetail(CreateDefaultDetailRequest request);

    Detail toDetail(UpdateDetailRequest request);
}
