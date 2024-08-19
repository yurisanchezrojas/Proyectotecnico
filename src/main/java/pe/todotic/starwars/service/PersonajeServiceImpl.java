package pe.todotic.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.todotic.starwars.domain.Personaje;
import pe.todotic.starwars.domain.Planeta;
import pe.todotic.starwars.exception.ResourceNotFoundException;
import pe.todotic.starwars.repository.EspecieRepository;
import pe.todotic.starwars.repository.PersonajeRepository;
import pe.todotic.starwars.repository.PlanetaRepository;
import pe.todotic.starwars.web.dto.PersonajeRequestDTO;
import pe.todotic.starwars.web.dto.PersonajeResponseDTO;
import pe.todotic.starwars.web.dto.PlanetaResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements  PersonajeService{

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Override
    public PersonajeResponseDTO crearPersonaje(PersonajeRequestDTO personajeRequestDTO) {
        Personaje personaje = new Personaje();
        personaje.setNombre(personajeRequestDTO.getNombre());
        personaje.setAnioNacimiento(personajeRequestDTO.getAnioNacimiento());
        personaje.setColorOjos(personajeRequestDTO.getColorOjos());
        personaje.setGenero(personajeRequestDTO.getGenero());
        personaje.setColorCabello(personajeRequestDTO.getColorCabello());
        personaje.setAltura(personajeRequestDTO.getAltura());
        personaje.setMasa(personajeRequestDTO.getMasa());
        personaje.setColorPiel(personajeRequestDTO.getColorPiel());
        // Mapear Planeta si existe
        if(personajeRequestDTO.getPlanetaOrigenId()!= null){
            Planeta planeta = planetaRepository.findById(personajeRequestDTO.getPlanetaOrigenId())
                    .orElseThrow(()-> new ResourceNotFoundException("Personaje con ID: "+ personajeRequestDTO.getPlanetaOrigenId()+ " no encontrado"));
            personaje.setPlanetaOrigen(planeta);
        }
         Personaje personajeGuardado = personajeRepository.save(personaje);
        return mapearAResponseDTO(personajeGuardado);
    }

    @Override
    public PersonajeResponseDTO obtenerPersonajePorId(Long id) {
        Personaje personaje = personajeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje no encontrado con id: " + id));
        return mapearAResponseDTO(personaje);
    }

    @Override
    public List<PersonajeResponseDTO> obtenerTodosLosPersonajes() {
        List<Personaje> personajes = personajeRepository.findAll();
        return personajes.stream()
                .map(this::mapearAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonajeResponseDTO actualizarPersonaje(Long id, PersonajeRequestDTO personajeRequestDTO) {
        Personaje personaje = personajeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje no encontrado con id: " + id));

        personaje.setNombre(personajeRequestDTO.getNombre());
        personaje.setAnioNacimiento(personajeRequestDTO.getAnioNacimiento());
        personaje.setColorOjos(personajeRequestDTO.getColorOjos());
        personaje.setGenero(personajeRequestDTO.getGenero());
        personaje.setColorCabello(personajeRequestDTO.getColorCabello());
        personaje.setAltura(personajeRequestDTO.getAltura());
        personaje.setMasa(personajeRequestDTO.getMasa());
        personaje.setColorPiel(personajeRequestDTO.getColorPiel());

        // Mapear Planeta si existe
        if(personajeRequestDTO.getPlanetaOrigenId()!= null){
            Planeta planeta = planetaRepository.findById(personajeRequestDTO.getPlanetaOrigenId())
                    .orElseThrow(()-> new ResourceNotFoundException("Personaje con ID: "+ personajeRequestDTO.getPlanetaOrigenId()+ " no encontrado"));
            personaje.setPlanetaOrigen(planeta);
        }

        Personaje personajeActulizado = personajeRepository.save(personaje);
        return mapearAResponseDTO(personajeActulizado);
    }

    @Override
    public void eliminarPersonaje(Long id) {
        Personaje personaje = personajeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje no encontrado con id: " + id));
        personajeRepository.delete(personaje);

    }

    private PersonajeResponseDTO mapearAResponseDTO(Personaje personaje) {
        PersonajeResponseDTO personajeResponseDTO = new PersonajeResponseDTO();

        personajeResponseDTO.setId(personaje.getId());
        personajeResponseDTO.setNombre(personaje.getNombre());
        personajeResponseDTO.setAnioNacimiento(personaje.getAnioNacimiento());
        personajeResponseDTO.setColorOjos(personaje.getColorOjos());
        personajeResponseDTO.setGenero(personaje.getGenero());
        personajeResponseDTO.setColorCabello(personaje.getColorCabello());
        personajeResponseDTO.setAltura(personaje.getAltura());
        personajeResponseDTO.setMasa(personaje.getMasa());
        personajeResponseDTO.setColorPiel(personaje.getColorPiel());
        //Conversion de Planeta  a PlanetaResponseDTO
        if(personaje.getPlanetaOrigen()!= null){
            Planeta planeta = personaje.getPlanetaOrigen();
            PlanetaResponseDTO responseDTO = new PlanetaResponseDTO();
            responseDTO.setId(planeta.getId());
            responseDTO.setNombre(planeta.getNombre());
            personajeResponseDTO.setPlanetaOrigen(responseDTO);
        }
        return personajeResponseDTO;
    }
}










