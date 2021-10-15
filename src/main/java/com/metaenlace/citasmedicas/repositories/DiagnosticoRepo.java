package com.metaenlace.citasmedicas.repositories;
import com.metaenlace.citasmedicas.models.Diagnostico;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DiagnosticoRepo  extends JpaRepository<Diagnostico, Long> {
    
}
