package com.metaenlace.citasmedicas.models.Converter;

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

public interface IConverter {

    public Usuario UDTOtoU(UsuarioDTO usuarioDTO);
	
	public UsuarioDTO UtoUDTO(Usuario usuario);
	
	public Paciente PDTOtoP(PacienteDTO pacienteDTO);
	
	public PacienteDTO PtoPDTO(Paciente paciente);
	
	public Medico MDTOtoM(MedicoDTO medicoDTO);
	
	public MedicoDTO MtoMDTO(Medico medico);
	
	public Cita CDTOtoC(CitaDTO citaDTO, Medico medico, Paciente paciente);
	
	public CitaDTO CtoCDTO(Cita cita);
	
	public Diagnostico DDTOtoD (DiagnosticoDTO diagnosticoDTO);
	
	public DiagnosticoDTO DtoDDTO(Diagnostico diagnostico);
    
}
