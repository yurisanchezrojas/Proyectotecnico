package pe.todotic.starwars.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "naves")
public class Nave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "clase_nave")
    private String claseNave;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "costo_en_creditos")
    private String costoEnCreditos;
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "tripulacion")
    private String tripulacion;
    @Column(name = "pasajeros")
    private String pasajeros;
    @Column(name = "velocidad_maxima_atmosferica")
    private String velocidadMaximaAtmosferica;
    @Column(name = "calificacion_hyperdrive")
    private String calificacionHyperdrive;
    @Column(name = "MGLT")
    private String MGLT;
    @Column(name = "capacidad_carga")
    private String capacidadCarga;
    @Column(name = "consumibles")
    private String consumibles;

    @ManyToMany(mappedBy = "naves")
    private List<Personaje> pilotos;

    @ManyToMany(mappedBy = "naves")
    private List<Pelicula> peliculas;


}
