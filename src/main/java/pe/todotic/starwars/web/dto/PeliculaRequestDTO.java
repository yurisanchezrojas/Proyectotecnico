package pe.todotic.starwars.web.dto;

import lombok.Data;

@Data
public class PeliculaRequestDTO {
    private String titulo;
    private Integer numeroEpisodio;
    private String introduccion;
    private String director;
    private String productor;
    private String fechaLanzamiento;
}
