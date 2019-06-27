package cg;
import java.util.*;
import java.io.*;
import com.cg.service.*;
import com.cg.bean.*;
public class Demo5 {

	public static void main(String[] args) throws IOException {
		Map<Long,Account> accmap=new TreeMap<Long,Account>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String choice="";
		while(true) {
		System.out.println("Menu");
		System.out.println("====");
		System.out.println("1 Create new Account");
		System.out.println("2 Print all accounts");
		System.out.println("3 Exit");
		System.out.println("Enter Your Choice");
		choice=br.readLine();
		switch(choice) {
		case "1":	int id=0;
					long mb=0L;
					String ah="";
					double bal=0.0;
					System.out.println("Enter account number");
					//accepting and validating input for account number
					while(true) {
						String s_id=br.readLine();
						boolean ch1=Validator.validatedata(s_id,Validator.aidpattern);
						if(ch1==true) {
							try {
								id=Integer.parseInt(s_id);
								break;
							}
							catch(NumberFormatException e) {
								System.out.println("Account number must be numeric.Re Enter");
							}
						}
						else {
							System.out.println("Re Enter Account Number in 3 digits");
						}
					}//end of account number while
					//accepting and validating input for mobile number
					System.out.println("Enter mobile number");
					while(true) {
						String mobile=br.readLine();
						boolean ch1=Validator.validatedata(mobile,Validator.mobilepattern);
						if(ch1==true) {
							try {
								mb=Long.parseLong(mobile);
								break;
							}
							catch(NumberFormatException e) {
								System.out.println("Mobile number must be numeric.Re Enter");
							}
						}
						else {
							System.out.println("Re Enter Mobile Number in 10 digits");
						}
					}//end of mobile number while
//==========================================================================================================
					//accepting and validating input for name
					System.out.println("Enter name");
					ah=br.readLine();
//					while(true) {
//						boolean ch1=Validator.validatedata(ah,Validator.mobilepattern);
//						if(ch1==true) {
//							try {
//								mb=Long.parseLong(ah);
//								break;
//							}
//							catch(NumberFormatException e) {
//								System.out.println("Mobile number must be numeric.Re Enter");
//							}
//						}
//						else {
//							System.out.println("Re Enter Name");
//						}
//					}//end of name while
					//accepting and validating input for balance
					System.out.println("Enter balance");
					String balance=br.readLine();
					bal=Double.parseDouble(balance);
//					while(true) {
//						boolean ch1=Validator.validatedata(balance,Validator.mobilepattern);
//						if(ch1==true) {
//							try {
//								mb=Long.parseLong(ah);
//								break;
//							}
//							catch(NumberFormatException e) {
//								System.out.println("Mobile number must be numeric.Re Enter");
//							}
//						}
//						else {
//							System.out.println("Re Enter Mobile Number in 10 digits");
//						}
//						
//					}//end of mobile balance while
//============================================================================================================
					Account ob=new Account(id,mb,ah,bal);
					accmap.put(ob.getMobile(),ob);
		break;
		case "2":
			Collection<Account> vc=accmap.values();
			List<Account> acclist=new ArrayList<Account>(vc);
			Collections.sort(acclist);
			for(Account o:acclist)
			{
				System.out.println(o);
				//service.printStatement
			}
			break;
		case "3":System.out.println("Exiting Program");
			System.exit(0);
			break;
		default:System.out.println("Invalid Choice");
		
		}
		}//end of menu
		
		
		
		
//		System.out.println(accmap);
//		System.out.println(accmap.keySet());
//		System.out.println("==============");
//		Collection<Account> vc=accmap.values();
//		List<Account> acclist=new ArrayList<Account>(vc);
//		Collections.sort(acclist);
//		for(Account o:acclist) {
//			System.out.println(o);
//		}
//		System.out.println("============== sort by name");
//		Comparator nc=new NameComparator();
//		Collections.sort(acclist,nc);
//		for(Account o:acclist) {
//			System.out.println(o);
//		}
//		System.out.println("============== sort by balance");
//		Comparator bc=new BalanceComparator();
//		Collections.sort(acclist,bc);
//		for(Account o:acclist) {
//			System.out.println(o);
//		}
		
		//Set<Account> aset=new TreeSet<Account>();
		//aset.add(Account object);//compareTo method
		//aset.add(Account object);
		//aset.add(Account object);
		
		//sort by name
//		Comparator nc=new NameComparator();
//		Set<Account> aset=new TreeSet<Account>(nc);
		//aset.add(Account object);//compare method of NameComparator //custom sorting
		//aset.add(Account object);
		}

}
