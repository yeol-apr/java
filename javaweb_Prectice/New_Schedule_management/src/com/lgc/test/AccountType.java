package com.lgc.test;

public enum AccountType {
    SAVING,
    FIXED,
    CURRENT;

    private AccountType() {
        System.out.println("It is an account type");
    }
}

 class EnumOne {
    public static void main(String[] args) {
        System.out.println(AccountType.FIXED);
    }
}



