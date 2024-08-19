package pe.todotic.starwars.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.todotic.starwars.service.PeliculaService;
import pe.todotic.starwars.web.dto.PeliculaRequestDTO;
import pe.todotic.starwars.web.dto.PeliculaResponseDTO;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<PeliculaResponseDTO>> obtenerTodasLasPeliculas() {
        List<PeliculaResponseDTO> peliculas = peliculaService.obtenerTodasLasPeliculas();
        return ResponseEntity.ok(peliculas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PeliculaResponseDTO> obtenerPeliculaPorId(@PathVariable Long id) {
        PeliculaResponseDTO pelicula = peliculaService.obtenerPeliculaPorId(id);
        return ResponseEntity.ok(pelicula);
    }

    @PostMapping
    public ResponseEntity<PeliculaResponseDTO> crearPelicula(@RequestBody PeliculaRequestDTO peliculaRequestDTO) {
        PeliculaResponseDTO peliculaCreada = peliculaService.crearPelicula(peliculaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaResponseDTO> actualizarPelicula(@PathVariable Long id, @RequestBody PeliculaRequestDTO peliculaRequestDTO) {
        PeliculaResponseDTO peliculaActualizada = peliculaService.actualizarPelicula(id, peliculaRequestDTO);
        return ResponseEntity.ok(peliculaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return ResponseEntity.noContent().build();
    }

}










