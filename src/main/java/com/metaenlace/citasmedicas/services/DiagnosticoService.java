package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaenlace.citasmedicas.models.Diagnostico;
import com.metaenlace.citasmedicas.repositories.DiagnosticoRepo;

@Service
public class DiagnosticoService implements IDiagnosticoService {

    @Autowired
	private DiagnosticoRepo repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Diagnostico> GetAllDiagnosticos() {

		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Diagnostico> GetDiagnosticoById(Long id) {

		if(!repository.findById(id).isPresent())
			return null;

        return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Boolean AddDiagnostico(Diagnostico diagnostico) {

		if(repository.findById(diagnostico.getId()).isPresent())
			return false;
		
		repository.save(diagnostico);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean UpdateDiagnostico(Long id, Diagnostico diagnostico) {

		if(!repository.findById(diagnostico.getId()).isPresent())
			return false;
		
		repository.save(diagnostico);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean DeleteDiagnostico(Long id) {

		if(!repository.findById(id).isPresent())
			return false;
		
		repository.deleteById(id);

		return true;
	}	
    
}
