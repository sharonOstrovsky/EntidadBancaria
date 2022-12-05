package Utility;

import Entity.Tarjeta;

import java.util.Comparator;

public class Comparators {

    public static Comparator<String> comparaNumero = new Comparator<String>(){
        @Override
        public int compare(String t, String t1) {
            return t.compareTo(t1);
        }

    };
}
