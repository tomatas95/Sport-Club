package com.sportclubs.web.repository;

import com.sportclubs.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
//    Optional<Club> findByName();
}
