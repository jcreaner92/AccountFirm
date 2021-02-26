package AccountFirm;

/**
 * Created by John Creaner on 02/02/2021
 * COMMENTS ABOUT PROGRAM HERE
 */
public abstract class Users
{
   String userLogin;
   String userPassword;

   public Users(String userLogin, String userPassword)
   {
      this.userLogin = userLogin;
      this.userPassword = userPassword;
   }

   public abstract String getUserLogin();

   public abstract void setUserLogin(String userLogin);

   public abstract String getUserPassword();

   public abstract void setUserPassword(String userPassword);
}//class
