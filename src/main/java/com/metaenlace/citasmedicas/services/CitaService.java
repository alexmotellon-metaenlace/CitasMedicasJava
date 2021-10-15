package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaenlace.citasmedicas.models.Cita;
import com.metaenlace.citasmedicas.repositories.CitaRepo;

@Service
public class CitaService implements ICitaService{

    @Autowired
	private CitaRepo repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cita> GetAllCitas() {

		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cita> GetCitaById(Long id) {

		if(!repository.findById(id).isPresent())
			return null;

        return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Boolean AddCita(Cita cita) {

		if(repository.findById(cita.getId()).isPresent())
			return false;
		
		repository.save(cita);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean UpdateCita(Long id, Cita cita) {

		if(!repository.findById(cita.getId()).isPresent())
			return false;
		
		repository.save(cita);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean DeleteCita(Long id) {

		if(!repository.findById(id).isPresent())
			return false;
		
		repository.deleteById(id);

		return true;
	}	  
    
}
