package com.metaenlace.citasmedicas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.metaenlace.citasmedicas.models.Usuario;
import com.metaenlace.citasmedicas.models.DTO.UsuarioDTO;
import com.metaenlace.citasmedicas.models.Converter.Converter;
import com.metaenlace.citasmedicas.services.IUsuarioService;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	@Autowired
	private Converter converter;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>>  GetAllUsuarios (){
		List<UsuarioDTO> out = new ArrayList<UsuarioDTO>();
		service.GetAllUsuarios().stream()
			.forEach(u -> out.add(converter.UtoUDTO(u)));
		return ResponseEntity.ok(out);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> GetUsuarioById (@PathVariable Long id){
		Optional<Usuario> opt = service.GetUsuarioById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(converter.UtoUDTO(opt.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<String> PostUsuario (@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = converter.UDTOtoU(usuarioDTO);
		if (service.AddUsuario(usuario)) {
			return ResponseEntity.ok("Usuario creado correctamente");
		}
		return ResponseEntity.status(412).build();
			
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteUsuario(@PathVariable Long id){
		service.DeleteUsuario(id);
		return ResponseEntity.ok("Usuario eliminado correctamente");
	}

}