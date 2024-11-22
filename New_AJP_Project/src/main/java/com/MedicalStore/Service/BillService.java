package com.MedicalStore.Service;

import com.MedicalStore.dao.BillDAO;
import com.MedicalStore.entities.Bill;
import java.util.List;

public class BillService {

    private BillDAO billDAO;

    public BillService() {
        this.billDAO = new BillDAO();
    }

    public boolean addBill(Bill bill) {
        return billDAO.addBill(bill);
    }

    public List<Bill> getAllBills() {
        return billDAO.getAllBills();
    }

    public Bill getBillById(int id) {
        return billDAO.getBillById(id);
    }

    public boolean updateBill(Bill bill) {
        return billDAO.updateBill(bill);
    }

    public boolean deleteBill(int id) {
        return billDAO.deleteBill(id);
    }

	public boolean generateBill(Bill newBill) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean generateBill1(Bill newBill) {
		// TODO Auto-generated method stub
		return false;
	}

    // Additional methods can be added based on business requirements, like:
    // - Get bills by a specific date range
    // - Get bills by customer
    // - Calculate total bill amount
    // - Other operations specific to the business logic
}
