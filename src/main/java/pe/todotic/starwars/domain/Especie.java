package pe.todotic.starwars.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "especies")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "clasificacion")
    private String clasificacion;

    @Column(name = "designacion")
    private String designacion;

    @Column(name = "altura_promedio")
    private String alturaPromedio;

    @Column(name = "vida_promedio")
    private String vidaPromedio;

    @Column(name = "colores_ojos")
    private String coloresOjos;

    @Column(name = "colores_cabello")
    private String coloresCabello;

    @Column(name = "colores_piel")
    private String coloresPiel;

    @Column(name = "idioma")
    private String idioma;

    @ManyToOne
    @JoinColumn(name = "planeta_origen_id")
    private Planeta planetaOrigen;

    @ManyToMany(mappedBy = "especies")
    private List<Personaje> personajes;

    @ManyToMany(mappedBy = "especies")
    private List<Pelicula> peliculas;
}
