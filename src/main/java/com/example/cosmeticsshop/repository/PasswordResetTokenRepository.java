package com.example.cosmeticsshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1

import com.example.cosmeticsshop.domain.PasswordResetToken;
import com.example.cosmeticsshop.domain.User;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);

    Optional<PasswordResetToken> findByUser(User user);
<<<<<<< HEAD

    @Modifying
    @Query("DELETE FROM PasswordResetToken p WHERE p.user = :user")
    void deleteByUser(@Param("user") User user);
=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
}
