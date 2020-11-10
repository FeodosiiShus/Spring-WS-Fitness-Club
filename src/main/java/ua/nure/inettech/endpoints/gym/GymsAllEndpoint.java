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
public class GymsAllEndpoint {
    private static final String NAMESPACE_URI = "http://inettech.nure.ua";

    private GymRepository gymRepository;

    @Autowired
    public GymsAllEndpoint(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GymList")
    @ResponsePayload
    public Gyms getAllGyms() {
        List<Gym> gymList = new ArrayList<>();
        gymRepository.getAllGyms().forEach(e -> gymList.add(e));
        Gyms gyms = new Gyms();
        gyms.setGym(gymList);
        return gyms;
    }
}
