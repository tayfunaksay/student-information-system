package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.detail.CreateDetailRequest;
import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.detailservice.model.Detail;

import java.util.List;

public interface DetailMapper {
    DetailDto toDetailDto(Detail from);

    List<DetailDto> toDetailDtoList(List<Detail> from);

    Detail toDetail(CreateDetailRequest request);

    Detail toDetail(UpdateDetailRequest request);
}
