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

    public EntityCandidato salvarCandidato(EntityCandidato candidado)  throws Exception{

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

        } else {
            throw new RuntimeException("Você precisa informar uma sequencia de números de 6 dígitos");
        }
        if (candidado.getNumeroApostado().equals(candidado.getNumeroSorteado())) {
            candidado.setResultadoDaAposta("Parabés,Você Ganhou na mega!");

        } else {
            candidado.setResultadoDaAposta("Infelizmente, você não ganhou o concurso!");
        }
        return candidadoRepository.save(candidado);
    }

    public Optional<EntityCandidato> resultadoSorteio (String cpf) throws Exception {
        Optional<EntityCandidato> retorno = candidadoRepository.findByCPF(cpf);
        if(retorno.isPresent()){
            return retorno;
        }else{
            throw new RuntimeException("Candidat não existe ou CPF informado incorreto");

        }

    }

}
