package com.simraninovation.bankingApi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@Entity
@NoArgsConstructor
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

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="userId", referencedColumnName = "id")
    @JsonProperty
    private User userId;

    public Account(User userId) {
        this.userId = userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfci() {
		return ifci;
	}

	public void setIfci(String ifci) {
		this.ifci = ifci;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public static long getSerialversion() {
		return serialVersion;
	}

	public User getUserId() {
		return userId;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
