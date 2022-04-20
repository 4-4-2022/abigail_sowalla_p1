package com.fishyfriends.test;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fishyfriends.Model.Account;
import com.fishyfriends.Model.CurrentSession;
import com.fishyfriends.Model.ProgramStage;
import com.fishyfriends.Model.User;
import com.fishyfriends.client.AppUI;
import com.fishyfriends.client.Flows;
import com.fishyfriends.client.Menus;
import com.fishyfriends.client.Switches;
import com.fishyfriends.repository.AccountDAO;
import com.fishyfriends.repository.AnimalDAO;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class AppUITest implements Menus, Switches, Flows{
	
	//object under test
	@InjectMocks
	private AppUI appUI;
	
	@Mock
	private AccountDAO accountDAO;
	private static Account mockAccount;
	private static User mockUser;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.mockAccount = new Account(4,"accountName",9.99f);
		this.mockUser = new User("username",7,"userpassword", true, "123 street", "cityville", "FL", 55555, "email@email.com", 020222, true, true);
	}
	
	@Test
	public static void testVerify1to() {
		//I'm testing "verify1or2()" to make sure that the original user selection is not changed as long as it is at or below 4.
		Scanner scanner = new Scanner(System.in);
		int tester = AppUI.verify1to(1, scanner, 4);
		Assertions.assertEquals(1, tester);
		scanner.close();
	}
	
	@Test
	public static void testVerifyInBudget() {
		Scanner scanner = new Scanner(System.in);
		//I'm testing to make sure this method won't make you change your entry as long as you are within budget.
		int tester = AppUI.verifyInBudget(40, 2, 40, scanner);
		scanner.close();
		Assertions.assertEquals(2, tester);
	}
	
	@Test
	public static void testCatalogSwitch() {
		//tests that the program stage switches from 2 to 1 when run through this method
		Scanner scanner = new Scanner(System.in);
		AppUI.catalogSwitch(2,scanner);
		scanner.close();
		ProgramStage programStage = ProgramStage.getInstance();
		int tester=programStage.returnsProgramStage();
		Assertions.assertEquals(1, tester);
	}
	
	@Test
	public static void testGetUsersBalance() {
		//tests that method accurately retrieves a user's balance
		Mockito.when(AccountDAO.getAccountID(mockUser.userName)).thenReturn(mockAccount.accountID);
		Mockito.when(AccountDAO.getAccountBalance(mockAccount.accountID)).thenReturn(mockAccount.accountBalance);
		
		float tester=AppUI.getUsersBalance();
		Assertions.assertEquals(9.99, tester);
	}
	
	public static void testGetUsersID() {
		
	}
	
}
