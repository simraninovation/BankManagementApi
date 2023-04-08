package com.simraninovation.bankingApi.model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User",uniqueConstraints={
		@UniqueConstraint(columnNames = {"Email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
     @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
     @Column(name="Email", unique = true)
	private String email;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@NotBlank(message = "mobileNumber is required")
	@Size(min = 10, max = 10)
	@Column(name="PhoneNo")
	private String phoneNo;


	
}
