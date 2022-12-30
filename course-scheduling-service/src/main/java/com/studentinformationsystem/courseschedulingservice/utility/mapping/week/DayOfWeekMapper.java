package com.studentinformationsystem.courseschedulingservice.utility.mapping.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.CreateDayOfWeekRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.DayOfWeekDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.UpdateDayOfWeekRequest;
import com.studentinformationsystem.courseschedulingservice.model.week.DayOfWeek;

import java.util.List;

public interface DayOfWeekMapper {
    DayOfWeekDto toDayOfWeekDto (DayOfWeek from);
    List<DayOfWeekDto> toDayOfWeekDtoList(List<DayOfWeek> from);
    DayOfWeek toDayOfWeek (CreateDayOfWeekRequest request);
    DayOfWeek toDayOfWeek (UpdateDayOfWeekRequest request);
}
