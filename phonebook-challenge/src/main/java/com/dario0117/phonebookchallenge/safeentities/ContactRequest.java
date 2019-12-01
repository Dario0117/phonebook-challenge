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
    private String name;
    private String phone;

    public void setName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public String getPhone() {
      return phone;
    }
}
