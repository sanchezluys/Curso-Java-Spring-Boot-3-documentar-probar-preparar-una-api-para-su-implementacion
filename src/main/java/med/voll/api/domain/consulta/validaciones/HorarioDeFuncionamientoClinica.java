package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class HorarioDeFuncionamientoClinica implements ValidadorDeConsultas{
    public void validar(DatosAgendarConsulta datos){
        //validar horario de funcionamiento de la clinica
        var domingo = DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());
        var antesDeApertura= datos.fecha().getHour() < 7;
        var despuesDeCierre= datos.fecha().getHour() > 19;

        if(domingo || antesDeApertura || despuesDeCierre){
            throw new ValidationException("El horario es de lun-sab 7 am a 19 horas");
        }
    }
}
