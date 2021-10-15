package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;
import com.metaenlace.citasmedicas.models.Diagnostico;

public interface IDiagnosticoService {
 
    public List<Diagnostico> GetAllDiagnosticos();

    public Optional<Diagnostico> GetDiagnosticoById(Long id);

    public Boolean AddDiagnostico(Diagnostico diagnostico);

    public Boolean UpdateDiagnostico(Long id, Diagnostico diagnostico);
    
    public Boolean DeleteDiagnostico(Long id);
    
}
