package br.com.alex.gravadora.repositorio;

import br.com.alex.gravadora.entidades.Gravadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GravadoraRepositorio extends JpaRepository<Gravadora, Integer> {
}
