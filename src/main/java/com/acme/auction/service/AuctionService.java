package com.acme.auction.service;

import com.acme.auction.contract.Auction;
import com.acme.auction.model.AuctionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.io.IOException;
import java.math.BigInteger;

/**
 * This class contains all the logic to interact with the ethereum client.
 *
 */
@Service
public class AuctionService {


    private static final Logger log = LoggerFactory.getLogger(AuctionService.class);
    //keystore files location
    private static final String KEYSTORE_LOCATION = "/home/xxx/.ethereum/testnet/keystore/";
    //contract address
    private static String contractAddress;

    @Autowired
    private Web3j web3j;

    /**
     * Deploy contract to ethereum n/w.
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String deploy(AuctionRequest request) throws Exception {

        if(contractAddress == null){

            Auction contract = Auction.deploy(web3j,getCredentials(request.getAddress(), request.getPassword()),
                            ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
            //store contract address for future references , so this app allows only one contract deploy per vm
            contractAddress = contract.getContractAddress();

            log.info("Smart contract deployed to address " + contractAddress);
            log.info("View contract at https://rinkeby.etherscan.io/address/" + contractAddress);


        }

        return contractAddress;

    }

    /**
     * Initialize an auction
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String startAuction(AuctionRequest request) throws Exception {

        Auction contract = getContract(request.getAddress(), request.getPassword());

        TransactionReceipt transactionReceipt = contract.startAuction(request.getAuctionName(), request.getAuctionTime()).send();

        log.info("Auction: "+request.getAuctionName()+ " started. "+ transactionReceipt.getBlockHash()+ " "+ transactionReceipt.getBlockNumber()+
        " "+transactionReceipt.getStatus());

        return transactionReceipt.getTransactionHash();

    }

    /**
     * Send a bid request
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String bid(AuctionRequest request) throws Exception {

        Auction contract = getContract(request.getAddress(), request.getPassword());

        TransactionReceipt transactionReceipt =  contract.bid(request.getAuctionName(), request.getKey(), request.getBid()).send();

        log.info("User: "+request.getAddress()+" Bid: "+request.getBid()+" "+ transactionReceipt.getBlockHash()+ " "+ transactionReceipt.getBlockNumber()+
                " "+transactionReceipt.getStatus());

        return transactionReceipt.getTransactionHash();


    }

    /**
     * End auction . This auction will only end when the auction deadline has passed and correct key is passed in
     * transfer the locked in funds.
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String endAuction(AuctionRequest request) throws Exception {

        Auction contract = getContract(request.getAddress(), request.getPassword());

        TransactionReceipt transactionReceipt =  contract.endAuction(request.getAuctionName(), request.getKey(), BigInteger.ZERO).send();

        log.info("User: "+request.getAddress()+" EndAuction Request  "+ transactionReceipt.getBlockHash()+ " "+ transactionReceipt.getBlockNumber()+
                " "+transactionReceipt.getStatus());

        return transactionReceipt.getTransactionHash();


    }


    private Auction getContract(String address, String password) throws IOException, CipherException {

        Credentials credentials = getCredentials(address, password);

        return Auction.load(contractAddress, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);

    }

    private Credentials getCredentials(String address, String password) throws IOException, CipherException {
        //Assumption: wallet file has been stored has account.json
        String filePath = KEYSTORE_LOCATION+address+".json";

        Credentials credentials = WalletUtils.loadCredentials(password, filePath);

        return credentials;

    }

}
