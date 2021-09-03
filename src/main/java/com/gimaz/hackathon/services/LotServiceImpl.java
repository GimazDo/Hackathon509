package com.gimaz.hackathon.services;

import com.gimaz.hackathon.entity.Lot;
import com.gimaz.hackathon.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LotServiceImpl implements LotService{
    private final LotRepository lotRepository;
    @Override
    public Lot add(Lot lot) {
        log.info("saving lot: {}",lot.toString());
        return lotRepository.save(lot);
    }
}
