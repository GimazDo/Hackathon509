package com.gimaz.hackathon.services;

import com.gimaz.hackathon.entity.Lot;
import com.gimaz.hackathon.repository.LotRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface LotService {
    Lot add(Lot lot);

    List<Lot> getAll();
}
