package pe.todotic.starwars.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.todotic.starwars.service.NaveService;
import pe.todotic.starwars.web.dto.NaveRequestDTO;
import pe.todotic.starwars.web.dto.NaveResponseDTO;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/naves")
public class NaveController {
    private final NaveService naveService;

    @GetMapping
    public ResponseEntity<List<NaveResponseDTO>> obtenerTodasLasNaves() {
        List<NaveResponseDTO> naves = naveService.obtenerTodasLasNaves();
        return ResponseEntity.ok(naves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NaveResponseDTO> obtenerNavePorId(@PathVariable Long id) {
        NaveResponseDTO nave = naveService.obtenerNavePorId(id);
        return ResponseEntity.ok(nave);
    }

    @PostMapping
    public ResponseEntity<NaveResponseDTO> crearNave(@RequestBody NaveRequestDTO naveRequestDTO) {
        NaveResponseDTO naveCreada = naveService.crearNave(naveRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(naveCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NaveResponseDTO> actualizarNave(@PathVariable Long id, @RequestBody NaveRequestDTO naveRequestDTO) {
        NaveResponseDTO naveActualizada = naveService.actualizarNave(id, naveRequestDTO);
        return ResponseEntity.ok(naveActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNave(@PathVariable Long id) {
        naveService.eliminarNave(id);
        return ResponseEntity.noContent().build();
    }


}
