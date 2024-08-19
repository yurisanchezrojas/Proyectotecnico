package pe.todotic.starwars.service;

import pe.todotic.starwars.web.dto.PersonajeRequestDTO;
import pe.todotic.starwars.web.dto.PersonajeResponseDTO;

import java.util.List;

public interface PersonajeService {
    PersonajeResponseDTO crearPersonaje(PersonajeRequestDTO personajeRequestDTO);
    PersonajeResponseDTO obtenerPersonajePorId(Long id);
    List<PersonajeResponseDTO> obtenerTodosLosPersonajes();
    PersonajeResponseDTO actualizarPersonaje(Long id, PersonajeRequestDTO personajeRequestDTO);
    void eliminarPersonaje(Long id);
}
