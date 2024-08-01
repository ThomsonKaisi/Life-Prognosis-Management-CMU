package usermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.time.LocalDate;

public class Authentication {
    LocalDate date;
    
Authentication(){

}
public Boolean logIn(String password,String email){
if(verifyEmail(email) && verifyPassword(password, email)){
    this.date = LocalDate.now(); 
 return true;
}
return false;

}
public boolean verifyEmail(String email){
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

//Verifying password
private boolean verifyPassword(String password,String email){

    //Creating a process to communicate with email/password file
    String read_line;
    String hash_password =computePasswordHash(password);

    ProcessBuilder builder = new ProcessBuilder("./BashScripts/read_credentials.sh");
    try{
    Process process = builder.start();
    OutputStream os = process.getOutputStream();
    os.write(email.getBytes());
    os.flush();
    //getting the password_hash from the input stream
    InputStreamReader inputStream = new InputStreamReader(process.getInputStream());
    BufferedReader bufferedReader = new BufferedReader(inputStream);
    read_line=bufferedReader.readLine();
    if(read_line.equals("null")){
        return false;
    }else{
        if(hash_password.equals(read_line)){
            return true;
        }
    }

    }catch(Exception e){

    }
    return false;

}
//Hashing password
private String computePasswordHash(String plainPassword){
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
public boolean verifyUUID(String uuid){
    String read_line;
    try{
        ProcessBuilder builder = new ProcessBuilder("./BashScripts/verifyUUID.sh");
        Process process = builder.start();
        OutputStream os = process.getOutputStream();
        os.write(uuid.getBytes());
        os.flush();
        
    InputStreamReader inputStream = new InputStreamReader(process.getInputStream());
    BufferedReader bufferedReader = new BufferedReader(inputStream);
    read_line=bufferedReader.readLine();
    if(read_line.equals(uuid)){
        return true;
    }

    }catch(Exception e){

    }
    return false;
}
}
