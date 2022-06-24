package com.JPAExampleReady.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
	
		@Id
		@SequenceGenerator(
				name = "teacher_sequence",
				sequenceName = "teacher_sequence"
				)
		@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator = "teacher_sequence"
				)
		private Long teacherId; 
		private String techerFirstName; 
		private String techerLastName;
		
		//********************************one to Many****************************
		 /* one to Many relationship: one teacher teach many courses [one to many],
		 * First defined Cascade : so we need to defined the cascade here 
		 * Then join the course table and teacher table by the PK teacherID and course table shoudl have the teacherID as a F.K
		 */
		
	/*	
		@OneToMany(
				cascade = CascadeType.ALL
				)
		@JoinColumn(
				
				name= "techer_Id",
				referencedColumnName = "techerId"
				
				)
		
		private List<Course> courses;*/
		//better to defined the many to one relationship  e.g teacher offereing several course, so one teacher offer several coursematerial
		
}
