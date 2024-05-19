package com.sorteio.mega.sorteioController;

import com.sorteio.mega.sorteioEntity.EntityCandidato;
import com.sorteio.mega.sorteioService.SorteioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/sorteio")
public class SorteioController {
    @Autowired
    SorteioService sorteioService;


    @PostMapping("/salvar-candidato")

    public ResponseEntity <EntityCandidato> salvarCandidato(@RequestBody EntityCandidato candidato) throws Exception{
        try {
         return new ResponseEntity<>(sorteioService.salvarCandidato(candidato),HttpStatus.CREATED);
        }catch (Exception e ){
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/resultado-da-aposta/{cpf}")
    public ResponseEntity <Optional<EntityCandidato>>resultadoSorteio(@PathVariable String cpf) throws Exception {
        try {
           return  new ResponseEntity<>(sorteioService.resultadoSorteio(cpf),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Transactional
    @DeleteMapping("/deletar-candidato/{cpf}")
     public ResponseEntity <Optional <EntityCandidato>> deletarCandidato(@PathVariable String cpf){
        try {
       return new ResponseEntity<>(sorteioService.deletarCandidato(cpf),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

