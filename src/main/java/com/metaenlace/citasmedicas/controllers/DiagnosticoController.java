package com.metaenlace.citasmedicas.controllers;

import java.util.ArrayList;
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

import com.metaenlace.citasmedicas.models.Diagnostico;
import com.metaenlace.citasmedicas.models.DTO.DiagnosticoDTO;
import com.metaenlace.citasmedicas.models.DTO.MessageDTO;
import com.metaenlace.citasmedicas.models.Converter.Converter;
import com.metaenlace.citasmedicas.services.IDiagnosticoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
	
	@Autowired
	private IDiagnosticoService service;
	@Autowired
	private Converter converter;
	
	@GetMapping
	public ResponseEntity<MessageDTO> GetAllDiagnosticos(){
		List<DiagnosticoDTO> out = new ArrayList<DiagnosticoDTO>();
		service.GetAllDiagnosticos().stream()
			.forEach(d -> out.add(converter.DtoDDTO(d)));
		return ResponseEntity.ok(new MessageDTO(200, out));
	}
	
	@PostMapping
	public ResponseEntity<MessageDTO> PostDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
		Diagnostico diagnostico = converter.DDTOtoD(diagnosticoDTO);
		if (service.AddDiagnostico(diagnostico)) {
			return ResponseEntity.ok(new MessageDTO(200, "Diágnostico creado correctamente"));
		}
		return ResponseEntity.ok(new MessageDTO(404, "El diagnóstico con ID "+diagnostico.id+" ya existe o no se puede crear"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> GetDiagnostico(@PathVariable Long id){
		Optional<Diagnostico> opt = service.GetDiagnosticoById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(new MessageDTO(200, converter.DtoDDTO(opt.get())));
		}
		return ResponseEntity.ok(new MessageDTO(404, null));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageDTO> DeleteDiagnostico(@PathVariable Long id){
		service.DeleteDiagnostico(id);
		return ResponseEntity.ok(new MessageDTO(200, "Diagnóstico eliminado correctamente"));
	}
}