## Curso:
### Instructor:
### Academia: Alura Latam
### Programa: One Next Oracle Education G6: 2024


![img.png](img.png)

| Clase | Descripción                                                                 | Observaciones |
|-------|-----------------------------------------------------------------------------|---------------|
| 01-04 | Nueva funcionalidad                                                         |               |
|       | se deifinen las nuevas opciones para agendar nueva cita                     |               |
|       | se definen las reglas de negocio                                            |               |
|       |                                                                             |               |
| 01-05 | Consulta controller                                                         |               |
|       | Se crea la clase consultacontroller con las siguientes anotaciones:         |               |
|       | @Component, @ResponseBody, @RequestMapping("/consultas")                    |               |
|       | se crea el dto DatosAgendarConsulta                                         |               |
|       | se crea el dto DatosDetalleConsulta                                         |               |
|       | se crea la entidad Consulta                                                 |               |
|       | se agregan los dto para pacientes                                           |               |
|       | se agregan las migraciones de crear tabla pacientes y tabla consultas       |               |
|       |                                                                             |               |
| 01-08 | Clase Service                                                               |               |
|       | se revisan las validaciones basandose en las reglas del negocio             |               |
|       | se corrige errores,                                                         |               |
|       | 1. consultacontroller debia ser marcada con @controller y no con @component |               |
|       | 2. el payload para agregar la consulta era con guiones 2024-10-10           |               |
|       | se crea el service agendadeconsultaservice                                  |               |


## Reglas del Negocio

### Agendamiento de consultas

    El sistema debe contar con una funcionalidad que permita agendar citas, en la cual se debe llenar la siguiente información:

    Paciente
    Medico
    Consulta fecha/hora
    Las siguientes reglas de negocio deben ser validadas por el sistema:
    El horario de atención de la clínica es de lunes a sábado, de 07:00 a 19:00 horas;
    Las consultas tienen una duración fija de 1 hora;
    Las consultas deben programarse con al menos 30 minutos de anticipación;
    No permitir agendar citas con pacientes inactivos en el sistema;
    No permitir programar citas con médicos inactivos en el sistema;
    No permita programar más de una consulta en el mismo día para el mismo paciente;
    No permitir programar una cita con un médico que ya tiene otra cita programada en la misma fecha/hora;
    La elección de un médico es opcional, en cuyo caso de que no exista el id el sistema debe elegir aleatoriamente un médico que esté disponible en la fecha/hora ingresada.


### Cancelacion de consultas

    El sistema deberá contar con una funcionalidad que permita la cancelación de consultas, en la cual se deberá diligenciar la siguiente información:

    Consulta
    Motivo de la cancelación
    Las siguientes reglas de negocio deben ser validadas por el sistema:
    Es obligatorio informar el motivo de la cancelación de la consulta, entre las opciones: paciente se retiró, médico canceló u otras;
    Una cita solo se puede cancelar con al menos 24 horas de anticipación.

### Payload para agregar nueva consulta

    {
        "idPaciente":"1",
        "idMedico":"1",
        "fecha":"2024-11-12T10:30"
    }