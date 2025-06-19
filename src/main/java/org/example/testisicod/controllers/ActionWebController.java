package org.example.testisicod.controllers;

import jakarta.validation.Valid;
import org.example.testisicod.entities.Action;
import org.example.testisicod.entities.Status;
import org.example.testisicod.entities.ActionType;
import org.example.testisicod.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/web/actions")
public class ActionWebController {

  private final ActionService actionService;

  @Autowired
  public ActionWebController(ActionService actionService) {
    this.actionService = actionService;
  }

  @GetMapping
  public String listActions(Model model) {
    model.addAttribute("actions", actionService.getAllActions());
    return "actions/list";
  }

  @GetMapping("/new")
  public String showCreateForm(Model model) {
    model.addAttribute("action", new Action());
    model.addAttribute("types", ActionType.values());
    model.addAttribute("statuses", Status.values());
    return "actions/form";
  }

  @PostMapping
  public String createAction(@Valid @ModelAttribute Action action, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("types", ActionType.values());
      model.addAttribute("statuses", Status.values());
      return "actions/form";
    }
    actionService.saveAction(action);
    return "redirect:/web/actions";
  }

  @GetMapping("/{id}")
  public String showAction(@PathVariable Long id, Model model) {
    Optional<Action> action = actionService.getActionById(id);
    if (action.isPresent()) {
      model.addAttribute("action", action.get());
      return "actions/detail";
    }
    return "redirect:/web/actions";
  }

  @GetMapping("/{id}/edit")
  public String showEditForm(@PathVariable Long id, Model model) {
    Optional<Action> action = actionService.getActionById(id);
    if (action.isPresent()) {
      model.addAttribute("action", action.get());
      model.addAttribute("types", ActionType.values());
      model.addAttribute("statuses", Status.values());
      return "actions/form";
    }
    return "redirect:/web/actions";
  }

  @PostMapping("/{id}")
  public String updateAction(@PathVariable Long id, @Valid @ModelAttribute Action action, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("types", ActionType.values());
      model.addAttribute("statuses", Status.values());
      return "actions/form";
    }
    action.setId(id);
    actionService.saveAction(action);
    return "redirect:/web/actions";
  }

  @PostMapping("/{id}/delete")
  public String deleteAction(@PathVariable Long id) {
    actionService.deleteActionById(id);
    return "redirect:/web/actions";
  }
}
