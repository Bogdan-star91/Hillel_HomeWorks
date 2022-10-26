package app;

public class Car {
    private double tankVolume;
    private double tankBalance;
    private double consumptionFuel;

    public Car() {
    }

    public Car(double volume, double fuelConsumption) {
        this.tankVolume = volume;
        this.tankBalance = volume;
        this.consumptionFuel = fuelConsumption;
    }

    public void addFullFuel() {
        this.tankBalance += neededFuel();
    }

    public void addFullFuel(double kilometers) throws CarFuelException {
        this.tankBalance += neededFuel(kilometers);
    }

    public void overcomingKilometers(double kilometers) throws CarFuelException {
        if (tankBalance - kilometers / 100 * consumptionFuel < 0) {
            throw new CarFuelException("Ran out of fuel");
        }
        tankBalance = tankBalance - kilometers / 100 * consumptionFuel;
    }

    public double neededFuel() {
        return tankVolume - tankBalance;
    }

    public double neededFuel(double kilometers) throws CarFuelException {
        overcomingKilometers(kilometers);
        return tankVolume - tankBalance;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }

    public double getTankBalance() {
        return tankBalance;
    }

    public void setTankBalance(double tankBalance) {
        this.tankBalance = tankBalance;
    }

    public double getConsumptionFuel() {
        return consumptionFuel;
    }

    public void setConsumptionFuel(double consumptionFuel) {
        this.consumptionFuel = consumptionFuel;
    }

}

