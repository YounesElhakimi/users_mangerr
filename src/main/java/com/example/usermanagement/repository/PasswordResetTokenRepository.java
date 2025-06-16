package com.example.usermanagement.repository;

import com.example.usermanagement.entity.PasswordResetToken;
import com.example.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, UUID> {
    Optional<PasswordResetToken> findByToken(String token);
    
    @Query("SELECT pt FROM PasswordResetToken pt WHERE pt.user = :user AND pt.used = false AND pt.expiresAt > :now")
    Optional<PasswordResetToken> findValidTokenByUser(User user, OffsetDateTime now);
    
    @Modifying
    @Query("DELETE FROM PasswordResetToken pt WHERE pt.user = :user")
    void deleteAllByUser(User user);
    
    @Modifying
    @Query("UPDATE PasswordResetToken pt SET pt.used = true WHERE pt.id = :id")
    void markAsUsed(UUID id);
} 