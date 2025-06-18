package org.example.testisicod.repositories;

import org.example.testisicod.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
  List<Personne> findByNom(String nom);
  List<Personne> findByPrenom(String prenom);
}
