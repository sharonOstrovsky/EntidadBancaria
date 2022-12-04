package Service;

import Entity.Tarjeta;
import Utility.Comparators;

import java.util.TreeSet;

public class TarjetaService {

    TreeSet<Tarjeta> tarjetas = new TreeSet<>(Comparators.comparaNumero);

    //crea la trajeta cuando se crea la cuenta bancaria
    public Tarjeta crearTarjeta(){
        Tarjeta tarjeta = new Tarjeta();
        String numTarjeta = "";

        for (int i = 0; i < 16; i++) {

            numTarjeta += Integer.toString(Aleatorio(0,9));

        }

        tarjeta.setNumero(numTarjeta);

        if(!validarNumeroTarjeta(tarjeta)){
            crearTarjeta();
        }

        return tarjeta;
    }

    private boolean validarNumeroTarjeta(Tarjeta tarjeta){
         int cantTarjetas = tarjetas.size();
         tarjetas.add(tarjeta);
         if(cantTarjetas != tarjetas.size()){
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
