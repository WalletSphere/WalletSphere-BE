package com.khomishchak.cryptoportfolio.repositories.history;

import com.khomishchak.cryptoportfolio.model.exchanger.trasaction.ExchangerDepositWithdrawalTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepositWithdrawalTransactionsHistoryRepository extends JpaRepository<ExchangerDepositWithdrawalTransactions, Long> {

    List<ExchangerDepositWithdrawalTransactions> findAllByUserId(long userId);
    Optional<ExchangerDepositWithdrawalTransactions> findByBalance_Id(long balanceId);
}
