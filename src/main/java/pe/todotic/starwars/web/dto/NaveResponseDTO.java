package pe.todotic.starwars.web.dto;

import lombok.Data;

@Data
public class NaveResponseDTO {
    private Long id;
    private String nombre;
    private String modelo;
    private String claseNave;
    private String fabricante;
    private String costoEnCreditos;
    private String longitud;
    private String tripulacion;
    private String pasajeros;
    private String velocidadMaximaAtmosferica;
    private String calificacionHyperdrive;
    private String MGLT;
    private String capacidadCarga;
    private String consumibles;
}
