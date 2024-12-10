/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structureclass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class category_dao {
    private Connection conn;

    public category_dao(Connection conn) {
        this.conn = conn;
    }

    public void addCategory(String category) throws SQLException {
        String query = "INSERT INTO category_info (category) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, category);
            stmt.executeUpdate();
        }
    }

    public void deleteCategory(String category) throws SQLException {
        String query = "DELETE FROM category_info WHERE category = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, category);
            stmt.executeUpdate();
        }
    }

    public List<String> getAllCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        String query = "SELECT * FROM category_info";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
        }
        return categories;
    }
}
