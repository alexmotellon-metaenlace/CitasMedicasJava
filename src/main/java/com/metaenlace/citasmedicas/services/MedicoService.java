package com.metaenlace.citasmedicas.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaenlace.citasmedicas.models.Medico;
import com.metaenlace.citasmedicas.repositories.MedicoRepo;

@Service
public class MedicoService implements IMedicoService{

    @Autowired
	private MedicoRepo repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Medico> GetAllMedicos() {

		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Medico> GetMedicoById(Long id) {

		if(!repository.findById(id).isPresent())
			return null;

        return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Boolean AddMedico(Medico medico) {

		if(repository.findById(medico.getId()).isPresent())
			return false;
		
		repository.save(medico);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean UpdateMedico(Long id, Medico medico) {

		if(!repository.findById(medico.getId()).isPresent())
			return false;
		
		repository.save(medico);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean DeleteMedico(Long id) {

		if(!repository.findById(id).isPresent())
			return false;
		
		repository.deleteById(id);

		return true;
	}

		
	@Override
	@Transactional(readOnly = true)
	public Optional<Medico> findByUsuario(String usuario){
		Optional<Medico> opt = Optional.empty();
		List<Medico> l = repository.findByNickUsuario(usuario);
		if (!l.isEmpty())
			opt = Optional.of(l.get(0));
		return opt;
	}

	@Override
	public Optional<Medico> login (String usuario, String clave){
		Optional<Medico> opt = Optional.empty();
		List<Medico> l = repository.findByNickUsuario(usuario);
		if (l.isEmpty() || !l.get(0).getClave().equals(clave))
			return opt;
		return opt = Optional.of(l.get(0));
	}

}
