package org.example.sec09.helper;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public record Flight(String airline, Integer price) {

}
