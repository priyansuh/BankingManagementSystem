package util;
import model.Account;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static final String FILE_NAME="accounts.dat";
    public static void saveAccounts(ArrayList<Account> accounts){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(accounts);
            System.out.println("Accounts saved successfully.");
        }catch (IOException e){
            System.out.println("Error while saving accounts: "+e.getMessage());
        }
    }
    public static ArrayList<Account> loadAccounts(){
        File file=new File(FILE_NAME);
        if(!file.exists()){
            return new ArrayList<>();
        }try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(FILE_NAME))){
            return (ArrayList<Account>) ois.readObject();
        }catch(IOException|ClassNotFoundException e){
            System.out.println("Error while loading accounts:"+e.getMessage());
            return new ArrayList<>();
        }
    }
}
