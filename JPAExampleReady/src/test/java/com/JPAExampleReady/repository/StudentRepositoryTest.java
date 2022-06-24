package com.JPAExampleReady.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.JPAExampleReady.entity.Guardian;
import com.JPAExampleReady.entity.Student;


@SpringBootTest
class StudentRepositoryTest {

	//First Step: Create the object of the repository and autowired 
	
	@Autowired
	private StudentRepository stdRepo;
	
	
	@Test
	void saveStudentSpec() { 
	
		//second Step: create the Mock data for the POJO
		
		Student std = Student.builder()
				.firstName("Alex")
				.lastName("Alop")
				.emailAddress("alex@gmail.com")
//				.guardianName("colone")
//				.guardianEmailAddress("colone@gmail.com")
				.build();
		
		
		/*third step save into repo : as we ar eusing @SpringBootTest : so it will directly change the database, 
		 * so in production used the @ JPAtesting instead.
		 */
		
		stdRepo.save(std);
		
		
	}
	
	
	@Test
	void saveStudentGuardian() {
		
		Guardian guard = Guardian.builder()
				.guardianName("colone2")
				.guardianEmailAddress("colone2@gmail.com")
				.build();
		
		Student std = Student.builder()
				.firstName("Alex2")
				.lastName("Alop2")
				.emailAddress("23alex2@gmail.com")
				.guardian(guard)
				.build();
		
		stdRepo.save(std);
		

	}
	
	
	
	
	@Test
	void printAllStudent() {
		
		List<Student> printStd = stdRepo.findAll();
		System.out.println("Print All Student :" + printStd);

	}
	
	@Test	
	 void printStudentByFirstName() {
		
		List<Student> byName = 
				stdRepo.findByFirstName("Alex");
		
		System.out.println("Print By Name: " + byName);
		
	}
	
	
	@Test	
	 void printStudentByStudentId() {
		List<Student> byStdId = 
				stdRepo.findByStudentId(209L);
		System.out.println("Print By Student Id"+ byStdId);
	}
	
	
	@Test	
	 void printStudnetByLastName() {
		List<Student> byLastName =
				stdRepo.findByLastName("Alop");
		System.out.println("Print By Last Name : " + byLastName);
	}
	
	//for the inheritance testing "Gurdian"
	
	@Test
	void printStudentByGuardianName() {
		
		List<Student> printGuardName =
				stdRepo.findByGuardianGuardianName("colone2");
		System.out.println("Print ByGuardianName : "+ printGuardName);

	}
	
	
	@Test
	void findByLastNameNotNullSpec() {
		
		List<Student> nameNotNull =
				stdRepo.findByLastNameNotNull();
		System.out.println(" Find name not null : "+ nameNotNull);

	}
	
	
	@Test
	void findByFirstNameAndLastNameSpec() {
		
		Student byLastFirstName =
				stdRepo.findByFirstNameAndLastName("Alex2", "Alop2");
		
		System.out.println("byLastFirstName : " + byLastFirstName);

	}
	
	@Test
	void getStudentByEmailAddressSpec() {
		Student studentByEmailAddress =
				stdRepo.getStudentByEmailAddress("alex@gmail.com");
		System.out.println( "studentByEmailAddress   " + studentByEmailAddress);

	}
	
	@Test
	void getStudentByEmailAddressNativeSpec() {
		Student studentByEmailAddressNative =
				stdRepo.getStudentByEmailAddressNative("alex@gmail.com");
		System.out.println( "Native studentByEmailAddress   " + studentByEmailAddressNative);

	}
	

	@Test
	void getStudentByEmailAddressNativeNamedParamSpec() {
		
		Student studentByEmailAddressNamedParamSpec =
				stdRepo.getStudentByEmailAddressNativeNamedParam("alex@gmail.com");
		System.out.println( "NamedParam  studentByEmailAddress   " + studentByEmailAddressNamedParamSpec);

	}
	
	@Test
	void updateStudentEmailAddressSpec() {
		
		
				stdRepo.updateStudentNameByEmailId("Alex", "monica@gmail.com");
		

	}

}
