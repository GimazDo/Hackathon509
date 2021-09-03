package com.gimaz.hackathon.entity;

import jnr.posix.LibC;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Auction {
    @Id

    private Long id;

    private LocalDateTime startAuc;

    private  LocalDateTime endAuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id")
    private Lot lot;

    private Long startPrice;

    private Long lastPrice;
}
