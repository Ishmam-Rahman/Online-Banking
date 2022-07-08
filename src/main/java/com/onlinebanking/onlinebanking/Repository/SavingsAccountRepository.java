package com.onlinebanking.onlinebanking.Repository;

import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import com.onlinebanking.onlinebanking.entity.SavingsAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccountEntity, Long> {
}
