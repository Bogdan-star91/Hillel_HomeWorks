package app.discriminant;

public class Disc {
    private double i;
    private double j;
    private double f;

    protected Disc() {
    }

    public Disc(String s) {
        Disc ds = new FormattedDisk().getItem(s);
        this.i = ds.getI();
        this.j = ds.getJ();
        this.f = ds.getF();
    }

    public double getDiscriminant() {
        return (j * j) - (4 * i * f);
    }

    public String getEquationRoots() {
        String result;
        if (getDiscriminant() < 0) {
            return "Not roots";
        }

        if (getDiscriminant() > 0) {
            result = "x1 = " + (-j - Math.sqrt(getDiscriminant())) / (2 * i) + "\n";
            result += "x2 = " + (-j + Math.sqrt(getDiscriminant())) / (2 * i);
        } else {
            result = "x1 = " + (-1 * (j / (2 * i)));
        }
        return result;
    }

    protected void setI(double i) {
        this.i = i;
    }

    protected void setJ(double j) {
        this.j = j;
    }

    protected void setF(double f) {
        this.f = f;
    }

    public double getI() {
        return i;
    }

    public double getJ() {
        return j;
    }

    public double getF() {
        return f;
    }
}
