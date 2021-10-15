package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;
import com.metaenlace.citasmedicas.models.Cita;

public interface ICitaService {

    public List<Cita> GetAllCitas();

    public Optional<Cita> GetCitaById(Long id);

    public Boolean AddCita(Cita Cita);

    public Boolean UpdateCita(Long id, Cita Cita);
    
    public Boolean DeleteCita(Long id);
    
}
