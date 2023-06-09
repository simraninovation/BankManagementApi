package com.simraninovation.bankingApi.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Payee")
public class PayeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="AccountNumber", unique=true)
    private String accountNumber;

    
    @Column(name="IFSC",length=11)
    
    private String ifsc="SIBN0002838";

    @Column(name="Name" )
    private String name;
    
    @Column(name="isOtherBank")
    private Boolean isOtherBank;

    @CreatedDate
    @CreationTimestamp
    private Date createdDate;

    @OneToOne
    @JoinColumn(name="accountId", referencedColumnName = "id")
    private Account accountId;

}
