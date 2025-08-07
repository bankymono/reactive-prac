package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromIterableOrArray {
    public static void main(String[] args) {
        var list = List.of("a", "b", "c");
        Flux.fromIterable(list)
                .subscribe(Util.subscriber());
    }
}
