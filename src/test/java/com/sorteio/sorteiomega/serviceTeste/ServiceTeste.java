package com.sorteio.sorteiomega.serviceTeste;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceTeste {

    public List<Integer> gerarNumeroDaSorteioTeste(){
        Random random = new Random();
        List<Integer>numerosDoSorteio = new ArrayList<>();

        Integer numerosAleatorios = random.nextInt(65);
        for (int i = 0; numerosAleatorios <= 6; i++){
            numerosDoSorteio.add(i);
        }

        return numerosDoSorteio;

    }


    public List<Integer>verificarSorteioTeste(Integer seuNumero){
        // compara os número informandos com a número do metodo GerarNumeroDaSorteio
        return new ArrayList<>();
    }
}
