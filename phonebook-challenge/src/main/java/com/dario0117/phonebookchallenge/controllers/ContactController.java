package com.dario0117.phonebookchallenge.controllers;

import com.dario0117.phonebookchallenge.safeentities.ContactRequest;
import com.dario0117.phonebookchallenge.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/contact")
public class ContactController {

  @Autowired
  private ContactService service;

    @GetMapping(
        value = ""
    )
    public ResponseEntity<Object> list() {
        return ResponseEntity
            .ok()
            .body(service.listAll());
    }

    @PostMapping(
        value = ""
    )
    public ResponseEntity<Object> create(@RequestBody ContactRequest body) {
      try {
        return ResponseEntity
            .ok()
            .body(service.create(body));
      } catch (Exception e) {
        return ResponseEntity.badRequest().body("");
      }
    }

    @PostMapping(
        value = "/search"
    )
    public ResponseEntity<Object> search(@RequestBody ContactRequest body) {
        return ResponseEntity
            .ok()
            .body(service.search(body));
    }
}
