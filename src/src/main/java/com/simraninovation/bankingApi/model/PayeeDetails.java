package com.simraninovation.bankingApi.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@Table(name="Payee")
public class PayeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="AccountNumber")
    private String accountNumber;

    @Column(name="IFSC",length=11)
    private String ifsc;

    @Column(name="Name")
    private String name;

    @CreatedDate
    @CreationTimestamp
    private Date createdDate;

    @OneToOne
    @JoinColumn(name="accountId", referencedColumnName = "id")
    private Account accountId;

}
