package pe.todotic.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.todotic.starwars.domain.Vehiculo;
import pe.todotic.starwars.exception.ResourceNotFoundException;
import pe.todotic.starwars.repository.VehiculoRepository;
import pe.todotic.starwars.web.dto.VehiculoRequestDTO;
import pe.todotic.starwars.web.dto.VehiculoResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Override
    public VehiculoResponseDTO crearVehiculo(VehiculoRequestDTO vehiculoRequestDTO) {
        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setNombre(vehiculoRequestDTO.getNombre());
        vehiculo.setModelo(vehiculoRequestDTO.getModelo());
        vehiculo.setClaseVehiculo(vehiculoRequestDTO.getClaseVehiculo());
        vehiculo.setFabricante(vehiculoRequestDTO.getFabricante());
        vehiculo.setCostoEnCreditos(vehiculoRequestDTO.getCostoEnCreditos());
        vehiculo.setLongitud(vehiculoRequestDTO.getLongitud());
        vehiculo.setTripulacion(vehiculoRequestDTO.getTripulacion());
        vehiculo.setPasajeros(vehiculoRequestDTO.getPasajeros());
        vehiculo.setVelocidadMaximaAtmosferica(vehiculoRequestDTO.getVelocidadMaximaAtmosferica());
        vehiculo.setCapacidadCarga(vehiculoRequestDTO.getCapacidadCarga());
        vehiculo.setConsumibles(vehiculoRequestDTO.getConsumibles());

        Vehiculo vehiculoGuardado = vehiculoRepository.save(vehiculo);
        return mapearAResponseDTO(vehiculoGuardado);

    }

    @Override
    public VehiculoResponseDTO obtenerVehiculoPorId(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehiculo no encontrado con id: " + id));
        return mapearAResponseDTO(vehiculo);
    }

    @Override
    public List<VehiculoResponseDTO> obtenerTodosLosVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream()
                .map(this::mapearAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculoResponseDTO actualizarVehiculo(Long id, VehiculoRequestDTO vehiculoRequestDTO) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehiculo no encontrado con id: " + id));

        vehiculo.setNombre(vehiculoRequestDTO.getNombre());
        vehiculo.setModelo(vehiculoRequestDTO.getModelo());
        vehiculo.setClaseVehiculo(vehiculoRequestDTO.getClaseVehiculo());
        vehiculo.setFabricante(vehiculoRequestDTO.getFabricante());
        vehiculo.setCostoEnCreditos(vehiculoRequestDTO.getCostoEnCreditos());
        vehiculo.setLongitud(vehiculoRequestDTO.getLongitud());
        vehiculo.setTripulacion(vehiculoRequestDTO.getTripulacion());
        vehiculo.setPasajeros(vehiculoRequestDTO.getPasajeros());
        vehiculo.setVelocidadMaximaAtmosferica(vehiculoRequestDTO.getVelocidadMaximaAtmosferica());
        vehiculo.setCapacidadCarga(vehiculoRequestDTO.getCapacidadCarga());
        vehiculo.setConsumibles(vehiculoRequestDTO.getConsumibles());

        Vehiculo vehiculoActualizado = vehiculoRepository.save(vehiculo);
        return mapearAResponseDTO(vehiculoActualizado);

    }

    @Override
    public void eliminarVehiculo(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehiculo no encontrado con id: " + id));
        vehiculoRepository.delete(vehiculo);
    }

    private VehiculoResponseDTO mapearAResponseDTO(Vehiculo vehiculo) {
        VehiculoResponseDTO responseDTO = new VehiculoResponseDTO();

        responseDTO.setId(vehiculo.getId());
        responseDTO.setNombre(vehiculo.getNombre());
        responseDTO.setModelo(vehiculo.getModelo());
        responseDTO.setClaseVehiculo(vehiculo.getClaseVehiculo());
        responseDTO.setFabricante(vehiculo.getFabricante());
        responseDTO.setCostoEnCreditos(vehiculo.getCostoEnCreditos());
        responseDTO.setLongitud(vehiculo.getLongitud());
        responseDTO.setTripulacion(vehiculo.getTripulacion());
        responseDTO.setPasajeros(vehiculo.getPasajeros());
        responseDTO.setVelocidadMaximaAtmosferica(vehiculo.getVelocidadMaximaAtmosferica());
        responseDTO.setCapacidadCarga(vehiculo.getCapacidadCarga());
        responseDTO.setConsumibles(vehiculo.getConsumibles());

        return responseDTO;
    }
}


















