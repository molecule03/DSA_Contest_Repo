package Companies.IBM;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class B {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


//        System.out.println();
        calculateVaccDriveList("123", "08/09/2001", "yes");
        calculateVaccDriveList("123", "13/05/1952", "no");
        calculateVaccDriveList("123", "03/12/1972", "no");
    }

    public static  void  calculateVaccDriveList(String adharNumber, String DOB, String comorbidity){




        if(!validAadhar(adharNumber)){
            System.out.println("Invalid adhar number");
            return;
        }

        int age = calculateAge(DOB);
//        System.out.println(calculateAge(DOB));
        boolean com = comorbidity.toLowerCase().equals("yes");

        if(age > 60 || com){
            System.out.println("1");
        }
        else if(age > 45){
            System.out.println("2");
        }
        else if(age > 30){
            System.out.println("3");
        }
    }

    public static int calculateAge(String dob) {
        LocalDate birthDate = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public static boolean validAadhar(String a){
        String fa = a.replaceAll("\\s", "");
        return fa.matches("\\d{12}");
    }

    public  static boolean validDob(String dob){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(dob, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }

    }



//    public static boolean validCom(String com){
//
//    }


}
