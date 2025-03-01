package br.com.nlw.events.service;

import br.com.nlw.events.model.Event;
import br.com.nlw.events.model.Subscription;
import br.com.nlw.events.model.User;
import br.com.nlw.events.repo.EventRepo;
import br.com.nlw.events.repo.SubscriptionRepo;
import br.com.nlw.events.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {


    @Autowired
    private EventRepo evtRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SubscriptionRepo subRepo;

    public Subscription createNewSubscription(String eventName, User user){
        //recuperar o evento pelo nome
        Event evt = evtRepo.findByPrettyName(eventName);
        user = userRepo.save(user);

        Subscription subs = new Subscription();
        subs.setEvent(evt);
        subs.setSubscriber(user);

        Subscription res = subRepo.save(subs);
        return res;
    }
}
