package org.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Payee extends PanacheEntity {

    public String payeeName;
    public String accountNumber;
    public String address;

    // No need for getters and setters, Panache simplifies this.
}
