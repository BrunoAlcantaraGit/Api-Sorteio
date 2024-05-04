package com.sorteio.mega.sorteioRepository;

import com.sorteio.mega.sorteioEntity.EntityCandidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidadoRepository extends JpaRepository <EntityCandidato,Long> {
}
