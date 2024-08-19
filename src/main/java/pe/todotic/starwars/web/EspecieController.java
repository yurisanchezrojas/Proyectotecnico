package pe.todotic.starwars.web;

import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.todotic.starwars.service.EspecieService;
import pe.todotic.starwars.web.dto.EspecieRequestDTO;
import pe.todotic.starwars.web.dto.EspecieResponseDTO;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/especies")
public class EspecieController {
    private final EspecieService especieService;

    @GetMapping
    public ResponseEntity<List<EspecieResponseDTO>> obtenerTodasLasEspecies(){
    List<EspecieResponseDTO> especies = especieService.obtenerTodasLasEspecies();
    return ResponseEntity.ok(especies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecieResponseDTO> obtenerEspeciePorId(@PathVariable Long id) {
        EspecieResponseDTO especie = especieService.obtenerEspeciePorId(id);
        return ResponseEntity.ok(especie);
    }

    @PostMapping
    public ResponseEntity<EspecieResponseDTO> crearEspecie(@RequestBody EspecieRequestDTO especieRequestDTO) throws BadRequestException {
        EspecieResponseDTO especieCreada = especieService.crearEspecie(especieRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(especieCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecieResponseDTO> actualizarEspecie(@PathVariable Long id, @RequestBody EspecieRequestDTO especieRequestDTO) {
        EspecieResponseDTO especieActualizada = especieService.actualizarEspecie(id, especieRequestDTO);
        return ResponseEntity.ok(especieActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEspecie(@PathVariable Long id) {
        especieService.eliminarEspecie(id);
        return ResponseEntity.noContent().build();
    }


}
