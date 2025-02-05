package com.auction.service;

import com.auction.model.AuctionListing;
import com.auction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

@Autowired
private AuctionRepository auctionRepository;

// Create a new auction listing
public AuctionListing createAuction(AuctionListing auctionListing) {
return auctionRepository.save(auctionListing);
}

// Get all active auctions without bids
public List<AuctionListing> getActiveAuctions() {
return auctionRepository.findByCurrentHighBidderIsNull();
}

// Place a bid on an auction (simplified)
public AuctionListing placeBid(int auctionId, int userId, double bidAmount) {
AuctionListing auction = auctionRepository.findById(auctionId).orElse(null);
if (auction != null && (auction.getCurrentHighBidder() == null || bidAmount > auction.getStartingPrice())) {
// Update the highest bidder and save the auction listing.
auction.setCurrentHighBidder(userId);
auction.setStartingPrice(bidAmount); // Update to new bid amount if needed.
return auctionRepository.save(auction);
}
return null; // Bid failed (low amount or invalid auction).
}
}
