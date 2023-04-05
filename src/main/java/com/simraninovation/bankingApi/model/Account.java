package com.simraninovation.bankingApi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="Account")

public class Account implements Serializable {
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="AccountNumber")
    private String accountNumber;

    @Column(name="Branch")
    private String branch;

    @Column(name="IFSC",length=11)
    private String ifci;
    @Column(name="Name")
    private String name;
    @CreatedDate
    @CreationTimestamp
    private Date createdDate;

    @Column(name="Balance")
    private String balance;

    @OneToOne//(cascade=CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName = "id")
    
    private User userId;

    public Account(User userId) {
        this.userId = userId;
    }

 

	

	
}
