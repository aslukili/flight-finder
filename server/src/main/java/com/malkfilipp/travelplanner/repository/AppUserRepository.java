package com.malkfilipp.travelplanner.repository;


import com.malkfilipp.travelplanner.domain.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
