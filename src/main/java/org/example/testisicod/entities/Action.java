package org.example.testisicod.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Action {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Enumerated(EnumType.STRING)
  private ActionType type;
  private LocalDate heure;
  private LocalDateTime debutPrevu;
  private LocalDateTime  finPrevu;

  private Status status;
  @ManyToOne()
  private Personne personne;

  public void setId(Long id) {
    this.id = id;
  }
  public Long getId() {
    return id;
  }

  public Action() {
  }

  public Action(ActionType type, LocalDate heure, LocalDateTime debutPrevu, LocalDateTime finPrevu, Status status, Personne personne) {
    this.type = type;
    this.heure = heure;
    this.debutPrevu = debutPrevu;
    this.finPrevu = finPrevu;
    this.status = status;
    this.personne = personne;
  }

  public LocalDateTime getDebutPrevu() {
    return debutPrevu;
  }

  public void setDebutPrevu(LocalDateTime debutPrevu) {
    this.debutPrevu = debutPrevu;
  }

  public LocalDateTime getFinPrevu() {
    return finPrevu;
  }

  public void setFinPrevu(LocalDateTime finPrevu) {
    this.finPrevu = finPrevu;
  }

  public ActionType getType() {
    return type;
  }

  public void setType(ActionType type) {
    this.type = type;
  }

  public LocalDate getHeure() {
    return heure;
  }

  public void setHeure(LocalDate heure) {
    this.heure = heure;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Personne getPersonne() {
    return personne;
  }

  public void setPersonne(Personne personne) {
    this.personne = personne;
  }
}
