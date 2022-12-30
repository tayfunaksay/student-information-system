package com.studentinformationsystem.courseschedulingservice.service.concretes.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.hour.CreateHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.hour.HourDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.hour.UpdateHourRequest;
import com.studentinformationsystem.courseschedulingservice.exception.HourNotFoundException;
import com.studentinformationsystem.courseschedulingservice.repository.week.HourRepository;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.week.HourService;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.week.HourMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HourManager implements HourService {
    private final HourRepository hourRepository;
    private final HourMapper hourMapper;

    public HourManager(HourRepository hourRepository, HourMapper hourMapper) {
        this.hourRepository = hourRepository;
        this.hourMapper = hourMapper;
    }

    @Override
    public HourDto create(CreateHourRequest request) {
        return hourMapper.toHourDto(hourRepository.save(hourMapper.toHour(request)));
    }

    @Override
    public HourDto update(UpdateHourRequest request) {
        if (hourRepository.existsById(request.getId())){
            return hourMapper.toHourDto(hourRepository.save(hourMapper.toHour(request)));
        }else{
            throw new HourNotFoundException("Hour could not found by id: "+request.getId());
        }
    }

    @Override
    public void delete(Long hourId) {
        hourRepository.deleteById(hourId);
    }

    @Override
    public List<HourDto> getAll() {
        return hourMapper.toHourDtoList(hourRepository.findAll());
    }

    @Override
    public List<HourDto> getAllAvailableHour() {
        return hourMapper.toHourDtoList(hourRepository.getAllAvailableHourForCourses());
    }
}
