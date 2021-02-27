package com.example.demo.batch.process;

import com.example.demo.dto.CountriesDTO;
import com.example.demo.entity.Countries;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CountriesProcessor implements ItemProcessor<CountriesDTO, Countries> {

    /*@Autowired
    private SalesOrderRepository salesOrderRepository;*/

    @Override
    public Countries process(final CountriesDTO conDto) throws Exception {
        final Countries countries = new Countries();

        countries.setName(conDto.getName());
        countries.setAlpha2(conDto.getAlpha2());
        countries.setAlpha3(conDto.getAlpha3());
        countries.setCountryCode(conDto.getCountryCode());
        countries.setRegion(conDto.getRegion());
        countries.setSubRegion(conDto.getSubRegion());
        countries.setIntermediateRegion(conDto.getIntermediateRegion());
        countries.setRegionCode(conDto.getRegionCode());
        countries.setSubRegionCode(conDto.getSubRegionCode());
        countries.setIntermediateRegionCode(conDto.getIntermediateRegionCode());

        System.out.println(countries.getName() + "===Region==" + countries.getRegion());
        return countries;
    }

}