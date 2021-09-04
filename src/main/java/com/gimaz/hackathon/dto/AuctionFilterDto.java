package com.gimaz.hackathon.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AuctionFilterDto {
    private String type;
    private String filter;
}
