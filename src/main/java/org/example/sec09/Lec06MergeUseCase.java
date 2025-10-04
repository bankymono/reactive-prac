package org.example.sec09;

import org.example.common.Util;
import org.example.sec09.helper.Kayak;

public class Lec06MergeUseCase {
    public static void main(String[] args) {
        Kayak.getFlights()
                .subscribe(Util.subscriber());

        Util.sleepSeconds(3);
    }
}
