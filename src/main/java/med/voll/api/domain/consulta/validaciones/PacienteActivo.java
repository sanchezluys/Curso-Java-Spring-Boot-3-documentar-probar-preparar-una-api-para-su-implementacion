package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements ValidadorDeConsultas{

    @Autowired
    public PacienteRepository pacienteRepository;

    public void validar(DatosAgendarConsulta datos){
        if(datos.idPaciente() == null){
            return;
        }

        boolean pacienteActivo= PacienteRepository.findActivoById(datos.idPaciente());

        if(!pacienteActivo){
            throw new ValidationException("No se permite agendar con pacientes inactivos en sistema");
        }

    }
}
