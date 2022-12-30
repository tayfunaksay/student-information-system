package com.studentinformationsystem.courseschedulingservice.service.abstracts.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.CreateDayOfWeekRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.DayOfWeekDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.UpdateDayOfWeekRequest;

import java.util.List;

public interface DayOfWeekService {
    DayOfWeekDto create (CreateDayOfWeekRequest request);
    DayOfWeekDto update (UpdateDayOfWeekRequest request);
    void delete (Long dayId);
    List<DayOfWeekDto> getAll ();
    List<DayOfWeekDto> getAllAvailableDay ();
    List<DayOfWeekDto> getAllNotAvailableDay ();
}
