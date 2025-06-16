package com.example.usermanagement.repository;

import com.example.usermanagement.entity.PasswordHistory;
import com.example.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, UUID> {
    List<PasswordHistory> findByUserOrderByCreatedAtDesc(User user);
    
    @Query("SELECT ph FROM PasswordHistory ph WHERE ph.user = :user ORDER BY ph.createdAt DESC")
    List<PasswordHistory> findLastFivePasswordsByUser(User user);
    
    void deleteAllByUser(User user);
} 