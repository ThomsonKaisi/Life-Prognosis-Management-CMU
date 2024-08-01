package usermanagement;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
public class Admin {
    

    public void registerUser(String email){

        ProcessBuilder builder = new ProcessBuilder("./BashScripts/userReg.sh");
        try{
            Process process = builder.start();
            OutputStream os = process.getOutputStream();
            os.write(email.getBytes());
            os.flush();
            os.close();
        }catch(Exception e){

        }
      


    }
}
