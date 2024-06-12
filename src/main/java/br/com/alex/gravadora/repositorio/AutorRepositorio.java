package br.com.alex.gravadora.repositorio;

import br.com.alex.gravadora.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Integer> {

    @Query("SELECT a " +
            "FROM Autor a ")
    List<Autor> findAll();

}
