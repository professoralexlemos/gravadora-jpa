package br.com.alex.gravadora.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "gravadora")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gravadora implements Serializable {
    @Id
    @Column(name = "codigo_gravadora", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "nome_gravadora", nullable = false, length = 60)
    private String nome;

    @Size(max = 60)
    @Column(name = "endereco_gravadora", length = 60)
    private String endereco;

    @Size(max = 20)
    @Column(name = "telefone_gravadora", length = 20)
    private String telefone;

    @Size(max = 20)
    @Column(name = "contato_gravadora", length = 20)
    private String contato;

    @Size(max = 80)
    @Column(name = "url_gravadora", length = 80)
    private String url;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "gravadora", fetch = FetchType.LAZY)
    private Set<Cd> cds = new LinkedHashSet<>();

}
