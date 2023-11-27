package com.khomishchak.ws.model.exchanger.transaction;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khomishchak.ws.model.TransferTransactionType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "deposit_withdrawal_transactions")
public class DepositWithdrawalTransaction extends Transaction {

    @Enumerated(EnumType.STRING)
    private TransferTransactionType transferTransactionType;

    @ManyToOne
    @JoinColumn(name = "deposit_withdrawal_transactions_history_id")
    @JsonIgnore
    private ExchangerDepositWithdrawalTransactions exchangerDepositWithdrawalTransactions;

    @Builder(builderMethodName = "depositWithdrawalTransactionBuilder")
    public DepositWithdrawalTransaction(String transactionId, String transactionHash, String ticker, BigDecimal fee,
                                        BigDecimal amount, LocalDateTime createdAt, TransferTransactionType transferTransactionType) {
        super(transactionId, transactionHash, ticker, fee, amount, createdAt);
        this.transferTransactionType = transferTransactionType;
    }
}