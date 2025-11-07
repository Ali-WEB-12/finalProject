import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

public class Expenditure {
    Scanner sc = new Scanner(System.in);
    BMS help = new BMS();
    protected static double balance;
    ArrayList<Expenditure> expenditures = new ArrayList<>();

    public Expenditure(BMS b) {
        help = b;
        balance = help.getRemBalance();
    }

    public Expenditure() {

    }

    public String toString() {
        return "Total Remaining Balance after Expenditures: " + balance;
    }

    public void displayExpenditures() {
        System.out.println();
        for (Expenditure ex : expenditures) {
            System.out.println(ex);
        }
    }

}

class MandatoryExp extends Expenditure {
    private final double rent;
    private double messFee;
    private double gymFee;
    private double totalMandatoryExpen;

    public MandatoryExp(BMS b) { // should only be called once for a BMS object
        super(b);
        System.out.println("Enter Montly rent: ");
        rent = sc.nextDouble();
        messFee = 0.0;
        gymFee = 0.0;

    }

    public void getInfo() {

        System.out.println("Mess Fee: ");
        messFee = sc.nextDouble();
        if (gym()) {
            System.out.println("Enter Gym Fee: ");
            gymFee = sc.nextDouble();

        }

    }

    public boolean gym() {
        System.out.println("Do you have a gym membership?\n1.Yes\n0.No");
        int n = Integer.valueOf(sc.nextLine());
        switch (n) {
            case 1:
                return true;
            case 0:
                return false;
            default:
                System.out.println("Invalid Entry");
                return false;
        }
    }

    public double calculator() {
        totalMandatoryExpen = (rent + messFee + gymFee);
        if (totalMandatoryExpen < balance) {
            System.out.println("Insufficient Budget!\n" + help.displayBalance());
            return balance;
        }
        return balance -= totalMandatoryExpen;
    }

    public ArrayList<Expenditure> returnList() {
        expenditures.add(this);
        return expenditures;
    }

    public String toString() {
        return "Details:\nTotal Mandatory Expenditure Include:\nRent: " + rent + "\nMess Fee: "
                + messFee + "Gym Fee: " + gymFee + "\nTotal: " + totalMandatoryExpen + "Dated: " + LocalDateTime.now();
    }

}

class ExtraExpenditure extends Expenditure {
    // Scanner sc = new Scanner(System.in);
    private String name;
    private double exp;
    public static double bal;

    public ExtraExpenditure(String name, double cost, BMS b) {
        super(b);
        this.name = name;
        this.exp = cost;
        balance -= exp;
    }

    public ArrayList<Expenditure> addExpenditures() {
        System.out.println("1.Add\n0.Return");
        int n = Integer.valueOf(sc.nextLine());
        while (n != 0) {
            System.out.println("Enter Name: ");
            name = sc.nextLine();
            System.out.println("Enter expense: ");
            exp = sc.nextDouble();
            ExtraExpenditure x = new ExtraExpenditure(name, exp);
            if (balance - exp < 0) {
                System.out.println("Low Budgetted!");
                help.displayBalance();
                return expenditures;
            }
            expenditures.add(x);
            System.out.println("Remaining Balance: " + balance);
            System.out.println("1.Add\n0.Return");
            n = Integer.valueOf(sc.nextLine());

        }
        return expenditures;

    }

    public String toString() {
        return name + " cost: " + exp + " (Extra Expense)";
    }

    public void showExtraExpen() {
        for (Expenditure exp : expenditures) {
            if (exp instanceof ExtraExpenditure) {
                System.out.println(exp);
            }
        }
        System.out.println("Remaining Balance: " + balance + " Dated: " + LocalDateTime.now());
    }

}
