package com.gimaz.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {
    private Long lotId;
    private Double Price;
    private String startAuc;
    private String endAuc;
}
