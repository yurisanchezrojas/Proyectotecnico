package pe.todotic.starwars.service;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.todotic.starwars.domain.Especie;
import pe.todotic.starwars.domain.Planeta;
import pe.todotic.starwars.exception.ResourceNotFoundException;
import pe.todotic.starwars.repository.EspecieRepository;
import pe.todotic.starwars.repository.PlanetaRepository;
import pe.todotic.starwars.web.dto.EspecieRequestDTO;
import pe.todotic.starwars.web.dto.EspecieResponseDTO;
import pe.todotic.starwars.web.dto.PlanetaResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecieServiceImpl implements EspecieService{

    @Autowired
    private EspecieRepository especieRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Override
    public EspecieResponseDTO crearEspecie(EspecieRequestDTO especieRequestDTO) throws BadRequestException {

        if(especieRequestDTO == null){
            throw new BadRequestException("El DTO de especie no puede ser nulo.");
        }

        Especie especie = new Especie();
        especie.setNombre(especieRequestDTO.getNombre());
        especie.setClasificacion(especieRequestDTO.getClasificacion());
        especie.setDesignacion(especieRequestDTO.getDesignacion());
        especie.setAlturaPromedio(especieRequestDTO.getAlturaPromedio());
        especie.setVidaPromedio(especieRequestDTO.getVidaPromedio());
        especie.setColoresOjos(especieRequestDTO.getColoresOjos());
        especie.setColoresCabello(especieRequestDTO.getColoresCabello());
        especie.setColoresPiel(especieRequestDTO.getColoresPiel());
        especie.setIdioma(especieRequestDTO.getIdioma());

        // Mapear Planeta si existe
        if(especieRequestDTO.getPlanetaOrigenId() != null){
            Planeta planeta = planetaRepository.findById(especieRequestDTO.getPlanetaOrigenId())
                    .orElseThrow(() -> new ResourceNotFoundException("Planeta con ID "+ especieRequestDTO.getPlanetaOrigenId()+ " No encontrado"));
            especie.setPlanetaOrigen(planeta);
        }
        Especie especieGuardada = especieRepository.save(especie);

        return mapearResponseDTO(especieGuardada);
    }

    @Override
    public EspecieResponseDTO obtenerEspeciePorId(Long id) {
        Especie especie = especieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especie no encontrado con id: "+ id));
        return mapearResponseDTO(especie);
    }

    @Override
    public List<EspecieResponseDTO> obtenerTodasLasEspecies() {
        List<Especie> especies = especieRepository.findAll();
        return especies.stream()
                .map(this::mapearResponseDTO)
                .collect(Collectors.toList());

    }

    @Override
    public EspecieResponseDTO actualizarEspecie(Long id, EspecieRequestDTO especieRequestDTO) {
        Especie especie = especieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Especie no encontrado con id: "+ id));

        especie.setNombre(especieRequestDTO.getNombre());
        especie.setClasificacion(especieRequestDTO.getClasificacion());
        especie.setDesignacion(especieRequestDTO.getDesignacion());
        especie.setAlturaPromedio(especieRequestDTO.getAlturaPromedio());
        especie.setVidaPromedio(especieRequestDTO.getVidaPromedio());
        especie.setColoresOjos(especieRequestDTO.getColoresOjos());
        especie.setColoresCabello(especieRequestDTO.getColoresCabello());
        especie.setColoresPiel(especieRequestDTO.getColoresPiel());
        especie.setIdioma(especieRequestDTO.getIdioma());
        // Mapear Planeta si existe
        if(especieRequestDTO.getPlanetaOrigenId() != null){
            Planeta planeta = planetaRepository.findById(especieRequestDTO.getPlanetaOrigenId())
                    .orElseThrow(() -> new ResourceNotFoundException("Planeta con ID "+ especieRequestDTO.getPlanetaOrigenId()+ " No encontrado"));
            especie.setPlanetaOrigen(planeta);
        }

        Especie especieActualizada = especieRepository.save(especie);
        return mapearResponseDTO(especieActualizada);

    }

    @Override
    public void eliminarEspecie(Long id) {
        Especie especie = especieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Especie no encontrado con id: "+ id));
        especieRepository.delete(especie);
    }

    private EspecieResponseDTO mapearResponseDTO(Especie especie){
        EspecieResponseDTO especieResponseDTO = new EspecieResponseDTO();
        especieResponseDTO.setId(especie.getId());
        especieResponseDTO.setNombre(especie.getNombre());
        especieResponseDTO.setClasificacion(especie.getClasificacion());
        especieResponseDTO.setDesignacion(especie.getDesignacion());
        especieResponseDTO.setAlturaPromedio(especie.getAlturaPromedio());
        especieResponseDTO.setVidaPromedio(especie.getVidaPromedio());
        especieResponseDTO.setColoresOjos(especie.getColoresOjos());
        especieResponseDTO.setColoresCabello(especie.getColoresCabello());
        especieResponseDTO.setColoresPiel(especie.getColoresPiel());
        especieResponseDTO.setIdioma(especie.getIdioma());
        //Conversion de Planeta  a PlanetaResponseDTO
        if(especie.getPlanetaOrigen() != null){
            Planeta planeta = especie.getPlanetaOrigen();
            PlanetaResponseDTO responseDTO = new PlanetaResponseDTO();
            responseDTO.setId(planeta.getId());
            responseDTO.setNombre(planeta.getNombre());
            especieResponseDTO.setPlanetaOrigen(responseDTO);
        }
       return  especieResponseDTO;
    }
}
