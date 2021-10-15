package com.metaenlace.citasmedicas.repositories;
import com.metaenlace.citasmedicas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo  extends JpaRepository<Usuario, Long> {
    
}
