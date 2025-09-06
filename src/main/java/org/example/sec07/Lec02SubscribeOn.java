package org.example.sec07;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOn {
    private static final Logger log = LoggerFactory.getLogger(Lec02SubscribeOn.class);

    public static void main(String[] args) {
        var flux = Flux.create(sink -> {
           for(int i = 1; i < 3; i++) {
               log.info("generating: {}", i);
               sink.next(i);
           }
           sink.complete();
        }).doOnNext(v -> log.info("value: {}", v));

        flux
                .doFirst(()-> log.info("first1"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(()->log.info("first2"))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(2);
    }
}
