package com.studentinformationsystem.courseschedulingservice.utility.mapping.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.CreateDayOfWeekRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.DayOfWeekDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.UpdateDayOfWeekRequest;
import com.studentinformationsystem.courseschedulingservice.model.week.DayOfWeek;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DayOfWeekConverter implements DayOfWeekMapper {
    @Override
    public DayOfWeekDto toDayOfWeekDto(DayOfWeek from) {
        return DayOfWeekDto.builder()
                .id(from.getId())
                .name(from.getName())
                .whichDayOfWeek(from.getWhichDayOfWeek())
                .isAvailableForCourses(from.isAvailableForCourses())
                .build();
    }

    @Override
    public List<DayOfWeekDto> toDayOfWeekDtoList(List<DayOfWeek> from) {
        return from.stream()
                .map(day -> toDayOfWeekDto(day))
                .collect(Collectors.toList());
    }

    @Override
    public DayOfWeek toDayOfWeek(CreateDayOfWeekRequest request) {
        return DayOfWeek.builder()
                .name(request.getName())
                .whichDayOfWeek(request.getWhichDayOfWeek())
                .isAvailableForCourses(request.isAvailableForCourses())
                .build();
    }

    @Override
    public DayOfWeek toDayOfWeek(UpdateDayOfWeekRequest request) {
        return DayOfWeek.builder()
                .id(request.getId())
                .name(request.getName())
                .whichDayOfWeek(request.getWhichDayOfWeek())
                .isAvailableForCourses(request.isAvailableForCourses())
                .build();
    }
}
