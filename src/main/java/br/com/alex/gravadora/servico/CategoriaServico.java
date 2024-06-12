package br.com.alex.gravadora.servico;

import br.com.alex.gravadora.entidades.Categoria;
import br.com.alex.gravadora.repositorio.CategoriaRepositorio;
import br.com.alex.gravadora.repositorio.CdRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServico {

    private final CategoriaRepositorio categoriaRepositorio;
    private final CdRepositorio cdRepositorio;

    public Categoria criar(Categoria categoria) {
        this.categoriaRepositorio.findById(categoria.getId()).ifPresent(autorExistente -> {
            throw new IllegalArgumentException("Categoria já cadastrada");
        });

        var cd = this.cdRepositorio.findById(categoria.getCd().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cd não encontrado"));
        categoria.setCd(cd);
        return this.categoriaRepositorio.save(categoria);
    }

    public List<Categoria> listar() {
        return this.categoriaRepositorio.findAll();
    }
}
