package com.sorteio.mega.sorteioEntity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class EntityCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_candidato")
    private Long id;
    private String nome;
    private String CPF;

    @Column(nullable = false)
    private String NumeroSorteado;

    private String numeroApostado;
    @Column(nullable = false)
    private LocalDate dataatual;

   @PrePersist
    public void prePersist() {
        this.dataatual = LocalDate.now();
    }

}
