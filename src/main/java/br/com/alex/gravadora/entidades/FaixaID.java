package br.com.alex.gravadora.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FaixaID implements java.io.Serializable {

    @JsonBackReference
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_musica", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "fk_faixa_musica"))
    private Musica musica;

    @JsonBackReference
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_cd", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "fk_faixa_cd"))
    private Cd cd;

}
