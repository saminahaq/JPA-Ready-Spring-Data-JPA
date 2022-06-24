package com.JPAExampleReady.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import com.JPAExampleReady.entity.Course;
import com.JPAExampleReady.entity.Student;
import com.JPAExampleReady.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	
	@Autowired
	private CourseRepository courseRepo;
	
	
	
	//we already defined in the courseMaterial Class
	
	@Test 
	void printCourse() {
		
		List<Course> printCourse =
				courseRepo.findAll();
		
		System.out.println("Print the course :" + printCourse);
	
	}
	
	@Test
	
    public void saveCourseWithTeacher() {
		
        Teacher teacher = Teacher.builder()
                .techerFirstName("Priyanka")
                .techerLastName("Singh")
                .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepo.save(course);
    }

	 @Test
	    public void findAllPagination(){
	        Pageable firstPagewithThreeRecords =
	                PageRequest.of(0, 3);
	        Pageable secondPageWithTwoRecords = 
	                PageRequest.of(1,2);
	        
	        List<Course> courses =
	                courseRepo.findAll(secondPageWithTwoRecords)
	                        .getContent();

	        long totalElements =
	        		courseRepo.findAll(secondPageWithTwoRecords)
	                .getTotalElements();

	        long totalPages =
	        		courseRepo.findAll(secondPageWithTwoRecords)
	                .getTotalPages();

	        System.out.println("totalPages = " + totalPages);
	        
	        System.out.println("totalElements = " + totalElements);

	        System.out.println("courses = " + courses);
	    }

	 @Test
	    public void findAllSorting() {
	        Pageable sortByTitle =
	                PageRequest.of(
	                        0,
	                        2,
	                        Sort.by("title")
	                        );
	        Pageable sortByCreditDesc =
	                PageRequest.of(
	                        0,
	                        2,
	                        Sort.by("credit").descending()
	                );

	        Pageable sortByTitleAndCreditDesc =
	                PageRequest.of(
	                        0,
	                        2,
	                        Sort.by("title")
	                        .descending()
	                        .and(Sort.by("credit"))
	                );
	        
	        List<Course> courses
	                = courseRepo.findAll(sortByTitle).getContent();

	        System.out.println("courses = " + courses);
	    }
	 @Test
	    public void printfindByTitleContaining() {
	        Pageable firstPageTenRecords =
	                PageRequest.of(0,10);

	        List<Course> courses =
	                courseRepo.findByTitleContaining(
	                        "D",
	                        firstPageTenRecords).getContent();

	        System.out.println("courses = " + courses);
	    }

	    @Test
	    public void saveCourseWithStudentAndTeacher() {

	        Teacher teacher = Teacher.builder()
	                .techerFirstName("Lizze")
	                .techerLastName("Morgan")
	                .build();

	        Student student = Student.builder()
	                .firstName("Abhishek")
	                .lastName("Singh")
	                .emailAddress("abhishek@gmail.com")
	                .build();

	        Course course = Course
	                .builder()
	                .title("AI")
	                .credit(12)
	                .teacher(teacher)
	                .build();

	        course.addStudents(student);

	        courseRepo.save(course);
	    }

}
