package Dolphin;

import java.util.ArrayList;

public class Subscription {
    private Member member;
    private double payment;
    private double price;
    private double debt;
    private ArrayList<Member> debtList = new ArrayList<>();

    Subscription(Member member){
        this.member = member;
    }

    public void addToDebtList(Member member){
        debtList.add(member);
        System.out.println(member.getName());
    }

    public void removeFromDebtList(Member member){
        debtList.remove(member);
        System.out.println(member.getName() + "has now paid their debt.");
    }

    public void saveDebtList(){

    }
}
