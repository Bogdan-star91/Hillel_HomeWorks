public class RunCollection {

    public static void main(String[] args) {

        String[] arr = new String[]{"1", "2", "3", "4", "5"}; //початковий масив.

        CollectionImpl service = new CollectionImpl(arr);//об'єкт класу сервісу.

        System.out.println("\nArray output: " + service);// виведення стартового масиву.

        System.out.println("\n\nArray size is: " + service.size());//тест (add(value)).
        service.add("8");
        System.out.println("\nAdd to array \"8\": " + service);
        System.out.println("\nArray size is: " + service.size());

        service.add(4, "7");//тест (add(index, value)).
        System.out.println("\n\nAdd to the array after 4 \"7\": " + service);
        System.out.println("\nArray size is : " + service.size());

        service.delete("5");//тест (delete(value)).
        System.out.println("\n\nRemove from the array 5 \"5\": " + service);
        System.out.println("\nArray size is : " + service.size());

        System.out.println("\n\nThe second element is: " + service.get(1));/*повернення значення елементу колекції по
        індексу*/

        System.out.println("\n\nCheck if  the array contains 3: " + service.contain("3"));/*перевірка наявності в
        масиві вказаного елементу*/

        String[] testArr1 = new String[]{"f", "d", "c", "i", "j"};//перевірка чи дорівнює масив заданому масиву.
        CollectionImpl service1 = new CollectionImpl(testArr1);
        System.out.println("\n\nCheck for equality of arrays: " + service.equals(service1));

        service.clear();//тест (clear()).
        System.out.println("\n\nArray after method clear: " + service);
        System.out.println("\nArray size is : " + service.size());
    }
}
