package com.gimaz.hackathon.blockchain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class RentContract extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_CREATERENTCONTRACT = "createRentContract";

    public static final String FUNC_DELETERENTCONTRACT = "deleteRentContract";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_EDITRENTCONTRACT = "editRentContract";

    public static final String FUNC_GETCONTRACTS = "getContracts";

    public static final String FUNC_LANDLORD = "landlord";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PAYOFFOP = "payOffOp";

    public static final String FUNC_RENTCONTRACTS = "rentContracts";

    public static final String FUNC_SETBALANCE = "setBalance";

    public static final String FUNC_SIGNCONTRACT = "signContract";

    public static final String FUNC_TERMINATECONTRACT = "terminateContract";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_WRITEOFFRENT = "writeOffRent";

    @Deprecated
    protected RentContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RentContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RentContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RentContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createRentContract(rentInfo _info) {
        final Function function = new Function(
                FUNC_CREATERENTCONTRACT, 
                Arrays.<Type>asList(_info), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deleteRentContract(BigInteger _contractId) {
        final Function function = new Function(
                FUNC_DELETERENTCONTRACT, 
                Arrays.<Type>asList(new Uint256(_contractId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit(String _to) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(new Address(160, _to)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> editRentContract(rentInfo _newInfo, BigInteger _contractId) {
        final Function function = new Function(
                FUNC_EDITRENTCONTRACT, 
                Arrays.<Type>asList(_newInfo, 
                new Uint256(_contractId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getContracts() {
        final Function function = new Function(FUNC_GETCONTRACTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<rentInfo>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<String> landlord() {
        final Function function = new Function(FUNC_LANDLORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payOffOp(BigInteger _contractId) {
        final Function function = new Function(
                FUNC_PAYOFFOP, 
                Arrays.<Type>asList(new Uint256(_contractId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple8<Boolean, String, Boolean, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> rentContracts(BigInteger param0) {
        final Function function = new Function(FUNC_RENTCONTRACTS, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple8<Boolean, String, Boolean, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple8<Boolean, String, Boolean, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple8<Boolean, String, Boolean, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<Boolean, String, Boolean, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (Boolean) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> setBalance(String _user, BigInteger _value) {
        final Function function = new Function(
                FUNC_SETBALANCE, 
                Arrays.<Type>asList(new Address(160, _user),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> signContract(BigInteger _contractId, Boolean _payOpNow, BigInteger _today) {
        final Function function = new Function(
                FUNC_SIGNCONTRACT, 
                Arrays.<Type>asList(new Uint256(_contractId),
                new Bool(_payOpNow),
                new org.web3j.abi.datatypes.generated.Uint8(_today)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> terminateContract(BigInteger _contractId) {
        final Function function = new Function(
                FUNC_TERMINATECONTRACT, 
                Arrays.<Type>asList(new Uint256(_contractId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(String _to, BigInteger _amount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new Address(160, _to),
                new Uint256(_amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> writeOffRent(BigInteger _contractId) {
        final Function function = new Function(
                FUNC_WRITEOFFRENT, 
                Arrays.<Type>asList(new Uint256(_contractId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static RentContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RentContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RentContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RentContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RentContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RentContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RentContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RentContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class rentInfo extends StaticStruct {
        public Boolean isOccupied;

        public String tenant;

        public Boolean opPayed;

        public BigInteger opDaysLeft;

        public BigInteger opAmountLeft;

        public BigInteger paymentDate;

        public BigInteger area;

        public BigInteger monthlyPrice;

        public rentInfo(Boolean isOccupied, String tenant, Boolean opPayed, BigInteger opDaysLeft, BigInteger opAmountLeft, BigInteger paymentDate, BigInteger area, BigInteger monthlyPrice) {
            super(new Bool(isOccupied),new Address(tenant),new Bool(opPayed),new Uint256(opDaysLeft),new Uint256(opAmountLeft),new Uint256(paymentDate),new Uint256(area),new Uint256(monthlyPrice));
            this.isOccupied = isOccupied;
            this.tenant = tenant;
            this.opPayed = opPayed;
            this.opDaysLeft = opDaysLeft;
            this.opAmountLeft = opAmountLeft;
            this.paymentDate = paymentDate;
            this.area = area;
            this.monthlyPrice = monthlyPrice;
        }

        public rentInfo(Bool isOccupied, Address tenant, Bool opPayed, Uint256 opDaysLeft, Uint256 opAmountLeft, Uint256 paymentDate, Uint256 area, Uint256 monthlyPrice) {
            super(isOccupied,tenant,opPayed,opDaysLeft,opAmountLeft,paymentDate,area,monthlyPrice);
            this.isOccupied = isOccupied.getValue();
            this.tenant = tenant.getValue();
            this.opPayed = opPayed.getValue();
            this.opDaysLeft = opDaysLeft.getValue();
            this.opAmountLeft = opAmountLeft.getValue();
            this.paymentDate = paymentDate.getValue();
            this.area = area.getValue();
            this.monthlyPrice = monthlyPrice.getValue();
        }
    }
}
