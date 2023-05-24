package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Department;
import com.example.demo.model.EmpSample;

public interface EmpSampleRepository extends JpaRepository<EmpSample, Integer> {
    List<EmpSample> findByDepartment(Department dep);
}
