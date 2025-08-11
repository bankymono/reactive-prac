package org.example.sec03;

import org.example.common.Util;
import org.example.sec03.helper.NameGenerator;

public class Lec07FluxVsList {
    public static void main(String[] args) {
//        var list = NameGenerator.getNamesList(10);
//        System.out.println(list);

        NameGenerator.getNamesFlux(10).subscribe(Util.subscriber());
//        System.out.println(list);
    }
}
