package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec05TakeOperator {
    public static void main(String[] args) {
        takeWhile();
    }

    private static void take() {
        Flux.range(1,10)
                .log("take")
                .take(3)
                .log("sub")
                .subscribe(Util.subscriber());
    }

    private static void takeWhile() {
        Flux.range(1,10)
                .log("take")
                .takeWhile(i -> i < 3)
                .log("sub")
                .subscribe(Util.subscriber());
    }
}
