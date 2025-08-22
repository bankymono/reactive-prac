package org.example.sec05;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec06ErrorHandling {
    private static final Logger log = LoggerFactory.getLogger(Lec06ErrorHandling.class);

    public static void main(String[] args) {
        Flux.range(1,10)
                .map(i -> i == 5 ? 5/0: i)
                .subscribe(Util.subscriber());
    }

    private static void onErrorReturn(){
        Flux.range(1,10)
                .map(i -> i == 5 ? 5/0: i)
                .onErrorReturn(IllegalArgumentException.class, -1)
                .onErrorReturn(ArithmeticException.class, -2)
                .onErrorReturn(-3)
                .subscribe(Util.subscriber());
    }
}
