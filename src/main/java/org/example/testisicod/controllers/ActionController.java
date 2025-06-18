package org.example.testisicod.controllers;

import org.example.testisicod.entities.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.testisicod.services.ActionService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/actions")
public class ActionController {
  private ActionService actionService;
 // private ActionService actionService;

  @Autowired
  public ActionController(ActionService actionService) {
    this.actionService = actionService;
    //this.actionService = actionService;
  }

  @GetMapping("/all")
  public List<Action> all(){
    return this.actionService.getAllActions();
  }
  @GetMapping("person/{personId}")
  public List<Action> getActionsByPerson(@PathVariable Long personId) {
    return actionService.findByPerson(personId);
  }

  @GetMapping("/{id}")
  public Optional<Action> findById(@PathVariable Long id){
    return this.actionService.getActionById(id);
  }
  @PostMapping("/")
  public Action save(@RequestBody Action action){
    return this.actionService.saveAction(action);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){
    this.actionService.deleteActionById(id);
  }
  @PutMapping("/{id}")
  public Action update(@PathVariable Long id, @RequestBody Action action){
    action.setId(id);
    return this.actionService.saveAction(action);
  }


}
