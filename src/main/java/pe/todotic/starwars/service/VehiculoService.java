package pe.todotic.starwars.service;

import pe.todotic.starwars.web.dto.VehiculoRequestDTO;
import pe.todotic.starwars.web.dto.VehiculoResponseDTO;

import java.util.List;

public interface VehiculoService {
    VehiculoResponseDTO crearVehiculo(VehiculoRequestDTO vehiculoRequestDTO);
    VehiculoResponseDTO obtenerVehiculoPorId(Long id);
    List<VehiculoResponseDTO> obtenerTodosLosVehiculos();
    VehiculoResponseDTO actualizarVehiculo(Long id, VehiculoRequestDTO vehiculoRequestDTO);
    void eliminarVehiculo(Long id);
}
