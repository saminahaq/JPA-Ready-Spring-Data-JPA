package com.JPAExampleReady.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "student_table")//shows as this in the database [this way we define the name of the table]
//Table Name with the table contraint 
@Table(
		name = "student_table",
		uniqueConstraints = @UniqueConstraint(
				name = "email_unique",
				columnNames = "email_address"
				)
		
		)
public class Student {
	
	//for the ID we need sequences generated, as a standard practice
	@Id
	@SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
			
	private Long studentId; 
	private String firstName; 
	private String lastName; 
	//defined the column name inside the database
    //for the column that cannot be null
	@Column(
            name = "email_address",
            nullable = false
    )
	private String emailAddress; 
	
//	private String guardianName; 
//	private String guardianEmailAddress;

    /*
     * If you wan to used the different class in the same entity, as they are in one table in the database,
     * but in the codebase they are two different entities classes,
     *  than used the @Embedded annotation at both side,
     *  
     */
    @Embedded
    private Guardian guardian;

}
