package com.JPAExampleReady.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.JPAExampleReady.entity.Course;
import com.JPAExampleReady.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepo;
	
	
	
	@Test
	void saveTeacherwithCourse() {
		
		//ideally we need to create the method for the list of the course
		Course java = Course.builder()
							.title("Java")
			                .credit(5)
			                .build();
		Course spring = Course.builder()
				.title("spring")
                .credit(5)
                .build();
	
		Teacher teacher = Teacher.builder()
							.techerFirstName("Lui")
							.techerLastName("wong")
							//.courses(List.of(java, spring)) //one to many so there is list
							.build();
		
		teacherRepo.save(teacher);
		
	}
	
	

}
