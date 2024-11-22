package com.MedicalStore;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.MedicalStore.Service.BillService;
import com.MedicalStore.Service.CustomerService;
import com.MedicalStore.Service.ProductService;
import com.MedicalStore.Service.SalesService;
import com.MedicalStore.entities.Bill;
import com.MedicalStore.entities.Customer;
import com.MedicalStore.entities.Product;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.entities.SalesItem;


public class Mainapp extends JFrame {

    // Declare the service classes globally
    private CustomerService customerService;
    private ProductService productService;
    private SalesService saleService;
    private BillService billService;

    // Declare UI components for Customer, Product, Sale, and Bill
    private JTextField nameField, emailField, phoneField, productNameField, priceField, stockField, billAmountField, customerIdField;
    private JTextField saleProductIdField, saleQuantityField;
    private JTextArea outputArea;
    private JButton addCustomerButton, updateCustomerButton, deleteCustomerButton, addProductButton, addSaleButton, generateBillButton, getAllCustomersButton;

    // Login Panel components
    private JTextField adminUsernameField, adminPasswordField;
    private JTextField staffUsernameField, staffPasswordField;
    private JButton adminLoginButton, staffLoginButton;
    
    private JPanel loginPanel, adminPanel, staffPanel;

    public Mainapp() {
        // Initialize the service classes
        customerService = new CustomerService();
        productService = new ProductService();
        saleService = new SalesService();
        billService = new BillService();

        // Initialize the JFrame
        setTitle("Medical Store Management System");
        setSize(600, 600);  // Increased size to accommodate new fields
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());  // Using CardLayout to switch between login and main panels

        // Initialize login components for Admin and Staff
        adminUsernameField = new JTextField(20);
        adminPasswordField = new JTextField(20);
        adminLoginButton = new JButton("Login as Admin");

        staffUsernameField = new JTextField(20);
        staffPasswordField = new JTextField(20);
        staffLoginButton = new JButton("Login as Staff");

