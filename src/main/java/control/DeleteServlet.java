package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operation.Operation;

/**
 * 削除処理サーブレット
 * @author M.Takahashi
 */
@WebServlet("/delete-servlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// productId の取得
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("id");
		
    	String url = "msg.jsp";		// 転送先の初期化

		try {
			// 削除処理
			Operation op = new Operation();
			op.deleteProd(productId);
			// 完了メッセージ
			request.setAttribute("msg", "削除処理が完了しました。");	
		} catch (Exception e) {
			request.setAttribute("errorMsg", "削除時にエラーが発生しました。");	
		}

	    // リクエストの転送
	    RequestDispatcher rd = request.getRequestDispatcher(url);
	    rd.forward(request, response);
	}

}
