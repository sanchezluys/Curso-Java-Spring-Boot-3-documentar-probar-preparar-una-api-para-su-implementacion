package med.voll.api.domain.consulta.validaciones;


import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class HorarioDeAnticipacion implements ValidadorDeConsultas{
    public void validar(DatosAgendarConsulta datos){
        var ahora = LocalDateTime.now();
        var horaDeConsulta= datos.fecha();

        var diferenciaDe30min= Duration.between(ahora, horaDeConsulta).toMinutes() < 30;

        if(diferenciaDe30min){
            throw new ValidationException("Las consultas se deben hacer con 30 min de anticipación");
        }
    }
}
