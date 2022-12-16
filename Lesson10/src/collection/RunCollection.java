package collection;

import collection.myCollection.CollectionImpl;

public class RunCollection {
    public static void main(String[] args) {
        CollectionImpl list = new CollectionImpl(5);
        list.add("1");
        list.add("3");
        list.add("3");
        list.add("5");
        list.add("5");
        list.add("2");

        System.out.println("\nCollection output with the iterator method: ");
        while (list.hasNext()) {
            System.out.print(list.next() + " ");
        }
        System.out.println("\n-----------");

        list.remove();
        System.out.println("List after deletion using the iterator method: " + list);
        System.out.println("-------------------------------------------------------");

        System.out.println("A new collection with a unique value from the list: " + list.getUnique());
    }
}
