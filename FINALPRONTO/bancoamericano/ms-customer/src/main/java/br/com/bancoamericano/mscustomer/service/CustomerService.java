package br.com.bancoamericano.mscustomer.service;

import br.com.bancoamericano.mscustomer.model.Customer;
import br.com.bancoamericano.mscustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}
