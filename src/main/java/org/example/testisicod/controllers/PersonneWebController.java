package org.example.testisicod.controllers;

import jakarta.validation.Valid;
import org.example.testisicod.entities.Personne;
import org.example.testisicod.entities.Role;
import org.example.testisicod.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/web/personnes")
public class PersonneWebController {

  private final PersonneService personneService;

  @Autowired
  public PersonneWebController(PersonneService personneService) {
    this.personneService = personneService;
  }

  @GetMapping
  public String listPersonnes(Model model) {
    model.addAttribute("personnes", personneService.getAllPersonnes());
    return "personnes/list";
  }

  @GetMapping("/new")
  public String showCreateForm(Model model) {
    model.addAttribute("personne", new Personne());
    model.addAttribute("roles", Role.values());
    return "personnes/form";
  }

  @PostMapping
  public String createPersonne(@Valid @ModelAttribute Personne personne,
                               BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("roles", Role.values());
      return "personnes/form";
    }
    personneService.savePersonne(personne);
    return "redirect:/web/personnes";
  }

  @GetMapping("/{id}")
  public String showPersonne(@PathVariable Long id, Model model) {
    Optional<Personne> personne = personneService.getPersonneById(id);
    if (personne.isPresent()) {
      model.addAttribute("personne", personne.get());
      return "personnes/detail";
    }
    return "redirect:/web/personnes";
  }
  @GetMapping("/{id}/edit")
  public String showEditForm(@PathVariable Long id, Model model) {
    Optional<Personne> personne = personneService.getPersonneById(id);
    if (personne.isPresent()) {
      model.addAttribute("personne", personne.get());
      model.addAttribute("roles", Role.values());
      return "personnes/form";
    }
    return "redirect:/web/personnes";
  }

  @PostMapping("/{id}")
  public String updatePersonne(@PathVariable Long id,
                               @Valid @ModelAttribute Personne personne,
                               BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("roles", Role.values());
      return "personnes/form";
    }
    personne.setId(id);
    personneService.savePersonne(personne);
    return "redirect:/web/personnes";
  }

  @PostMapping("/{id}/delete")
  public String deletePersonne(@PathVariable Long id) {
    personneService.deletePersonneById(id);
    return "redirect:/web/personnes";
  }
}
