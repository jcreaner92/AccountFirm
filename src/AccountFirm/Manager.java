package AccountFirm;

import java.text.DecimalFormat;

/**
 * Created by John Creaner on 01/02/2021
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Manager extends Users
{

   double yearsWorked;
   double salary = 45000;
   double weeklySalary;
   DecimalFormat df = new DecimalFormat("#.##");


   public Manager(String userLogin,String userPassword, double yearsWorked)
   {
      super(userLogin, userPassword);
      this.yearsWorked = yearsWorked;
      this.salary = (45000 * 0.02) * yearsWorked + salary;
      this.weeklySalary = salary / 52;
      weeklySalary = Double.parseDouble(df.format(weeklySalary));
   }

   public double getYearsWorked()
   {
      return yearsWorked;
   }

   public void setYearsWorked(double yearsWorked)
   {
      this.yearsWorked = yearsWorked;
   }

   public double getWeeklySalary()
   {
      return weeklySalary;
   }

   @Override
   public String getUserLogin()
   {
      return userLogin;
   }

   @Override
   public void setUserLogin(String userLogin)
   {
   this.userLogin = userLogin;
   }

   @Override
   public String getUserPassword()
   {
      return userPassword;
   }

   @Override
   public void setUserPassword(String userPassword)
   {
   this.userPassword = userPassword;
   }


}//class
