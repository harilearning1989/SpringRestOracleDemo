package com.example.demo.repos;

import com.example.demo.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    List<CreditCard> findByCardTypeFullNameAndIssuingBankAndBillingDate(String cardTypeFullName, String issuingBank, int billDate);
}
