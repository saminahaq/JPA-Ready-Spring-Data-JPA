package com.JPAExampleReady.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.JPAExampleReady.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	/*for the interface singanture name formate are very important,
	 * e.g findBy+properties_Field_Name[first alpha should be capital](same dataType with same dataField)
	 *   findByStudentId(Long studentId); 
	 *   so complete signature will be List<Student> findByStudentId(Lomg studentId);
	 */
 
	 List<Student> findByFirstName(String firstName);
	 List<Student> findByLastName(String lastName);
	 List<Student> findByStudentId(Long studentId);
	 
	 /*
	  * for the Guardian class
	  * List<Student> findBy+[object of that class in main class "Student class" [first alpha cap]]+[field name of Gurdian class [first alpha cap]](same)
	  */
	 
	 List<Student> findByGuardianGuardianName(String guardianName);
	 
	 
	 List<Student> findByLastNameNotNull();
	 
	 Student findByFirstNameAndLastName(String firstName, String lastName);
	 
	 //JQL
	 
	 @Query("select s from Student s where s.emailAddress =?1")
	 Student getStudentByEmailAddress(String emailAddress); //here method name start with the "get...." not find, beacuse its query
	 
	//Native
	    @Query(
	            value = "SELECT * FROM student_table s where s.email_address = ?1",
	            nativeQuery = true
	    )
	    Student getStudentByEmailAddressNative(String emailAddress);

	    
	    
	  //Native Named Param
	    @Query(
	            value = "SELECT * FROM student_table s where s.email_address = :emailAddress",
	            nativeQuery = true
	    )
	    Student getStudentByEmailAddressNativeNamedParam(
	            @Param("emailAddress") String emailAddress
	    );
	    
	    
	  //update Query : 
	    
	    @Modifying
	    @Transactional
	    @Query(
	            value = "update student_table set first_name = ?1 where email_address = ?2",
	            nativeQuery = true
	    )
	    int updateStudentNameByEmailId(String firstName, String emailAddress);

	    

			   
			 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
