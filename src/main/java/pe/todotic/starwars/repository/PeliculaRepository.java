package pe.todotic.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.starwars.domain.Pelicula;
import pe.todotic.starwars.domain.Personaje;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
    List<Pelicula> findByTitulo(String titulo);
    List<Pelicula> findByPersonajes(Personaje personaje);
}
