package pe.todotic.starwars.web.dto;

import lombok.Data;

@Data
public class VehiculoRequestDTO {
    private String nombre;
    private String modelo;
    private String claseVehiculo;
    private String fabricante;
    private String costoEnCreditos;
    private String longitud;
    private String tripulacion;
    private String pasajeros;
    private String velocidadMaximaAtmosferica;
    private String capacidadCarga;
    private String consumibles;
}
