package test;

import java.util.List;

import dao.ListViewDAO;
import model.ListView;

public class ListViewLogicTest {

	public static void main(String[] args) {
		ListViewDAO dao = new ListViewDAO();
		List<ListView> lvList = dao.findAll();
		
		for (ListView lv : lvList) {
			System.out.println("user_id:" + lv.getUserId());
			System.out.println("名前:" + lv.getName());
			System.out.println("年齢:" + lv.getAge());
		}
	}
	
}
