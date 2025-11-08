import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class BMS {
    Scanner sc = new Scanner(System.in);
    protected double totalBalance;
    protected double remBalance;
    Expenditure ex;
    LocalDateTime date;
    LocalDateTime date2;

    public BMS() {
        totalBalance = 0.0;
        remBalance = totalBalance;

    }

    public BMS(double amount) {
        totalBalance = amount;
        remBalance = totalBalance;
    }

    public void getInfo() {
        System.out.println("Enter your montly Budget: ");
        totalBalance = remBalance = sc.nextDouble();
        date = LocalDateTime.now();
        System.out.println(totalBalance + " RS is Successfully added into your Budget Basket! Dated: " + date + ".");
        
        // aik date boht nahi thi...?
        date2 = LocalDateTime.now();
        System.out.println("Action Menu: ");
        while (true) {
            System.out.println("0.Exit\n1.Display Balance\n2.Display Expenditures:");
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 0)
                return;
            else if (n == 1)
                System.out.println(displayBalance());
            else if (n == 2)
                ex.displayExpenditures();

        }

    }

    public double getRemBalance() {
        return remBalance;
    }

    public BMS(BMS b) {
        if (b == null) {
            System.exit(0);
        }
        // baki sab kuch bhi copy karna hota...
        this.remBalance = b.remBalance;

    }

    public String displayBalance() {
        return "Total Balance deposited: " + totalBalance + " Dated: " + date2 +
                "\nRemaining balance at " + LocalDateTime.now() + " : " + remBalance;

    }

    public String toString() {
        return "Details Dated " + LocalDateTime.now() + ":\n" + "Total Balance deposited: " + totalBalance + " Dated: "
                + date2 + "\nRemaining balance at " + LocalDateTime.now() + " : " + remBalance;
    }

}