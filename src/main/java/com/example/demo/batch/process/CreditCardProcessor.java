package com.example.demo.batch.process;

import com.example.demo.dto.CreditCardDTO;
import com.example.demo.entity.CreditCard;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class CreditCardProcessor implements ItemProcessor<CreditCardDTO, CreditCard> {

    @Override
    public CreditCard process(final CreditCardDTO cardDto) throws Exception {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat format1 = new SimpleDateFormat("dd/yyyy", Locale.ENGLISH);
        Date date = null;
        final CreditCard creditCard = new CreditCard();
        if(cardDto.getIssueDate().length()>8){
            date= format.parse(cardDto.getIssueDate());
        }else{
            date = format1.parse(cardDto.getIssueDate());
        }
        creditCard.setIssueDate(date);

        if(cardDto.getExpiryDate().length()>8){
            date= format.parse(cardDto.getExpiryDate());
        }else{
            date = format1.parse(cardDto.getExpiryDate());
        }
        creditCard.setExpiryDate(date);

        creditCard.setCardTypeCode(cardDto.getCardTypeCode());
        creditCard.setCardTypeFullName(cardDto.getCardTypeFullName());
        creditCard.setIssuingBank(cardDto.getIssuingBank());
        creditCard.setCardNumber(Long.valueOf(cardDto.getCardNumber()));
        creditCard.setCardHolderName(cardDto.getCardHolderName());
        creditCard.setcVVCVV2(Integer.valueOf(cardDto.getcVVCVV2()));
        creditCard.setBillingDate(Integer.valueOf(cardDto.getBillingDate()));
        creditCard.setCardPIN(Integer.valueOf(cardDto.getCardPIN()));
        creditCard.setCreditLimit(Integer.valueOf(cardDto.getCreditLimit()));
        System.out.println("Transforming CreditCard(s) to CreditCardDTO(s)..");
        return creditCard;
    }
}
