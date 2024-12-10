/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structureclass;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class expense_dao {
    private Connection conn;

    public expense_dao(Connection conn) {
        this.conn = conn;
    }

    public void addExpense(expense_model expense) throws SQLException {
        String query = "INSERT INTO spendings (category, spending_date, amount) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, expense.getCategory());
            stmt.setDate(2, new java.sql.Date(expense.getSpendingDate().getTime()));
            stmt.setInt(3, expense.getAmount());
            stmt.executeUpdate();
        }
    }

    public List<expense_model> getExpenses(java.util.Date from, java.util.Date to) throws SQLException {
        String query = "SELECT * FROM spendings WHERE spending_date BETWEEN ? AND ?";
        List<expense_model> expenses = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(from.getTime()));
            stmt.setDate(2, new java.sql.Date(to.getTime()));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    expense_model expense = new expense_model();
                    expense.setId(rs.getInt("sid"));
                    expense.setCategory(rs.getString("category"));
                    expense.setSpendingDate(rs.getDate("spending_date"));
                    expense.setAmount(rs.getInt("amount"));
                    expenses.add(expense);
                }
            }
        }
        return expenses;
    }

    public void deleteExpense(int id) throws SQLException {
        String query = "DELETE FROM spendings WHERE sid = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
