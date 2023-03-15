package serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import UI.ATMMain;
import bean.Bank;

import service.AtmInterface;


public class ATMImplementation implements AtmInterface{
	ArrayList<Bank>list5=new ArrayList<Bank>();
	@Override
	public void Withdraw(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException {
		try {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter  Amount in Rs. which you want to withdraw :");
		double id=sc.nextDouble();
		
	    int flag=0,index = 0;
	    Bank s=null;
	    for(Bank e:list)
	    {
	    	if(id<=e.getAmount()&&userId.equals(e.getUserId()))//1001=1001
	    	{
	    		flag=1;
	    		
	    		index=list.indexOf(e);//1001
	    		s=e;
	    		
	    		break;
	    	}
	    }
	    
	    if(flag==1)
	    {	
	    	double bal = s.getAmount();
	    	double updatedbal = bal-id;
			  
			s.setAmount(updatedbal);
			s.setOperation("Withdraw");
			
			list.set(index,s);
			
			System.out.println("Balance Updated!!");
			
			String name = s.getAccountholdername();
			double amount = s.getAmount();
			String bName=s.getBankName();
			String ope =s.getOperation();
			String uid=s.getUserId();
			
			Bank bw = new Bank(uid,bName,name,amount,ope);
			bw.history();
			list5.add(bw);
			
			
	    }
	    else {
	    	System.out.println("You have not enough balance to proceed this transaction ..");
	    }
		}catch(NumberFormatException | InputMismatchException | NullPointerException e) {
			System.out.println("Enter proper response");	
		}
	    

		
	}

	@Override
	public void Deposit(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException  {
		try {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter  Amount in Rs. which you want to Deposit :");
		double id=sc.nextDouble();
	    int flag=0,index = 0;
	    Bank s=null;
	    for(Bank e:list)
	    {
	    	if((id<=e.getAmount()||id>=e.getAmount())&&userId.equals(e.getUserId()))//1001=1001
	    	{
	    		flag=1;
	    		
	    		index=list.indexOf(e);
	    		s=e;
	    		
	    		break;
	    	}
	    }
	    
	    if(flag==1)
	    {	
	    	double bal = s.getAmount();
	    	double updatedbal = bal+id;
			  
			s.setAmount(updatedbal);
			s.setOperation("Deposit");
			
			list.set(index,s);
			
			System.out.println("Balance Updated!!");
			String name = s.getAccountholdername();
			double amount = s.getAmount();
			String bName=s.getBankName();
			String ope =s.getOperation();
			String uid=s.getUserId();
			String upin = s.getUserPin();
			
			Bank bd = new Bank(uid,bName,name,amount,ope);
			bd.history();
			list5.add(bd);
			
	    }
	    else {
	    	System.out.println("You have not enough balance to proceed this transaction ..");
	    }
		}catch(NumberFormatException | InputMismatchException | NullPointerException  e) {
			System.out.println("Enter proper response");	
		}

		
	}
	

	@Override
	public void Transfer(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException{
		try {
		System.out.println("Please enter user id from following list to transfer money : ");
		System.out.println("=================================================");
		System.out.println("           All User ID in Student Bank          " );
		System.out.println("=================================================");
		Bank b3 =null;
		int index2 = 0;
		for(Bank b:list) {
			if(userId.equals(b.getUserId())) {
				index2 = list.indexOf(b);
				b3=b;
				continue;
			}else {
				System.out.println(b.getUserId());
			}
			}
		System.out.println("=================================================");
		System.out.println("==Please Enter user Id Properly from above list==");
		System.out.println("=================================================");
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter recepient User Id : ");
		String ruserid = sc.next();
		int flag=0,index = 0;
		
		Bank b2=null;
		
		
		for(Bank b1:list) {
			if(ruserid.equals(b1.getUserId())) {
				flag=1;
				index=list.indexOf(b1);
				b2=b1;
				break;
				
			}
		}
		if(flag==1&&userId.equals(b3.getUserId())) {
			System.out.println("Enter amount in Rs. that you want to transfer : ");
			double transferamt = sc.nextDouble();
			double bal = b2.getAmount();
	    	double updatedbal = bal+transferamt;
			double useramt = b3.getAmount();
			double firstuseramt = useramt - transferamt;
			
			b2.setAmount(updatedbal);
			b2.setOperation("Transfered from : "+b3.getUserId());
			
			b3.setAmount(firstuseramt);
			b3.setOperation("Transfer to : "+b2.getUserId());
			
			
			System.out.println("Balance Updated!!");
			
			String name = b2.getAccountholdername();
			double amount = b2.getAmount();
			String bName=b2.getBankName();
			String ope =b2.getOperation();
			String uid=b2.getUserId();
			
			Bank bt1 = new Bank(uid,bName,name,amount,ope);
			bt1.history();
			list5.add(bt1);
			
			String name2 = b3.getAccountholdername();
			double amount2 = b3.getAmount();
			String bName2=b3.getBankName();
			String ope2 =b3.getOperation();
			String uid2=b3.getUserId();
			
			Bank bt2 = new Bank(uid2,bName2,name2,amount2,ope2);
			bt2.history();
			list5.add(bt2);
			
			
			
			
			
		}
		}catch(NumberFormatException | InputMismatchException | NullPointerException e) {
			System.out.println("Enter proper response");	
		}
	}

	
	@Override
	public void quit() throws NumberFormatException, IOException,InputMismatchException {
		System.out.println("Redircting to main page...");
		System.out.println(".");
		System.out.println(".....");
		System.out.println("...........");
		System.out.println("................");
		System.out.println("For Go Back to Main Dashboard Please enter <yes>");
		
		ATMMain atm = new ATMMain();
		
		
	}

	@Override
	public void showTransactionHistory() throws NumberFormatException, IOException,InputMismatchException{
		new Bank();
		
		if(list5.size()==0)
		{
			System.out.println("No any Transactions!!");
		}
		
		for(Bank s1:list5)
		{
			System.out.println(s1.history());
			
		}
	}

	
		
}

	
	
	
	


