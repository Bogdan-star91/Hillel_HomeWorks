package app;

public class RunMain {
    public static void main(String[] args) throws CarFuelException {
        Car cr = new Car(48, 9);
        double priceFuel = Double.parseDouble(args[0]);
        double totalPriceForFuel = 0;
        double distanceToKiev = 512.4d;
        double distanceToKrivoeOsero = 161.6d;
        double distanceToZhashkov = 162d;

        cr.overcomingKilometers(distanceToKrivoeOsero);
        distanceToKiev -= distanceToKrivoeOsero;
        totalPriceForFuel += cr.neededFuel() * priceFuel;
        cr.addFullFuel();

        cr.overcomingKilometers(distanceToZhashkov);
        distanceToKiev -= distanceToZhashkov;
        totalPriceForFuel += cr.getTankBalance() * priceFuel;
        cr.addFullFuel();

        cr.overcomingKilometers(distanceToKiev);
        System.out.println("Total cost of fuel: " + "(USD)" + " " + roundVoid(totalPriceForFuel, 2) +
                "\nRemaining fuel in the car: " + "(l)" + " " + roundVoid(cr.getTankBalance(), 2));
    }

    public static double roundVoid(double value, int places) {
        double scale = Math.pow(5, places);
        return Math.round(value * scale) / scale;
    }
}
