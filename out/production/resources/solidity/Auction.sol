pragma solidity ^0.4.0;
contract Auction{
	struct auction {
	    string name;
	    address owner;
		uint deadline;
		uint highestBid;
		address highestBidder;
		bytes32 bidHash;
	}
	mapping(bytes => auction) Auctions;

	function startAuction(string auctionName, uint timeLimit) {
		auction a = Auctions[bytes(auctionName)];
		a.name = auctionName;
		a.deadline = block.number + timeLimit;
		a.owner = msg.sender;
	}

	function bid(string auctionName, string key) payable{
	    require(msg.value >0);
		auction a = Auctions[bytes(auctionName)];
		if (a.highestBid > msg.value || block.number >= a.deadline) {
			msg.sender.transfer(msg.value);

		}
		a.highestBidder.transfer(a.highestBid);
		a.highestBidder = msg.sender;
		a.highestBid = msg.value;
		a.bidHash  = keccak256(key);

	}

	function endAuction(string auctionName, string key) payable{
		auction a = Auctions[bytes(auctionName)];
		if (block.number >= a.deadline && keccak256(key) == a.bidHash) {
			a.owner.transfer(a.highestBid);
			clean(auctionName);
		}
	}
	function clean(string auctionName) private{
		auction a = Auctions[bytes(auctionName)];
		a.highestBid = 0;
		a.highestBidder =0;
		a.deadline = 0;
		a.owner = 0;
		a.bidHash = 0;
	}
}