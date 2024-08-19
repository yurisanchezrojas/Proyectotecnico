package pe.todotic.starwars.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "numero_episodio")
    private Integer numeroEpisodio;
    @Column(name = "introduccion")
    private String introduccion;
    @Column(name = "director")
    private String director;
    @Column(name = "productor")
    private String productor;
    @Column(name = "fecha_lanzamiento")
    private String fechaLanzamiento;

    @ManyToMany
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private List<Personaje> personajes;

    @ManyToMany
    @JoinTable(
            name = "pelicula_planeta",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "planeta_id"))
    private List<Planeta> planetas;

    @ManyToMany
    @JoinTable(
            name = "pelicula_especie",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "especie_id"))
    private List<Especie> especies;

    @ManyToMany
    @JoinTable(
            name = "pelicula_nave",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "nave_id"))
    private List<Nave> naves;

    @ManyToMany
    @JoinTable(
            name = "pelicula_vehiculo",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "vehiculo_id"))
    private List<Vehiculo> vehiculos;


}
