package pe.todotic.starwars.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.todotic.starwars.service.VehiculoService;
import pe.todotic.starwars.web.dto.VehiculoRequestDTO;
import pe.todotic.starwars.web.dto.VehiculoResponseDTO;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<VehiculoResponseDTO>> obtenerTodosLosVehiculos() {
        List<VehiculoResponseDTO> vehiculos = vehiculoService.obtenerTodosLosVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoResponseDTO> obtenerVehiculoPorId(@PathVariable Long id) {
        VehiculoResponseDTO vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        return ResponseEntity.ok(vehiculo);
    }

    @PostMapping
    public ResponseEntity<VehiculoResponseDTO> crearVehiculo(@RequestBody VehiculoRequestDTO vehiculoRequestDTO) {
        VehiculoResponseDTO vehiculoCreado = vehiculoService.crearVehiculo(vehiculoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoResponseDTO> actualizarVehiculo(@PathVariable Long id, @RequestBody VehiculoRequestDTO vehiculoRequestDTO) {
        VehiculoResponseDTO vehiculoActualizado = vehiculoService.actualizarVehiculo(id, vehiculoRequestDTO);
        return ResponseEntity.ok(vehiculoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Long id) {
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }


}
