package pe.todotic.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.starwars.domain.Pelicula;
import pe.todotic.starwars.domain.Planeta;

import java.util.List;

public interface PlanetaRepository extends JpaRepository<Planeta,Long> {
    List<Planeta> findByNombre(String nombre);
    List<Planeta> findByPeliculas(Pelicula pelicula);
}
