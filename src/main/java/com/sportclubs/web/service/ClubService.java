package com.sportclubs.web.service;

import com.sportclubs.web.dto.ClubDto;
import com.sportclubs.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();


    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);

    void delete(Long clubId);
}
