package com.gimaz.hackathon.services;

import com.gimaz.hackathon.blockchain.RentContract;

import java.util.List;

public interface ContractService {
    public boolean createContract(RentContract contract);

    public List<RentContract> checkPayment();



}
