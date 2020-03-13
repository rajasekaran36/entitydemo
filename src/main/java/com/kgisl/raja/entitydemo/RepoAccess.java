package com.kgisl.raja.entitydemo;

import com.kgisl.raja.entitydemo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * RepoAccess
 */
public class RepoAccess {
    @Autowired
    StudentRepository studentRepository;


    public StudentRepository getStudentRepository() {
        return this.studentRepository;
    }
        
}