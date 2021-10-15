package com.metaenlace.citasmedicas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.metaenlace.citasmedicas.models.Medico;
import com.metaenlace.citasmedicas.models.DTO.MedicoDTO;
import com.metaenlace.citasmedicas.services.IMedicoService;
import com.metaenlace.citasmedicas.models.DTO.MessageDTO;
import com.metaenlace.citasmedicas.models.Converter.Converter;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private IMedicoService service;
	@Autowired
	private Converter converter;

	@GetMapping
	public ResponseEntity<MessageDTO> GetAllMedicos(){
		List<Medico> medicos = service.GetAllMedicos();
		if(medicos==null)
			return ResponseEntity.ok(new MessageDTO(404, "No se ha encontrado ningún médico"));
		
		return ResponseEntity.ok(new MessageDTO(200, medicos));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> GetMedico(@PathVariable Long id){
		Optional<Medico> medico = service.GetMedicoById(id);
		if(medico!=null)
			return ResponseEntity.ok(new MessageDTO(200, medico));

		return ResponseEntity.ok(new MessageDTO(404, "No se ha encontrado el medico con ID "+id));
	}
	
	@PostMapping
	public ResponseEntity<MessageDTO> PostMedico(@RequestBody MedicoDTO medicoDTO) {
		Medico medico = converter.MDTOtoM(medicoDTO);
		if (service.AddMedico(medico)) 
			return ResponseEntity.ok(new MessageDTO(200, "Médico creado correctamente"));;

		return ResponseEntity.ok(new MessageDTO(412, "El médico con ID "+medico.getId()+" ya existe, o no se puede crear"));
	}
		
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageDTO> DeleteMedico(@PathVariable Long id){
		if(service.DeleteMedico(id))
			return ResponseEntity.ok(new MessageDTO(200, "Medico eliminado correctamente"));

		return ResponseEntity.ok(new MessageDTO(404, "No se ha encontrado el médico con ID "+id));
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<MessageDTO> login(@RequestBody ObjectNode obj){
		String usuario = obj.get("nickUsuario").asText();
		String clave = obj.get("clave").asText();
		Optional<Medico> opt = service.login(usuario, clave);
		if (opt.isPresent())
			return ResponseEntity.ok(new MessageDTO(200, opt.get()));
		return ResponseEntity.ok(new MessageDTO(404, "Usuario o clave incorrectos"));

	}
}