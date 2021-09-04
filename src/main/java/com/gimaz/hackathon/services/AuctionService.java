package com.gimaz.hackathon.services;

import com.gimaz.hackathon.dto.AuctionDto;
import com.gimaz.hackathon.dto.AuctionUserDto;
import com.gimaz.hackathon.entity.Auction;

import java.util.List;

public interface AuctionService {
    Auction save(Auction auction);
    Auction addUser(AuctionUserDto auctionUserDto);
    List<Auction> getAllActiveAuctions();
    List<Auction> getAll();
    Auction save(AuctionDto auctionDto);

}
