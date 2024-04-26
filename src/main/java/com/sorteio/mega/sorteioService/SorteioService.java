package com.sorteio.mega.sorteioService;

import com.sorteio.mega.sorteioRepository.SorteioRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@Data
public class SorteioService {
    @Autowired
    SorteioRepository sorteioRepository;

    public List<Integer>gerarNumeroDaSorteio(){
        Random random = new Random();
        List<Integer>numerosDoSorteio = new ArrayList<>();

        Integer numerosAleatorios = random.nextInt(65);
        for (int i = 0; numerosAleatorios <= 6; i++){
            numerosDoSorteio.add(i);
        }

        return numerosDoSorteio;

    }


    public List<Integer>verificarSorteio(Integer seuNumero){
        // compara os número informandos com a número do metodo GerarNumeroDaSorteio
        return new ArrayList<>();
    }
}
