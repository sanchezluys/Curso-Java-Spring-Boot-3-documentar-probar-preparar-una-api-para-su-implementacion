package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PacienteActivo {


    private PacienteRepository pacienteRepository;

    public void validar(DatosAgendarConsulta datos){
        if(datos.idPaciente() == null){
            return;
        }

        var pacienteActivo=PacienteRepository.findActivoById(datos.idPaciente());
    }
}
