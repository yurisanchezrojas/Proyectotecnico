package pe.todotic.starwars.service;

import pe.todotic.starwars.web.dto.NaveRequestDTO;
import pe.todotic.starwars.web.dto.NaveResponseDTO;

import java.util.List;

public interface NaveService {
    NaveResponseDTO crearNave(NaveRequestDTO naveRequestDTO);
    NaveResponseDTO obtenerNavePorId(Long id);
    List<NaveResponseDTO> obtenerTodasLasNaves();
    NaveResponseDTO actualizarNave(Long id, NaveRequestDTO naveRequestDTO);
    void eliminarNave(Long id);
}
