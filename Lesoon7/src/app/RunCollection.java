package app;

public class RunCollection {
    public static void main(String[] args) {
        Collection col = new Collection(5);

        System.out.println("Add string \"i\": " + col.add("i"));
        System.out.println(col + "\n");

        System.out.println("Remove element at index 7 outside of bounds: " + col.delete(7));
        System.out.println(col + "\n");

        System.out.println("Add data to collection: ");
        col.add("2");
        col.add("1");
        col.add("3");
        col.add("1");
        col.add("2");
        System.out.println(col + "\n");

        System.out.println("Add string \"j\" into 2 index: " + col.add(2, "j"));
        System.out.println(col + "\n");

        System.out.println("Remove third element from collection : " + col.delete(2));
        System.out.println(col + "\n");

        System.out.println("Add 5 to collection: ");
        col.add("5");
        System.out.println(col + "\n");

        System.out.println("Remove first 2 from collection : " + col.delete("2"));
        System.out.println(col + "\n");

        System.out.println("Remove all 2 from collection : " + col.deleteAll("2"));
        System.out.println(col + "\n");

        System.out.println("Get the third element from the collection : " + col.get(2));
        System.out.println(col + "\n");
    }
}
