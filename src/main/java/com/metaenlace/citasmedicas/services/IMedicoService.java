package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;
import com.metaenlace.citasmedicas.models.Medico;

public interface IMedicoService {

    public List<Medico> GetAllMedicos();

    public Optional<Medico> GetMedicoById(Long id);

    public Boolean AddMedico(Medico medico);

    public Boolean UpdateMedico(Long id, Medico medico);
    
    public Boolean DeleteMedico(Long id);

    public Optional<Medico> findByUsuario(String usuario);

    public Optional<Medico> login(String usuario, String clave);
    
}
