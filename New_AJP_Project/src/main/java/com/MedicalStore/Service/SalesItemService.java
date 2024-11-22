package com.MedicalStore.Service;

import com.MedicalStore.dao.SalesItemDAO;
import com.MedicalStore.entities.SalesItem;
import java.util.List;

public class SalesItemService {

    private SalesItemDAO salesItemDAO;

    public SalesItemService() {
        this.salesItemDAO = new SalesItemDAO();
    }

    public boolean addSalesItem(SalesItem salesItem) {
        return salesItemDAO.addSalesItem(salesItem);
    }

    public List<SalesItem> getAllSalesItems() {
        return salesItemDAO.getAllSalesItems();
    }

    public SalesItem getSalesItemById(int id) {
        return salesItemDAO.getSalesItemById(id);
    }

    public boolean updateSalesItem(SalesItem salesItem) {
        return salesItemDAO.updateSalesItem(salesItem);
    }

    public boolean deleteSalesItem(int id) {
        return salesItemDAO.deleteSalesItem(id);
    }
}
