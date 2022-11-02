package app;

import java.util.Locale;

public class SubscriberServiceImpl implements SubscriberService {

    private Subscriber[] sbArr;

    public SubscriberServiceImpl(Subscriber[] sbArr) {
        this.sbArr = sbArr;
    }

    @Override
    public void exceededCityTime(double value) {
        for (Subscriber sb : sbArr) {
            if (sb.getUrbanTime() > value) {
                System.out.println(sb);
            }
        }
    }

    @Override
    public void whoUseIntercityTime() {
        for (Subscriber sb : sbArr) {
            if (sb.getIntercityTime() > 0) {
                System.out.println(sb);
            }
        }
    }

    @Override
    public void findAllUsersLNameStartWith(char symbol) {
        for (Subscriber sb : sbArr) {
            if (sb.getSurName().toUpperCase(Locale.ROOT).charAt(0) == symbol) {
                System.out.println(sb.getSurName() + " " + sb.getName() + " " + sb.getMiddleName() + " " +
                        sb.getPhone() + " " + sb.getBalance());
            }
        }
    }

    @Override
    public void getAllInternetTrafficFromCity(String city) {
        double allTraffic = 0;
        for (Subscriber sb : sbArr) {
            if (sb.getCity().equals(city)) {
                allTraffic += sb.getInternetTraffic();
            }
        }
        System.out.printf("All internet traffic from %s: %.2f", city, allTraffic);
    }

    @Override
    public void findAllUsersWithNegativeBalance() {
        for (Subscriber sb : sbArr) {
            if (sb.getBalance() < 0) {
                System.out.println(sb);
            }
        }
    }
}
