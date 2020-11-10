package ua.nure.inettech.endpoints.gym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.nure.inettech.entity.Gym;
import ua.nure.inettech.entity.Gyms;
import ua.nure.inettech.repository.GymRepository;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AddGymEndpoint {
    private static final String NAMESPACE_URI = "http://inettech.nure.ua";

    private GymRepository gymRepository;

    @Autowired
    public AddGymEndpoint(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddGym")
    @ResponsePayload
    public Gyms addNewGym(@RequestPayload Gym gym) {
        List<Gym> gymList = new ArrayList<>();
        gymList.add(gymRepository.addGym(gym));
        Gyms gyms = new Gyms();
        gyms.setGym(gymList);
        return gyms;
    }
}
