package com.onlinebanking.onlinebanking.Repository;

import com.onlinebanking.onlinebanking.entity.LoanAccountTransactionEntity;
import com.onlinebanking.onlinebanking.entity.SavingsTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsTransactionRepository extends JpaRepository<SavingsTransactionEntity, Long> {
}
