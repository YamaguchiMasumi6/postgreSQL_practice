package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 *  TODO #001 データベースへ接続するクラス作成
 */
public class DBConnection {
	public static void main(String[] args) throws Exception {
		// Postgresqlへの接続情報
		Connection con;
		Statement st;
		ResultSet rs;
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "gkf798092";
		
		// JDBCドライバの定義
		Class.forName("org.postgresql.Driver");
		
		// Postgresqlへの接続
		con = DriverManager.getConnection(url, user, password);
		st = con.createStatement();		
	}
}
