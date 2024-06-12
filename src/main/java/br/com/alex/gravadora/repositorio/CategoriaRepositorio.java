package br.com.alex.gravadora.repositorio;

import br.com.alex.gravadora.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    @Query("SELECT c " +
            "FROM Categoria c " +
            "JOIN FETCH c.cd " +
            "JOIN FETCH c.cd.gravadora ")
    List<Categoria> findAll();
}
