package com.kgisl.raja.entitydemo.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.kgisl.raja.entitydemo.RepoAccess;
import com.kgisl.raja.entitydemo.model.Student;
import com.kgisl.raja.entitydemo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * AppConfig
 */
@Configuration
@EnableJpaRepositories("com.kgisl.raja.entitydemo.repository") 
public class AppConfig {

    @Autowired
    private EntityManager entityManager;
    


    @Bean(name = "default-student")
    @Scope("prototype")
    public Student getStudent(){
        return new Student();
    }

    @Bean(name = "dbentity")
    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("stucoreunit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    @Bean(name="dbtransaction")
    public EntityTransaction getEntityTransaction(){
        EntityTransaction entityTransaction = this.entityManager.getTransaction();
        return entityTransaction;
    }

    @Bean(name = "dbrepo")
    public RepoAccess getRepoAccess(){
        return new RepoAccess();
    }
}