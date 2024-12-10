/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structureclass;

import java.sql.Connection;
import java.util.List;

public class category_service {
    private category_dao categoryDAO;

    public category_service(Connection conn) {
        this.categoryDAO = new category_dao(conn);
    }

    public void addCategory(String category) throws Exception {
        categoryDAO.addCategory(category);
    }

    public void deleteCategory(String category) throws Exception {
        categoryDAO.deleteCategory(category);
    }

    public List<String> getAllCategories() throws Exception {
        return categoryDAO.getAllCategories();
    }
}

