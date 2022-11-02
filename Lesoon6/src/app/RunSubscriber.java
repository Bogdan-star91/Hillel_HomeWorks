package app;

public class RunSubscriber {
    public static void main(String[] args) {
        Subscriber[] sbArr = {
                new Subscriber("Gritsay", "Bogdan", 4200, 37, 0, 250),
                new Subscriber("Cot", "Nik", 550, 90, 30, 118),
                new Subscriber("Chen", "Tom", 430, 0, 0, 145),
                new Subscriber("Zuk", "Mark", -510, 110, 65, 20),
                new Subscriber("Korz", "Oleh", -215, 50, 15, 90),
        };
        sbArr[0].setCity("Rivne");
        sbArr[1].setCity("Sumy");
        sbArr[2].setCity("Rivne");
        sbArr[3].setCity("Sumy");
        sbArr[4].setCity("Rivne");

        sbArr[0].setMiddleName("Dmitrievich");
        sbArr[1].setMiddleName("Vladimirovich");
        sbArr[2].setMiddleName("Petrovich");
        sbArr[3].setMiddleName("Ivanovich");
        sbArr[4].setMiddleName("Alekseevich");

        sbArr[0].setPhone("+380507890055");
        sbArr[1].setPhone("+380977243567");
        sbArr[2].setPhone("+380687994522");
        sbArr[3].setPhone("+380635446708");
        sbArr[4].setPhone("+380964567899");

        sbArr[0].setContractNumber("45");
        sbArr[1].setContractNumber("12");
        sbArr[2].setContractNumber("55");
        sbArr[3].setContractNumber("100");
        sbArr[4].setContractNumber("27");

        SubscriberServiceImpl service = new SubscriberServiceImpl(sbArr);
        System.out.println("Information about subscribers whose intracity conversation time exceeds " +
                "the specified (37): ");
        service.exceededCityTime(37);

        System.out.println("\nInformation about subscribers who used long-distance communication: ");
        service.whoUseIntercityTime();

        System.out.println("\nInformation about subscribers, the balance of which the first letter of the last name" +
                " is transmitted as a parameter: C");
        service.findAllUsersLNameStartWith('C');

        System.out.println("\nTotal Internet traffic consumption from Rivne: ");
        service.getAllInternetTrafficFromCity("Rivne");

        System.out.println("\n\nNumber of subscribers with negative balance: ");
        service.findAllUsersWithNegativeBalance();
    }
}
