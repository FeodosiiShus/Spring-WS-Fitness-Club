package ua.nure.inettech.repository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import ua.nure.inettech.entity.Gym;
import ua.nure.inettech.entity.Gyms;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GymRepository {
    private static final Map<String, Gym> gyms = new HashMap<>();

    @PostConstruct
    public void initData(){
        Gym malibu = new Gym();
        malibu.setId(1);
        malibu.setGymName("Malibu");
        malibu.setGymInformation("goof");
        malibu.setGymMaximumUser(3);
        gyms.put(malibu.getGymName(), malibu);
        Gym hello = new Gym();
        hello.setId(2);
        hello.setGymName("Hello");
        hello.setGymInformation("fsdfsdf");
        hello.setGymMaximumUser(456);
        gyms.put(hello.getGymName(), hello);
    }

    public Gym findGymByName(Gym gym){
        Assert.notNull(gym.getGymName(), "Название зала должно быть больше 0 символов");
        return gyms.get(gym.getGymName());
    }

    public List<Gym> getAllGyms(){
        List<Gym> gymList= new ArrayList<Gym>(gyms.values());
        return gymList;
    }

    public Gym addGym(Gym gym){
        Assert.notNull(gym, "Объект должен быть не пустым");
        gyms.put(gym.getGymName(), gym);
        return gym;
    }
}
