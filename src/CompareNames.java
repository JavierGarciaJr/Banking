import java.util.*;
public class CompareNames implements Comparator<Account>{
	/**
	 * this method compares 2 objects
	 */
	@Override
	public int compare(Account o1, Account o2) {
		String op1 = o1.getFirstName();
		String op2 = o2.getLastName();
		if(op1 == op2) {
			return 0;
		}
		double ok1 = o1.getBalance();
		double ok2 = o2.getBalance();
		if(ok1 > ok2) {
			return 1;
		}else {
		return -1;
	}
	}

//implement the compare method
    
    
}

