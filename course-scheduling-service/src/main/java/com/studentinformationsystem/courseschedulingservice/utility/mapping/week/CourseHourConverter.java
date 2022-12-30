package com.studentinformationsystem.courseschedulingservice.utility.mapping.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.CreateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.UpdateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.model.week.CourseHour;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseHourConverter implements CourseHourMapper {
    @Override
    public CourseHourDto toCourseHourDto(CourseHour from) {
        return CourseHourDto.builder()
                .id(from.getId())
                .dayOfWeek(from.getDayOfWeek())
                .hour(from.getHour())
                .isAvailable(from.getHour().isAvailableForCourses()||from.getDayOfWeek().isAvailableForCourses())
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
                .dayOfWeek(request.getDay())
                .hour(request.getHour())
                .isAvailable(request.getHour().isAvailableForCourses()||request.getDay().isAvailableForCourses())
                .build();
    }

    @Override
    public CourseHour toCourseHour(UpdateCourseHourRequest request) {
        return CourseHour.builder()
                .id(request.getId())
                .dayOfWeek(request.getDay())
                .hour(request.getHour())
                .isAvailable(request.getHour().isAvailableForCourses()||request.getDay().isAvailableForCourses())
                .build();
    }
}
