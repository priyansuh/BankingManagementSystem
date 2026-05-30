package model;
import java.time.LocalDateTime;

public class Transaction implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String type;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String type,double amount){
        this.type=type;
        this.amount=amount;
        this.dateTime=LocalDateTime.now();
    }

    public void displayTransaction(){
        System.out.println(type+" | Amount: "+amount+" | Time: "+dateTime);
    }

}
