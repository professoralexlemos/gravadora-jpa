package br.com.alex.gravadora.recurso;

import br.com.alex.gravadora.entidades.Gravadora;
import br.com.alex.gravadora.servico.GravadoraServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gravadoras")
@RequiredArgsConstructor
public class GravadoraRecurso {

    private final GravadoraServico gravadoraServico;

    @PostMapping
    public Gravadora criar(@RequestBody Gravadora gravadora) {
        return this.gravadoraServico.criar(gravadora);
    }

    @GetMapping
    public List<Gravadora> listar() {
        return this.gravadoraServico.listar();
    }

}
