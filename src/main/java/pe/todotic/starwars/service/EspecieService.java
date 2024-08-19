package pe.todotic.starwars.service;

import org.apache.coyote.BadRequestException;
import pe.todotic.starwars.web.dto.EspecieRequestDTO;
import pe.todotic.starwars.web.dto.EspecieResponseDTO;

import java.util.List;

public interface EspecieService {
    EspecieResponseDTO crearEspecie(EspecieRequestDTO especieRequestDTO) throws BadRequestException;
    EspecieResponseDTO obtenerEspeciePorId(Long id);
    List<EspecieResponseDTO> obtenerTodasLasEspecies();
    EspecieResponseDTO actualizarEspecie(Long id, EspecieRequestDTO especieRequestDTO);
    void eliminarEspecie(Long id);
}
