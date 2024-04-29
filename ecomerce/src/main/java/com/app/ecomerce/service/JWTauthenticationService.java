package com.app.ecomerce.service;

import com.app.ecomerce.model.Customer;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTauthenticationService {

    //algorythm key can be HS256 or RS256
    @Value("${jwt.algorythm.key}")
    private String algorythmkey;

    //who is going to issue the token
    @Value("${jwt.token.issuer}")
    private String tokenIssuer;

    @Value("${jwt.time.seconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;

    private static final String USERNAME_KEY = "USERNAME";

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(algorythmkey);
    }

    //Generates Jwt token for the customer
    public String generateJWTToken(Customer customer){
        return JWT
                .create()
                .withClaim(USERNAME_KEY,customer.getUserName())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expiryInSeconds)))
                .withIssuer(tokenIssuer)
                .sign(algorithm);

    }
}
