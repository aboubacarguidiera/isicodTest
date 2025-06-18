package org.example.testisicod.services;

import org.example.testisicod.entities.Action;
import org.example.testisicod.entities.Personne;
import org.example.testisicod.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.testisicod.repositories.PersonneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
  final PersonneRepository personneRepository;
  final ActionRepository actionRepository;

  @Autowired
  public PersonneService(PersonneRepository personneRepository,ActionRepository actionRepository){
    this.personneRepository = personneRepository;
    this.actionRepository = actionRepository;
  }

  public List<Personne> getAllPersonnes(){
    return personneRepository.findAll();
  }
  public Optional<Personne> getPersonneById(Long id){
    return this.personneRepository.findById(id);
  }
  public List<Personne> getPersonneByNom(String nom){
    return this.personneRepository.findByNom(nom);
  }
  public List<Personne> getPersonneByPrenom(String prenom){
    return this.personneRepository.findByPrenom(prenom);
  }

  public Personne savePersonne(Personne personne){
    return this.personneRepository.save(personne);
  }
  public void deletePersonneById(Long id){
    this.personneRepository.deleteById(id);
  }

  public Action ajouterAction(Long personId, Action action) {
    Personne p = personneRepository.findById(personId)
      .orElseThrow(() -> new RuntimeException("Person not found"));
    action.setPersonne(p);
    action = actionRepository.save(action);
    p.getActionList().add(action);
    personneRepository.save(p);
    return action;
  }


}
