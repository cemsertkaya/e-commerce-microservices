package com.egebilmuh.ecommerce.controller;

import com.egebilmuh.ecommerce.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.egebilmuh.ecommerce.entity.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department)
    {

         return departmentService.saveDepartment(department);

    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId)
    {
        return  departmentService.findDepartmentById(departmentId);
    }
}
