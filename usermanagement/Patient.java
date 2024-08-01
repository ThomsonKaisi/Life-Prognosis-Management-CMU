package usermanagement;

import java.time.LocalDate;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Patient extends User {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean hivPositive;
    private LocalDate diagnosisDate;
    private boolean onART;
    private LocalDate artStartDate;
    private String country;

    public Patient() {
        // Default constructor
    }

    @Override
    public void login(String username, String password) {
        // Implementation of the abstract login method from User class
        System.out.println("Logging in with username: " + username + " and password: " + password);
        // In a real-world scenario, you'd have logic here to verify the credentials
    }



    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isHivPositive() {
        return hivPositive;
    }

    public void setHivPositive(boolean hivPositive) {
        this.hivPositive = hivPositive;
    }

    public LocalDate getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(LocalDate diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public boolean isOnART() {
        return onART;
    }

    public void setOnART(boolean onART) {
        this.onART = onART;
    }

    public LocalDate getArtStartDate() {
        return artStartDate;
    }

    public void setArtStartDate(LocalDate artStartDate) {
        this.artStartDate = artStartDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void completeRegistration(String firstName, String lastName, LocalDate birthDate, Boolean isHiv, Boolean isOnART, LocalDate diagnosisDate, LocalDate artStartDate, String country) {
        ProcessBuilder builder = new ProcessBuilder("bash","./BashScripts/add_user_data.sh");

        // Ensure all fields are set before proceeding
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDateOfBirth(birthDate);
        this.setHivPositive(isHiv);
        this.setOnART(isOnART);
        this.setDiagnosisDate(diagnosisDate);
        this.setArtStartDate(artStartDate);
        this.setCountry(country);

        try {
            Process process = builder.start();
            OutputStream os = process.getOutputStream();
            PrintWriter writer = new PrintWriter(os);

            writer.println(this.getEmail());
            writer.println(this.getFirstName());
            writer.println(this.getLastName());
            writer.println(this.getDateOfBirth());
            writer.println(this.isHivPositive());
            writer.println(this.getDiagnosisDate());
            writer.println(this.isOnART());
            writer.println(this.getArtStartDate());
            writer.println(this.getCountry());

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.toString());
        }
    }
}
