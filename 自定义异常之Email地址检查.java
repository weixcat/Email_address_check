import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by weix on 2017/6/15.
 */
public class Tester {
    public static void check(String email)throws InputFormatError{
        String pattern = "/^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b$/";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        if (m.find()){
            System.out.println("ok, to the next step");
        }
        else {
            throw new InputFormatError("this is not an email address!");
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        do {
            System.out.println("input an email address:");
            String emailAddress = in.next();
            try {
                check(emailAddress);
                done = true;
            } catch (InputFormatError inputFormatError) {
                System.out.println(inputFormatError.getReason());
            }
        }while (!done);

    }
}
class InputFormatError extends Exception{
    private String reason;
    InputFormatError(String reason){
        this.reason = reason;
    }
    public String getReason(){
        return reason;
    }
}