package com.gimaz.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuctionUserDto {
    private String token;
    private Long auctionId;
}
