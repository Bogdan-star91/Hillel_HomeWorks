package com.hillel.controller;

import com.hillel.service.ServiceLoyalty;
import lombok.RequiredArgsConstructor;
import com.hillel.model.BonusLoyalty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bonus_loyalty")
@RequiredArgsConstructor
public class ControllerLoyalty {

    private final ServiceLoyalty serviceLoyalty;

    @RequestMapping(value = "/loyalty", method = RequestMethod.POST)
    public void addEmployeesLoyalty(int experience){
        serviceLoyalty.addEmployeesLoyalty(experience);
    }

    @RequestMapping(value = "/loyalty_employees", method = RequestMethod.GET)
    public List<BonusLoyalty> getAllEmployeeLoyalty(){
        return serviceLoyalty.getEmployeesLoyalty();
    }
}
