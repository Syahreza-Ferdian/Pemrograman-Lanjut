/**
 * test
 */
public class polymorphism {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Daniel", "135", 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karina", "234", 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Keanu", "145", 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bondan", "234", 5000, .04, 300);
        System.out.println("Employees diproses secara terpisah:\n");
        System.out.printf("%s\n%s: $%,.2f\n\n", salariedEmployee, "pendapatan: ", salariedEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", hourlyEmployee, "pendapatan: ", hourlyEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", commissionEmployee, "pendapatan: ", commissionEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());

        Employee[] employees = new Employee[4];
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;

        System.out.println("Employees diproses secara polimorfisme:\n");
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
                employee.setBaseSalary(1.10 *employee.getBaseSalary());
                System.out.printf("Gaji pokok setelah dinaikkan 10%% : $%,.2f\n", employee.getBaseSalary());
            }
            System.out.printf("pendapatan: $%,.2f\n\n", currentEmployee.earnings());
        }
        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Employee %d = %s\n", j, employees[j].getClass().getName());
        }
    }
}
abstract class Employee {
    private String name;
    private String noKTP;
    public Employee(String name, String noKTP){
        this.name = name;
        this.noKTP = noKTP;
    }
    public String getName(){
        return name;
    }
    public String getNoKTP(){
        return noKTP;
    }
    public String toString(){
        return String.format(" "+getName()+"\nNo. KTP :"+getNoKTP());
    }
    public abstract double earnings();//pendapatan
}
class SalariedEmployee extends Employee {
    private double weeklySalary; //gaji/minggu
    public SalariedEmployee(String name, String noKTP, double salary) {
        super(name, noKTP);
        setWeeklySalary(salary);
    }
    public void setWeeklySalary(double salary) {
        weeklySalary = salary;
    }
    public double getWeeklySalary() {
        return weeklySalary;
    }
    public double earnings() {
        return getWeeklySalary();
    }
    public String toString() {
        return String.format("Salaried employee: " + super.toString() + "\nweekly salary:" + getWeeklySalary());
    }
}
class HourlyEmployee extends Employee {
    private double wage; //upah per jam
    private double hours; //jumlah jam tiap minggu
    
    public HourlyEmployee(String name, String noKTP, double hourlyWage, double hoursWorked) {
        super(name, noKTP);
        setWage(hourlyWage);
        setHours(hoursWorked);
    }
    public void setWage(double hourlyWage){
        wage = hourlyWage;
    }
    public double getWage(){
        return wage;
    }
    public void setHours(double hoursWorked){
        hours = hoursWorked;
    }
    public double getHours(){
        return hours;
    }
    public double earnings(){
        if(getHours()<=40) return getWage() * getHours();
        else return 40 * getWage() + ( getHours()-40) * getWage() * 1.5;
    }
    public String toString(){
        return String.format("Hourly employee: "+super.toString()+"\nhourly wage"+getWage()+"\nhours worked: "+getHours());
    }
}
class CommissionEmployee extends Employee {
    private double grossSales;//penjualan per minggu
    private double commissionRate;//komisi

    public CommissionEmployee(String name, String noKTP, double sales, double rate){
        super(name, noKTP);
        setGrossSales(sales);
        setCommissionRate(rate);
    }
    public void setGrossSales(double sales){
        grossSales = sales;
    }
    public double getGrossSales(){
        return grossSales;
    }
    public void setCommissionRate(double rate){
        commissionRate = rate;
    }
    public double getCommissionRate(){
        return commissionRate;
    }
    public double earnings(){
        return getCommissionRate()*getGrossSales();
    }
    public String toString(){
        return String.format("Commision employee: "+super.toString()+"\ngross sales: "+getGrossSales()+"\ncommission rate"+getCommissionRate());
    }
}
class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;//gaji pokok tiap minggu
    public BasePlusCommissionEmployee(String name, String noKTP, double sales, double rate, double salary) {
        super(name, noKTP, sales, rate);
        setBaseSalary(salary);
    }
    public void setBaseSalary(double salary) {
        baseSalary = salary;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }
    public String toString() {
        return String.format("Base-Salaried " + super.toString() + "\nbase salary " + getBaseSalary());
    }
}