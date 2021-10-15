package com.metaenlace.citasmedicas.controllers;
import java.util.ArrayList;
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

import com.metaenlace.citasmedicas.models.Medico;
import com.metaenlace.citasmedicas.models.Paciente;
import com.metaenlace.citasmedicas.models.Cita;
import com.metaenlace.citasmedicas.models.DTO.CitaDTO;
import com.metaenlace.citasmedicas.services.ICitaService;
import com.metaenlace.citasmedicas.services.IPacienteService;
import com.metaenlace.citasmedicas.services.IMedicoService;
import com.metaenlace.citasmedicas.models.DTO.MessageDTO;
import com.metaenlace.citasmedicas.models.Converter.Converter;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private ICitaService service;
	@Autowired 
	private IMedicoService mService;
	@Autowired
	private IPacienteService pService;
	@Autowired
	private Converter converter;
	
	@GetMapping
	public ResponseEntity<MessageDTO> GetAllCitas(){
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.GetAllCitas().stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(new MessageDTO(200, out));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> GetCita (Long id){
		Optional<Cita> opt = service.GetCitaById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(new MessageDTO(200, converter.CtoCDTO(opt.get())));
		}
		return ResponseEntity.ok(new MessageDTO(404, null));
	}

	@PostMapping
	public ResponseEntity<MessageDTO> PostCita (@RequestBody CitaDTO citaDTO) {
		Optional<Paciente> paciente = pService.GetPacienteById(citaDTO.getPaciente());
		Optional<Medico> medico = mService.GetMedicoById(citaDTO.getMedico());
		if (!medico.isPresent() && !paciente.isPresent())
			return ResponseEntity.ok(new MessageDTO(404, "Paciente o Médico no registrados"));
		Cita cita = converter.CDTOtoC(citaDTO, medico.get(), paciente.get()); 
		if (service.AddCita(cita)) {
			return ResponseEntity.ok(new MessageDTO(200, "Cita guardada correctamente"));
		}
		return ResponseEntity.ok(new MessageDTO(404, "La cita con ID "+cita.id+" ya existe o no se puede crear"));
	} 
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageDTO> DeleteCita(@PathVariable Long id){
		if(service.DeleteCita(id))
			return ResponseEntity.ok(new MessageDTO(200, "Cita eliminada correctamente"));

		return ResponseEntity.ok(new MessageDTO(404, "No se ha encontrado la cita con ID "+id));
	}
	

}