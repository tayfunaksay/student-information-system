package com.studentinformationsystem.courseschedulingservice.utility.mapping.courseHour;

import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CreateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.UpdateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.model.CourseHour;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseHourConverter implements CourseHourMapper {
    @Override
    public CourseHourDto toCourseHourDto(CourseHour from) {
        return CourseHourDto.builder()
                .id(from.getId())
                .dayName(from.getDayName().getDayName())
                .hour(from.getHour().getHourName())
                .build();
    }

    @Override
    public List<CourseHourDto> toCourseHourDtoList(List<CourseHour> from) {
        return from.stream()
                .map(courseHour -> toCourseHourDto(courseHour))
                .collect(Collectors.toList());
    }

    @Override
    public CourseHour toCourseHour(CreateCourseHourRequest request) {
        return CourseHour.builder()
                .dayName(request.getDayName())
                .hour(request.getHour())
                .build();
    }

    @Override
    public CourseHour toCourseHour(UpdateCourseHourRequest request) {
        return CourseHour.builder()
                .id(request.getId())
                .dayName(request.getDayName())
                .hour(request.getHour())
                .build();
    }
}
