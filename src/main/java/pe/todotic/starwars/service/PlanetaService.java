package pe.todotic.starwars.service;

import pe.todotic.starwars.web.dto.PlanetaRequestDTO;
import pe.todotic.starwars.web.dto.PlanetaResponseDTO;

import java.util.List;

public interface PlanetaService {
    PlanetaResponseDTO crearPlaneta(PlanetaRequestDTO planetaRequestDTO);
    PlanetaResponseDTO obtenerPlanetaPorId(Long id);
    List<PlanetaResponseDTO> obtenerTodosLosPlanetas();
    PlanetaResponseDTO actualizarPlaneta(Long id, PlanetaRequestDTO planetaRequestDTO);
    void eliminarPlaneta(Long id);
}
