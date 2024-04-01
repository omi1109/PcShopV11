package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import operation.Operation;

/**
 * 検索処理サーブレット
 * @author M.Takahashi
 */
@WebServlet("/search-servlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		String url = "search.jsp";	// 転送先の初期化
		
		try {
			// 登録処理
			Operation op = new Operation();
			List<Product> list = op.searchProd(name);

			// リクエストスコープへの属性の設定
			request.setAttribute("list", list);							// 結果
			request.setAttribute("cond", request.getParameter("name"));	// 検索条件
			
		} catch (Exception e) {
			request.setAttribute("errorMsg", "検索時にエラーが発生しました。");	
			url = "msg.jsp";
		}

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
