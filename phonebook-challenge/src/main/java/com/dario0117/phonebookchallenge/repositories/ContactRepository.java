package com.dario0117.phonebookchallenge.repositories;

import java.util.List;

import com.dario0117.phonebookchallenge.entities.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
  List<Contact> findByFirstNameContaining(String name);
  List<Contact> findByLastNameContaining(String name);
  List<Contact> findByPhoneContaining(String phone);
  @Modifying
  @Query(
    value = "SELECT * FROM contacts where  first_name like CONCAT('%',:term,'%') or last_name like CONCAT('%',:term,'%') or phone like CONCAT('%',:term,'%')",
    nativeQuery = true
  )
  List<Contact> search(@Param("term") String term);
}
