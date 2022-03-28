package com.onlinebanking.onlinebanking.Repository;

import com.onlinebanking.onlinebanking.entity.CustomerEntity;
import com.onlinebanking.onlinebanking.entity.LoanAccountEntity;
import com.onlinebanking.onlinebanking.entity.LoanProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccountEntity, Long> {
}
