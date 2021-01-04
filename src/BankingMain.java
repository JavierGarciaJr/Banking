import java.io.*;
import java.util.*;
class BankingMain {
	private static Account[] users = new Account[6];
	/**
	 * this method is the main driver for the class
	 * @param args
	 * @throws IOException
	 */
  public static void main(String[] args) throws IOException {
    // create a new bank called Wells Fargo
      BankCompany chase  = new BankCompany("Chase Bank");
      // populate the bank with bank account objects read from the file
      readingfile(chase);
      // make a copy of this unsorted bank account arraylist
      BankCompany copy = new BankCompany("Copy of Chase Bank");
      
      chase.backup(copy);
      //make another copy of the unsorted wellsfargo bank
      BankCompany anotherCopy = new BankCompany("Another Copy of Chase Bank");
      chase.backup(anotherCopy);
      // use bubble sort to sort the wells fargo bank 
      // all sorts are based on account number
      int timesBubble= chase.bubbleSort();
      System.out.println(chase.toString());
      //print the number of swaps
      System.out.println("The number of swaps for bubble sort was "+timesBubble);
      // use selection sort to sort the copy of wells fargo
      int timesSelection =copy.selectionSort();
      System.out.println(copy.toString());
      // print the number of swaps for this sort
      System.out.println("The number of swaps for selection sort was "+timesSelection);

      // use the JAva Collections sort  by passing a AutoNamesCompare object

      anotherCopy.nameSort();
      System.out.println(anotherCopy.toString());

      // search for an existing account 1201
      searchAccount(chase);
      //search for a non exisiting account 1200
     searchAccount(copy);

     //test the withdraw and deposit methods
     int number = getAccountNumber();
     int found = chase.recursiveBinarySearch(number);
     if (found>=0){
    // bank.get(found.deposit(1000)); test this
    //bank.get(found.withdraw(1)); test this
    // bank.get(found).withdraw(1000);  test this
    // bank.get(found).deposit(-1000);  test this
   
     }

   

  }
  /**
   * this method puts information inside of the array "users"
   * @param b
   * @throws IOException
   */
  public static void readingfile(BankCompany b)throws IOException{

      
       // read the bank account information line by line (there is one account per line)
       // create a bank account object for each account 
       // add the bank account to the bank 
    	  int count = 0;
    	  File f = new File("BankData.txt");
    	  Scanner kb = new Scanner(f);

    	  while (kb.hasNext()) {

    	  String data = kb.nextLine();

    	  if (!data.isEmpty()) {

    	  String[] first = data.split(" ");

    	  String second[]= new String[16];
    	  second[1]= first[0]+ " " + first[1];//combines the 0 and 1 slots of the array because it is one name
    	  int test = first[0].length() + first[1].length() + 1;
    	  int test2 = 15 - test;
    	  double can = Double.parseDouble(first[first.length-1]);
    	  double soup = can + 0;
    	  
    	  Account player = new Account(first[0], first[1], Integer.valueOf(first[1+ test2]), soup);//constructs a new SoccerPlayer

    	  player.setLastName(first[0]);
    	  player.setLastName(first[1]);
    	  player.setAccountNumber(Integer.valueOf(first[1+ test2]));
    	  player.setBalance(soup);
    	  
    	  users[count] = player;
    	  
    	  String cake = users[count].toString();
		  
		  b.add(users[count]);
    	  count++;
    	  

    	 

    	  }
    	  
    	  }
    		  
    	  

    	  }
      
  
        
      
      
    
  /**
   * gets the users input for the account number they want to look up
   * @return
   */
  public static int getAccountNumber(){
    System.out.print("What is the account number ? ");
    Scanner console = new Scanner(System.in);
    return console.nextInt();
  }
  /**
   * this searches for the users input of account number
   * @param b
   */
  public static void searchAccount(BankCompany b){
    int accountNumber =getAccountNumber();
    int num = b.recursiveBinarySearch(accountNumber);
    if (num>=0)
        System.out.println(b.get(num).toString());
    else
      System.out.println("Account Does Not Exist");
  }

}