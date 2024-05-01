package com.app.ecomerce.config;


import com.app.ecomerce.model.Customer;
import com.app.ecomerce.repository.CustomerRepository;
import com.app.ecomerce.service.CustomerService;
import com.app.ecomerce.service.JWTauthenticationService;
import com.auth0.jwt.exceptions.JWTDecodeException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTauthenticationService jwTauthenticationService;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String tokenHeader = request.getHeader("Authorization");
      if(tokenHeader != null && tokenHeader.startsWith("Bearer ")){
         String token = tokenHeader.substring(7);
          try {
              String userName = jwTauthenticationService.getUserName(token);
              Optional<Customer> customer = customerRepository.findByUserName(userName);
              if(customer.isPresent()){
                  Customer user =  customer.get();
                  UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,new ArrayList());
                  authentication.setDetails(new WebAuthenticationDetails(request));
                  SecurityContextHolder.getContext().setAuthentication(authentication);
              }
          }catch ( JWTDecodeException exception){

          }
      }
      filterChain.doFilter(request,response);
    }
}
