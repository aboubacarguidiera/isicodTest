package org.example.testisicod.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Entity
public class Personne {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nom;
  private String prenom;
//  private Status status;
  private Role role;
  @JsonIgnore
  @OneToMany(mappedBy = "personne",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<org.example.testisicod.entities.Action> actionList = new ArrayList<>();
  public Personne() {}

  public Personne(String nom, String prenom, Role role) {
    this.nom = nom;
    this.prenom = prenom;
   // this.status = status;
    this.role = role;
  }

  public List<org.example.testisicod.entities.Action> getActionList() {
    return actionList;
  }

  public int size() {
    return actionList.size();
  }

  public void forEach(Consumer<? super org.example.testisicod.entities.Action> action) {
    actionList.forEach(action);
  }

  public Spliterator<org.example.testisicod.entities.Action> spliterator() {
    return actionList.spliterator();
  }

  public boolean addAll(Collection<? extends org.example.testisicod.entities.Action> c) {
    return actionList.addAll(c);
  }

  public org.example.testisicod.entities.Action get(int index) {
    return actionList.get(index);
  }

  public List<org.example.testisicod.entities.Action> subList(int fromIndex, int toIndex) {
    return actionList.subList(fromIndex, toIndex);
  }

  public <T> T[] toArray(IntFunction<T[]> generator) {
    return actionList.toArray(generator);
  }

  public boolean remove(Object o) {
    return actionList.remove(o);
  }

  public boolean containsAll(Collection<?> c) {
    return actionList.containsAll(c);
  }

  public boolean add(org.example.testisicod.entities.Action action) {
    return actionList.add(action);
  }

  public ListIterator<org.example.testisicod.entities.Action> listIterator(int index) {
    return actionList.listIterator(index);
  }

  public ListIterator<org.example.testisicod.entities.Action> listIterator() {
    return actionList.listIterator();
  }

  public Stream<org.example.testisicod.entities.Action> parallelStream() {
    return actionList.parallelStream();
  }

  public void clear() {
    actionList.clear();
  }

  public Stream<org.example.testisicod.entities.Action> stream() {
    return actionList.stream();
  }

  public <T> T[] toArray(T[] a) {
    return actionList.toArray(a);
  }

  public void sort(Comparator<? super org.example.testisicod.entities.Action> c) {
    actionList.sort(c);
  }

  public int lastIndexOf(Object o) {
    return actionList.lastIndexOf(o);
  }

  public Object[] toArray() {
    return actionList.toArray();
  }

  public void replaceAll(UnaryOperator<org.example.testisicod.entities.Action> operator) {
    actionList.replaceAll(operator);
  }

  public int indexOf(Object o) {
    return actionList.indexOf(o);
  }

  public org.example.testisicod.entities.Action remove(int index) {
    return actionList.remove(index);
  }

  public boolean retainAll(Collection<?> c) {
    return actionList.retainAll(c);
  }

  public Iterator<org.example.testisicod.entities.Action> iterator() {
    return actionList.iterator();
  }

  public boolean isEmpty() {
    return actionList.isEmpty();
  }

  public boolean contains(Object o) {
    return actionList.contains(o);
  }

  public boolean removeAll(Collection<?> c) {
    return actionList.removeAll(c);
  }

  public void add(int index, org.example.testisicod.entities.Action element) {
    actionList.add(index, element);
  }

  public boolean removeIf(Predicate<? super org.example.testisicod.entities.Action> filter) {
    return actionList.removeIf(filter);
  }

  public boolean addAll(int index, Collection<? extends org.example.testisicod.entities.Action> c) {
    return actionList.addAll(index, c);
  }

  public org.example.testisicod.entities.Action set(int index, org.example.testisicod.entities.Action element) {
    return actionList.set(index, element);
  }

  public void setActionList(List<Action> actionList) {
    this.actionList = actionList;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

//  public Status getStatus() {
//    return status;
//  }
//
//  public void setStatus(Status status) {
//    this.status = status;
//  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
