package usermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Authentication {
    
Authentication(){

}
public String logIn(String password,String email){

return token
}
private boolean VerifyEmail(String email){
    String read_line;
ProcessBuilder processBuilder = new ProcessBuilder("./BashScripts/csv_read.sh");
try{
    Process process = processBuilder.start();
    InputStreamReader inputStream = new InputStreamReader(process.getInputStream());
    BufferedReader bufferedReader = new BufferedReader(inputStream);
    read_line=bufferedReader.readLine();
    String [] arrayOfEmail = read_line.split(" ");
    ArrayList<String> emails =new ArrayList<String>(Arrays.asList(arrayOfEmail));
    for(int i=0;i<emails.size();i++)
       if( email.equals(emails.get(i)))
        return true;
}catch(Exception e){
return false;
}
return false;
}
//Verifying password
private boolean verifyPassword(String hashedPassword){

}
//Hashing password
private String hashPassword(String plainPassword){
try{
ProcessBuilder builder = new ProcessBuilder("./BashScripts/hashpassword.sh");
Process process = builder.start();


}catch(Exception e){

}
}
}
