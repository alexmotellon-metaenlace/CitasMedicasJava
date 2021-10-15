package com.metaenlace.citasmedicas.repositories;
import com.metaenlace.citasmedicas.models.Cita;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Long> {
    
}
