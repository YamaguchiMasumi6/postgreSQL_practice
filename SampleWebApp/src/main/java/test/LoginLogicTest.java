package test;

import model.Login;
import model.LoginLogic;

/*
 *  TODO #103 ログイン　LoginLogicをテストする
 */

public class LoginLogicTest {
	public static void main(String[] args) {
		testExecuteOK(); // ログイン成功のテスト
		testExecuteNG(); // ログイン失敗のテスト
	}
	public static void testExecuteOK() {
		Login login = new Login("minato", "1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.excute(login);
		if(result) {
			System.out.println("testExecuteOK:成功しました");
		} else {
			System.out.println("testExecuteOK:失敗しました");
		}
	}
	public static void testExecuteNG() {
		Login login = new Login("minato", "12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.excute(login);
		if(!result) {
			System.out.println("testExecuteNG:成功しました");
		} else {
			System.out.println("testExecuteNG:失敗しました");
		}
	}
}
