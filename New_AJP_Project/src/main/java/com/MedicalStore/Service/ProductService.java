package com.MedicalStore.Service;

import com.MedicalStore.dao.ProductDAO;
import com.MedicalStore.entities.Product;
import java.util.List;

public class ProductService {

    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public boolean addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    public boolean deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
