package service;

import dao.MedicineDAO;
import dao.MedicineDAOImpl;
import com.infosys.jdbc.Medicine;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MedicineDAO medicineDAO = new MedicineDAOImpl();

        try (Scanner scanner = new Scanner(System.in)) {
            // User authentication
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (!"root".equals(username) || !"Kabir@2506".equals(password)) {
                System.out.println("Invalid username or password!");
                return;
            }

            while (true) {
                System.out.println("1. Add Medicine");
                System.out.println("2. View Medicine");
                System.out.println("3. Update Medicine");
                System.out.println("4. Delete Medicine");
                System.out.println("5. View All Medicines");
                System.out.println("6. Get Medicine Name by ID");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        Medicine medicine = new Medicine(0, name, price, quantity);
                        medicineDAO.create(medicine);
                        break;
                    case 2:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        Medicine foundMedicine = medicineDAO.read(id);
                        if (foundMedicine != null) {
                            System.out.println(foundMedicine);
                        } else {
                            System.out.println("Medicine not found!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter ID: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        System.out.print("Enter new price: ");
                        double newPrice = scanner.nextDouble();
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        Medicine updateMedicine = new Medicine(updateId, newName, newPrice, newQuantity);
                        medicineDAO.update(updateMedicine);
                        break;
                    case 4:
                        System.out.print("Enter ID: ");
                        int deleteId = scanner.nextInt();
                        medicineDAO.delete(deleteId);
                        break;
                    case 5:
                        List<Medicine> medicines = medicineDAO.getAllMedicines();
                        for (Medicine med : medicines) {
                            System.out.println(med);
                        }
                        break;
                    case 6:
                        System.out.print("Enter ID: ");
                        int medicineId = scanner.nextInt();
                        String medicineName = medicineDAO.getMedicineNameById(medicineId);
                        System.out.println("Medicine Name: " + medicineName);
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }
}
