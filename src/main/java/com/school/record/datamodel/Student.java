package com.school.record.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
           
	       @Id
	       @GeneratedValue(strategy = GenerationType.IDENTITY)
	       private Long id;
	       
	       @Column(nullable = false)
	       @NotBlank(message = "First name is mandatory")
	       private String firstName;
	       
	       @Column(nullable = false)
	       @NotBlank(message = "Last Name is mandatory")
	       private String lastName;
	       
	      
	       private int age;
	       
	       @NotNull(message = "ClassName must be mandatory")
	       @Column(nullable = false)
	       @Min(value = 1,message = "Class name must be greater than 0")
	       private int className;
	       
	       @NotBlank(message = "ClassName must be mandatory")
	       @Column(nullable = false)
	       @Size(min = 1,max = 1,message = "Class division must be a single character")
	       private String classDivision;
	       
	       private Long mobileNo;
	       
	       private String address;
}
