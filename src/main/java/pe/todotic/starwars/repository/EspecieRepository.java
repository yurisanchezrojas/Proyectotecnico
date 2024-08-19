package pe.todotic.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.starwars.domain.Especie;
import pe.todotic.starwars.domain.Planeta;

import java.util.List;

public interface EspecieRepository extends JpaRepository<Especie,Long> {
    List<Especie> findByNombre(String nombre);
    List<Especie> findByPlanetaOrigen(Planeta planetaOrigen);
}
