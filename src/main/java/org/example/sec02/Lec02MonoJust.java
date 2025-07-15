package org.example.sec02;

import org.example.sec01.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("vins");
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(10);
//        System.out.println(mono);
    }
}
