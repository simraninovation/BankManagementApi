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
@Table(name="Transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="message")
    private String message;

    @Column(name="amount")
    private String amount;

    @CreatedDate
    @CreationTimestamp
    private Date createdDate;

    @OneToOne
    @JoinColumn(name="accountId" , referencedColumnName = "id")
    private Account accountId;

    public Transactions(Account accountId) {
        this.accountId = accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId.id;
    }
}
