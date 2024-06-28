package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

public class MedicoConConsulta {
    private ConsultaRepository repository;


    public void validar(DatosAgendarConsulta datos){
        //validar que el médico no tenga una consulta en ese día y horario
        if(datos.idMedico() == null){
            return;
        }


        var medicoConConsulta= repository.existsByMedicoIdAndData(datos.idMedico(), datos.fecha());

        if(medicoConConsulta){
            throw new ValidationException("El médico ya tiene una consulta en ese día y horario");
        }
    }
}
