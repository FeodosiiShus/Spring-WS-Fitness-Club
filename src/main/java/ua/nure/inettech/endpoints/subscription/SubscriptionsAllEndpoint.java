package ua.nure.inettech.endpoints.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.nure.inettech.entity.Subscription;
import ua.nure.inettech.entity.Subscriptions;
import ua.nure.inettech.repository.SubscriptionRepository;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class SubscriptionsAllEndpoint {
    private static final String NAMESPACE_URI = "http://inettech.nure.ua";

    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionsAllEndpoint(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubscriptionList")
    @ResponsePayload
    public Subscriptions getAllSubscriptions() {
        List<Subscription> subscriptionList = new ArrayList<>();
        subscriptionRepository.getAllSubscriptions().forEach(e -> subscriptionList.add(e));
        Subscriptions subscriptions = new Subscriptions();
        subscriptions.setSubscription(subscriptionList);
        return subscriptions;
    }

}
