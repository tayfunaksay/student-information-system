package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.staff.CreateStaffRequest;
import com.studentinformationsystem.registrarservice.dto.staff.StaffDto;
import com.studentinformationsystem.registrarservice.dto.staff.UpdateStaffRequest;
import com.studentinformationsystem.registrarservice.model.Staff;

import java.util.List;

public interface StaffMapper {
    StaffDto toStaffDto(Staff from);

    List<StaffDto> toStaffDtoList(List<Staff> from);

    Staff toStaff(CreateStaffRequest request);

    Staff toStaff(UpdateStaffRequest request);
}
