package org.npc.test;

/**
 * Created by Caleb on 11/15/15.
 */
public class TransactionObject {
    private int trans_total;
    private int pay_total;
    private int balance;

     public TransactionObject(){
        this.pay_total=0;
        this.pay_total=0;
        this.balance=0;
    }
    public int getTrans_total() {
        return trans_total;
    }

    public int getPay_total() {
        return pay_total;
    }

    public int getBalance() {
        return balance;
    }

    public void setTrans_total(int total) {
        this.trans_total = total;
    }

    public void setPay_total(int total) {
        this.pay_total = total;
    }

    public void setBalance(int total) {
        this.balance = total;
    }

}