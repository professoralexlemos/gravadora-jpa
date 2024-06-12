package br.com.alex.gravadora.servico;

import br.com.alex.gravadora.entidades.Musica;
import br.com.alex.gravadora.repositorio.MusicaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicaServico {

    private final MusicaRepositorio musicaRepositorio;

    public Musica criar(Musica musica) {
        this.musicaRepositorio.findById(musica.getId()).ifPresent(gravadoraExistente -> {
            throw new IllegalArgumentException("Musica já cadastrada");
        });
        return this.musicaRepositorio.save(musica);
    }

    public List<Musica> listar() {
        return this.musicaRepositorio.findAll();
    }
}
