package app;

import java.util.UUID;

public class Subscriber {
    private String id;
    private String surName;
    private String name;
    private String middleName;
    private String city;
    private String phone;
    private String contractNumber;
    private double balance;
    private double urbanTime;
    private double intercityTime;
    private double internetTraffic;

    public Subscriber() {
        id = UUID.randomUUID().toString();
    }

    public Subscriber(String surName, String name, double balance, double urbanTime, double intercityTime,
                      double internetTraffic) {
        id = UUID.randomUUID().toString();
        this.surName = surName;
        this.name = name;
        this.balance = balance;
        this.urbanTime = urbanTime;
        this.intercityTime = intercityTime;
        this.internetTraffic = internetTraffic;
    }

    @Override
    public String toString() {
        return "Subscriber: " + id + " "
                + surName +
                " " + name +
                " " + middleName + ',' +
                " " + city + ',' +
                " " + phone + ',' +
                " " + contractNumber + ',' +
                " " + balance + ',' +
                " " + urbanTime + ',' +
                " " + intercityTime + ',' +
                " " + internetTraffic;
    }

    public String getId() {
        return id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getUrbanTime() {
        return urbanTime;
    }

    public void setUrbanTime(double urbanTime) {
        this.urbanTime = urbanTime;
    }

    public double getIntercityTime() {
        return intercityTime;
    }

    public void setIntercityTime(double intercityTime) {
        this.intercityTime = intercityTime;
    }

    public double getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(double internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

}
