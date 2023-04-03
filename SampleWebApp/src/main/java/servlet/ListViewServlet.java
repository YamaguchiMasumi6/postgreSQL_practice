package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ListView;
import model.ListViewLogic;

/**
 * Servlet implementation class ListViewServlet
 *  TODO #401 一覧画面　一覧画面に関するリクエストを処理するコントローラー
 */
public class ListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListViewServlet() {
        super();     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListViewLogic getListViewLogic = new ListViewLogic();
		List<ListView> listView = getListViewLogic.excute();
		request.setAttribute("listView", listView);
		
		// 一覧画面へのフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/listView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
