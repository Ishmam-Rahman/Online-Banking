package com.onlinebanking.onlinebanking.Repository;

import com.onlinebanking.onlinebanking.entity.LoanProductEntity;
import com.onlinebanking.onlinebanking.entity.SavingsProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsProductRepository extends JpaRepository<SavingsProductEntity, Long> {
}
