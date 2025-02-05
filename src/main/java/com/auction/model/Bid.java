package com.auction.model;

import javax.persistence.*;

@Entity
@Table(name = "bids")
public class Bid {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "auction_id")
private int auctionId;

@Column(name = "user_id")
private int userId;

private double bidAmount;

// Getters and Setters

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public int getAuctionId() {
return auctionId;
}

public void setAuctionId(int auctionId) {
this.auctionId = auctionId;
}

public int getUserId() {
return userId;
}

public void setUserId(int userId) {
this.userId = userId;
}

public double getBidAmount() {
return bidAmount;
}

public void setBidAmount(double bidAmount) {
this.bidAmount = bidAmount;
}
}

