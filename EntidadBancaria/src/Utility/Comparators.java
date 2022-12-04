package Utility;

import Entity.Tarjeta;

import java.util.Comparator;

public class Comparators {

    public static Comparator<Tarjeta> comparaNumero = new Comparator<Tarjeta>(){
        @Override
        public int compare(Tarjeta t, Tarjeta t1) {


            return t.getNumero().compareTo(t1.getNumero());
        }

    };
}
