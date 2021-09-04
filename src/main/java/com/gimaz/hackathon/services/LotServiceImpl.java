package com.gimaz.hackathon.services;

import com.gimaz.hackathon.entity.Lot;
import com.gimaz.hackathon.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Lot findById(Long id) {
        Optional<Lot> lots = lotRepository.findById(id);
        return lots.get();
    }

    @Override
    public List<Lot> getAll() {
        return lotRepository.findAll();
    }
}
