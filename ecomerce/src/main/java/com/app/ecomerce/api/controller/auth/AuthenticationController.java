package com.app.ecomerce.api.controller.auth;

import com.app.ecomerce.api.model.RegistrationBody;
import com.app.ecomerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private CustomerService customerService;

    public AuthenticationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/registerUser")
    public void registerUser(@RequestBody RegistrationBody registrationBody){
      customerService.registerUser(registrationBody);
    }
}
