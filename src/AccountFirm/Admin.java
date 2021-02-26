package AccountFirm;

/**
 * Created by John Creaner on 01/02/2021
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Admin extends Users
{
   static String userPassword = "password";

   public Admin(String userLogin)
   {
      super(userLogin, userPassword);
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
