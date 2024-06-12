package br.com.alex.gravadora.recurso;

import br.com.alex.gravadora.entidades.Categoria;
import br.com.alex.gravadora.servico.CategoriaServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cd/categorias")
@RequiredArgsConstructor
public class CategoriaRecurso {

    private final CategoriaServico categoriaServico;

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return this.categoriaServico.criar(categoria);
    }

    @GetMapping
    public List<Categoria> listar() {
        return this.categoriaServico.listar();
    }

}
