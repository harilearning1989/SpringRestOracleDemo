package com.example.demo.batch.process;

import com.example.demo.entity.CreditCard;
import com.example.demo.entity.CreditCardRisk;
import org.springframework.batch.item.ItemProcessor;

public class CreditCardItemProcessor implements ItemProcessor<CreditCard, CreditCardRisk> {

    @Override
    public CreditCardRisk process(CreditCard cc) {
        CreditCardRisk ccr = new CreditCardRisk();
        if (cc.getCardTypeFullName().equalsIgnoreCase("visa")
                && cc.getIssuingBank().equalsIgnoreCase("Barclays")) {
            ccr.setCardId(cc.getCardId());
            ccr.setCardTypeCode(cc.getCardTypeCode());
            ccr.setCardTypeFullName(cc.getCardTypeFullName());
            ccr.setCardTypeCode(cc.getCardTypeCode());
            ccr.setCardTypeFullName(cc.getCardTypeFullName());
            ccr.setIssuingBank(cc.getIssuingBank());
            ccr.setCardNumber(Long.valueOf(cc.getCardNumber()));
            ccr.setCardHolderName(cc.getCardHolderName());
            ccr.setcVVCVV2(Integer.valueOf(cc.getcVVCVV2()));
            ccr.setIssueDate(cc.getIssueDate());
            ccr.setBillingDate(Integer.valueOf(cc.getBillingDate()));
            ccr.setExpiryDate(cc.getExpiryDate());
            ccr.setCardPIN(Integer.valueOf(cc.getCardPIN()));
            ccr.setCreditLimit(Integer.valueOf(cc.getCreditLimit()));
            System.out.println("Transforming CreditCard(s) to CreditCardDTO(s)..");

            return ccr;
        }
        return null;
    }

   /* private Set<CreditCardRisk> seenUsers = new HashSet<>();

    public CreditCardRisk process(CreditCardRisk user) {
        if(seenUsers.contains(user)) {
            return null;
        }
        seenUsers.add(user);
        return user;
    }*/
}
