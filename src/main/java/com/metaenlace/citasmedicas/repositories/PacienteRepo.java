package com.metaenlace.citasmedicas.repositories;
import com.metaenlace.citasmedicas.models.Paciente;
import com.metaenlace.citasmedicas.models.Cita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Long> {
    
    public List<Paciente> findByNickUsuario(String nickUsuario);

    @Query(value = "SELECT * FROM CITAS c WHERE c.paciente = ?1)",
    nativeQuery = true)
    public List<Cita> findCitas(Long id);

}