        // Create Panels for Login, Admin, and Staff
        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        
        loginPanel.add(new JLabel("Admin Login"));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(adminUsernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(adminPasswordField);
        loginPanel.add(adminLoginButton);

        loginPanel.add(Box.createVerticalStrut(20));

        loginPanel.add(new JLabel("Staff Login"));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(staffUsernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(staffPasswordField);
        loginPanel.add(staffLoginButton);

        // Main panels for Admin and Staff sections after successful login
        adminPanel = new JPanel(new FlowLayout());
        staffPanel = new JPanel(new FlowLayout());

        // Main UI components for the Admin Panel (Customer Management, Product Management etc.)
        customerIdField = new JTextField(10);  // Added field for customer ID
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        productNameField = new JTextField(20);
        priceField = new JTextField(10);
        stockField = new JTextField(10);
        saleProductIdField = new JTextField(10);
        saleQuantityField = new JTextField(10);
        billAmountField = new JTextField(10);

        addCustomerButton = new JButton("Add Customer");
        updateCustomerButton = new JButton("Update Customer");
        deleteCustomerButton = new JButton("Delete Customer");
        addProductButton = new JButton("Add Product");
        addSaleButton = new JButton("Add Sale");
        generateBillButton = new JButton("Generate Bill");
        getAllCustomersButton = new JButton("Get All Customers");

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Add components to the Admin Panel (Same as your current UI for managing customers, products, etc.)
        adminPanel.add(new JLabel("Customer ID:"));
        adminPanel.add(customerIdField);
        adminPanel.add(new JLabel("Customer Name:"));
        adminPanel.add(nameField);
        adminPanel.add(new JLabel("Customer Email:"));
        adminPanel.add(emailField);
        adminPanel.add(new JLabel("Customer Phone:"));
        adminPanel.add(phoneField);
        adminPanel.add(addCustomerButton);
        adminPanel.add(updateCustomerButton);
        adminPanel.add(deleteCustomerButton);

        adminPanel.add(new JLabel("Product Name:"));
        adminPanel.add(productNameField);
        adminPanel.add(new JLabel("Product Price:"));
        adminPanel.add(priceField);
        adminPanel.add(new JLabel("Product Stock:"));
        adminPanel.add(stockField);
        adminPanel.add(addProductButton);

        adminPanel.add(new JLabel("Sale Product ID:"));
       adminPanel.add(saleProductIdField);
        adminPanel.add(new JLabel("Sale Quantity:"));
        adminPanel.add(saleQuantityField);
        adminPanel.add(addSaleButton);

        adminPanel.add(new JLabel("Total Bill Amount:"));
        adminPanel.add(billAmountField);
        adminPanel.add(generateBillButton);

        adminPanel.add(getAllCustomersButton);
        adminPanel.add(new JScrollPane(outputArea));

        // Add action listeners for buttons (Add, Update, etc.)
        addCustomerButton.addActionListener(new AddCustomerAction());
        updateCustomerButton.addActionListener(new UpdateCustomerAction());
        deleteCustomerButton.addActionListener(new DeleteCustomerAction());
        addProductButton.addActionListener(new AddProductAction());
        addSaleButton.addActionListener(new AddSaleAction());
        generateBillButton.addActionListener(new GenerateBillAction());
        getAllCustomersButton.addActionListener(new GetAllCustomersAction());

        // Add action listeners for login buttons
        adminLoginButton.addActionListener(new AdminLoginAction());
        staffLoginButton.addActionListener(new StaffLoginAction());

        // Add the login panel to the JFrame
        add(loginPanel, "LoginPanel");

        // Add Admin and Staff Panels (but not visible yet)
        add(adminPanel, "AdminPanel");
        add(staffPanel, "StaffPanel");
    }

    // ActionListener for Admin login
    private class AdminLoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = adminUsernameField.getText();
            String password = adminPasswordField.getText();

            // Admin credentials verification (hardcoded for simplicity)
            if ("admin".equals(username) && "admin123".equals(password)) {
                // Switch to Admin Panel
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "AdminPanel");
            } else {
                outputArea.setText("Invalid Admin credentials.");
            }
        }
    }

    // ActionListener for Staff login
    private class StaffLoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = staffUsernameField.getText();
            String password = staffPasswordField.getText();

            // Staff credentials verification (hardcoded for simplicity)
            if ("staff".equals(username) && "staff123".equals(password)) {
                // Switch to Staff Panel
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "StaffPanel");

                // Add basic functionalities for staff (view customers, products, and bills)
                staffPanel.removeAll();
                staffPanel.add(new JLabel("Staff Panel"));
                staffPanel.add(new JButton("View Customers"));
                staffPanel.add(new JButton("View Products"));
                staffPanel.add(new JButton("View Bills"));
                staffPanel.revalidate();
                staffPanel.repaint();
            } else {
                outputArea.setText("Invalid Staff credentials.");
            }
        }
    }

    // ActionListener for adding a customer
    private class AddCustomerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                outputArea.setText("Please fill in all fields.");
                return;
            }

            Customer newCustomer = new Customer();
            newCustomer.setName(name);
            newCustomer.setEmail(email);
            newCustomer.setPhone(phone);

            if (customerService.addCustomer(newCustomer)) {
                outputArea.setText("Customer added successfully!");
            } else {
                outputArea.setText("Failed to add customer.");
            }
        }
    }

    // ActionListener for updating a customer
    private class UpdateCustomerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String customerIdStr = customerIdField.getText();
            String name = nameField.getText();
            String phone = phoneField.getText();

            if (customerIdStr.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                outputArea.setText("Please provide customer ID, name, and phone.");
                return;
            }

            int customerId = Integer.parseInt(customerIdStr);
            Customer updatedCustomer = customerService.getCustomerById(customerId);
            if (updatedCustomer == null) {
                outputArea.setText("Customer not found.");
                return;
            }

            updatedCustomer.setName(name);
            updatedCustomer.setPhone(phone);

            if (customerService.updateCustomer(updatedCustomer)) {
                outputArea.setText("Customer updated successfully!");
            } else {
                outputArea.setText("Failed to update customer.");
            }
        }
    }

    // ActionListener for deleting a customer
    private class DeleteCustomerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String customerIdStr = customerIdField.getText();

            if (customerIdStr.isEmpty()) {
                outputArea.setText("Please provide customer ID.");
                return;
            }

            int customerId = Integer.parseInt(customerIdStr);
            if (customerService.deleteCustomer(customerId)) {
                outputArea.setText("Customer deleted successfully!");
            } else {
                outputArea.setText("Failed to delete customer.");
            }
        }
    }

    // ActionListener for adding a product
    private class AddProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String productName = productNameField.getText();
            String priceStr = priceField.getText();
            String stockStr = stockField.getText();

            if (productName.isEmpty() || priceStr.isEmpty() || stockStr.isEmpty()) {
                outputArea.setText("Please fill in all fields.");
                return;
            }

            double price = Double.parseDouble(priceStr);
            int stock = Integer.parseInt(stockStr);

            Product newProduct = new Product();
            newProduct.setProductName(productName);
            newProduct.setUnitPrice(price);
            newProduct.setStockQuantity(stock);

            if (productService.addProduct(newProduct)) {
                outputArea.setText("Product added successfully!");
            } else {
                outputArea.setText("Failed to add product.");
            }
        }
    }

    // ActionListener for adding a sale
    private class AddSaleAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String productIdStr = saleProductIdField.getText();
            String quantityStr = saleQuantityField.getText();

            if (productIdStr.isEmpty() || quantityStr.isEmpty()) {
                outputArea.setText("Please provide product ID and quantity.");
                return;
            }

            int productId = Integer.parseInt(productIdStr);
            int quantity = Integer.parseInt(quantityStr);
            
            Product product = productService.getProductById(productId);
            if (product == null || product.getStockQuantity() < quantity) {
                outputArea.setText("Product not available or insufficient stock.");
                return;
            }

            Sales newSale = new Sales();
            SalesItem saleItem = new SalesItem();
            saleItem.setProduct(product);
            saleItem.setQuantity(quantity);
            saleItem.setUnitPrice(product.getUnitPrice());
            newSale.addSalesItem(saleItem);
            
            // Update stock
            product.setStockQuantity(product.getStockQuantity() - quantity);
            productService.updateProduct(product);

            if (saleService.addSale(newSale)) {
                outputArea.setText("Sale added successfully!");
            } else {
                outputArea.setText("Failed to add sale.");
            }
        }
    }

    // ActionListener for generating a bill
    private class GenerateBillAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          List<Sales>sales = saleService.getAllSales();
            if (sales == null || sales.isEmpty()) {
                outputArea.setText("No sales found.");
                return;
            }

            // Assuming we generate bill for the last sale
    Sales sale = sales.get(sales.size() - 1);
            double totalAmount = sale.getTotalAmount();
            
            Bill newBill = new Bill();
            newBill.setSale(sale);
            newBill.setTotalAmount(totalAmount);
            
            if (billService.generateBill(newBill)) {
                outputArea.setText("Bill generated successfully!\n" +
                        "Total Amount: " + totalAmount);
            } else {
                outputArea.setText("Failed to generate bill.");
            }
        }
    }

    // ActionListener for getting all customers
    private class GetAllCustomersAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Customer> customers = customerService.getAllCustomers();
            if (customers == null || customers.isEmpty()) {
                outputArea.setText("No customers found.");
                return;
            }

            StringBuilder customerList = new StringBuilder("List of Customers:\n");
            for (Customer customer : customers) {
                customerList.append("ID: ").append(customer.getId()).append(", Name: ").append(customer.getName()).append("\n");
            }
            outputArea.setText(customerList.toString());
        }
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Mainapp mainApp = new Mainapp();
                mainApp.setVisible(true);
            }
        });
    }
}
