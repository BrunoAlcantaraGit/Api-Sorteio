package com.sorteio.mega.sorteioService;

import com.sorteio.mega.sorteioRepository.SorteioRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor
@Data
public class SorteioService {
    @Autowired
    SorteioRepository sorteioRepository;

    public void gerarNumeroDaSorteio(String seuNumero) {
        Pattern pattern = Pattern.compile("\\b\\d{1,2}\\b");
        Matcher matcher = pattern.matcher(seuNumero);
        List<String>numeros = new ArrayList<>();

        while (matcher.find()){
            numeros.add(matcher.group());
        }
;
        if (numeros.size() == 6) {
            Random random = new Random();
            List<String> numerosDoSorteio = new ArrayList<>();

            for (int i = 0; i <= 6; i++) {
                Integer numerosAleatorios = random.nextInt(65);
                numerosDoSorteio.add(String.valueOf(numerosAleatorios));
            }
            String resultados = numerosDoSorteio.toString();

            if (numeros.equals(resultados)) {
                System.out.println("Você ganhou na mega");
                System.out.println(resultados);
            } else {
                System.out.println("Infelizmente você não foi sorteado");
                System.out.println(resultados);
            }

        } else {
            System.out.println("Você deve  informar 6 dígitos para concorrer ao sorteio  ");
        }
    }


}
