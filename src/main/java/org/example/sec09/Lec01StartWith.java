package org.example.sec09;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01StartWith {
    private static final Logger log = LoggerFactory.getLogger(Lec01StartWith.class);

    public static void main(String[] args) {
        producer1()
                .startWith(12,9)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(3);
    }

    private static Flux<Integer> producer1() {
        return Flux.just(1,2,3)
                .doOnSubscribe(s -> log.info("subscribing to producer1"))
                .delayElements(Duration.ofMillis(10));
    }
}
