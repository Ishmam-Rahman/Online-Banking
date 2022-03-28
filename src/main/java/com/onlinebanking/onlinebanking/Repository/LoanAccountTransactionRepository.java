package com.onlinebanking.onlinebanking.Repository;

import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import com.onlinebanking.onlinebanking.entity.LoanAccountTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanAccountTransactionRepository extends JpaRepository<LoanAccountTransactionEntity, Long> {
}
