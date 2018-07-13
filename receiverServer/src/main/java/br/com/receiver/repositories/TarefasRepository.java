package br.com.receiver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.receiver.domain.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Integer> {
}
