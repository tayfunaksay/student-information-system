package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.staff.CreateStaffRequest;
import com.studentinformationsystem.registrarservice.dto.staff.StaffDto;
import com.studentinformationsystem.registrarservice.dto.staff.UpdateStaffRequest;
import com.studentinformationsystem.registrarservice.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffManager implements StaffService {
    @Override
    public StaffDto create(CreateStaffRequest request) {
        return null;
    }

    @Override
    public StaffDto delete(String staffId) {
        return null;
    }

    @Override
    public StaffDto update(UpdateStaffRequest request) {
        return null;
    }

    @Override
    public List<StaffDto> getAll() {
        return null;
    }

    @Override
    public StaffDto getById(String staffId) {
        return null;
    }
}
