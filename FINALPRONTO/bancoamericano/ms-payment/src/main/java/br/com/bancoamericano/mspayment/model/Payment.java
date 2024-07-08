package br.com.bancoamericano.mspayment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private LocalDateTime createdDate;

    public Payment() {
        this.createdDate = LocalDateTime.now();
    }

    // Getters e Setters omitidos para brevidade

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
