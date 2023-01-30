package com.studentinformationsystem.operationservice.service.concretes;

import com.studentinformationsystem.operationservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.operationservice.dto.department.DepartmentDto;
import com.studentinformationsystem.operationservice.dto.department.UpdateDepartmentRequest;
import com.studentinformationsystem.operationservice.exception.DepartmentNotFoundException;
import com.studentinformationsystem.operationservice.repository.DepartmentRepository;
import com.studentinformationsystem.operationservice.service.DepartmentService;
import com.studentinformationsystem.operationservice.utility.mapper.abstracts.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentManager(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentDto create(CreateDepartmentRequest request) {
        return departmentMapper.toDepartmentDto(departmentRepository.save(departmentMapper.toDepartment(request)));
    }

    @Override
    public void delete(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public DepartmentDto update(UpdateDepartmentRequest request) {
        if (departmentRepository.existsById(request.getId())) {
            return departmentMapper.toDepartmentDto(departmentRepository.save(departmentMapper.toDepartment(request)));
        } else {
            throw new DepartmentNotFoundException("Department could not found by id: " + request.getId());

        }
    }

    @Override
    public List<DepartmentDto> getAllByFacultyId(String facultyId) {
        return departmentMapper.toDepartmentDtoList(departmentRepository.findAllByFacultyId(facultyId));
    }

    @Override
    public DepartmentDto getById(String departmentId) {
        return departmentMapper.toDepartmentDto(departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department could not found by id: " + departmentId)));
    }
}
