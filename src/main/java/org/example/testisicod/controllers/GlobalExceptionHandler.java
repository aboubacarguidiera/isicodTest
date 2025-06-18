package org.example.testisicod.controllers;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public String handleEntityNotFound(EntityNotFoundException ex, Model model) {
    model.addAttribute("error", ex.getMessage());
    return "error/404";
  }

  @ExceptionHandler(Exception.class)
  public String handleGenericException(Exception ex, Model model) {
    model.addAttribute("error", "Une erreur inattendue s'est produite");
    return "error/500";
  }
}
