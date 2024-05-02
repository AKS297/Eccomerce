package com.app.ecomerce.api.controller.cutomerOrderController;

import com.app.ecomerce.model.Customer;
import com.app.ecomerce.model.CustomerOrders;
import com.app.ecomerce.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/getAllOrders")
    public List<CustomerOrders> getOrders(@AuthenticationPrincipal Customer customer){
        return customerOrderService.getOrderes(customer);
    }
}

