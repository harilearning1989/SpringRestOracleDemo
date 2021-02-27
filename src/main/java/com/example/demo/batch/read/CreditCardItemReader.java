package com.example.demo.batch.read;

import com.example.demo.entity.CreditCard;
import com.example.demo.repos.CreditCardRepository;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class CreditCardItemReader implements ItemReader<CreditCard> {

    @Autowired
    private CreditCardRepository respository;

    private Iterator<CreditCard> usersIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        //usersIterator = respository.findAll().iterator();
        usersIterator = respository.findByCardTypeFullNameAndIssuingBankAndBillingDate("Visa", "Barclays", 10).iterator();
    }

    @Override
    public CreditCard read() {
        if (usersIterator != null && usersIterator.hasNext()) {
            return usersIterator.next();
        } else {
            return null;
        }
    }
}
