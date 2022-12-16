import app.discriminant.Disc;

public class RunRoots {
    public static void main(String[] args) {
        Disc ds = new Disc("3-4+1");
        System.out.println("\napp.discriminant: " + ds.getDiscriminant());
        System.out.println("Roots: " + ds.getEquationRoots());
        System.out.println("------------------------------");

        ds = new Disc("1+4+4");
        System.out.println("app.discriminant: " + ds.getDiscriminant());
        System.out.println("Roots: " + ds.getEquationRoots());
        System.out.println("------------------------------");

        ds = new Disc("1+6+45");
        System.out.println("app.discriminant: " + ds.getDiscriminant());
        System.out.println("Roots: " + ds.getEquationRoots());
    }
}
