package com.gimaz.hackathon.controller;

import com.gimaz.hackathon.entity.Auction;
import com.gimaz.hackathon.services.AuctionService;
import com.gimaz.hackathon.services.LotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionService auctionService;
    private final LotService lotService;
    @GetMapping("/add")
    public String getAddPage()
    {
        return "AuctionAdd";
    }

    @PostMapping("/add")
    public String addAuction(@RequestParam Long lot_id,
                             @RequestParam Long price,
                             @RequestParam String startAuc,
                             @RequestParam String endAuc
                             )
    {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(startAuc.replace("T"," "), formatter);
        LocalDateTime localDateTime1 = LocalDateTime.parse(endAuc.replace("T"," "), formatter);

        Auction auction = new Auction(null,localDateTime,
                localDateTime1,lotService.findById(lot_id),
                price.doubleValue(),true,null);
        auctionService.save(auction);
        return "AuctionAdd";
    }
}
