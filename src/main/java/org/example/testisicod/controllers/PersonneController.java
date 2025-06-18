package org.example.testisicod.controllers;

import org.example.testisicod.entities.Action;
import org.example.testisicod.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.testisicod.services.ActionService;
import org.example.testisicod.services.PersonneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
  private final PersonneService personneService;
  private final ActionService actionService;

  @Autowired
  public PersonneController(PersonneService personneService, ActionService actionService) {
    this.personneService = personneService;
    this.actionService = actionService;
  }
  @PostMapping("/{id}/actions")
  public ResponseEntity<Action> addActionToPerson(@PathVariable Long id, @RequestBody Action action) {
    return ResponseEntity.ok(personneService.ajouterAction(id, action));
  }
  @GetMapping("/all")
  public List<Personne> all(){
    return this.personneService.getAllPersonnes();
  }
  @GetMapping("/id/{id}")
  public Optional<Personne> findById(@PathVariable Long id){
    return this.personneService.getPersonneById(id);
  }
  @GetMapping("/nom/{nom}")
  public List<Personne> findByNom(@PathVariable String nom){
    return this.personneService.getPersonneByNom(nom);
  }
  @GetMapping("/prenom/{prenom}")
  public List<Personne> findByPrenom(@PathVariable String prenom){
    return this.personneService.getPersonneByPrenom(prenom);
  }
  @PostMapping("/")
  public Personne save(@RequestBody Personne personne){
    return this.personneService.savePersonne(personne);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){
    this.personneService.deletePersonneById(id);
  }
  @PutMapping("/{id}")
  public Personne update(@PathVariable Long id, @RequestBody Personne personne){
    personne.setId(id);
    return this.personneService.savePersonne(personne);
  }

}
