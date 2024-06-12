package br.com.alex.gravadora.repositorio;

import br.com.alex.gravadora.entidades.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CdRepositorio extends JpaRepository<Cd, Integer> {


    @Query("SELECT c " +
            "FROM Cd c " +
            "JOIN FETCH c.gravadora ")
    List<Cd> findAll();
}
