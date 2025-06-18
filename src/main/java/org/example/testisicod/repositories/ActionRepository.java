package org.example.testisicod.repositories;

import org.example.testisicod.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
  List<Action> findByPersonneId(Long id);

}
