package com.egebilmuh.ecommerce.service;

import com.egebilmuh.ecommerce.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egebilmuh.ecommerce.entity.*;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);

    }

    public Department findDepartmentById(Long departmentId)
    {
        return  departmentRepository.findByDepartmentId(departmentId);
    }
}
