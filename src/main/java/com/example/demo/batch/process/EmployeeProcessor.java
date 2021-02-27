package com.example.demo.batch.process;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repos.IEmployeeRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee> {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee process(final EmployeeDTO employee) throws Exception {
        //Optional<Employee> userFromDb = employeeRepository.findById(employee.getId());
        System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
        final Employee empDto = new Employee(employee.getFirstName(), employee.getLastName(),
                employee.getCompanyName(), employee.getAddress(), employee.getCity(), employee.getCounty(), employee.getState()
                , employee.getZip());

        return empDto;
    }
}
