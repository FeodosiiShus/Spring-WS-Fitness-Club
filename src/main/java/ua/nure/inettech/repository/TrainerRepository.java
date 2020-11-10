package ua.nure.inettech.repository;

import org.springframework.stereotype.Component;
import ua.nure.inettech.entity.Gym;
import ua.nure.inettech.entity.Phones;
import ua.nure.inettech.entity.Trainer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TrainerRepository {
    private static final Map<String, Trainer> trainer = new HashMap<>();

    @PostConstruct
    public void initData(){
        Trainer Hendriks = new Trainer();
        Hendriks.setId(1);
        Hendriks.setTrainerName("Ричард");
        Hendriks.setTrainerLastName("Хендрикс");
        Hendriks.setTrainerExperienceYear(4);
        Hendriks.setTrainerInformation("Профессиональный боксер лицом");

        Gym malibu = new Gym();
        malibu.setId(1);
        malibu.setGymName("Malibu");
        malibu.setGymInformation("goof");
        malibu.setGymMaximumUser(3);
        Hendriks.setGym(malibu);

        Phones hendriksPhones = new Phones();
        List<String> phoneList = new ArrayList<>();
        phoneList.add("+(380)99-231-98-65");
        phoneList.add("+(380)96-231-98-65");
        hendriksPhones.setPhone(phoneList);
        Hendriks.setPhones(hendriksPhones);
        trainer.put(Hendriks.getTrainerName(), Hendriks);

        Trainer Dinesh = new Trainer();
        Dinesh.setId(2);
        Dinesh.setTrainerName("Динеш");
        Dinesh.setTrainerLastName("Чугтай");
        Dinesh.setTrainerExperienceYear(5);
        Dinesh.setTrainerInformation("Пакистанский учитель арабского танца");

        Gym hello = new Gym();
        hello.setId(2);
        hello.setGymName("Hello");
        hello.setGymInformation("fsdfsdf");
        hello.setGymMaximumUser(456);
        Dinesh.setGym(hello);

        Phones dineshPhones = new Phones();
        List<String> dList = new ArrayList<>();
        dList.add("+(380)99-123-98-65");
        dList.add("+(380)96-123-98-65");
        dineshPhones.setPhone(dList);
        Dinesh.setPhones(dineshPhones);
        trainer.put(Dinesh.getTrainerName(), Dinesh);
    }

    public List<Trainer> getAllTrainers(){
        List<Trainer> trainerList= new ArrayList<>(trainer.values());
        return trainerList;
    }
}
