package com.gimaz.hackathon.controller;

import com.gimaz.hackathon.entity.Lot;
import com.gimaz.hackathon.services.LotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lot")
@RequiredArgsConstructor
public class LotController {
    private final LotService lotService;
    @GetMapping("/add")
    public String getAddPage(Model Model)
    {
        return "LotAdd";
    }


    @PostMapping("/add")
    public String postAdd(@RequestParam Long square,
                          @RequestParam boolean status)
    {
        Lot lot = new Lot(null,square,status);
        lotService.add(lot);
        return "LotAdd";
    };
}
