package com.acme.auction.ws;

import com.acme.auction.model.AuctionRequest;
import com.acme.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API. localhost:8080/auction/*
 */
@RequestMapping("/auction")
@RestController
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    @RequestMapping("/deploy")
    public String deploy(@RequestBody AuctionRequest auctionRequest) throws Exception {
        return auctionService.deploy(auctionRequest);
    }

    @RequestMapping("/start")
    public String startAuction(@RequestBody AuctionRequest auctionRequest) throws Exception {
        return auctionService.startAuction(auctionRequest);
    }

    @RequestMapping("/bid")
    public String bid(@RequestBody AuctionRequest auctionRequest) throws Exception {
        return auctionService.bid(auctionRequest);
    }

    @RequestMapping("/end")
    public String endAuction(@RequestBody AuctionRequest auctionRequest) throws Exception {
        return auctionService.endAuction(auctionRequest);
    }


}
