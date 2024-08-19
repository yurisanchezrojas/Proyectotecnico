package pe.todotic.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.todotic.starwars.domain.Pelicula;
import pe.todotic.starwars.exception.ResourceNotFoundException;
import pe.todotic.starwars.repository.PeliculaRepository;
import pe.todotic.starwars.web.dto.PeliculaRequestDTO;
import pe.todotic.starwars.web.dto.PeliculaResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaServiceImpl implements  PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public PeliculaResponseDTO crearPelicula(PeliculaRequestDTO peliculaRequestDTO) {
        Pelicula pelicula = new Pelicula();

        pelicula.setTitulo(peliculaRequestDTO.getTitulo());
        pelicula.setNumeroEpisodio(peliculaRequestDTO.getNumeroEpisodio());
        pelicula.setIntroduccion(peliculaRequestDTO.getIntroduccion());
        pelicula.setDirector(peliculaRequestDTO.getDirector());
        pelicula.setProductor(peliculaRequestDTO.getProductor());
        pelicula.setFechaLanzamiento(peliculaRequestDTO.getFechaLanzamiento());

        Pelicula peliculaGuardada = peliculaRepository.save(pelicula);
        return mapearAResponseDTO(peliculaGuardada);

    }

    @Override
    public PeliculaResponseDTO obtenerPeliculaPorId(Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula no encontrada con id: " + id));
        return mapearAResponseDTO(pelicula);
    }

    @Override
    public List<PeliculaResponseDTO> obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        return peliculas.stream()
                .map(this::mapearAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PeliculaResponseDTO actualizarPelicula(Long id, PeliculaRequestDTO peliculaRequestDTO) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula no encontrada con id: " + id));

        pelicula.setTitulo(peliculaRequestDTO.getTitulo());
        pelicula.setNumeroEpisodio(peliculaRequestDTO.getNumeroEpisodio());
        pelicula.setIntroduccion(peliculaRequestDTO.getIntroduccion());
        pelicula.setDirector(peliculaRequestDTO.getDirector());
        pelicula.setProductor(peliculaRequestDTO.getProductor());
        pelicula.setFechaLanzamiento(peliculaRequestDTO.getFechaLanzamiento());

        Pelicula peliculaActualizada = peliculaRepository.save(pelicula);
        return mapearAResponseDTO(peliculaActualizada);

    }

    @Override
    public void eliminarPelicula(Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula no encontrada con id: " + id));
        peliculaRepository.delete(pelicula);

    }

    private PeliculaResponseDTO mapearAResponseDTO(Pelicula pelicula) {
        PeliculaResponseDTO dto = new PeliculaResponseDTO();

        dto.setId(pelicula.getId());
        dto.setTitulo(pelicula.getTitulo());
        dto.setNumeroEpisodio(pelicula.getNumeroEpisodio());
        dto.setIntroduccion(pelicula.getIntroduccion());
        dto.setDirector(pelicula.getDirector());
        dto.setProductor(pelicula.getProductor());
        dto.setFechaLanzamiento(pelicula.getFechaLanzamiento());

        return dto;
    }
}














