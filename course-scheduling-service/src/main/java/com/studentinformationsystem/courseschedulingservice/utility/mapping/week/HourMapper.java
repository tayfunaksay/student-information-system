package com.studentinformationsystem.courseschedulingservice.utility.mapping.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.hour.CreateHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.hour.HourDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.hour.UpdateHourRequest;
import com.studentinformationsystem.courseschedulingservice.model.week.Hour;

import java.util.List;

public interface HourMapper {
    HourDto toHourDto (Hour from);
    List<HourDto> toHourDtoList(List<Hour> from);
    Hour toHour (CreateHourRequest request);
    Hour toHour (UpdateHourRequest request);
}
