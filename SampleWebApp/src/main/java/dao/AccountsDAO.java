package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

/*
 *  TODO #202 アカウント　ACCOUNTSテーブルを担当するDAO
 */

public class AccountsDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/sukkiriShop";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "gkf798092";
	
	public Account findByLogin(Login login) {
		Account account = null;
		// JDBC ドライバを読み込む
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			// SELECT文を準備
			String sql = "SELECT * FROM public.accounts WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());
			
			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				// ユーザーが存在したらデータを取得
				// そのユーザーを表すAccountインスタンスを生成
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				account = new Account(userId, pass, mail, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}
}
