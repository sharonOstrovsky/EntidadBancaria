package Service;

import Entity.Tarjeta;
import Utility.Comparators;

import java.util.TreeSet;

public class TarjetaService {

    TreeSet<String> tarjetas = new TreeSet<>(Comparators.comparaNumero);

    //crea la trajeta cuando se crea la cuenta bancaria
    public Tarjeta crearTarjeta(){
        Tarjeta tarjeta = new Tarjeta();
        String numTarjeta = "";

        for (int i = 0; i < 16; i++) {//16

            numTarjeta += Integer.toString(Aleatorio(0,9));

        }

        if(!validarNumeroTarjeta(numTarjeta, tarjeta)){
            tarjeta = crearTarjeta();

        }

        return tarjeta;
    }

    private boolean validarNumeroTarjeta(String tarjeta, Tarjeta t){
         int cantTarjetas = tarjetas.size();

         tarjetas.add(tarjeta);

         if(cantTarjetas != tarjetas.size()){
             t.setNumero(tarjeta);
             return true;
         }else{
             return false;

         }



    }





    public static int Aleatorio(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }



}
