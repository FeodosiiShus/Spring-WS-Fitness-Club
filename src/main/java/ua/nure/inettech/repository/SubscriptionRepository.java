package ua.nure.inettech.repository;

import org.springframework.stereotype.Component;
import ua.nure.inettech.entity.Gym;
import ua.nure.inettech.entity.Gyms;
import ua.nure.inettech.entity.Subscription;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SubscriptionRepository {
    private static final Map<String, Subscription> subscription = new HashMap<>();

    @PostConstruct
    public void initData(){
        Subscription bronze = new Subscription();
        bronze.setId(1);
        bronze.setSubscriptionName("Bronze");
        bronze.setSubscriptionCountVisits(15);
        bronze.setSubscriptionPrice(300.00);

        Gym malibu = new Gym();
        malibu.setId(1);
        malibu.setGymName("Malibu");
        malibu.setGymInformation("goof");
        malibu.setGymMaximumUser(3);
        List<Gym> bronzeList = new ArrayList<>();
        bronzeList.add(malibu);
        Gyms gyms = new Gyms();
        gyms.setGym(bronzeList);
        bronze.setGyms(gyms);
        subscription.put(bronze.getSubscriptionName(), bronze);

        Subscription silver = new Subscription();
        silver.setId(2);
        silver.setSubscriptionName("Silver");
        silver.setSubscriptionCountVisits(30);
        silver.setSubscriptionPrice(450.00);

        Gym hello = new Gym();
        hello.setId(2);
        hello.setGymName("Hello");
        hello.setGymInformation("fsdfsdf");
        hello.setGymMaximumUser(456);
        List<Gym> silverList = new ArrayList<>();
        silverList.add(malibu);
        silverList.add(hello);
        Gyms sGyms = new Gyms();
        sGyms.setGym(silverList);
        silver.setGyms(sGyms);
        subscription.put(silver.getSubscriptionName(), silver);

        Subscription gold = new Subscription();
        gold.setId(3);
        gold.setSubscriptionName("Gold");
        gold.setSubscriptionCountVisits(45);
        gold.setSubscriptionPrice(500.00);

        Gym dance = new Gym();
        dance.setId(3);
        dance.setGymName("Dance gym");
        dance.setGymMaximumUser(30);
        dance.setGymInformation("Gym for cool dancers");
        List<Gym> goldList = new ArrayList<>();
        goldList.add(malibu);
        goldList.add(hello);
        goldList.add(dance);
        Gyms gGyms = new Gyms();
        gGyms.setGym(goldList);
        gold.setGyms(gGyms);
        subscription.put(gold.getSubscriptionName(), gold);
    }

    public List<Subscription> getAllSubscriptions(){
        List<Subscription> subscriptionList= new ArrayList<>(subscription.values());
        return subscriptionList;
    }
}
