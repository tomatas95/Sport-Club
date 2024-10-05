package com.sportclubs.web.service.impl;

import com.sportclubs.web.dto.ClubDto;
import com.sportclubs.web.models.Club;
import com.sportclubs.web.repository.ClubRepository;
import com.sportclubs.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> sportclubs = clubRepository.findAll();
        return sportclubs.stream().map((club -> mapToClubDto(club))).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);

        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    private Club mapToClub(ClubDto club){
        Club clubDto  = Club.builder()
                .id(club.getId())
                .name(club.getName())
                .surname(club.getSurname())
                .email(club.getEmail())
                .phone(club.getPhone())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();

        return clubDto;
    }

    private ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .name(club.getName())
                .surname(club.getSurname())
                .email(club.getEmail())
                .phone(club.getPhone())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }
}
