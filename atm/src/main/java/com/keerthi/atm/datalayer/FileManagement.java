package com.keerthi.atm.datalayer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.keerthi.atm.model.Customers;
import com.keerthi.atm.model.Transaction;

public class FileManagement {

    private static FileManagement fileManagement;

    private Customers currentCustomer;

    Gson gson = new Gson();

    public static FileManagement getInstance() {
        if (fileManagement == null) {
            fileManagement = new FileManagement();
            fileManagement.LoadCustomerJson();
            fileManagement.LoadMiniStatement();
        }
        return fileManagement;
    }

    Map<String, Customers> customerMap = new HashMap<>();
    Map<String, List<Transaction>> transactionList = new HashMap<>();

    public boolean addCustomerToJson(Customers customer) {
        LoadCustomerJson();
        if (!customerMap.containsKey(customer.getAccNo())) {
            customerMap.put(customer.getAccNo(), customer);
            convertCustomerJson();
            return true;
        }

        return false;
    }

    private void convertCustomerJson() {
        String customerJson = gson.toJson(customerMap);
        try (FileWriter fileWriter = new FileWriter("customerData.json")) {
            fileWriter.write(customerJson);
            System.out.println("Json added success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadCustomerJson() {
        File file = new File("customerData.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("{}");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (FileReader fileReader = new FileReader("customerData.json")) {
            Type type = new TypeToken<Map<String, Customers>>() {
            }.getType();
            Map<String, Customers> existingData = gson.fromJson(fileReader, type);
            if (existingData != null) {
                customerMap.putAll(existingData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Customers> geAllCustomers() {
        LoadCustomerJson();
        return customerMap;
    }

    public boolean checkCustomers(Customers customer) {
        System.out.println(customer.getAccNo());
        for (Entry<String, Customers> entry : customerMap.entrySet()) {
            if (customer.getAccNo().equals(entry.getKey()) && customer.getPinNo() == entry.getValue().getPinNo()) {

                currentCustomer = entry.getValue();
                System.out.println("get current customer111....");
                return true;
            }
        }

        return false;

    }

    public void getAllDataFromJson() {
        LoadCustomerJson();
        LoadMiniStatement();

    }

    public Customers getCurrentCustomer() {
        System.out.println("get current customer....");
        return currentCustomer;
    }

    public void updateAmountInCustomers(Customers customer, int amount) {
        for (Entry<String, Customers> entry : customerMap.entrySet()) {
            if (customer.getAccNo().equals(entry.getKey()) && customer.getPinNo() == entry.getValue().getPinNo())
                customer.setAmount(customer.getAmount() - amount);

        }

        convertCustomerJson();

    }

    public boolean checkReceiverExist(String receiverAccNo) {
        for (Entry<String, Customers> entry : customerMap.entrySet()) {
            if (receiverAccNo.equals(entry.getKey()))
                return true;

        }

        return false;
    }

    public void updateTransactionSender(String receiverAccNo, Customers customer, int amount) {
        for (Entry<String, Customers> entry : customerMap.entrySet()) {
            if (receiverAccNo.equals(entry.getKey()))
                entry.getValue().setAmount(entry.getValue().getAmount() + amount);
            else if (customer.getAccNo().equals(entry.getKey()))
                entry.getValue().setAmount(entry.getValue().getAmount() - amount);

        }
        convertCustomerJson();
    }

    public Long checkBalanceForCustomer(String accNo) {
        long amount = 0;
        for (Entry<String, Customers> entry : customerMap.entrySet()) {
            if (entry.getKey().equals(accNo))
                amount = entry.getValue().getAmount();
        }
        return amount;
    }

    public List<List<Transaction>> getAllTransaction(Customers customer) {
        LoadMiniStatement();
        List<List<Transaction>> list = new ArrayList<>();

        for (Entry<String, List<Transaction>> entry : transactionList.entrySet()) {
            if (entry.getKey().equals(customer.getAccNo()))
                list.add(entry.getValue());
        }

        return list;
    }

    public void addMiniStatement(Transaction receiver, Transaction sender, String receiverAccNo, Customers customer,
            int amount) {
        LoadMiniStatement();

        List<Transaction> receiverTransactions = transactionList.getOrDefault(receiverAccNo, new ArrayList<>());
        List<Transaction> senderTransactions = transactionList.getOrDefault(customer.getAccNo(), new ArrayList<>());

        receiver.setTransactionId(receiverTransactions.size() + 1);
        receiverTransactions.add(receiver);
        transactionList.put(receiverAccNo, receiverTransactions);

        sender.setTransactionId(senderTransactions.size() + 1);
        senderTransactions.add(sender);
        transactionList.put(customer.getAccNo(), senderTransactions);
        ConvertMiniStatementJson();
    }

    public void ConvertMiniStatementJson() {
        String miniStatementString = gson.toJson(transactionList);
        try (FileWriter writer = new FileWriter("MiniStatement.json")) {
            writer.write(miniStatementString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoadMiniStatement() {
        File file = new File("MiniStatement.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("{}");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<String, List<Transaction>>>() {
            }.getType();
            Map<String, List<Transaction>> existingMinistatement = gson.fromJson(reader, type);
            if (existingMinistatement != null)
                transactionList.putAll(existingMinistatement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
