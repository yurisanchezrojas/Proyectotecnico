package pe.todotic.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.starwars.domain.Personaje;
import pe.todotic.starwars.domain.Vehiculo;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
    List<Vehiculo> findByModelo(String modelo);
    List<Vehiculo> findByPilotos(Personaje personaje);
}
