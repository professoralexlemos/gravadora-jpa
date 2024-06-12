package br.com.alex.gravadora.recurso;

import br.com.alex.gravadora.entidades.Cd;
import br.com.alex.gravadora.servico.CdServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cd")
@RequiredArgsConstructor
public class CdRecurso {

    private final CdServico cdServico;

    @PostMapping
    public Cd criar(@RequestBody Cd cd) {
        return this.cdServico.criar(cd);
    }

    @GetMapping
    public List<Cd> listar() {
        return this.cdServico.listar();
    }

}
