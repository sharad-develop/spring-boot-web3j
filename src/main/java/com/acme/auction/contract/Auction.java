package com.acme.auction.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class Auction extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6106ea8061001e6000396000f3006060604052600436106100565763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663862882e5811461005b5780638bc678b0146100b0578063a4f2613d14610138575b600080fd5b341561006657600080fd5b6100ae60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965050933593506101c092505050565b005b6100ae60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061027f95505050505050565b6100ae60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496506103b795505050505050565b600080836040518082805190602001908083835b602083106101f35780518252601f1990920191602091820191016101d4565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405190819003902090508083805161023b929160200190610623565b5043919091016002820155600101805473ffffffffffffffffffffffffffffffffffffffff19163373ffffffffffffffffffffffffffffffffffffffff1617905550565b600080836040518082805190602001908083835b602083106102b25780518252601f199092019160209182019101610293565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902090508060020154431015801561035a57506005810154826040518082805190602001908083835b6020831061032b5780518252601f19909201916020918201910161030c565b6001836020036101000a0380198251168184511617909252505050919091019250604091505051908190039020145b156103b2576001810154600382015473ffffffffffffffffffffffffffffffffffffffff9091169080156108fc0290604051600060405180830381858888f1935050505015156103a957600080fd5b6103b283610575565b505050565b6000348190116103c657600080fd5b6000836040518082805190602001908083835b602083106103f85780518252601f1990920191602091820191016103d9565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902090503481600301541180610443575080600201544310155b156104875773ffffffffffffffffffffffffffffffffffffffff33163480156108fc0290604051600060405180830381858888f19350505050151561048757600080fd5b6004810154600382015473ffffffffffffffffffffffffffffffffffffffff9091169080156108fc0290604051600060405180830381858888f1935050505015156104d157600080fd5b60048101805473ffffffffffffffffffffffffffffffffffffffff19163373ffffffffffffffffffffffffffffffffffffffff16179055346003820155816040518082805190602001908083835b6020831061053e5780518252601f19909201916020918201910161051f565b6001836020036101000a03801982511681845116179092525050509190910192506040915050519081900390206005909101555050565b600080826040518082805190602001908083835b602083106105a85780518252601f199092019160209182019101610589565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405190819003902060006003820181905560048201805473ffffffffffffffffffffffffffffffffffffffff199081169091556002830182905560018301805490911690556005909101555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061066457805160ff1916838001178555610691565b82800160010185558215610691579182015b82811115610691578251825591602001919060010190610676565b5061069d9291506106a1565b5090565b6106bb91905b8082111561069d57600081556001016106a7565b905600a165627a7a72305820eaf062feeec25a60244aa72afbe1c1416fe1b10f7da8db0424c51ee3a8f47d940029";

    protected Auction(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Auction(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> startAuction(String auctionName, BigInteger timeLimit) {
        final Function function = new Function(
                "startAuction", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(auctionName), 
                new org.web3j.abi.datatypes.generated.Uint256(timeLimit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> endAuction(String auctionName, String key, BigInteger weiValue) {
        final Function function = new Function(
                "endAuction", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(auctionName), 
                new org.web3j.abi.datatypes.Utf8String(key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> bid(String auctionName, String key, BigInteger weiValue) {
        final Function function = new Function(
                "bid", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(auctionName), 
                new org.web3j.abi.datatypes.Utf8String(key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public static RemoteCall<Auction> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Auction.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Auction> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Auction.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Auction load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Auction(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Auction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Auction(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
