package com.MedicalStore.Service;

import com.MedicalStore.dao.SalesDAO;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.entities.SalesItem;

import java.util.List;

public class SalesService {
	

    private SalesDAO salesDAO;

    public SalesService() {
        this.salesDAO = new SalesDAO();
    }

    public boolean addSale(Sales sales) {
        return salesDAO.addSale(sales);
    }

    public List<Sales> getAllSales() {
        return salesDAO.getAllSales();
    }

    public Sales getSaleById(int id) {
        return salesDAO.getSaleById(id);
    }

    public boolean updateSale(Sales sales) {
        return salesDAO.updateSale(sales);
    }

    public boolean deleteSale(int id) {
        return salesDAO.deleteSale(id);
    }

	public boolean createSale(Sales sale, SalesItem salesItem) {
		// TODO Auto-generated method stub
		return false;
	}
}
