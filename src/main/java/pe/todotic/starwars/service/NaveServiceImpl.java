package pe.todotic.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.todotic.starwars.domain.Nave;
import pe.todotic.starwars.exception.ResourceNotFoundException;
import pe.todotic.starwars.repository.NaveRepository;
import pe.todotic.starwars.web.dto.NaveRequestDTO;
import pe.todotic.starwars.web.dto.NaveResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NaveServiceImpl implements  NaveService{

    @Autowired
    private NaveRepository naveRepository;
    @Override
    public NaveResponseDTO crearNave(NaveRequestDTO naveRequestDTO) {
        Nave nave = new Nave();

        nave.setNombre(naveRequestDTO.getNombre());
        nave.setModelo(naveRequestDTO.getModelo());
        nave.setClaseNave(naveRequestDTO.getClaseNave());
        nave.setFabricante(naveRequestDTO.getFabricante());
        nave.setCostoEnCreditos(naveRequestDTO.getCostoEnCreditos());
        nave.setLongitud(naveRequestDTO.getLongitud());
        nave.setTripulacion(naveRequestDTO.getTripulacion());
        nave.setPasajeros(naveRequestDTO.getPasajeros());
        nave.setVelocidadMaximaAtmosferica(naveRequestDTO.getVelocidadMaximaAtmosferica());
        nave.setCalificacionHyperdrive(naveRequestDTO.getCalificacionHyperdrive());
        nave.setMGLT(naveRequestDTO.getMGLT());
        nave.setCapacidadCarga(naveRequestDTO.getCapacidadCarga());
        nave.setConsumibles(naveRequestDTO.getConsumibles());

        Nave naveGuardada = naveRepository.save(nave);
        return  mapearAResponseDTO(naveGuardada);

    }

    @Override
    public NaveResponseDTO obtenerNavePorId(Long id) {
        Nave nave = naveRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Nave no encontrada con id: "+ id));
        return mapearAResponseDTO(nave);
    }

    @Override
    public List<NaveResponseDTO> obtenerTodasLasNaves() {
        List<Nave> naves = naveRepository.findAll();
        return naves.stream()
                .map(this::mapearAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NaveResponseDTO actualizarNave(Long id, NaveRequestDTO naveRequestDTO) {
        Nave nave = naveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nave no encontrada con id: " + id));

        nave.setNombre(naveRequestDTO.getNombre());
        nave.setModelo(naveRequestDTO.getModelo());
        nave.setClaseNave(naveRequestDTO.getClaseNave());
        nave.setFabricante(naveRequestDTO.getFabricante());
        nave.setCostoEnCreditos(naveRequestDTO.getCostoEnCreditos());
        nave.setLongitud(naveRequestDTO.getLongitud());
        nave.setTripulacion(naveRequestDTO.getTripulacion());
        nave.setPasajeros(naveRequestDTO.getPasajeros());
        nave.setVelocidadMaximaAtmosferica(naveRequestDTO.getVelocidadMaximaAtmosferica());
        nave.setCalificacionHyperdrive(naveRequestDTO.getCalificacionHyperdrive());
        nave.setMGLT(naveRequestDTO.getMGLT());
        nave.setCapacidadCarga(naveRequestDTO.getCapacidadCarga());
        nave.setConsumibles(naveRequestDTO.getConsumibles());

        Nave naveActualizada = naveRepository.save(nave);
        return mapearAResponseDTO(naveActualizada);

    }

    @Override
    public void eliminarNave(Long id) {
        Nave nave = naveRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Nave no encontrada con id: " + id));
        naveRepository.delete(nave);

    }

    private NaveResponseDTO mapearAResponseDTO(Nave nave){
        NaveResponseDTO dto = new NaveResponseDTO();

        dto.setId(nave.getId());
        dto.setNombre(nave.getNombre());
        dto.setModelo(nave.getModelo());
        dto.setClaseNave(nave.getClaseNave());
        dto.setFabricante(nave.getFabricante());
        dto.setCostoEnCreditos(nave.getCostoEnCreditos());
        dto.setLongitud(nave.getLongitud());
        dto.setTripulacion(nave.getTripulacion());
        dto.setPasajeros(nave.getPasajeros());
        dto.setVelocidadMaximaAtmosferica(nave.getVelocidadMaximaAtmosferica());
        dto.setCalificacionHyperdrive(nave.getCalificacionHyperdrive());
        dto.setMGLT(nave.getMGLT());
        dto.setCapacidadCarga(nave.getCapacidadCarga());
        dto.setConsumibles(nave.getConsumibles());
        return  dto;

    }
}























