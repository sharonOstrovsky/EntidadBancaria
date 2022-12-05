package Service;

import Entity.Tarjeta;
import Utility.Comparators;

import java.util.TreeSet;

public class TarjetaService {

    TreeSet<String> tarjetas = new TreeSet<>(Comparators.comparaNumero);

    //crea la trajeta cuando se crea la cuenta bancaria
    public Tarjeta crearTarjeta2(){
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

    public Tarjeta crearTarjeta(){
        Tarjeta tarjeta = new Tarjeta();
        String numTarjeta = "";

        numTarjeta = crearNumeroTarjeta();

        if(validarNumeroTarjeta(numTarjeta, tarjeta)){
            return tarjeta;

        }else{
            return crearTarjeta();
        }
    }

    private String crearNumeroTarjeta(){
        String numeroTarjeta = "";

        for (int i = 0; i < 16; i++) {//16

            numeroTarjeta += Integer.toString(Aleatorio(0,9));

        }
        return numeroTarjeta;
    }

    private boolean validarNumeroTarjeta(String numTarjeta, Tarjeta tarjeta){
         int cantTarjetas = tarjetas.size();

         tarjetas.add(numTarjeta);

         if(cantTarjetas != tarjetas.size()){
             tarjeta.setNumero(numTarjeta);
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
