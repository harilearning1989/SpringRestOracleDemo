package com.example.demo.batch.process;

import com.example.demo.dto.CropInsuranceDTO;
import com.example.demo.entity.CropInsurance;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CropInsuranceProcessor implements ItemProcessor<CropInsuranceDTO, CropInsurance> {

    @Override
    public CropInsurance process(final CropInsuranceDTO dto) throws Exception {
        final CropInsurance crop = new CropInsurance();
        crop.setId(dto.getSerialNumber());
        crop.setMandalName(dto.getMandalName());
        crop.setVillName(dto.getVillageName());
        crop.setBeneficiary(dto.getNameOfTheBeneficiary());
        crop.setCrop(dto.getCrop());
        crop.setExtentHa(dto.getExtentHa());
        crop.setClaimAmount(dto.getClaimAmountRs());
        crop.setBankName(dto.getBankName());
        crop.setBranchName(dto.getBranchName());
        crop.setAccNumber(dto.getAccountNumber());
        crop.setLoanee(dto.getCategoryLoaneeNonLoanee());
        //System.out.println("Transforming CropInsurance(s) to CropInsuranceDTO(s).." + cropDto.getSerialNumber());
        return crop;
    }
}
