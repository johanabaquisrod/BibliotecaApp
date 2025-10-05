package com.example.biblioteca.service;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Cacheable("libros")
    public Libro obtenerLibroPorId(Long id) {
        System.out.println("Consultando base de datos para libro con id " + id);
        return libroRepository.findById(id).orElse(null);
    }
}
