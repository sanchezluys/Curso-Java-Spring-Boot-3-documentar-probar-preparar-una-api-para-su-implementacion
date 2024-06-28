package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;

public class MedicoActivo {


    private MedicoRepository repository;

    public void validar(DatosAgendarConsulta datos){
        if(datos.idMedico() == null){
            return;
        }

        var medicoActivo=repository.findActivoById(datos.idMedico());

        if(!medicoActivo){
            throw new ValidationException("No se permite agendar con Medicos inactivos en sistema");
        }

    }
}
