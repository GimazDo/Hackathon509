package com.gimaz.hackathon.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rate {
    @EmbeddedId
    private AuctionUserKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("auctionId")
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "start_price")
    private Double Price;




}
