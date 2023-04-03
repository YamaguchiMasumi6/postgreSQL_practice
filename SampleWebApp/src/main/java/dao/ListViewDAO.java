package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ListView;

public class ListViewDAO {
	// データベースに接続するための情報
		private final String JDBC_URL = "jdbc:postgresql://localhost:5432/sukkiriShop";
		private final String DB_USER = "postgres";
		private final String DB_PASS = "gkf798092";
		
	// 取得したデータ
		String usersId = null;
		String names = null;
		int ages = 0;
		
		public List<ListView> findAll() {
			List<ListView> lvList = new ArrayList<>();
			// JDBC ドライバを読み込む
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("JDBCドライバを読み込めませんでした");
			}
			
			// データベースへ接続
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
				
				// SELECT文を準備
				String sql = "SELECT user_id,name,age FROM public.accounts";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				// SELECT文を実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery();
				
				while(rs.next()) {
					// SELECT文の結果をArrayListに格納
					usersId = rs.getString("USER_ID");
					names = rs.getString("NAME");
					ages = rs.getInt("AGE");
					ListView lists = new ListView(usersId, names, ages);
					lvList.add(lists);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
			return lvList;
		}
}
