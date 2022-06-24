package com.JPAExampleReady.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.utility.nullability.MaybeNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//if you want to exclude course table from the courseMaterial table :use the table name here
@ToString(exclude = "course")
public class CourseMaterial {
	
	@Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
	private Long courseMaterialId; 
	private String url;

	/*
	 * courseMaterial has to have the courses, so it cannot stand alone, so here we need to add the Course
	 * @OneToOne : so for that we need to define the one to one mapping,
	 * 
	 * @JoinColumn:now we need to defined for which particular column foreign key will be applied by, 
	 * so in parantheses we need to defined for which particulr column we can join the table 
	 * so for the course,  the course material refernce to the courseID
	 * 
	 */
	
	@OneToOne(
			cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,  //two type of fetching 1: eager [bring the course and course material both] 2: lazy [bring only courseMaterial ]
            optional = false // we are saying here when we save the course courseMaterial is required, not optional
            )
	@JoinColumn(
			name = "course_Id",
			referencedColumnName = "courseId" //from Course POJO
			)
	private Course course;
	

	
}

