package service;

import java.io.IOException;
import java.util.InputMismatchException;

public interface BankInterface {

	public void addAccountHolder() throws NumberFormatException, IOException,InputMismatchException,NullPointerException;
	public void bankInfo() throws NumberFormatException, IOException,InputMismatchException,NullPointerException;
	public void allAccountHolder() throws NumberFormatException, IOException,InputMismatchException,NullPointerException;
	
}
