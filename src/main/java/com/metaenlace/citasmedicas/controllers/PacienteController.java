package com.metaenlace.citasmedicas.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.metaenlace.citasmedicas.models.Paciente;
import com.metaenlace.citasmedicas.models.DTO.PacienteDTO;
import com.metaenlace.citasmedicas.models.DTO.MessageDTO;
import com.metaenlace.citasmedicas.models.Converter.Converter;
import com.metaenlace.citasmedicas.services.IPacienteService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	@Autowired
	private Converter converter;
	
	@GetMapping
	public ResponseEntity<?> GetAllPacientes(){
		List<Paciente> pacientes = service.GetAllPacientes();
		if(pacientes==null)
			return ResponseEntity.ok(new MessageDTO(404, "No se ha encontrado ningún paciente"));
		
		return ResponseEntity.ok(new MessageDTO(200, pacientes));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> GetPaciente(@PathVariable Long id){
		Optional<Paciente> paciente = service.GetPacienteById(id);
		if(paciente!=null)
			return ResponseEntity.ok(new MessageDTO(200, paciente));

		return ResponseEntity.ok(new MessageDTO(404, "No se ha encontrado el paciente con ID "+id));
	}

	@PostMapping
	public ResponseEntity<MessageDTO> PostPaciente (@RequestBody PacienteDTO pacienteDTO) {
		Paciente paciente = converter.PDTOtoP(pacienteDTO);
		if (service.AddPaciente(paciente))
			return ResponseEntity.ok(new MessageDTO(200, "Paciente creado correctamente"));

		return ResponseEntity.ok(new MessageDTO(412, "El paciente con ID "+paciente.getId()+" ya existe, o no se puede crear"));
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageDTO> DeletePaciente(@PathVariable Long id){
		if(service.DeletePaciente(id))
			return ResponseEntity.ok(new MessageDTO(200, "Paciente eliminado correctamente"));

		return ResponseEntity.ok(new MessageDTO(404, "No se ha encontrado el paciente con ID "+id));
	}
	

	@PostMapping("/login")
	public ResponseEntity<MessageDTO> login(@RequestBody ObjectNode obj){
		String usuario = obj.get("nickUsuario").asText();
		String clave = obj.get("clave").asText();
		Optional<Paciente> opt = service.login(usuario, clave);
		if (opt.isPresent())
			return ResponseEntity.ok(new MessageDTO(200, opt.get()));
		return ResponseEntity.ok(new MessageDTO(404, "Usuario o clave incorrectos"));
	}

}