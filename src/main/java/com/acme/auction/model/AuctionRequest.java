package com.acme.auction.model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Request model for rest webservice exchange
 */
public class AuctionRequest implements Serializable {

    private String address;
    private String password;
    private String auctionName;
    private String key;
    private BigInteger bid;
    private BigInteger auctionTime;

    public AuctionRequest(String address, String password, String auctionName) {
        this.address = address;
        this.password = password;
        this.auctionName = auctionName;
    }

    public AuctionRequest(String address, String password) {
        this.address = address;
        this.password = password;
    }

    public  AuctionRequest(){

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public BigInteger getBid() {
        return bid;
    }

    public void setBid(BigInteger bid) {
        this.bid = bid;
    }

    public BigInteger getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(BigInteger auctionTime) {
        this.auctionTime = auctionTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuctionRequest that = (AuctionRequest) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (auctionName != null ? !auctionName.equals(that.auctionName) : that.auctionName != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (bid != null ? !bid.equals(that.bid) : that.bid != null) return false;
        return auctionTime != null ? auctionTime.equals(that.auctionTime) : that.auctionTime == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (auctionName != null ? auctionName.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (bid != null ? bid.hashCode() : 0);
        result = 31 * result + (auctionTime != null ? auctionTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuctionRequest{" +
                "address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", auctionName='" + auctionName + '\'' +
                ", key='" + key + '\'' +
                ", bid=" + bid +
                ", auctionTime=" + auctionTime +
                '}';
    }
}
