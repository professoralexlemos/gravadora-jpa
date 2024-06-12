package br.com.alex.gravadora.servico;

import br.com.alex.gravadora.entidades.Cd;
import br.com.alex.gravadora.entidades.Faixa;
import br.com.alex.gravadora.entidades.FaixaID;
import br.com.alex.gravadora.entidades.Musica;
import br.com.alex.gravadora.entidades.dto.FaixaDTO;
import br.com.alex.gravadora.repositorio.CdRepositorio;
import br.com.alex.gravadora.repositorio.FaixaRepositorio;
import br.com.alex.gravadora.repositorio.MusicaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaixaServico {

    private final FaixaRepositorio faixaRepositorio;
    private final MusicaRepositorio musicaRepositorio;
    private final CdRepositorio cdRepositorio;

    public FaixaDTO criar(FaixaDTO dto) {

        Musica musica = this.musicaRepositorio.findById(dto.getCodigoMusica()).orElseThrow(() -> new IllegalArgumentException("Música não encontrada"));
        Cd cd = this.cdRepositorio.findById(dto.getCodigoCd()).orElseThrow(() -> new IllegalArgumentException("CD não encontrado"));

        this.faixaRepositorio.findFaixasByIdCdAndIdMusicaAndNumeroFaixa(cd, musica, dto.getNumeroFaixa())
                .ifPresent(f -> {
                    throw new IllegalArgumentException("Faixa já cadastrada");
                });
        var faixa = Faixa.builder().
                id(FaixaID.builder().cd(cd).musica(musica).build())
                .numeroFaixa((dto.getNumeroFaixa())).build();
        final var save = this.faixaRepositorio.save(faixa);
        return FaixaDTO.builder()
                .codigoCd(save.getId().getCd().getId())
                .codigoMusica(save.getId().getMusica().getId())
                .numeroFaixa(save.getNumeroFaixa())
                .build();
    }

    public List<FaixaDTO> listar() {
        return this.faixaRepositorio.findAll().stream().map(f -> FaixaDTO.builder()
                .codigoCd(f.getId().getCd().getId())
                .codigoMusica(f.getId().getMusica().getId())
                .numeroFaixa(f.getNumeroFaixa())
                .build()).toList();
    }

}
