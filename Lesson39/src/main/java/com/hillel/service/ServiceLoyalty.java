package com.hillel.service;

import com.hillel.model.BonusLoyalty;

import java.util.List;

public interface ServiceLoyalty {

    void addEmployeesLoyalty(int experience);

    List<BonusLoyalty> getEmployeesLoyalty();
}
