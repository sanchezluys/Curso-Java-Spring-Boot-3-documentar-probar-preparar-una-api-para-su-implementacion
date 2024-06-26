package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

import java.time.DayOfWeek;

public class HorarioDeFuncionamientoClinica {
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
