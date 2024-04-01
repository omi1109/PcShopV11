package operation;

import java.util.List;

import dao.ProductDAO;
import dto.Product;

/**
 * 商品オペレーションクラス
 * @author M.Takahashi
 */
public class Operation {

	/**
	 * 商品検索
	 * @param name 商品名（部分一致文字列）
	 * @return 結果の商品情報リスト
	 * @throws Exception
	 */
	public List<Product> searchProd(String name) throws Exception {

		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.selectByName(name);

		return list;
	}

	
	/**
	 * 商品追加
	 * @param product
	 * @throws Exception
	 */
	public void registProd(Product product) throws Exception {

		ProductDAO dao = new ProductDAO();
		dao.insert(product);

	}
	
	/**
	 * 商品情報更新
	 * @param product
	 * @throws Exception
	 */
	public void updateProd(Product product) throws Exception {

		ProductDAO dao = new ProductDAO();
		dao.update(product);

	}

	/**
	 * 商品情報削除
	 * @param product
	 * @throws Exception
	 */
	public void deleteProd(String productId) throws Exception {

		ProductDAO dao = new ProductDAO();
		dao.delete(productId);

	}

}
