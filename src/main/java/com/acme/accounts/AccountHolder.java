package com.acme.accounts;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * Account data holder class that holds the account number and password.
 * These credentials are used to retrieve the wallet credentials.
 * For simplicity the wallet file name matches with account no. e,g. for acccount x,
 * it is assumed the file has been stored as x.json.
 */
@Component
public class AccountHolder {

    private static HashMap<String, Account> accounts;

    @PostConstruct
    public void init(){

        Account account1 = new Account("9f4af73607020ee72cxxxxxxxxxxxxxxxxxxxxxx","password");
        Account account2 = new Account("a0842d0079a3f7383xxxxxxxxxxxxxxxxxxxxxxx","password123");
        Account account3 = new Account("2d70db2e21c52f918xxxxxxxxxxxxxxxxxxxxxxx","password1234");

        accounts = new HashMap<>();
        accounts.put(account1.getAccount(), account1);
        accounts.put(account2.getAccount(), account2);
        accounts.put(account3.getAccount(), account3);




    }

    class Account{
        String account;
        String password;

        public Account(String account, String password) {
            this.account = account;
            this.password = password;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Account account1 = (Account) o;

            if (account != null ? !account.equals(account1.account) : account1.account != null) return false;
            return password != null ? password.equals(account1.password) : account1.password == null;
        }

        @Override
        public int hashCode() {
            int result = account != null ? account.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
