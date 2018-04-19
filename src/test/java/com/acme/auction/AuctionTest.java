package com.acme.auction;

import com.acme.auction.model.AuctionRequest;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.web3j.utils.Convert;

import java.math.BigInteger;

/**
 * This is not a junit, but acts as test client to call the webservices.
 * Note make sure there is appropriate spacing between calls to make sure the block has been mined.
 * And end auction will only be successful after auction has ended
 *
 */
public class AuctionTest {

    public static void main(String args[]) throws InterruptedException {
        new AuctionTest().testAuction();
    }

    public void testAuction() throws InterruptedException {


        final String auctionResourceUrl = "http://localhost:8080/auction/";
        final String auctionName = "testAuction";


        AuctionRequest auctionRequest = new AuctionRequest("9f4af73607020eexxxxxxxxxxxxxxxxxxxx","password");



        RestTemplate restTemplate = new RestTemplate();


        HttpEntity<AuctionRequest> request = new HttpEntity<>(auctionRequest);
        restTemplate.postForObject(auctionResourceUrl+"deploy", request, String.class);

        auctionRequest = new AuctionRequest("9f4af73607020eexxxxxxxxxxxxxxxxxxxx","password",auctionName);
        auctionRequest.setAuctionTime(new BigInteger("10"));
        request = new HttpEntity<>(auctionRequest);
        restTemplate.postForObject(auctionResourceUrl+"start", request, String.class);

        Thread.sleep(15000);

        auctionRequest = new AuctionRequest("a0842d0079a3f738xxxxxxxxxxxxxxxxxxxx","password123",auctionName);
        auctionRequest.setBid(Convert.toWei(".01", Convert.Unit.ETHER).toBigInteger());
        auctionRequest.setKey("key1");
        request = new HttpEntity<>(auctionRequest);
        restTemplate.postForObject(auctionResourceUrl+"bid", request, String.class);

        auctionRequest = new AuctionRequest("2d70db2e21c52xxxxxxxxxxxxxxxxxx","password1234",auctionName);
        auctionRequest.setBid(Convert.toWei(".02", Convert.Unit.ETHER).toBigInteger());
        auctionRequest.setKey("key2");
        request = new HttpEntity<>(auctionRequest);
        restTemplate.postForObject(auctionResourceUrl+"bid", request, String.class);

        Thread.sleep(60000);

        auctionRequest = new AuctionRequest("2d70db2e21c52f9xxxxxxxxxxxxxxxxx","password1234",auctionName);
        auctionRequest.setKey("key2");
        request = new HttpEntity<>(auctionRequest);
        restTemplate.postForObject(auctionResourceUrl+"end", request, String.class);


    }
}
