package pe.todotic.starwars.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "anio_nacimiento")
    private String anioNacimiento;

    @Column(name = "color_ojos")
    private String colorOjos;

    @Column(name = "genero")
    private String genero;

    @Column(name = "color_cabello")
    private String colorCabello;

    @Column(name = "altura")
    private String altura;

    @Column(name = "masa")
    private String masa;

    @Column(name = "color_piel")
    private String colorPiel;

    @ManyToOne
    @JoinColumn(name = "planeta_origen_id")
    private Planeta planetaOrigen;

    @ManyToMany
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private List<Pelicula> peliculas;

    @ManyToMany
    @JoinTable(
            name = "personaje_especie",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "especie_id"))
    private List<Especie> especies;

    @ManyToMany
    @JoinTable(
            name = "personaje_nave",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "nave_id"))
    private List<Nave> naves;

    @ManyToMany
    @JoinTable(
            name = "personaje_vehiculo",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "vehiculo_id"))
    private List<Vehiculo> vehiculos;


}
