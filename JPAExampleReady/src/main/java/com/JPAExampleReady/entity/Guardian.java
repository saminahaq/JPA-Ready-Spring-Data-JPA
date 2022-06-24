package com.JPAExampleReady.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//reattribute override withthe databse column name
@AttributeOverrides({
	@AttributeOverride(
			name = "guardianName",
			column = @Column(name ="guardian_name")
			),
	@AttributeOverride(
			name = "guardianEmailAddress",
			column = @Column(name ="guardian_email_address")
			)
	
})
public class Guardian {
	
	
	private String guardianName; 
	private String guardianEmailAddress;

}
