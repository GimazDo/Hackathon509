package com.gimaz.hackathon.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gimaz.hackathon.dto.AuctionDto;
import com.gimaz.hackathon.dto.AuctionFilterDto;
import com.gimaz.hackathon.entity.Auction;
import com.gimaz.hackathon.entity.Lot;
import com.gimaz.hackathon.services.AuctionService;
import com.gimaz.hackathon.services.LotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class APIAdmin {

    private final AuctionService auctionService;
    private final LotService lotService;

    @PostMapping("/getAuctions")
    public @ResponseBody
    HashMap getAuctionsWithFilter(@RequestBody AuctionFilterDto filter)
    {
        HashMap<String, List<Auction>> map = new HashMap<>();
        map.put("auctions",auctionService.findWithFilter(filter));
        return  map;
    }

    @PostMapping("/getLots")
    @ResponseBody
    public  String getAllLot() throws JsonProcessingException {
        HashMap<String,Object> lots = new HashMap<>();
        lots.put("lots",lotService.getAll());
        return new ObjectMapper().writeValueAsString(lots);
    }

    @PostMapping("/addAuction")
    public @ResponseBody
    Map addAuction(@RequestBody AuctionDto auctionDto)
    {
        auctionService.save(auctionDto);
        HashMap<String,String> res = new HashMap<>();
        res.put("status","access");
        return res;
    }



}
