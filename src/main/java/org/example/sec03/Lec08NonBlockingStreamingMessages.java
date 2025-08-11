package org.example.sec03;

import org.example.common.Util;
import org.example.sec03.client.ExternalServiceClient;

public class Lec08NonBlockingStreamingMessages {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        client.getNames()
                .subscribe(Util.subscriber());
        Util.sleepSeconds(6);
    }
}
