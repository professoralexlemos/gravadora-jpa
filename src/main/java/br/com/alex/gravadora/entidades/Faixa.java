package br.com.alex.gravadora.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "faixa")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Faixa implements Serializable {

    @EmbeddedId
    private FaixaID id;

    @NotNull
    @Column(name = "numero_faixa", nullable = false)
    private Integer numeroFaixa;

}
