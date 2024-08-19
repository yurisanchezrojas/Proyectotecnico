package pe.todotic.starwars.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.todotic.starwars.service.PersonajeService;
import pe.todotic.starwars.web.dto.PersonajeRequestDTO;
import pe.todotic.starwars.web.dto.PersonajeResponseDTO;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/personajes")
public class PersonajeController {
    private final PersonajeService personajeService;

    @GetMapping
    public ResponseEntity<List<PersonajeResponseDTO>> obtenerTodosLosPersonajes() {
        List<PersonajeResponseDTO> personajes = personajeService.obtenerTodosLosPersonajes();
        return ResponseEntity.ok(personajes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeResponseDTO> obtenerPersonajePorId(@PathVariable Long id) {
        PersonajeResponseDTO personaje = personajeService.obtenerPersonajePorId(id);
        return ResponseEntity.ok(personaje);
    }

    @PostMapping
    public ResponseEntity<PersonajeResponseDTO> crearPersonaje(@RequestBody PersonajeRequestDTO personajeRequestDTO) {
        PersonajeResponseDTO personajeCreado = personajeService.crearPersonaje(personajeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeResponseDTO> actualizarPersonaje(@PathVariable Long id, @RequestBody PersonajeRequestDTO personajeRequestDTO) {
        PersonajeResponseDTO personajeActualizado = personajeService.actualizarPersonaje(id, personajeRequestDTO);
        return ResponseEntity.ok(personajeActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersonaje(@PathVariable Long id) {
        personajeService.eliminarPersonaje(id);
        return ResponseEntity.noContent().build();
    }
}












