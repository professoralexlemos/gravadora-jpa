package br.com.alex.gravadora.servico;

import br.com.alex.gravadora.entidades.Gravadora;
import br.com.alex.gravadora.repositorio.GravadoraRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GravadoraServico {

    private final GravadoraRepositorio gravadoraRepositorio;

    public Gravadora criar(Gravadora gravadora) {
        this.gravadoraRepositorio.findById(gravadora.getId()).ifPresent(gravadoraExistente -> {
            throw new IllegalArgumentException("Gravadora já cadastrada");
        });
        return this.gravadoraRepositorio.save(gravadora);
    }

    public List<Gravadora> listar() {
        return this.gravadoraRepositorio.findAll();
    }
}
