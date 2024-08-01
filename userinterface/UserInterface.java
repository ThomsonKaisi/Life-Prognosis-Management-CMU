package userinterface;
import java.util.Scanner;      // For reading user input
import java.time.LocalDate; 
import usermanagement.Patient;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    String firstName = getFirstName(scanner);// FirstName
    String lastName = getLastName(scanner);  // Last Name
    int yearOfBirth = getYearOfBirth(scanner);
    int monthOfBirth = getMonthOfBirth(scanner);
    int dateOfBirth = getDateOfBirth(scanner);
    LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dateOfBirth);//Date of Birth
    String hivStatus = getHIVStatus(scanner);//HIV Status
    

    if (hivStatus.equals("yes") || hivStatus.equals("y")) {

        int yearOfDiagnosis = getYearOfDiagnosis(scanner);
        int monthOfDiagnosis = getMonthOfDiagnosis(scanner);
        int dateOfDiagnosis = getDateOfDiagnosis(scanner);
        boolean hivBool = True;
        String artStatus = getARTStatus(scanner);//ART Status
        LocalDate diagnosisDate = LocalDate.of(yearOfDiagnosis, monthOfDiagnosis, dateOfDiagnosis);//Date of Diagnosis

        if (artStatus.equals("yes") || artStatus.equals("y")) {
            int yearOfTherapy = getYearOfTherapy(scanner);
            int monthOfTherapy = getMonthOfTherapy(scanner);
            int dateOfTherapy = getDateOfTherapy(scanner);
            boolean artBool = True;
            LocalDate therapyDate = LocalDate.of(yearOfTherapy, monthOfTherapy, dateOfTherapy);//Date of Therapy
        } else if (artStatus.equals("no") || artStatus.equals("n")) {
            boolean artBool = False;
        } else {
            System.out.println("Invalid input: Please enter yes or no.");
        }
    } else if (hivStatus.equals("no") || hivStatus.equals("n")) {
        boolean hivBool = False;
    } else {
        System.out.println("Invalid input: Please enter yes or no.");
    }

    private static String getFirstName(Scanner scanner) {
    System.out.print("Please enter your first name: ");
    return scanner.nextLine();
    }

    private static String getLastName(Scanner scanner) {
        System.out.print("Please enter your last name: ");
        return scanner.nextLine();
    }

    private static int getYearOfBirth(Scanner scanner) {
        System.out.print("Please enter your year of birth (YYYY): ");
        return scanner.nextInt();
    }

    private static int getMonthOfBirth(Scanner scanner) {
        System.out.print("Please enter your month of birth (MM): ");
        return scanner.nextInt();
    }

    private static int getDateOfBirth(Scanner scanner) {
        System.out.print("Please enter your date of birth (DD): ");
        return scanner.nextInt();
    }

    private static String getHIVStatus(Scanner scanner) {
        System.out.print("Are you HIV positive? (yes or no): ");
        return scanner.next().trim().toLowerCase();
    }

    private static int getYearOfDiagnosis(Scanner scanner) {
        System.out.print("Please enter the year you were diagnosed with HIV (YYYY): ");
        return scanner.nextInt();
    }

    private static int getMonthOfDiagnosis(Scanner scanner) {
        System.out.print("Please enter the month you were diagnosed with HIV (MM): ");
        return scanner.nextInt();
    }

    private static int getDateOfDiagnosis(Scanner scanner) {
        System.out.print("Please enter the date you were diagnosed with HIV (DD): ");
        return scanner.nextInt();
    }

    private static String getARTStatus(Scanner scanner) {
        System.out.print("Are you on ART (Antiretroviral therapy) drugs? (yes or no): ");
        return scanner.next().trim().toLowerCase();
    }

    private static int getYearOfTherapy(Scanner scanner) {
        System.out.print("Please enter the year you started your ART (YYYY): ");
        return scanner.nextInt();
    }

    private static int getMonthOfTherapy(Scanner scanner) {
        System.out.print("Please enter the month you started your ART (MM): ");
        return scanner.nextInt();
    }

    private static int getDateOfTherapy(Scanner scanner) {
        System.out.print("Please enter the day you started your ART (DD): ");
        return scanner.nextInt();
    }

    private static String getCountryOfResidence(Scanner scanner) {
        System.out.print("What is your country of residence? ");
        return scanner.nextLine();
    }
    String countryOfResidence = getCountryOfResidence(scanner);//Country of residence
    scanner.close();

    Patient patient = new Patient();
    patient.completeRegistration(firstName, lastName, birthDate, hivBool, artBool, diagnosisDate, therapyDate, countryOfResidence);
    
}

