import java.util.InputMismatchException;
import java.util.Scanner;

public class Date {
    private int day ;
    private int month ;
    private int year ;
    private String fullDate;
    Scanner scanner = new Scanner(System.in);
    public Date(int day, int month,int year) {
        this.setDay(day);
        this.setMonth(month);
        this.year = year;
        this.setFullDate();
    }

    public void setDay(int day) {
        try {
            if (day<=31&&day>0)
                this.day = day;
         //  else{
           //     System.out.println("Invalid day!");
           //     int userDay=scanner.nextInt();
           ///     setDay(userDay);
           // }
        }catch (InputMismatchException e){
            System.out.println("Write a number !");
            int userDay=scanner.nextInt();
            setDay(userDay);
        }

    }

    public void setMonth(int month) {

        try {
            if (month>0&&month<=12)
                this.month = month;
            ///else{
           ///     System.out.println("Invalid month!");
           ///     int userMonth=scanner.nextInt();
           ///     setMonth(userMonth);
           /// }
        }catch (InputMismatchException e){
            System.out.println("Write a number !");
            int userMonth=scanner.nextInt();
            setMonth(userMonth);
        }

    }


    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setFullDate() {
        this.fullDate = day+"."+month+"."+year;

    }

    public String getFullDate (){
       return this.fullDate;
    }

    public void print (){
        System.out.println(fullDate);
    }

    public void setYear(int year) {
        this.year = year; }


}
