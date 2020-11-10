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
public class GymEndpoint {
    private static final String NAMESPACE_URI = "http://inettech.nure.ua";

    private GymRepository gymRepository;

    @Autowired
    public GymEndpoint(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Gyms")
    @ResponsePayload
    public Gyms getGymRequest(@RequestPayload Gym gym) {
        Gyms gyms = new Gyms();
        List<Gym> gymList = new ArrayList<>();
        gymList.add(gymRepository.findGymByName(gym));
        gyms.setGym(gymList);
        return gyms;
    }
}
