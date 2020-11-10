package ua.nure.inettech.endpoints.trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.nure.inettech.entity.Gym;
import ua.nure.inettech.entity.Gyms;
import ua.nure.inettech.entity.Trainer;
import ua.nure.inettech.entity.Trainers;
import ua.nure.inettech.repository.TrainerRepository;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class TrainersAllEndpoint {
    private static final String NAMESPACE_URI = "http://inettech.nure.ua";

    private TrainerRepository trainerRepository;

    @Autowired
    public TrainersAllEndpoint(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TrainerList")
    @ResponsePayload
    public Trainers getAllTrainers() {
        List<Trainer> trainerList = new ArrayList<>();
        trainerRepository.getAllTrainers().forEach(e -> trainerList.add(e));
        Trainers trainers = new Trainers();
        trainers.setTrainer(trainerList);
        return trainers;
    }
}
