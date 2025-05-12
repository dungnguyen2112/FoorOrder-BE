package com.example.cosmeticsshop.domain.response;

import com.example.cosmeticsshop.domain.Role;
import com.example.cosmeticsshop.util.constant.RoyaltyEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
<<<<<<< HEAD
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
public class ResLoginDTO {
    @JsonProperty("access_token")
    private String accessToken;

    private UserLogin user;

<<<<<<< HEAD
    private String message;

    @Builder.Default
    private boolean needPin = false;

=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserLogin {
        private long id;
        private String email;
        private String name;
        private String avatar;
        private Long roleId;
        private RoyaltyEnum royalty;
        private double totalMoneySpent;
        private int totalOrder;
        private String phone;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserGetAccount {
        private UserLogin user;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserInsideToken {
        private long id;
        private String email;
        private String name;
    }
<<<<<<< HEAD
=======

>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
}
