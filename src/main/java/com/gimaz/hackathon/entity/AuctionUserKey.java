package com.gimaz.hackathon.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuctionUserKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "auction_id")
    Long auctionId;
}
