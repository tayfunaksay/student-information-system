package com.studentinformationsystem.courseschedulingservice.utility.mapping.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.hour.CreateHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.hour.HourDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.hour.UpdateHourRequest;
import com.studentinformationsystem.courseschedulingservice.model.week.Hour;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HourConverter implements HourMapper{
    @Override
    public HourDto toHourDto(Hour from) {
        return HourDto.builder()
                .id(from.getId())
                .name(from.getName())
                .whichHourOfDay(from.getWhichHourOfDay())
                .isAvailableForCourses(from.isAvailableForCourses())
                .build();
    }

    @Override
    public List<HourDto> toHourDtoList(List<Hour> from) {
        return from.stream()
                .map(hour -> toHourDto(hour))
                .collect(Collectors.toList());
    }

    @Override
    public Hour toHour(CreateHourRequest request) {
        return Hour.builder()
                .name(request.getName())
                .whichHourOfDay(request.getWhichHourOfDay())
                .isAvailableForCourses(request.isAvailableForCourses())
                .build();
    }

    @Override
    public Hour toHour(UpdateHourRequest request) {
        return Hour.builder()
                .name(request.getName())
                .whichHourOfDay(request.getWhichHourOfDay())
                .isAvailableForCourses(request.isAvailableForCourses())
                .build();
    }
}
