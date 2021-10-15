package com.metaenlace.citasmedicas.repositories;
import com.metaenlace.citasmedicas.models.Medico;
import com.metaenlace.citasmedicas.models.Cita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Long> {

    public List<Medico> findByNickUsuario(String nickUsuario);

    @Query(value = "SELECT * FROM CITAS c WHERE c.medico = ?1)",
    nativeQuery = true)
    public List<Cita> findCitas(Long id);
    
}
