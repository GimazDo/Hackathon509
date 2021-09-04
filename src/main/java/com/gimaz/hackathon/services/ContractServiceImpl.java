package com.gimaz.hackathon.services;

import com.gimaz.hackathon.blockchain.RentContract;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContractServiceImpl implements ContractService{
    private final Web3j web3j = Web3j.build( new HttpService(
            "https://kovan.infura.io/v3/a3674ea3192a4e22a32a9ad2301df83b"
    ));
    Credentials credentials = Credentials.create("cc9fd47e80730173f01d614ec84908ed923afceebb09b7bcbd3effe5d51dbeae");
    TransactionManager transactionManager = new RawTransactionManager(web3j,credentials, ChainId.KOVAN);
    private final RentContract rentContract = RentContract.load("0xd2435293340e537bacd2fed2f700b204c707518d",web3j,transactionManager, BigInteger.valueOf(1000000000L),BigInteger.valueOf(8000000L));

    @Override
    public boolean createContract(Boolean isOccupied, String tenant,
                                  Boolean opPayed, BigInteger opDaysLeft,
                                  BigInteger opAmountLeft, BigInteger paymentDate,
                                  BigInteger area, BigInteger monthlyPrice ) {
        try {
            rentContract.createRentContract(new RentContract.rentInfo( isOccupied,  tenant,  opPayed,  opDaysLeft,  opAmountLeft,  paymentDate,  area,  monthlyPrice)).sendAsync();

        }
        catch (Exception e)
        {
            log.warn(e.getMessage());
            return false;
        }
        log.info("IN createContract - success create contract");
        return true;
    }

    @Override
    public List<RentContract> checkPayment() {
        return null;
    }

    @Override
    public void writeOffRent(BigInteger contractId) {
        try {

            rentContract.writeOffRent(contractId).sendAsync();
        }
        catch (Exception e)
        {
            log.warn(e.getMessage());
            return;
        }
        log.info("IN writeOffRent - success write off rent with contract id: {}",contractId);
    }

    @Override
    public void terminateContract(BigInteger contractId) {
        try {
            rentContract.terminateContract(contractId).sendAsync();
        }
        catch (Exception e)
        {
            log.warn(e.getMessage());
            return;
        }
        log.warn("IN terminateContract - terminate contract with id: {}",contractId);
    }
}
