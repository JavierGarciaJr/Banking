import java.util.*;
public class BankCompany implements Comparator{ 
  private String bankName="";
  private static Account[] sorter = new Account[6];
  ArrayList<Account> bank;
  /**
   * this method is a constructor
   * @param bankName
   */
  public BankCompany(String bankName){
    this.bankName=bankName;
    bank= new ArrayList<Account>();
    
  }
/**
 * this method adds a new bank account to the bank
 * @param a
 */
  public  void add(Account a){
	  this.bank.add(a);
    
  }
  /**
   * this method bubble sorts the account numbers
   * @return
   */
  public int bubbleSort(){
	 for(int i = 0; i <= 5; i++) {
	 sorter[i] = bank.get(i);
	 }
    int num = sorter.length;
    int count =0;
    for(int i = 0; i <= num -1; i++) {
    	for(int j = 0; j < num-i-1;j++) {
    		if(sorter[j].getAccountNumber() > sorter[j+1].getAccountNumber()) {
    			int temp =sorter[j].getAccountNumber();
    			int jab = sorter[j+1].getAccountNumber();
    			sorter[j].setAccountNumber(jab);
    			sorter[j+1].setAccountNumber(temp);
    		}
    		count++;
    	}
    	
    }
   return count;
  }
  /**
   * this method swaps the order of the arrays
   * @param i
   * @param j
   */
  public void swapEm(int i, int j){
    Account temp1=bank.get(i);
    Account temp2 = bank.get(j);
    bank.remove(i);
    bank.add(i,temp2);
    bank.remove(j);
    bank.add(j,temp1);
  }
  /**
   * this method does a selection sort on the First names
   * @return
   */
  public int selectionSort(){
    int num = sorter.length;
    int count =0;
    for(int i = 0; i < num -1; i++) {
    	int minIn =i;
    	Account minSt = sorter[i];
    	for(int j = i+1; j < num; j++) {
    		if(sorter[j].getFirstName().compareTo(minSt.getFirstName()) < 0) {
    			minSt = sorter[j];
    			minIn = j;
    		}
    		
    	}
    	if(minIn != i) {
    		Account temp1 = bank.get(minIn);
    		Account temp = sorter[minIn];
    		bank.set(minIn, sorter[i]);
    		sorter[minIn] = sorter[i];
    		bank.set(i, temp);
    		sorter[i] = temp;
    		
    	}
    	count++;
    }
    return count;
  }
  /**
   * this method converts the bank into a String
   */
  public String toString(){
    String output = "\n"+bankName+"\n";
    for (int i= 0;i<bank.size();i++)
      output = output + bank.get(i).toString()+"\n";
    return output;
  }
  /**
   * this method does a binary search of the account numbers
   * @param accountNumber
   * @param first
   * @param last
   * @return
   */
  public int recursiveBinarySearch(int accountNumber, int first, int last){
    if (first>last) return -1;
    int middle= (first+last)/2;
    if (accountNumber== bank.get(middle).getAccountNumber())
      return middle;
    else if (accountNumber> bank.get(middle).getAccountNumber())
      return recursiveBinarySearch(accountNumber, middle+1,last);
    else 
       return recursiveBinarySearch(accountNumber, first,last-1);
  }
  /**
   * this method does binary search of the account numbers
   * @param accountNumber
   * @return
   */
  public int recursiveBinarySearch(int accountNumber){

    return recursiveBinarySearch(accountNumber,0,bank.size()-1);
    
  }
  /**
   * this method sorts names
   */
  public void nameSort(){
    Collections.sort(bank,new CompareNames());
  }
  /**
   * this method returns the values in the array
   * @param i
   * @return
   */
  public Account get(int i){
    return bank.get(i);
  }
  /**
   * this method returns the values in the array
   * @return
   */
  private ArrayList<Account> getAccounts(){
    return bank;
  }
  /**
   * this method is for the other bank account print
   * @param other
   */
  public void backup(BankCompany other){
    for (int i=0;i<bank.size();i++)
      other.add(bank.get(i));
   //Collections.copy(bank,other.getAccounts());
  }
/**
 * this method compares 2 objects
 */
@Override
public int compare(Object arg0, Object arg1) {
	
	return 0;
}
}