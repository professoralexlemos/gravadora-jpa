package br.com.alex.gravadora.repositorio;

import br.com.alex.gravadora.entidades.Cd;
import br.com.alex.gravadora.entidades.Faixa;
import br.com.alex.gravadora.entidades.FaixaID;
import br.com.alex.gravadora.entidades.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FaixaRepositorio extends JpaRepository<Faixa, FaixaID> {

    @Query("SELECT f " +
            "FROM Faixa f " +
            "JOIN FETCH f.id.musica m " +
            "JOIN FETCH f.id.cd c")
    List<Faixa> findAll();

    Optional<Faixa> findFaixasByIdCdAndIdMusicaAndNumeroFaixa(Cd cd, Musica musica, Integer numeroFaixa);

}
