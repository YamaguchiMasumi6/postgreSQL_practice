package model;

import java.util.List;

import dao.ListViewDAO;

public class ListViewLogic {
	public List<ListView> excute(){
		ListViewDAO dao = new ListViewDAO();
		List<ListView> listView = dao.findAll();
		return listView;
	}
}