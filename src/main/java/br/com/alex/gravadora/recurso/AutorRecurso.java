package br.com.alex.gravadora.recurso;

import br.com.alex.gravadora.entidades.Autor;
import br.com.alex.gravadora.servico.AutorServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorRecurso {

    private final AutorServico autorServico;

    @PostMapping
    public Autor criar(@RequestBody Autor autor) {
        return this.autorServico.criar(autor);
    }

    @GetMapping
    public List<Autor> listar() {
        return this.autorServico.listar();
    }

}
