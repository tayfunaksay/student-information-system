package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.registrarservice.model.Detail;

import java.util.List;

public interface DetailMapper {
    DetailDto toDetailDto(Detail from);

    List<DetailDto> toDetailDtoList(List<Detail> from);

    Detail toDetail(CreateDetailRequest request);

    Detail toDetail(UpdateDetailRequest request);
}
