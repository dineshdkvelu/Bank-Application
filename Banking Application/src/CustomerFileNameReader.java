import java.io.*;
import java.util.Scanner;

public class CustomerFileNameReader {
    private static final String filename = "Bank.txt";

    public void initialize() throws IOException {
//        Customer customers[] = new Customer[10];
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
       // String custInfo = reader.readLine();
        while(reader.ready()){
            String custInfo =reader.readLine();
            Bank.customers.add(castStringtoCustomer(custInfo));
        }

    }
    private Customer castStringtoCustomer(String custInfo) throws IOException {
        String[] customer = custInfo.split(" ");
        CustomerFileNameReader.createCustomerFile(customer[2]);
        return new Customer(
          Integer.parseInt(customer[0]),
          Integer.parseInt(customer[1]),
          customer[2],
          Double.parseDouble(customer[3]),
          customer[4],
          Customer.encyptCustomerPassword(customer[4])
        );
    }

    public void writeNewCustomerinFile() throws IOException {
        File write = new File(filename);
        BufferedWriter writer = new BufferedWriter(new FileWriter(write,true));
        int size = Bank.customers.size()-1;
        String newCustomer = Bank.customers.get(size).customerId+" "+Bank.customers.get(size).accountNumber+" "+Bank.customers.get(size).name
                +" "+Bank.customers.get(size).accountBalance+" "+Bank.customers.get(size).password;
        writer.write(newCustomer);
        writer.close();
    }

    public static void createCustomerFile() throws IOException {
        int size = Bank.customers.size()-1;
        String name = Bank.customers.get(size).name;
        File customerFile = new File("C:\\Users\\dinesh.bh.kumar\\IdeaProjects\\Banking Application\\"+name+".txt");
        customerFile.createNewFile();
    }
    public static void createCustomerFile(String name) throws IOException {
        File customerFile = new File("C:\\Users\\dinesh.bh.kumar\\IdeaProjects\\Banking Application\\"+name+".txt");
        customerFile.createNewFile();
    }

}
