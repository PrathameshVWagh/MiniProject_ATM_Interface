package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import bean.Bank;

public interface AtmInterface {
	
	public void Withdraw(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException;
	public void Deposit(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException;
	public void Transfer(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException;
	public void showTransactionHistory() throws NumberFormatException, IOException,InputMismatchException,NullPointerException;
	public void quit() throws NumberFormatException, IOException,InputMismatchException,NullPointerException;

}
