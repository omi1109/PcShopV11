package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import operation.Operation;

/**
 * 登録処理サーブレット
 * @author M.Takahashi
 */
@WebServlet("/regist-servlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// Productオブジェクト作成
    	request.setCharacterEncoding("UTF-8");
    	Product product = new Product();
    	product.setProductId(request.getParameter("id"));
    	product.setProductName(request.getParameter("name"));
    	product.setPrice(Integer.parseInt(request.getParameter("price")));
    	
    	String url = "msg.jsp";		// 転送先の初期化
    	
		try {
			// 登録処理
			Operation op = new Operation();
			op.registProd(product);
			// 完了メッセージ
			request.setAttribute("msg", "登録処理が完了しました。");	
		} catch (Exception e) {
			request.setAttribute("errorMsg", "登録時にエラーが発生しました。");	
		}

        // リクエストの転送
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
