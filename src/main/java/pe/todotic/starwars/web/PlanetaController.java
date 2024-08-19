package pe.todotic.starwars.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.todotic.starwars.service.PlanetaService;
import pe.todotic.starwars.web.dto.PlanetaRequestDTO;
import pe.todotic.starwars.web.dto.PlanetaResponseDTO;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    private final PlanetaService planetaService;

    @GetMapping
    public ResponseEntity<List<PlanetaResponseDTO>> obtenerTodosLosPlanetas() {
        List<PlanetaResponseDTO> planetas = planetaService.obtenerTodosLosPlanetas();
        return ResponseEntity.ok(planetas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetaResponseDTO> obtenerPlanetaPorId(@PathVariable Long id) {
        PlanetaResponseDTO planeta = planetaService.obtenerPlanetaPorId(id);
        return ResponseEntity.ok(planeta);
    }

    @PostMapping
    public ResponseEntity<PlanetaResponseDTO> crearPlaneta(@RequestBody PlanetaRequestDTO planetaRequestDTO) {
        PlanetaResponseDTO planetaCreado = planetaService.crearPlaneta(planetaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetaCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanetaResponseDTO> actualizarPlaneta(@PathVariable Long id, @RequestBody PlanetaRequestDTO planetaRequestDTO) {
        PlanetaResponseDTO planetaActualizado = planetaService.actualizarPlaneta(id, planetaRequestDTO);
        return ResponseEntity.ok(planetaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPlaneta(@PathVariable Long id) {
        planetaService.eliminarPlaneta(id);
        return ResponseEntity.noContent().build();
    }
}











