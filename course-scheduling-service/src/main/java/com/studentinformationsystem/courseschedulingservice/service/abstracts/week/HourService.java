package com.studentinformationsystem.courseschedulingservice.service.abstracts.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.hour.CreateHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.hour.HourDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.hour.UpdateHourRequest;

import java.util.List;

public interface HourService {
    HourDto create (CreateHourRequest request);
    HourDto update (UpdateHourRequest request);
    void delete (Long hourId);
    List<HourDto> getAll ();
    List<HourDto> getAllAvailableHour ();
}
