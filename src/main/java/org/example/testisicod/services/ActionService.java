package org.example.testisicod.services;

import org.example.testisicod.entities.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.testisicod.repositories.ActionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {
  final ActionRepository actionRepository;

@Autowired
  public ActionService(ActionRepository actionRepository){
  this.actionRepository = actionRepository;
}

public List<Action> findByPerson(Long personId){
  return this.actionRepository.findByPersonneId(personId);
}

public List<Action> getAllActions(){
  return actionRepository.findAll();
}
public Optional<Action> getActionById(Long id){
  return this.actionRepository.findById(id);
}
public Action saveAction(Action action){
  return this.actionRepository.save(action);
}
public void deleteActionById(Long id){
  this.actionRepository.deleteById(id);
}


}
