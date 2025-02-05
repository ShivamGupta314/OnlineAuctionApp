package com.auction.repository;

import com.auction.model.AuctionListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<AuctionListing, Integer> {

List<AuctionListing> findByCurrentHighBidderIsNull(); // Find active auctions without bids

}
