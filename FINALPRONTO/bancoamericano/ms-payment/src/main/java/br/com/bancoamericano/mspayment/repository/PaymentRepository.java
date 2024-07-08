package br.com.bancoamericano.mspayment.repository;


import br.com.bancoamericano.mspayment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Método para encontrar pagamentos por ID do cliente
}

