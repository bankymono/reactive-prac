package org.example.sec01.publisher;

import com.github.javafaker.Faker;
import org.example.sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private static final Logger log = LoggerFactory.getLogger(Subscription.class);
    public static final int MAX_ITEMS = 10;
    private final Faker faker;

    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private int count = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if(isCancelled) {
            return;
        }

        log.info("subscriber has requested {} items", requested);
        if(requested > MAX_ITEMS) {
            this.subscriber.onError(new RuntimeException("validation failed"));
            this.isCancelled = true;
            return;
        }

        for(int i = 0; i < requested && count < MAX_ITEMS; i++) {
            count++;
            this.subscriber.onNext(faker.internet().emailAddress());
        }

        if(count == MAX_ITEMS){
            log.info("No more data to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("Subscriber has cancelled");
        isCancelled = true;
    }
}
