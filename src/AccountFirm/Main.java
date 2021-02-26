package AccountFirm;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by John Creaner on 01/02/2021
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Main
{
   static Scanner keyboard = new Scanner(System.in);
   static ArrayList<Manager> managerArrayList = new ArrayList<>();
   static ArrayList<Admin> adminArrayList = new ArrayList<>();
   static ArrayList<Employee> employeeArrayList = new ArrayList<>();
   static boolean quit = false;

   public static void main(String[] args)

   {

      welcomeMessage();
      do
      {
         adminArrayEmpty();
      } while (adminArrayList.isEmpty());
      try
      {
         menu();

      } catch (
            InputMismatchException e) //This will catch if the user enters an integer value for choice.

      {
         System.out.println(
               "Input invalid, please only enter a number between 1 and 4. Restart the system to try again");
      }


   }//main

   public static void welcomeMessage()
   {
      System.out.println();
      System.out.println("Welcome to the Hr Application");
      System.out.println();
   }

   public static void adminArrayEmpty()
   {
      if (adminArrayList.isEmpty())
      {
         System.out.println("Enter admin password");
         String password = keyboard.nextLine();
         if (password.equalsIgnoreCase(Admin.userPassword))
         {
            System.out.println("Password correct");
            System.out.println();
            System.out.println("Please create a new admin for the system. Please enter admins username");
            String username = keyboard.nextLine();
            Admin admin = new Admin(username);
            adminArrayList.add(admin);
         } else
            System.out.println("Incorrect Password");
      }
   }

   public static void menu()
   {
      do
      {
         System.out.println("Main Menu");
         System.out.println();
         System.out.println("Please choose from one of the following options:");
         System.out.println();
         System.out.println("1. Manager Login");
         System.out.println("2. Employee Login");
         System.out.println("3. Admin Login");
         System.out.println("4. Quit");
         int choice = keyboard.nextInt();
         switch (choice)
         {
            case 1 -> manager();
            case 2 -> employee();
            case 3 -> adminLogin();
            case 4 -> end();
            default -> System.out.println("Invalid choice, please choose again");
         }
      } while (!quit);

   }

   public static void adminLogin()
   {
      System.out.println("Please Enter your Admin Login");
      keyboard.nextLine();
      String adminUser = keyboard.nextLine();
      boolean match = false;
      int adminChoice;
      for (Admin a : adminArrayList)
      {
         if (a.getUserLogin().equals(adminUser))
         {
            match = true;
            break;
         }
      }
      if (match)
      {
         System.out.println("Username found");
         System.out.println();
         System.out.println("Please enter your password");
         String adminPass = keyboard.nextLine();
         if (adminPass.equalsIgnoreCase(Admin.userPassword))
         {
            do
            {
               System.out.println("Please choose from the following options:");
               System.out.println("1. Add a Manager");
               System.out.println("2. Remove a Manager");
               System.out.println("3. Add an Employee");
               System.out.println("4. Remove an Employee");
               System.out.println("5. Quit");
               System.out.println("6. Return the main menu");
               adminChoice = keyboard.nextInt();
               switch (adminChoice)
               {
                  case 1 -> {
                     System.out.println("Please create a manager login");
                     keyboard.nextLine();
                     String newManager = keyboard.nextLine();
                     System.out.println("Please enter a password");
                     String newManagerPass = keyboard.nextLine();
                     System.out.println("Please enter years worked at the company");
                     int yearsAtCompany = keyboard.nextInt();
                     if(yearsAtCompany <0){
                        System.out.println("Invalid choice, please choose again");
                     }
                     Manager manager = new Manager(newManager, newManagerPass, yearsAtCompany);
                     managerArrayList.add(manager);
                  }
                  case 2 -> {
                     System.out.println("Which manager would you like to remove?");
                     keyboard.nextLine();
                     String managerRemove = keyboard.nextLine();
                     for (Manager m : managerArrayList)
                     {
                        if (m.getUserLogin().equals(managerRemove))
                        {
                           managerArrayList.remove(m);
                           System.out.println("You have successfully removed " + m.getUserLogin() + " from management pay role!");
                           System.out.println();
                        }
                     }
                     System.out.println();
                  }
                  case 3 -> {
                     System.out.println("Please create an employee login");
                     keyboard.nextLine();
                     String newEmployee = keyboard.nextLine();
                     System.out.println("Please enter a password");
                     String newEmployeePass = keyboard.nextLine();
                     System.out.println("Please enter years worked at the company");
                     int employeeYearsAtCompany = keyboard.nextInt();
                     Employee employee = new Employee(newEmployee, newEmployeePass, employeeYearsAtCompany);
                     employeeArrayList.add(employee);
                  }
                  case 4 -> {
                     System.out.println("Which employee would you like to remove?");
                     keyboard.nextLine();
                     String employeeRemove = keyboard.nextLine();

                     for (Employee e : employeeArrayList)
                     {
                        if (e.getUserLogin().equals(employeeRemove))
                        {
                           employeeArrayList.remove(e);
                           System.out.println("You have successfully removed " + e.getUserLogin() + " from employee pay role!");
                           System.out.println();
                        }
                     }
                     System.out.println();
                  }
                  case 5 -> System.out.println("Thanks for using the system");

                  case 6 -> menu();
               }

            } while (adminChoice < 6);
            quit = true;

         }
      }
   }

   public static void manager()
   {
      System.out.println("Please enter manager login");
      keyboard.nextLine();
      String managerLogin = keyboard.nextLine();
      System.out.println("Please enter manager password");
      String managerPassword = keyboard.nextLine();
      boolean detailsCorrect = false;
      Manager currManager = null;
      for (Manager m : managerArrayList)
      {

         if (m.getUserLogin().equals(managerLogin))
         {
            System.out.println("Username correct");
            System.out.println();
            if (m.getUserPassword().equals(managerPassword))
            {
               System.out.println("You have successfully logged in");
               detailsCorrect = true;
               currManager = m;
            } else
            {
               System.out.println("incorrect password");
            }
         } else
         {
            System.out.println();
         }

      }

      if (detailsCorrect)
      {
         managerMenu(currManager);
      }
   }

   public static void managerMenu(Manager currManager)
   {
      int managerChoice;
      do
      {
         System.out.println();
         System.out.println("Please choose from the following options");
         System.out.println();
         System.out.println("1. View your weekly pay slip");
         System.out.println("2. Create a new employee");
         System.out.println("3. Remove an employee");
         System.out.println("4. Quit your job");
         System.out.println("5. Return the main menu");
         System.out.println("6. Quit the application");
         managerChoice = keyboard.nextInt();
         switch (managerChoice)
         {
            case 1 -> System.out.println("Your weekly salary is : £" + currManager.getWeeklySalary());
            case 2 -> {
               System.out.println("Please create an employee login");
               keyboard.nextLine();
               String newEmployee = keyboard.nextLine();
               System.out.println("Please enter a password");
               String newEmployeePass = keyboard.nextLine();
               System.out.println("Please enter years worked at the company");
               int employeeYearsAtCompany = keyboard.nextInt();
               Employee employee = new Employee(newEmployee, newEmployeePass, employeeYearsAtCompany);
               employeeArrayList.add(employee);
            }
            case 3 -> {
               System.out.println("Which employee would you like to remove?");
               keyboard.nextLine();
               String employeeRemove = keyboard.nextLine();
               for (Employee e : employeeArrayList)
               {
                  if (e.getUserLogin().equals(employeeRemove))
                  {
                     employeeArrayList.remove(e);
                     System.out.println("You have successfully removed " + e.getUserLogin() + " from employee pay role!");
                     System.out.println();
                  }
               }
            }
            case 4 -> {
               System.out.println("Are you sure you want to quit?");
               keyboard.nextLine();
               String response = keyboard.nextLine();
               if (response.equalsIgnoreCase("yes"))
               {
                  managerArrayList.remove(currManager);
                  System.out.println("You have successfully removed " + currManager.getUserLogin() + " from management pay role!");
                  System.out.println();
               }
               System.out.println("Returning to manager menu");
               managerMenu(currManager);


            }
            case 5 -> menu();
            case 6 -> {

            }

         }
      } while (managerChoice != 6);

   }


   public static void employee()
   {
      System.out.println("Please enter employee login");
      keyboard.nextLine();
      String employeeLogin = keyboard.nextLine();
      System.out.println("Please enter employee password");
      String managerPassword = keyboard.nextLine();
      boolean detailsCorrect = false;
      Employee currEmployee = null;
      for (Employee e : employeeArrayList)
      {

         if (e.getUserLogin().equals(employeeLogin))
         {
            System.out.println("Username correct");
            System.out.println();
            if (e.getUserPassword().equals(managerPassword))
            {
               System.out.println("You have successfully logged in");
               detailsCorrect = true;
               currEmployee = e;
            } else
            {
               System.out.println("incorrect password");
            }
         } else
         {
            System.out.println();
         }

      }

      if (detailsCorrect)
      {
         employeeMenu(currEmployee);
      }
   }

   public static void employeeMenu(Employee currEmployee)
   {
      int employeeChoice;

      do
      {
         System.out.println();
         System.out.println("1. View your weekly pay slip");
         System.out.println("2. Quit your job");
         employeeChoice = keyboard.nextInt();

         switch (employeeChoice)
         {
            case 1 -> System.out.println("Your weekly salary is : £" + currEmployee.getWeeklySalary());
            case 2 -> {
               System.out.println("Are you sure you want to quit?");
               keyboard.nextLine();
               String response = keyboard.nextLine();
               if (response.equalsIgnoreCase("yes"))
               {
                  employeeArrayList.remove(currEmployee);
                  System.out.println("You have successfully removed " + currEmployee.getUserLogin() + " from management pay role!");
                  System.out.println();
               }
               System.out.println("Returning to main menu");
               System.out.println();
               menu();
            }
         }
      } while (employeeChoice != 2);

   }

   public static void end()
   {
      System.out.println("Thanks for using the system");
      quit = true;
   }


}//class
