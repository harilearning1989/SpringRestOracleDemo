package com.example.demo.batch.process;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repos.EmployeeRepo;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, EmployeeEntity> {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeEntity process(final EmployeeDTO employee) throws Exception {
        //Optional<Employee> userFromDb = employeeRepository.findById(employee.getId());
        System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
        final EmployeeEntity entity = new EmployeeEntity(employee.getFirstName(), employee.getLastName(),
                employee.getCompanyName(), employee.getAddress(), employee.getCity(), employee.getCounty(), employee.getState()
                , employee.getZip());

        return entity;
    }
}
