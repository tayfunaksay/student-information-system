package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.staff.CreateStaffRequest;
import com.studentinformationsystem.registrarservice.dto.staff.StaffDto;
import com.studentinformationsystem.registrarservice.dto.staff.UpdateStaffRequest;
import com.studentinformationsystem.registrarservice.exception.StaffNotFoundException;
import com.studentinformationsystem.registrarservice.repository.StaffRepository;
import com.studentinformationsystem.registrarservice.service.StaffService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.StaffMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffManager implements StaffService {
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    public StaffManager(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    @Override
    public StaffDto create(CreateStaffRequest request) {
        return staffMapper.toStaffDto(staffRepository.save(staffMapper.toStaff(request)));
    }

    @Override
    public void delete(String staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public StaffDto update(UpdateStaffRequest request) {
        if (staffRepository.findById(request.getId()).isEmpty()) {
            throw new StaffNotFoundException("Staff could not found by id: " + request.getId());
        }else {
            return staffMapper.toStaffDto(staffRepository.save(staffMapper.toStaff(request)));
        }
    }

    @Override
    public List<StaffDto> getAll() {
        return staffMapper.toStaffDtoList(staffRepository.findAll());
    }

    @Override
    public StaffDto getById(String staffId) {
        return staffMapper.toStaffDto(staffRepository.findById(staffId)
                .orElseThrow(()-> new StaffNotFoundException("Staff could not found by id: "+staffId)));
    }
}
