package com.studentinformationsystem.courseschedulingservice.service.concretes.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.CreateDayOfWeekRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.DayOfWeekDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek.UpdateDayOfWeekRequest;
import com.studentinformationsystem.courseschedulingservice.exception.DayNotFoundException;
import com.studentinformationsystem.courseschedulingservice.repository.week.DayOfWeekRepository;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.week.DayOfWeekService;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.week.DayOfWeekMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DayOfWeekManager implements DayOfWeekService {
    private final DayOfWeekRepository dayOfWeekRepository;
    private final DayOfWeekMapper dayOfWeekMapper;

    public DayOfWeekManager(DayOfWeekRepository dayOfWeekRepository, DayOfWeekMapper dayOfWeekMapper) {
        this.dayOfWeekRepository = dayOfWeekRepository;
        this.dayOfWeekMapper = dayOfWeekMapper;
    }

    @Override
    public DayOfWeekDto create(CreateDayOfWeekRequest request) {
        return dayOfWeekMapper.toDayOfWeekDto(dayOfWeekRepository.save(dayOfWeekMapper.toDayOfWeek(request)));
    }

    @Override
    public DayOfWeekDto update(UpdateDayOfWeekRequest request) {
        if (dayOfWeekRepository.existsById(request.getId())){
            return dayOfWeekMapper.toDayOfWeekDto(dayOfWeekRepository.save(dayOfWeekMapper.toDayOfWeek(request)));
        }else {
            throw new DayNotFoundException("DayOfWeek could not found by id: "+request.getId());
        }
    }

    @Override
    public void delete(Long dayId) {
        dayOfWeekRepository.deleteById(dayId);
    }

    @Override
    public List<DayOfWeekDto> getAll() {
        return dayOfWeekMapper.toDayOfWeekDtoList(dayOfWeekRepository.findAll());
    }

    @Override
    public List<DayOfWeekDto> getAllAvailableDay() {
        return dayOfWeekMapper.toDayOfWeekDtoList(dayOfWeekRepository.findAllAvailableDayForCourses());
    }

    @Override
    public List<DayOfWeekDto> getAllNotAvailableDay() {
        return dayOfWeekMapper.toDayOfWeekDtoList(dayOfWeekRepository.findAllNotAvailableDayForCourses());
    }
}
