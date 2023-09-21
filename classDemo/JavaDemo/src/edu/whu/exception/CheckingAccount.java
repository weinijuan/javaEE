package edu.whu.exception;

public class CheckingAccount {

    //余额
    private double balance;

    //卡号
    private int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    /**
     * 取钱
     *
     * @param amount 数量
     * @throws InsufficientFundsException 金额不足异常
     */
    public void withdraw(double amount) throws
            InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }


    /**
     * 存钱
     *
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
    }


    /**
     * 返回余额
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 返回卡号
     *
     * @return
     */
    public int getNumber() {
        return number;
    }
}
