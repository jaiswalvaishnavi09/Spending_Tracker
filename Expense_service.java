/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structureclass;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Expense_service {
    private expense_dao expenseDAO;

    public Expense_service(Connection conn) {
        this.expenseDAO = new expense_dao(conn);
    }

    public void addExpense(expense_model expense) throws Exception {
        expenseDAO.addExpense(expense);
    }

    public List<expense_model> getExpenses(Date from, Date to) throws Exception {
        return expenseDAO.getExpenses(from, to);
    }

    public void deleteExpense(int id) throws Exception {
        expenseDAO.deleteExpense(id);
    }
}

