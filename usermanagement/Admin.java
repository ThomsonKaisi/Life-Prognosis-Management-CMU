package usermanagement;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
public class Admin extends User{
    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    @Override
    public void login(String email, String password) {

    }

    public void createAccount(String patientEmail){}

    public void downloadUserData(){}

    public void downloadAnalyticsData(){}

    public void registerUser(String email){

        ProcessBuilder builder = new ProcessBuilder("./BashScripts/userReg.sh");
        try{
            Process process = builder.start();
            OutputStream os = process.getOutputStream();
            os.write(email.getBytes());
            os.flush();
            os.close();
        }catch(Exception e){
            System.out.println("An Error: "+e.toString());
        }
      


    }
}
