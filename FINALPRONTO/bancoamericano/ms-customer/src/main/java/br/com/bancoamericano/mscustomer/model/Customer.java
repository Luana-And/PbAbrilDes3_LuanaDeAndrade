package br.com.bancoamericano.mscustomer.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cpf;
    private String name;
    private String gender;
    private String birthdate;
    private String email;
    private int points = 0;
    private String urlPhoto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", email='" + email + '\'' +
                ", points=" + points +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }
}
