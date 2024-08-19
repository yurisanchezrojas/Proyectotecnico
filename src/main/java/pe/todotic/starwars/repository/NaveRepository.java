package pe.todotic.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.starwars.domain.Nave;
import pe.todotic.starwars.domain.Personaje;

import java.util.List;

public interface NaveRepository extends JpaRepository<Nave,Long> {
    List<Nave> findByModelo(String modelo);
    List<Nave> findByPilotos(Personaje personaje);
}
