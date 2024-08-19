package pe.todotic.starwars.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "planetas")
public class Planeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "diametro")
    private String diametro;

    @Column(name = "periodo_rotacion")
    private String periodoRotacion;

    @Column(name = "periodo_orbital")
    private String periodoOrbital;

    @Column(name = "gravedad")
    private String gravedad;

    @Column(name = "poblacion")
    private String poblacion;

    @Column(name = "clima")
    private String clima;

    @Column(name = "terreno")
    private String terreno;

    @Column(name = "agua_superficie")
    private String aguaSuperficie;

    @ManyToMany(mappedBy = "planetas")
    private List<Pelicula> peliculas;

    @OneToMany(mappedBy = "planetaOrigen")
    private List<Personaje> residentes;
}
