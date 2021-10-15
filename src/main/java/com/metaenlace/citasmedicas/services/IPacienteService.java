package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;
import com.metaenlace.citasmedicas.models.Paciente;

public interface IPacienteService {
    
    
    public List<Paciente> GetAllPacientes();

    public Optional<Paciente> GetPacienteById(Long id);

    public Boolean AddPaciente(Paciente paciente);

    public Boolean UpdatePaciente(Long id, Paciente paciente);
    
    public Boolean DeletePaciente(Long id);

    public Optional<Paciente> findByUsuario(String usuario);

    public Optional<Paciente> login(String usuario, String clave);
    
}
