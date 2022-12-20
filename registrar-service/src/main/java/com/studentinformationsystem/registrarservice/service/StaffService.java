package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.staff.CreateStaffRequest;
import com.studentinformationsystem.registrarservice.dto.staff.StaffDto;
import com.studentinformationsystem.registrarservice.dto.staff.UpdateStaffRequest;

import java.util.List;

public interface StaffService {
    StaffDto create (CreateStaffRequest request);
    void delete (String staffId);
    StaffDto update (UpdateStaffRequest request);
    List<StaffDto> getAll();
    StaffDto getById(String staffId);
}
