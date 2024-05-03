package com.app.ecomerce.repository;

import com.app.ecomerce.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailVerificationRepository extends JpaRepository<VerificationToken,Long> {
}
