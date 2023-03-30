package model;

import dao.AccountsDAO;

/*
 *  TODO #102 ログイン　ログイン処理を担当するBO
 */

public class LoginLogic {
	public boolean excute (Login login) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}
}
