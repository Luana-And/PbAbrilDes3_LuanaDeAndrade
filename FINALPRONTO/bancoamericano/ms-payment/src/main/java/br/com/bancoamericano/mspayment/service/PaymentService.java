package br.com.bancoamericano.mspayment.service;

import br.com.bancoamericano.mspayment.model.Payment;
import br.com.bancoamericano.mspayment.repository.PaymentRepository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, RabbitTemplate rabbitTemplate) {
        this.paymentRepository = paymentRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Payment processPayment(Payment payment) {
        // Setar a data de criação para o pagamento

        // Salvar o pagamento no banco de dados usando o paymentRepository
        Payment savedPayment = paymentRepository.save(payment);

        // Enviar mensagem para o RabbitMQ
        rabbitTemplate.convertAndSend("exchange-name", "routing-key", savedPayment);

        // Retornar o pagamento processado
        return savedPayment;
    }
}
