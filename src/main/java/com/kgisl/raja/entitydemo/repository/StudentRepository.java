package com.kgisl.raja.entitydemo.repository;

import java.util.List;

import com.kgisl.raja.entitydemo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * StudentRepository
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    public List<Student> findByName(String name);
}