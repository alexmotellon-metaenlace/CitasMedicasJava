package com.metaenlace.citasmedicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaenlace.citasmedicas.models.Usuario;
import com.metaenlace.citasmedicas.repositories.UsuarioRepo;


@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private UsuarioRepo repository;
		
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> GetAllUsuarios() {
		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> GetUsuarioById(Long id) {

		if(!repository.findById(id).isPresent())
			return null;

        return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Boolean AddUsuario(Usuario usuario) {

		if(repository.findById(usuario.getId()).isPresent())
			return false;
		
		repository.save(usuario);

		return true;
	}

	@Override
	@Transactional
	public Boolean UpdateUsuario(Long id, Usuario usuario) {

		if(!repository.findById(usuario.getId()).isPresent())
			return false;
		
		repository.save(usuario);
		
		return true;
	}

	@Override
	@Transactional
	public Boolean DeleteUsuario(Long id) {

		if(!repository.findById(id).isPresent())
			return false;
		
		repository.deleteById(id);

		return true;
	}
}