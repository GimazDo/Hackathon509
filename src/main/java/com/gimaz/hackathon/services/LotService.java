package com.gimaz.hackathon.services;

import com.gimaz.hackathon.entity.Lot;
import com.gimaz.hackathon.repository.LotRepository;
import lombok.RequiredArgsConstructor;

public interface LotService {
    public Lot add(Lot lot);
}
