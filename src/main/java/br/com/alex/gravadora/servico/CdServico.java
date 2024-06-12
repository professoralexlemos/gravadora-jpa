package br.com.alex.gravadora.servico;

import br.com.alex.gravadora.entidades.Cd;
import br.com.alex.gravadora.repositorio.CdRepositorio;
import br.com.alex.gravadora.repositorio.GravadoraRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CdServico {

    private final CdRepositorio cdRepositorio;
    private final GravadoraRepositorio gravadoraRepositorio;

    public Cd criar(Cd cd) {

        this.cdRepositorio.findById(cd.getId()).ifPresent(c -> {
            throw new IllegalArgumentException("Cd já cadastrado");
        });
        var gravadora = this.gravadoraRepositorio.findById(cd.getGravadora().getId())
                .orElseThrow(() -> new IllegalArgumentException("Gravadora não encontrada"));
        cd.setGravadora(gravadora);
        return this.cdRepositorio.save(cd);
    }

    public List<Cd> listar() {
        return this.cdRepositorio.findAll();
    }
}
