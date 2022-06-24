package com.JPAExampleReady.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course { 
	
	@Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
	private Long courseId; 
	private String title; 
	private Integer credit;
	
	/*As we alredy defined the joining into the courseMaterial class., so here we don't need to do again 
	 * just mentioed that its mapped by on the top of the other class object 
	 */
	@OneToOne(
			mappedBy = "course"
			)
	private CourseMaterial courseMaterial;
	
	//******************************** Many to One [preferred method]****************************
	/*
	 * for many to one: we need to defined the join table; so there is no change in database
	 * database structure remain same 
	 */
	 @ManyToOne(
	            cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,  //two type of fetching 1: eager [bring the course and course material both] 2: lazy [bring only courseMaterial ]
	            optional = false 
	    )
	    @JoinColumn(
	            name = "teacher_id",
	            referencedColumnName = "teacherId"
	    )
	    private Teacher teacher;
	 
	//******************************** Many to Many [course and student]****************************
		/*
		 * for the Many to Many relationship we need two annotation
		 * First : @ManyToMany(...
		 * second :  @JoinTable(...
		 * 
		 * For the @JoinTable we need two joinColumns configurations
		 * 
		 * First[joinColumns]: first with join table of same class [Course]
		 * 
		 * joinColumns = @JoinColumn(
	     *              name = "course_id",
	     *               referencedColumnName = "courseId"
	     *       ),
		 * 
		 * Second [inverseJoinColumns]: second with join table of other joined table class [Student]
		 * inverseJoinColumns = @JoinColumn( 
	     *               name = "student_id",
	     *               referencedColumnName = "studentId"
	     *       )
		 * 
		 */ 
	 
	 
	 
	   @ManyToMany(
	            cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY
	            
	    )
	    @JoinTable(
	            name = "studen_course_map",
	            joinColumns = @JoinColumn(
	                    name = "course_id",
	                    referencedColumnName = "courseId"
	            ),
	            inverseJoinColumns = @JoinColumn(
	                    name = "student_id",
	                    referencedColumnName = "studentId"
	            )
	    )
	    private List<Student> students;

	    public void addStudents(Student student){
	        if(students == null) students = new ArrayList<>();
	        students.add(student);
	    }
	 
	 
	 
}
