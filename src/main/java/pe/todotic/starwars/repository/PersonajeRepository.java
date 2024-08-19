package pe.todotic.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.starwars.domain.Pelicula;
import pe.todotic.starwars.domain.Personaje;

import java.util.List;

public interface PersonajeRepository extends JpaRepository<Personaje,Long> {
    List<Personaje> findByNombre(String nombre);
    List<Personaje> findByPeliculas(Pelicula pelicula);
}
