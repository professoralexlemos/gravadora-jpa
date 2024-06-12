package br.com.alex.gravadora.recurso;

import br.com.alex.gravadora.entidades.dto.FaixaDTO;
import br.com.alex.gravadora.servico.FaixaServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faixas")
@RequiredArgsConstructor
public class FaixaRecurso {

    private final FaixaServico faixaServico;

    @PostMapping
    public FaixaDTO criar(@RequestBody FaixaDTO dto) {
        return this.faixaServico.criar(dto);
    }

    @GetMapping
    public List<FaixaDTO> listar() {
        return this.faixaServico.listar();
    }

}
