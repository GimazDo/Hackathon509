package com.gimaz.hackathon.services;

import com.gimaz.hackathon.dto.AuctionDto;
import com.gimaz.hackathon.dto.AuctionUserDto;
import com.gimaz.hackathon.entity.Auction;
import com.gimaz.hackathon.entity.User;
import com.gimaz.hackathon.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService{
    private final AuctionRepository auctionRepository;
    private final UserService userService;
    private final LotService lotService;
    @Override
    public Auction save(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public Auction addUser(AuctionUserDto auctionUserDto) {
        User user = userService.getUserByToken(auctionUserDto.getToken());
        Auction auction = auctionRepository.getById(auctionUserDto.getAuctionId());
        auction.getUsers().add(user);
        log.info("IN AuctionService.addUser -> Add new user with username {} to auction {}", user.getUsername(),auction.getId());
        return auction;
    }

    @Override
    public List<Auction> getAllActiveAuctions() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("IN AuctionService.getAllActiveAuctions -> Return all active auctions from DB");
        return auctionRepository.findAuctionByEndAucLessThanAndStartAucGreaterThan(localDateTime);
    }

    @Override
    public List<Auction> getAll() {
        log.info("IN AuctionService.getAll -> Return all auctions from DB");
        return auctionRepository.findAll();
    }

    @Override
    public Auction save(AuctionDto auctionDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
        LocalDateTime startAuc = LocalDateTime.parse(auctionDto.getStartAuc(),formatter );
        LocalDateTime endAuc = LocalDateTime.parse(auctionDto.getEndAuc(),formatter);
        Auction auction = new Auction(null,startAuc,endAuc,lotService.findById(auctionDto.getLotId()),auctionDto.getPrice(),null);
        return auctionRepository.save(auction);
    }
}
