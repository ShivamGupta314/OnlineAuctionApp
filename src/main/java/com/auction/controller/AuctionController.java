package com.auction.controller;

import com.auction.model.AuctionListing;
import com.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuctionController {

@Autowired
private AuctionService auctionService;

// Show active auctions.
@GetMapping("/auctions")
public String showAuctions(ModelMap model) {
model.put("auctions", auctionService.getActiveAuctions());
return "auction"; // Thymeleaf template name for auctions list.
}

// Show form to create a new auction (Admin only).
@GetMapping("/create-auction")
public String showCreateAuctionForm(ModelMap model) {
model.put("auction", new AuctionListing());
return "create-auction"; // Thymeleaf template name for creating an auction.
}

// Handle new auction creation.
@PostMapping("/create-auction")
public String createAuction(AuctionListing auctionListing) {
auctionService.createAuction(auctionListing);
return "redirect:/auctions"; // Redirect to auctions after creation.
}

// Handle placing a bid on an auction (simplified).
@PostMapping("/place-bid")
public String placeBid(int auctionId, int userId, double bidAmount) {
// Logic to place bid here (you may want to retrieve user ID from session).
auctionService.placeBid(auctionId, userId, bidAmount);
return "redirect:/auctions"; // Redirect back to auctions after bidding.
}
}
