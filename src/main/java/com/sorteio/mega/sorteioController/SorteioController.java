package com.sorteio.mega.sorteioController;

import com.sorteio.mega.sorteioEntity.EntityCandidato;
import com.sorteio.mega.sorteioService.SorteioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/resultado-da-aposta")
    public ResponseEntity <List<EntityCandidato>> resultadoSorteio() throws Exception {
        try {
           return  new ResponseEntity<>(sorteioService.resultadoSorteio(),HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

