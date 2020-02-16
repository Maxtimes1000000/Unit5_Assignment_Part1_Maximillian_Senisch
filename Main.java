class Main {
  public static void main(String[] args) 
  {
    double weeklyPay = 0.00;

    weeklyPay = weeklyPay(47.00, 505.75, "Maximillian", 2);
    System.out.print(dollarFormat(weeklyPay));
    weeklyPay = weeklyPay(45.00, 55.25, "Melivin", 2);
    System.out.print(dollarFormat(weeklyPay));
    weeklyPay = weeklyPay(15.00, 65.25, "Susan", 1);
    System.out.print(dollarFormat(weeklyPay));
    weeklyPay = weeklyPay(41.00, 14.75, "Mika", 2);
    System.out.print(dollarFormat(weeklyPay));
    weeklyPay = weeklyPay(25.00, 15.00, "Eldridge", 1);
    System.out.print(dollarFormat(weeklyPay));
    weeklyPay = weeklyPay(55.00, 203.50, "Freedom", 2);
    System.out.print(dollarFormat(weeklyPay));
    weeklyPay = weeklyPay(32.50, 100.25, "Tyson", 2);
    System.out.print(dollarFormat(weeklyPay));
  }
  public static String dollarFormat(double weeklyPay)
  {
    String s = String.format("%.2f", weeklyPay);
    return s;
  }
  public static double weeklyPay(double hours, double rate, String name, int status)
  {
    //initialize variables
    double FIT = 0.00, SStax = 0.00, Medicaretax = 0.00, Dental = 17.00, Retirement = 77.00, OvertimeHours = 0.0, OvertimePay = 0.00, weeklyPay = 0.00, GrossPay = 0.00, TaxableIncome = 0.00;
    String color = "\u001b[32;4m"; //green and underlined
    String color2 = "\u001b[34;1m"; //blue
    String reset = "\u001b[0m"; //reset colors

    name = name.toUpperCase();
    System.out.print("\n\n" + color + name + reset);

    //process
    OvertimeHours = (hours >= 40.00) ? (hours - 40.00) : 0.00;
    OvertimePay = OvertimeHours * (rate * 2);   

    if(status == 2)
    {
      GrossPay = hours >= 40.00 ? (((40.00) * rate) + OvertimePay) : (hours * rate);

      TaxableIncome = ((GrossPay - Dental) - Retirement);
      System.out.print("\nStatus: Full time\nGross Pay: $" + dollarFormat(GrossPay) + "\nDental deductions: $" + dollarFormat(Dental) + "\nRetirement deductions: $" + dollarFormat(Retirement) + "\nTaxable Wages: $" + dollarFormat(TaxableIncome));
    }
    else
    {
      GrossPay = (hours * rate);

      TaxableIncome = GrossPay;
      System.out.print("\nStatus: Part time\nGross Pay: $" + dollarFormat(GrossPay) + "\nTaxable Wages: $" + dollarFormat(TaxableIncome));
    }

    FIT = rate < 15 ? TaxableIncome * 0.12 : TaxableIncome * 0.15;

    SStax = GrossPay * 0.062;
    Medicaretax = GrossPay * 0.0145;

    weeklyPay = (((TaxableIncome - FIT) - SStax) - Medicaretax);

    System.out.print("\nFederal Income Tax: $" + dollarFormat(FIT) + "\nSocial Security tax: $" + dollarFormat(SStax) + "\nMedicare tax: $" + dollarFormat(Medicaretax) + "\nNet Pay: " + color2 + "$");

    return weeklyPay;
  }
}