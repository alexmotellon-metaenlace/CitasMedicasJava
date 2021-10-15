package com.metaenlace.citasmedicas.models.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.metaenlace.citasmedicas.models.Usuario;
import com.metaenlace.citasmedicas.models.Paciente;
import com.metaenlace.citasmedicas.models.Medico;
import com.metaenlace.citasmedicas.models.Cita;
import com.metaenlace.citasmedicas.models.Diagnostico;
import com.metaenlace.citasmedicas.models.DTO.UsuarioDTO;
import com.metaenlace.citasmedicas.models.DTO.PacienteDTO;
import com.metaenlace.citasmedicas.models.DTO.MedicoDTO;
import com.metaenlace.citasmedicas.models.DTO.CitaDTO;
import com.metaenlace.citasmedicas.models.DTO.DiagnosticoDTO;

@Component
public class Converter implements IConverter{
	
	private ModelMapper mapper = new ModelMapper();
	
	public Usuario UDTOtoU(UsuarioDTO usuarioDTO) {
		return mapper.map(usuarioDTO, Usuario.class);
	}
	
	public UsuarioDTO UtoUDTO(Usuario usuario) {
		return mapper.map(usuario, UsuarioDTO.class); 
	}
	
	public Paciente PDTOtoP(PacienteDTO pacienteDTO) {
		return mapper.map(pacienteDTO, Paciente.class);
	}
	
	public PacienteDTO PtoPDTO(Paciente paciente) {
		return mapper.map(Paciente.class, PacienteDTO.class);		
	}
	
	public Medico MDTOtoM(MedicoDTO medicoDTO) {
		return mapper.map(medicoDTO, Medico.class);
	}
	
	public MedicoDTO MtoMDTO(Medico medico) {
		
		return mapper.map(Medico.class, MedicoDTO.class);
	}
	
	public Cita CDTOtoC(CitaDTO citaDTO, Medico medico, Paciente paciente) {
		Cita cita = mapper.typeMap(CitaDTO.class, Cita.class)
				.addMappings(mappr -> mappr.skip(Cita::setFechaHora))
				.addMappings(mappr -> mappr.skip(Cita::setMedico))
				.addMappings(mappr -> mappr.skip(Cita::setPaciente))
				.map(citaDTO);
		try {
			cita.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(citaDTO.getFechaHora()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cita.setMedico(medico);
		cita.setPaciente(paciente);
		return cita;
	}
	
	public CitaDTO CtoCDTO(Cita cita) {
		CitaDTO dto = mapper.typeMap(Cita.class, CitaDTO.class)
				.addMappings(mappr -> mappr.skip(CitaDTO::setMedico))
				.addMappings(mappr -> mappr.skip(CitaDTO::setPaciente))
				.addMappings(mappr -> mappr.skip(CitaDTO::setFechaHora))
				.map(cita);
		//dto.setDiagnostico(cita.getDiagnostico().getId());
		dto.setMedico(cita.getMedico().getId());
		dto.setPaciente(cita.getPaciente().getId());
		dto.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cita.getFechaHora()));
		return dto;
	}
	
	public Diagnostico DDTOtoD (DiagnosticoDTO diagnosticoDTO) {
		return mapper.map(diagnosticoDTO, Diagnostico.class);
	}
	
	public DiagnosticoDTO DtoDDTO(Diagnostico diagnostico) {
		return mapper.map(diagnostico, DiagnosticoDTO.class);
	}
	
}