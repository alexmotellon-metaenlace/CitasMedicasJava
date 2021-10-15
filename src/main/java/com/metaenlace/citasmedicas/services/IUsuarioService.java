package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;
import com.metaenlace.citasmedicas.models.Usuario;


public interface IUsuarioService {
    
    public List<Usuario> GetAllUsuarios();

    public Optional<Usuario> GetUsuarioById(Long id);

    public Boolean AddUsuario(Usuario usuario);

    public Boolean UpdateUsuario(Long id, Usuario usuario);
    
    public Boolean DeleteUsuario(Long id);
    
}
