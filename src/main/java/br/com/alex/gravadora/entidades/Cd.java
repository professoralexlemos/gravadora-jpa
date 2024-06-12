package br.com.alex.gravadora.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cd")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cd implements Serializable {
    @Id
    @Column(name = "codigo_cd", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "nome_cd", nullable = false, length = 60)
    private String nomeCd;

    @Column(name = "preco_venda_cd", precision = 14, scale = 2)
    private BigDecimal precoVendaCd;

    @Column(name = "data_lancamento_cd")
    private LocalDate dataLancamentoCd;

    @Column(name = "cd_indicado")
    private Integer cdIndicado;

    //@JsonIgnore
    @JsonBackReference
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_gravadora", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "fk_cd_gravadora"))
    private Gravadora gravadora;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "cd", fetch = FetchType.LAZY)
    private Set<Categoria> categorias = new LinkedHashSet<>();

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "id.cd", fetch = FetchType.LAZY)
    private Set<Faixa> faixas = new LinkedHashSet<>();
}
