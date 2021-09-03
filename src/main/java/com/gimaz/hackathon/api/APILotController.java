package com.gimaz.hackathon.api;

import com.gimaz.hackathon.entity.Lot;
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
@RequestMapping("/api/lot")
public class APILotController {
    private final LotService lotService;

    @GetMapping("/getAll")
    public @ResponseBody Map getAllLot()
    {
        Map<String,List<Lot>> lots = new HashMap<>();
        lots.put("lots",lotService.getAll());
        return lots;
    }

}
