package com.example.accessingmongodatarest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document("User")
public class User {

    @Id
    private String id;
    private String name;
    private String lastName;
    private List wallets;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public List getWallets() {
        return wallets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName (String lastName){
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWallets(List wallets) {
        this.wallets = wallets;
    }

    //    private ArrayList <Wallet> walletList = new ArrayList <Wallet>();
//    public User (long id, String name, String lastName){
//        this.id = id;
//        this.name = name;
//        this.lastName = lastName;
//        //In a bank, all the people have at least
//        // 1 account
//        //walletList.add(new Wallet(this.name, this.lastName, 1));
//        // with 0 $, but an account

//    }
    //create new wallet and add to user
//    public void addWallet(int numberOfWallet){
//        for (int i = 0; i< numberOfWallet; i++){
//            //create a wallet
//            walletList.add (new Wallet(this.name, this.lastName, i + 2));
//        }

//    }
//    public ArrayList<Wallet> getWalletList() {
//        return walletList;

//    }

//    private String getWalletListAsString(){
//        String result = "";
//
//        if (walletList.isEmpty())
//        {
//            result = "[]";
//        }else if (walletList.size() <= 1)
//        {
//            result = "[" + walletList.get(0) + "]";
//        }
//        else { //for multiple elements
//            for (int i = 0; i < walletList.size(); i++) {
//
//
//                String temp = walletList.get(i).toString();
//                if (i == 0) {
//                    //first position
//                    result = "[" + temp + ", ";
//
//                } else {
//                    //last position
//                    if (i == walletList.size()) {
//
//                        result = temp + "]";
//
//                    } else // intermediate pos
//                    {
//                        result = result + temp + ", ";
//                    }
//
//                }
//            }
//
//            for (Wallet wallet : walletList) {
//
//                result = "[" + walletList.toString() + "]";
//            }
//        }
//
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name);
//                Objects.equals(walletList, user.walletList);
    }

    @Override
    public String toString(){

//        String wallStr = getWalletListAsString();

        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}