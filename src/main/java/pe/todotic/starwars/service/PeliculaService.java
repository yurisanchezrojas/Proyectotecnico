package pe.todotic.starwars.service;

import pe.todotic.starwars.web.dto.PeliculaRequestDTO;
import pe.todotic.starwars.web.dto.PeliculaResponseDTO;

import java.util.List;

public interface PeliculaService {

    PeliculaResponseDTO crearPelicula(PeliculaRequestDTO peliculaRequestDTO);
    PeliculaResponseDTO obtenerPeliculaPorId(Long id);
    List<PeliculaResponseDTO> obtenerTodasLasPeliculas();
    PeliculaResponseDTO actualizarPelicula(Long id, PeliculaRequestDTO peliculaRequestDTO);
    void eliminarPelicula(Long id);
}
