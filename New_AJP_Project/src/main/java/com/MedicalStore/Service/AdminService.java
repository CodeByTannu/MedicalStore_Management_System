package com.MedicalStore.Service;

import com.MedicalStore.dao.AdminDAO;
import com.MedicalStore.entities.Admin;

public class AdminService {

    private AdminDAO adminDAO;

    public AdminService() {
        this.adminDAO = new AdminDAO();
    }

    public Admin getAdminByUsername(String username) {
        return adminDAO.getAdminByUsername(username);
    }

    public boolean addAdmin(Admin admin) {
        return adminDAO.addAdmin(admin);
    }

	public Admin validateAdminLogin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
