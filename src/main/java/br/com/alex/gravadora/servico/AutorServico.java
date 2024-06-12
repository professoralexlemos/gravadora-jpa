package br.com.alex.gravadora.servico;

import br.com.alex.gravadora.entidades.Autor;
import br.com.alex.gravadora.repositorio.AutorRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServico {

    private final AutorRepositorio autorRepositorio;

    public Autor criar(Autor autor) {
        this.autorRepositorio.findById(autor.getId()).ifPresent(autorExistente -> {
            throw new IllegalArgumentException("Autor já cadastrado");
        });
        return this.autorRepositorio.save(autor);
    }

    public List<Autor> listar() {
        return this.autorRepositorio.findAll();
    }
}
