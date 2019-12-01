package com.dario0117.phonebookchallenge.services;

import java.util.List;

import com.dario0117.phonebookchallenge.entities.Contact;
import com.dario0117.phonebookchallenge.repositories.ContactRepository;
import com.dario0117.phonebookchallenge.safeentities.ContactRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactService {
    @Autowired
    private ContactRepository repo;

    public Contact create(ContactRequest body) {
      Contact p = new Contact(body.getFirstName(), body.getLastName(), body.getPhone());
      Contact created = repo.save(p);
      return created;
    }

    public List<Contact> listAll() {
      return repo.findAll();
    }

    public List<Contact> search(String searchTerm) {
      return repo.search(searchTerm);
    }
}
