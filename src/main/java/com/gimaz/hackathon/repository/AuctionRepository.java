package com.gimaz.hackathon.repository;

import com.gimaz.hackathon.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction,Long> {
    List<Auction> findAuctionByEndAucLessThanAndStartAucGreaterThan(LocalDateTime localDateTime, LocalDateTime localDateTime1);
    List<Auction> findAuctionByStatusEquals(boolean status);
}
