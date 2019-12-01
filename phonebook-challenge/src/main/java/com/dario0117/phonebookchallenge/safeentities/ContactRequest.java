package com.dario0117.phonebookchallenge.safeentities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest implements Serializable {
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private String phone;

  public void setFirstName(String name) {
    this.firstName = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String name) {
    this.lastName = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone() {
    return phone;
  }
}
