package pe.todotic.starwars.web.dto;

import lombok.Data;

@Data
public class EspecieResponseDTO {

    private Long id;
    private String nombre;
    private String clasificacion;
    private String designacion;
    private String alturaPromedio;
    private String vidaPromedio;
    private String coloresOjos;
    private String coloresCabello;
    private String coloresPiel;
    private String idioma;
    private PlanetaResponseDTO planetaOrigen;

}
