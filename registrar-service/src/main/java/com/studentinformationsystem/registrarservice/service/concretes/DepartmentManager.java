package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.department.UpdateDepartmentRequest;
import com.studentinformationsystem.registrarservice.exception.DepartmentNotFoundException;
import com.studentinformationsystem.registrarservice.repository.DepartmentRepository;
import com.studentinformationsystem.registrarservice.service.DepartmentService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentManager implements DepartmentService{

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
        if (departmentRepository.findById(request.getId()).isEmpty()){
            throw new DepartmentNotFoundException("Department could not found by id: "+request.getId());
        }else {
            return departmentMapper.toDepartmentDto(departmentRepository.save(departmentMapper.toDepartment(request)));
        }
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departmentMapper.toDepartmentDtoList(departmentRepository.findAll());
    }

    @Override
    public DepartmentDto getById(String departmentId) {
        return departmentMapper.toDepartmentDto(departmentRepository.findById(departmentId)
                .orElseThrow(()-> new DepartmentNotFoundException("Department could not found by id: "+departmentId)));
    }
}
