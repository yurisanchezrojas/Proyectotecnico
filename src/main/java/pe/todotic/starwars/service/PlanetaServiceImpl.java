package pe.todotic.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.todotic.starwars.domain.Planeta;
import pe.todotic.starwars.exception.ResourceNotFoundException;
import pe.todotic.starwars.repository.PlanetaRepository;
import pe.todotic.starwars.web.dto.PlanetaRequestDTO;
import pe.todotic.starwars.web.dto.PlanetaResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetaServiceImpl implements PlanetaService{

    @Autowired
    private PlanetaRepository planetaRepository;
    @Override
    public PlanetaResponseDTO crearPlaneta(PlanetaRequestDTO planetaRequestDTO) {
        Planeta planeta = new Planeta();

        planeta.setNombre(planetaRequestDTO.getNombre());
        planeta.setDiametro(planetaRequestDTO.getDiametro());
        planeta.setPeriodoRotacion(planetaRequestDTO.getPeriodoRotacion());
        planeta.setGravedad(planetaRequestDTO.getGravedad());
        planeta.setPoblacion(planetaRequestDTO.getPoblacion());
        planeta.setClima(planetaRequestDTO.getClima());
        planeta.setTerreno(planetaRequestDTO.getTerreno());
        planeta.setAguaSuperficie(planetaRequestDTO.getAguaSuperficie());

        Planeta planetaGuardado = planetaRepository.save(planeta);
        return mapearAResponseDTO(planetaGuardado);

    }
    @Override
    public PlanetaResponseDTO obtenerPlanetaPorId(Long id) {
        Planeta planeta = planetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planeta no encontrado con id: " + id));
        return mapearAResponseDTO(planeta);
    }

    @Override
    public List<PlanetaResponseDTO> obtenerTodosLosPlanetas() {
        List<Planeta> planetas = planetaRepository.findAll();
        return planetas.stream()
                .map(this::mapearAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanetaResponseDTO actualizarPlaneta(Long id, PlanetaRequestDTO planetaRequestDTO) {
        Planeta planeta = planetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planeta no encontrado con id: " + id));

        planeta.setNombre(planetaRequestDTO.getNombre());
        planeta.setDiametro(planetaRequestDTO.getDiametro());
        planeta.setPeriodoRotacion(planetaRequestDTO.getPeriodoRotacion());
        planeta.setGravedad(planetaRequestDTO.getGravedad());
        planeta.setPoblacion(planetaRequestDTO.getPoblacion());
        planeta.setClima(planetaRequestDTO.getClima());
        planeta.setTerreno(planetaRequestDTO.getTerreno());
        planeta.setAguaSuperficie(planetaRequestDTO.getAguaSuperficie());

        Planeta planetaActualizado = planetaRepository.save(planeta);
        return mapearAResponseDTO(planetaActualizado);

    }
    @Override
    public void eliminarPlaneta(Long id) {
        Planeta planeta = planetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planeta no encontrado con id: " + id));
        planetaRepository.delete(planeta);

    }

    private PlanetaResponseDTO mapearAResponseDTO(Planeta planeta) {
        PlanetaResponseDTO dto = new PlanetaResponseDTO();

        dto.setId(planeta.getId());
        dto.setNombre(planeta.getNombre());
        dto.setDiametro(planeta.getDiametro());
        dto.setPeriodoRotacion(planeta.getPeriodoRotacion());
        dto.setPeriodoOrbital(planeta.getPeriodoOrbital());
        dto.setGravedad(planeta.getGravedad());
        dto.setPoblacion(planeta.getPoblacion());
        dto.setClima(planeta.getClima());
        dto.setTerreno(planeta.getTerreno());
        dto.setAguaSuperficie(planeta.getAguaSuperficie());

        return dto;
    }


}













