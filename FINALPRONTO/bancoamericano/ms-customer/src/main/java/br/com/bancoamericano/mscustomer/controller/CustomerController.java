package br.com.bancoamericano.mscustomer.controller;

import br.com.bancoamericano.mscustomer.model.Customer;
import br.com.bancoamericano.mscustomer.repository.CustomerRepository;
import br.com.bancoamericano.mscustomer.service.CustomerService;
import br.com.bancoamericano.mscustomer.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final S3Service s3Service;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerRepository customerRepository, S3Service s3Service) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.s3Service = s3Service;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer, @RequestParam String base64Image) {
        if (customerService.existsByEmail(customer.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        String imageUrl = s3Service.uploadImage(base64Image);
        customer.setUrlPhoto(imageUrl);
        customer.setPoints(0); // Initialize points to 0
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomer(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Validated @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
