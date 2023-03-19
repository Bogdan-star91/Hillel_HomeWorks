package com.hillel.service.impl;

import com.hillel.model.BonusLoyalty;
import com.hillel.model.Employee;
import com.hillel.repository.RepositoryEmployee;
import com.hillel.repository.RepositoryLoyaltyList;
import com.hillel.service.ServiceLoyalty;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLoyaltyImpl implements ServiceLoyalty {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final RepositoryLoyaltyList repositoryLoyaltyList;
    private final RepositoryEmployee repositoryEmployee;

    @Override
    public void addEmployeesLoyalty(int experience){
        List<Employee> employeeList = repositoryEmployee
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getExperience))
                .toList();
        List<Employee> loyaltyBonusEmployee = new ArrayList<>();
        for (Employee e : employeeList) {
            int ex = e.getExperience();
            if(ex >= experience){
                loyaltyBonusEmployee.add(e);
                String name = e.getName();
                BonusLoyalty bonusLoyalty = new BonusLoyalty();
                bonusLoyalty.setEmployees(name);
                repositoryLoyaltyList.save(bonusLoyalty);
            }
        }
        if(loyaltyBonusEmployee.isEmpty()){
            LOG.info("No employee matching the request");
        }
    }

    @Override
    public List<BonusLoyalty> getEmployeesLoyalty() {
        return repositoryLoyaltyList.findAll().stream().toList();
    }
}
