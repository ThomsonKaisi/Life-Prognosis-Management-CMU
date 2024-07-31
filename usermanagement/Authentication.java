package usermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;

public class Authentication {
    
Authentication(){

}
public String logIn(String password,String email){

return token
}
private boolean verifyEmail(String email){
    String read_line;
ProcessBuilder processBuilder = new ProcessBuilder("./BashScripts/read_emails.sh");
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
public String getUID(String email){

}
//Verifying password
private boolean verifyPassword(String password,String uid){

}
//Hashing password
private String hashPassword(String plainPassword){
String read_line;
ProcessBuilder builder = new ProcessBuilder("./BashScripts/encrypt.sh");
try{
    Process process = builder.start();
    OutputStream os = process.getOutputStream();
    os.write(plainPassword.getBytes());
    os.flush();

    InputStreamReader inputStream = new InputStreamReader(process.getInputStream());
    BufferedReader bufferedReader = new BufferedReader(inputStream);
    read_line=bufferedReader.readLine();
    return read_line;
}catch(Exception e){
return null;
}


}
}
