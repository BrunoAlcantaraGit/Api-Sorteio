package com.sorteio.mega.sorteioController;

import com.sorteio.mega.sorteioEntity.EntityCandidato;
import com.sorteio.mega.sorteioService.SorteioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/sorteio")
public class SorteioController {
    @Autowired
    SorteioService sorteioService;


    @PostMapping("/salvarCandidato")

    public ResponseEntity <EntityCandidato> salvarCandidato(@RequestBody EntityCandidato candidato) throws Exception{
        try {
         return new ResponseEntity<>(sorteioService.salvarCandidato(candidato),HttpStatus.CREATED);
        }catch (Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

