package br.com.alex.gravadora.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "musica")
public class Musica implements Serializable {
    @Id
    @Column(name = "codigo_musica", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "nome_musica", nullable = false, length = 60)
    private String nome;

    @Column(name = "duracao_musica")
    private LocalTime duracao;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "id.musica", fetch = FetchType.LAZY)
    private Set<Faixa> faixas = new LinkedHashSet<>();

    @JsonIgnore
    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "musica_autor",
            joinColumns = @JoinColumn(name = "codigo_musica", foreignKey = @jakarta.persistence.ForeignKey(name = "fk_musica_autor")),
            inverseJoinColumns = @JoinColumn(name = "codigo_autor"))
    private Set<Autor> autores = new LinkedHashSet<>();

}