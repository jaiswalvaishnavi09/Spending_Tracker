/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structureclass;

public class expense_model {
    private int id;
    private String category;
    private java.util.Date spendingDate;
    private int amount;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public java.util.Date getSpendingDate() {
        return spendingDate;
    }

    public void setSpendingDate(java.util.Date spendingDate) {
        this.spendingDate = spendingDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
