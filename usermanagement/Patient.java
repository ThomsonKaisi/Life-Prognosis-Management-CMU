package usermanagement;

import java.util.Date;
import java.io.OutputStream;
import java.io.PrintWriter;


public class Patient extends User {
    private Date dateOfBirth;
    private boolean hivPositive;
    private Date diagnosisDate;
    private boolean onART;
    private Date artStartDate;
    private String country;

    public Patient(){
       
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isHivPositive() {
        return hivPositive;
    }

    public void setHivPositive(boolean hivPositive) {
        this.hivPositive = hivPositive;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public boolean isOnART() {
        return onART;
    }

    public void setOnART(boolean onART) {
        this.onART = onART;
    }

    public Date getArtStartDate() {
        return artStartDate;
    }

    public void setArtStartDate(Date artStartDate) {
        this.artStartDate = artStartDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void login(String email, String password) {

    }

    public void completeRegistration(String first,String lastname, LocalDate birthDate, Boolean isHiv,Boolean isOnART,Date diagnosisDate,Date artStartDate,String country) {

        ProcessBuilder builder = new ProcessBuilder("./BashScripts/add_user_data.sh");
        try{
            Process process = builder.start();
            OutputStream os = process.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
            writer.println(this.email);
            writer.println(first);
            writer.println(lastname);
            writer.println(isHiv);
            writer.println(isOnART);
            writer.println(diagnosisDate);
            writer.println(artStartDate);
            writer.println(country);
            writer.flush();
            writer.close();
        }catch(Exception e){
            System.out.println("An Error: "+e.toString());
        }
      
    }
}
