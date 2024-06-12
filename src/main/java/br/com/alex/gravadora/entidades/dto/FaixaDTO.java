package br.com.alex.gravadora.entidades.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class FaixaDTO implements Serializable {

    private Integer codigoCd;
    private Integer codigoMusica;
    private Integer numeroFaixa;

}
