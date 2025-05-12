package com.example.cosmeticsshop.domain.request;

import jakarta.validation.constraints.NotBlank;

public class ReqLoginDTO {
    @NotBlank(message = "username không được để trống")
    private String username;

    @NotBlank(message = "password không được để trống")
    private String password;

<<<<<<< HEAD
    // PIN field is not marked as required since it's only needed for role_id 1
    private String pin;

=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< HEAD
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
}
