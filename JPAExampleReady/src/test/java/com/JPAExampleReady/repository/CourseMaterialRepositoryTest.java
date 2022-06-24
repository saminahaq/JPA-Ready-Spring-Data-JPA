package com.JPAExampleReady.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.CascadeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.JPAExampleReady.entity.Course;
import com.JPAExampleReady.entity.CourseMaterial;
import com.JPAExampleReady.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMatRepo;
	
	
	
	@Test
	void test() {
		Teacher teach = Teacher.builder()
							.techerFirstName("Sam")
							.techerLastName("Haq")
							.build();
		
		Course c = Course.builder()
						.title("Spring")
						.credit(6)
						.teacher(teach)
						.build();

		CourseMaterial courseMat = CourseMaterial.builder()
								.url("www.google.com")
								.course(c)
								.build();
		
	
	courseMatRepo.save(courseMat); 
	/*
	 * this simple is not work because the transient error, so we need to make the data persistant
	 * so making the course persistant, we neee to cascade the data [so in simple term uptill now we are going to save the coursematerial 
	 * table that connected with the course table, but the course table does not have any data, that called the transient error],
	 * so the solution of the transient error is the cascading [Cascading mean if there is no data available for the course so cascade try to persist this course]
	 * so there are several cascade type available so we go to the courseMaterial  file and under one-to one mapping put cascade = CascadeType.ALL,
	 * 
	 */ 
	 /*
	 * very Important:very Important:[till now we only defined uni-deirectional one to one mapping  very Important:very Important: ]
	 * so if you see the courseMaterial table there is no mappping of course in it,
	 * because courseMaterial mapped to Course not vice versa
	 * 
	 * **************************************Making bidirectional Mapping:**************************************
	 * so go to the course and put 
	 * @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;
	 */
	}
	
	@Test
	void printAllCourseMaterial() {
		
		List<CourseMaterial> printAllCourseMater = 
				courseMatRepo.findAll();
		
		System.out.println("printAllCourseMater  :" + printAllCourseMater);
				

	}
	

}
