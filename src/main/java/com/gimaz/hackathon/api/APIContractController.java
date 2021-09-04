package com.gimaz.hackathon.api;

import com.gimaz.hackathon.dto.AuctionDto;
import com.gimaz.hackathon.dto.AuctionUserDto;
import com.gimaz.hackathon.entity.Lot;
import com.gimaz.hackathon.entity.User;
import com.gimaz.hackathon.services.AuctionService;
import com.gimaz.hackathon.services.LotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/contract")
public class APIContractController {
    private final LotService lotService;
    private final AuctionService auctionService;

    @PostMapping("/addAuction")
    public @ResponseBody Map addAuction(@RequestBody AuctionDto auctionDto)
    {
        auctionService.save(auctionDto);
        HashMap<String,String> res = new HashMap<>();
        res.put("status","access");
        return res;
    }

    @PostMapping("/getAllAuction")
    public @ResponseBody Map getAllAuction()
    {
        Map<String,List<Lot>> lots = new HashMap<>();
        lots.put("lots",lotService.getAll());
        return lots;
    }

    @PostMapping("/addRate")
    public @ResponseBody Map addNewUserAuction(@RequestBody AuctionUserDto auctionUserDto)
    {
        auctionService.addUser(auctionUserDto);
        HashMap<String,String> res = new HashMap<>();
        res.put("status","access");
        return res;
    }

}
