package br.com.alex.gravadora.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "cd_categoria")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria implements Serializable {
    @Id
    @Column(name = "codigo_categoria", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "menor_preco", nullable = false, precision = 14, scale = 2)
    private BigDecimal menorPreco;

    @NotNull
    @Column(name = "maior_preco", nullable = false, precision = 14, scale = 2)
    private BigDecimal maiorPreco;

    @JsonBackReference
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Codigo_CD", nullable = false)
    private Cd cd;

}
