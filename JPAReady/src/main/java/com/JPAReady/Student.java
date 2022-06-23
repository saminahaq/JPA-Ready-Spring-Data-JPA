package com.JPAReady;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	
	 	@Id
		private Long studentId;
	    private String firstName;
	    private String lastName;
	    private String emailId;
	    private String guardianName;
	    private String guardianEmail;
	    private String guardianMobile;
	    

}
