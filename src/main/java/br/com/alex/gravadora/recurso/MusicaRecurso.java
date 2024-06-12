package br.com.alex.gravadora.recurso;

import br.com.alex.gravadora.entidades.Musica;
import br.com.alex.gravadora.servico.MusicaServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musicas")
@RequiredArgsConstructor
public class MusicaRecurso {

    private final MusicaServico musicaServico;

    @PostMapping
    public Musica criar(@RequestBody Musica musica) {
        return this.musicaServico.criar(musica);
    }

    @GetMapping
    public List<Musica> listar() {
        return this.musicaServico.listar();
    }

}
