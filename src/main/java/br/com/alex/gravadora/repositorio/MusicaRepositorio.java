package br.com.alex.gravadora.repositorio;

import br.com.alex.gravadora.entidades.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepositorio extends JpaRepository<Musica, Integer> {

    @Query("SELECT m " +
            "FROM Musica m ")
    List<Musica> findAll();

}
