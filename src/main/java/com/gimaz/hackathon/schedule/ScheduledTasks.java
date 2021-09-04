package com.gimaz.hackathon.schedule;

import com.gimaz.hackathon.blockchain.RentContract;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class ScheduledTasks {
    private final Web3j web3j = Web3j.build( new HttpService(
            "https://kovan.infura.io/v3/a3674ea3192a4e22a32a9ad2301df83b"
    ));
    Credentials credentials = Credentials.create("cc9fd47e80730173f01d614ec84908ed923afceebb09b7bcbd3effe5d51dbeae");
    TransactionManager transactionManager = new RawTransactionManager(web3j,credentials, ChainId.KOVAN);
    private final RentContract rentContract = RentContract.load("0xd2435293340e537bacd2fed2f700b204c707518d",web3j,transactionManager, BigInteger.valueOf(1000000000L),BigInteger.valueOf(8000000L));

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    Опрос блокчейна на списание и отправка тех, у кого надо списать денег
       @Scheduled(fixedRate = 1000*60*60*24)
        public void checkContract() throws Exception {
           rentContract.getContracts().sendAsync().get();
        }
}