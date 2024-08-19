package pe.todotic.starwars.web.dto;

import lombok.Data;

@Data
public class PlanetaResponseDTO {
    private Long id;
    private String nombre;
    private String diametro;
    private String periodoRotacion;
    private String periodoOrbital;
    private String gravedad;
    private String poblacion;
    private String clima;
    private String terreno;
    private String aguaSuperficie;
}
