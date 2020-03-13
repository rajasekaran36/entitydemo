package com.kgisl.raja.entitydemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.kgisl.raja.entitydemo.config.AppConfig;
import com.kgisl.raja.entitydemo.model.Student;
import com.kgisl.raja.entitydemo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EntitydemoApplication {
	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(EntitydemoApplication.class, args);
		System.out.println("Heeeeee");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EntityManager entityManager = (EntityManager)ctx.getBean("dbentity");
		EntityTransaction entityTransaction = (EntityTransaction)ctx.getBean("dbtransaction");
		entityTransaction.begin();
		for(int i = 0;i<10;i++){
			Student student = (Student)ctx.getBean("default-student");
			student.setName("B"+i);
			entityManager.persist(student);
		}
		entityTransaction.commit();

		RepoAccess re = (RepoAccess)ctx.getBean("dbrepo");

		StudentRepository repo = re.getStudentRepository();
		
		repo.findByName("B7").stream().map(Student::getId).forEach(System.out::println);
	}

}
