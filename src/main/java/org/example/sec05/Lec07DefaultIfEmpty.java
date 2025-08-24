package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Mono;

public class Lec07DefaultIfEmpty {
    public static void main(String[] args) {
        Mono.empty()
                .defaultIfEmpty("fallback")
                .subscribe(Util.subscriber());
    }
}
