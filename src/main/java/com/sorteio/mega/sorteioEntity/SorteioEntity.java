package com.sorteio.mega.sorteioEntity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SorteioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String CPF;
    @Column(nullable = false,length = 6)
    private String NumeroSorteado;
    @Column(nullable = false)
    private LocalDate dataatual;

   /* @PrePersist
    public void prePersist() {
        this.dataatual = LocalDate.now();
    }*/

}
