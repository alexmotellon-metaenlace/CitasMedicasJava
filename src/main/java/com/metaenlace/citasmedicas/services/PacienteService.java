package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.metaenlace.citasmedicas.repositories.PacienteRepo;
import com.metaenlace.citasmedicas.models.Paciente;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
	private PacienteRepo repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Paciente> GetAllPacientes() {

		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Paciente> GetPacienteById(Long id) {

		if(!repository.findById(id).isPresent())
			return null;

        return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Boolean AddPaciente(Paciente paciente) {

		if(repository.findById(paciente.getId()).isPresent())
			return false;
		
		repository.save(paciente);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean UpdatePaciente(Long id, Paciente paciente) {

		if(!repository.findById(paciente.getId()).isPresent())
			return false;
		
		repository.save(paciente);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean DeletePaciente(Long id) {

		if(!repository.findById(id).isPresent())
			return false;
		
		repository.deleteById(id);

		return true;
	}	

	@Override
	@Transactional(readOnly = true)
	public Optional<Paciente> findByUsuario(String usuario){
		Optional<Paciente> opt = Optional.empty();
		List<Paciente> l = repository.findByNickUsuario(usuario);
		if (!l.isEmpty())
			opt = Optional.of(l.get(0));
		return opt;
	}

	@Override
	public Optional<Paciente> login (String usuario, String clave){
		Optional<Paciente> opt = Optional.empty();
		List<Paciente> l = repository.findByNickUsuario(usuario);
		if (l.isEmpty() || !l.get(0).getClave().equals(clave))
			return opt;
		return opt = Optional.of(l.get(0));
	}

}
