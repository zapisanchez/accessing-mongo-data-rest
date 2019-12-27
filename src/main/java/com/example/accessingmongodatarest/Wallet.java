package com.example.accessingmongodatarest;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Random;

@Document("Wallet")
public class Wallet {

    @Id private String walletId;
    private float balance ;


    @Override
    public int hashCode() {

        Random rand = new Random();
        return Objects.hash(walletId, rand.nextInt());
    }

    public String getWalletId() {
        return walletId;
    }

    public float getBalance() {
        return balance;
    }

    public void setWalletId(String id) {
        this.walletId = id;
    }

    public void setBalance(float bal){
        this.balance = bal;
    }


    @Override
    public String toString(){
        return "Wallet{" +
                "id=" + walletId +
                ", balance='" + balance + '\'' +
                '}';
    }
}