import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class KYCFormDate {
    Date signUpDate, currentDate;
    String stringStartDate, stringEndDate;
    Date startDate, endDate;

    public void rangeKey(String inputSignUpDate, String inputCurrentDate){
        try {
            //conversion from date to string
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            signUpDate = dateFormatter.parse(inputSignUpDate);
            currentDate = dateFormatter.parse(inputCurrentDate);
            //checking the validity of date
            if(signUpDate.after(currentDate)){
                System.out.println("No range");
            }
            else{
                startDate = signUpDate;
                //setting sign up year to start date
                startDate.setYear(currentDate.getYear());
                //creating calender object
                Calendar calendar = Calendar.getInstance();
                //setting startdate as Calender current date
                calendar.setTime(startDate);
                //substracting 30 days from the calender date
                calendar.add(Calendar.DATE, -30);
                startDate = calendar.getTime();
                //adding 60 days to the calender date
                calendar.add(Calendar.DATE,60);
                endDate = calendar.getTime();
                //verify the end date if end date passes the current date then set as cuurent date
                if(endDate.after(currentDate)){
                    endDate = currentDate;
                }
            }
            stringStartDate = dateFormatter.format(startDate);
            stringEndDate = dateFormatter.format(endDate);
            //Printing dates
            System.out.println(stringStartDate);
            System.out.println("    ");
            System.out.println(stringEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
};
class MainClass{
    public static void main(String[] args) {
        //object creation for KYCFormDate class
        KYCFormDate kycFormDate = new KYCFormDate();
        //testing with given testcases
        kycFormDate.rangeKey("16-07-1998","27-06-2017");
        kycFormDate.rangeKey("04-02-2016","04-04-2017");
        kycFormDate.rangeKey("04-05-2007","04-04-2017");
        kycFormDate.rangeKey("04-04-2015","04-04-2016");
        kycFormDate.rangeKey("04-04-2015","15-03-2016");

    }
}
