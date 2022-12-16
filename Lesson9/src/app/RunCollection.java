package app;

public class RunCollection {
    public static void main(String[] args) {
        LinkedListImpl list1 = new LinkedListImpl();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        LinkedListImpl list2 = new LinkedListImpl();
        list2.add("5");
        list2.add("6");
        list2.add("7");

        System.out.println("\nList1 : " + list1);
        System.out.println("List2 : " + list2);
        System.out.println("\nAdd list2 to list1: " + list1.addAll(list2));
        System.out.println("List after adds collection: " + list1);
        System.out.println("------------------------------------------");

        System.out.println("\nAdd 9 to list: " + list1.add("9"));
        System.out.println("List after adds 9: " + list1);
        System.out.println("-----------------------------------");

        System.out.println("\nRemove second item from list: " + list1.delete(1));
        System.out.println("List after removes first item: " + list1);
        System.out.println("---------------------------------------------");

        System.out.println("\nRemove last item from list: " + list1.delete("9"));
        System.out.println("List after removes last item: " + list1);
        System.out.println("------------------------------------------");

        System.out.println("\nGet item with 4 index from list: " + list1.get(4));
        System.out.println("Get item with 8 index from list: " + list1.get(8));
        System.out.println("---------------------------------------");

        System.out.println("\nCheck contains 3 in list: " + list1.contains("3"));
        System.out.println("Check contains 10 in list: " + list1.contains("10"));
        System.out.println("---------------------------------");

        System.out.println("\nGet the size of the collection: " + list1.size());
        System.out.println("-----------------------");

        System.out.println("\nGet trim method: " + list1.trim());
        System.out.println("----------------------");

        System.out.println("\nClear the list : " + list1.clear());
        System.out.println("Get list: " + list1);
    }
}
