package com.auction.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "auctions")
public class AuctionListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;
    private String description;
    private double startingPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "current_high_bidder")
    private Integer currentHighBidder; // User ID of the highest bidder

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCurrentHighBidder() {
        return currentHighBidder;
    }

    public void setCurrentHighBidder(Integer currentHighBidder) {
        this.currentHighBidder = currentHighBidder;
    }
}
