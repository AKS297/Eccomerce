package com.app.ecomerce.service;

import com.app.ecomerce.api.model.LogInBody;
import com.app.ecomerce.api.model.RegistrationBody;
import com.app.ecomerce.model.Customer;
import com.app.ecomerce.model.VerificationToken;
import com.app.ecomerce.repository.CustomerRepository;
import com.app.ecomerce.repository.MailVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
   @Autowired
    private Customer customer;



    public CustomerService(CustomerRepository customerRepository, Customer customer, EncryptionService encryptionService, JWTauthenticationService jwTauthenticationService) {
        this.customerRepository = customerRepository;
        this.customer = customer;
        this.encryptionService = encryptionService;
        this.jwTauthenticationService = jwTauthenticationService;
    }

    @Autowired
   private EncryptionService encryptionService;

   private JWTauthenticationService jwTauthenticationService;

   @Autowired
   private EmailService emailService;

   @Autowired
   private MailVerificationRepository mailVerificationRepository;

    public Customer registerUser(RegistrationBody registrationBody){
        customer.setEmail(registrationBody.getEmail());
        customer.setUserName(registrationBody.getUserName());
        customer.setFirstName(registrationBody.getFirstName());
        customer.setLastName(registrationBody.getLastName());
        customer.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        VerificationToken verificationToken = createVerificationToken(customer);
        mailVerificationRepository.save(verificationToken);
        return customerRepository.save(customer);
    }

    public String logInUser(LogInBody logInBody) {
        Optional<Customer> checkUser = customerRepository.findByUserName(logInBody.getUserName());
        if (checkUser.isPresent()) {
            Customer customer1 = checkUser.get();
            if (encryptionService.verifyPassword(logInBody.getPassword(), customer1.getPassword())) {
                return jwTauthenticationService.generateJWTToken(customer1);
            }
        }
        return null;
    }

    public VerificationToken createVerificationToken(Customer customer){
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(jwTauthenticationService.generateEmailToken(customer));
        verificationToken.setTimestamp(new Timestamp(System.currentTimeMillis()));
        verificationToken.setUser(customer);
        customer.getVerificationTokens().add(verificationToken);
        return verificationToken;
    }
}
