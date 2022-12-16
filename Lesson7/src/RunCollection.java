import app.CollectionServiceImpl;

public class RunCollection {
    public static void main(String[] args) {
        CollectionServiceImpl col = new CollectionServiceImpl(5);

        System.out.println("Add string \"i\": " + col.add("i"));
        System.out.println(col + "\n");

        System.out.println("Remove element at index 7 outside of bounds: " + col.delete(7));
        System.out.println(col + "\n");

        System.out.println("Add data to collection: ");
        col.add("2");
        col.add("1");
        col.add(null);
        col.add("3");
        col.add("1");
        col.add("2");
        col.add(null);
        System.out.println(col + "\n");

        System.out.println("Add string \"j\" into 3 index: " + col.add(3, "j"));
        System.out.println(col + "\n");

        System.out.println("Remove second element from collection : " + col.delete(1));
        System.out.println(col + "\n");

        System.out.println("Add 5 to collection: ");
        col.add("5");
        System.out.println(col + "\n");

        System.out.println("Remove first 1 from collection : " + col.delete("1"));
        System.out.println(col + "\n");

        System.out.println("Remove all 1 from collection : " + col.deleteAll("1"));
        System.out.println(col + "\n");

        System.out.println("Get the fourth element from the collection : " + col.get(3));
        System.out.println(col.get(3) + "\n");
    }
}
