package br.com.alex.gravadora.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "autor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Autor implements Serializable {
    @Id
    @Column(name = "codigo_autor", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "nome_autor", nullable = false, length = 60)
    private String nome;

    @JsonIgnore
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "musica_autor",
            joinColumns = @JoinColumn(name = "codigo_autor", foreignKey = @jakarta.persistence.ForeignKey(name = "fk_autor_musica")),
            inverseJoinColumns = @JoinColumn(name = "codigo_musica"))
    private Set<Musica> musicas = new LinkedHashSet<>();

}