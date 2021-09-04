package com.gimaz.hackathon.services;

import com.gimaz.hackathon.blockchain.RentContract;

import java.math.BigInteger;
import java.util.List;

public interface ContractService {
    public boolean createContract(Boolean isOccupied, String tenant,
                                  Boolean opPayed, BigInteger opDaysLeft,
                                  BigInteger opAmountLeft, BigInteger paymentDate,
                                  BigInteger area, BigInteger monthlyPrice);

    public List<RentContract> checkPayment();

    public void writeOffRent(BigInteger contractId);


    public void terminateContract(BigInteger contractId);

}
