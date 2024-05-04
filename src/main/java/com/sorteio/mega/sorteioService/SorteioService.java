package com.sorteio.mega.sorteioService;


import com.sorteio.mega.sorteioEntity.EntityCandidato;
import com.sorteio.mega.sorteioRepository.CandidadoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@AllArgsConstructor
@Data
public class SorteioService {

    @Autowired
    CandidadoRepository candidadoRepository;


    public EntityCandidato salvarCandidato(EntityCandidato candidado) {

        String seuNumero = candidado.getNumeroApostado();

        Pattern pattern = Pattern.compile("\\b\\d{1,2}\\b");
        Matcher matcher = pattern.matcher((CharSequence) seuNumero);
        List<String> numeros = new ArrayList<>();

        while (matcher.find()) {
            numeros.add(matcher.group());
        }
        candidado.setNumeroApostado(String.valueOf(numeros));

        if (numeros.size() == 6) {
            Random random = new Random();
            List<String> numerosDoSorteado = new ArrayList<>();

            for (int i = 0; i < 6; i++) {
                Integer numerosAleatorios = random.nextInt(65);
                numerosDoSorteado.add(String.valueOf(numerosAleatorios));
                candidado.setNumeroSorteado(String.valueOf(numerosDoSorteado));
            }
            candidadoRepository.save(candidado);

        } else {
            throw new RuntimeException("Você precisa informar uma sequencia de números de 6 dígitos, entre 01 a 65");
        }
        return candidado;
    }


}
