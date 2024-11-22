package com.MedicalStore.Service;

import com.MedicalStore.dao.StaffDAO;
import com.MedicalStore.entities.Staff;

public class StaffService {

    private StaffDAO staffDAO;

    public StaffService() {
        this.staffDAO = new StaffDAO();
    }

    public Staff getStaffByUsername(String username) {
        return staffDAO.getStaffByUsername(username);
    }

    public boolean addStaff(Staff staff) {
        return staffDAO.addStaff(staff);
    }
}
