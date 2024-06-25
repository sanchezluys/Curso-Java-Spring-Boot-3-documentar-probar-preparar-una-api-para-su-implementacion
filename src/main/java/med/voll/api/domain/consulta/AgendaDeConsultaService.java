package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;


    public void agendar(DatosAgendarConsulta datos) {

        var consulta = new Consulta(
                null,
                new Medico(),
                new Paciente(),
                datos.fecha()
        );

        consultaRepository.save(consulta);

    }
}
