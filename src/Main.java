import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        Seller seller = sellerDao.findById(1L);
        List<Seller> sellerList = sellerDao.findAll();
        Department department = departmentDao.findById(1L);
        Department departmentToBeInserted = departmentDao.findById(3L);
        Seller sellerToBeUpdated = sellerDao.findById(6L);
        Seller sellerToBeInserted = new Seller("John Doe", "john_doe@gmail.com", Date.valueOf("1993-03-20"), 4000.0, departmentToBeInserted);

        System.out.println();
        System.out.println("Seller brought from the database by the method findById:");
        System.out.println(seller);
        System.out.println();

        System.out.println("Department brought from the database by the method findById:");
        System.out.println(department);
        System.out.println();

        System.out.println("Sellers list brought from the database by the method findAll:");
        for (Seller sellerFromList : sellerList) {
            System.out.println(sellerFromList);
        }

        System.out.println();
        sellerDao.insert(sellerToBeInserted);

        System.out.println();
        sellerToBeUpdated.setEmail("alex_pink@gmail.com");
        sellerDao.update(sellerToBeUpdated);

        System.out.println();
        sellerDao.deleteById(7L);

        DB.closeConnection();
    }
}