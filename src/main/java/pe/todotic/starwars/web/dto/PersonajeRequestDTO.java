package pe.todotic.starwars.web.dto;

import lombok.Data;

@Data
public class PersonajeRequestDTO {

    private String nombre;
    private String anioNacimiento;
    private String colorOjos;
    private String genero;
    private String colorCabello;
    private String altura;
    private String masa;
    private String colorPiel;
    private Long planetaOrigenId;
}
