package com.dario0117.phonebookchallenge.repositories;

import java.util.List;

import com.dario0117.phonebookchallenge.entities.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
  List<Contact> findByNameContaining(String name);
  List<Contact> findByPhoneContaining(String phone);
}
