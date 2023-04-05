package com.simraninovation.bankingApi.model;
import javax.persistence.*;

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

    @Column(name="Email", unique = true)
	private String email;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="PhoneNo")
	private String phoneNo;


	
}
