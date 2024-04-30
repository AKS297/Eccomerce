package com.app.ecomerce.api.model;

import jakarta.validation.constraints.*;

public class RegistrationBody {
   @NotNull
   @NotBlank
   @Max(255)
    private String userName;

   @NotNull
   @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Min(6)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    private String password;
    private String firstName;
    private String lastName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
