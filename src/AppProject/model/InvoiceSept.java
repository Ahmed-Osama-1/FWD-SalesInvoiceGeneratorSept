package AppProject.model;

import java.util.Date;
import java.util.ArrayList;
import AppProject.view.AppFrameSept;


public class InvoiceSept {
    private int num;
    private String customer;
    private Date date;
    private ArrayList<LineSept> lines;

    public InvoiceSept(int num, String customer, Date date) {
        this.num = num;
        this.customer = customer;
        this.date = date;
    }
    
    public String toCSV() {
        return num + "," + AppFrameSept.sdf.format(date) + "," + customer;
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<LineSept> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<LineSept> lines) {
        this.lines = lines;
    }
    
    public double getTotal() {
        double total = 0.0;
        for (LineSept line : getLines()) {
            total += line.getTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Invoice{" + "num=" + num + ", customer=" + customer + ", date=" + date + '}';
    }
    
    
    
}
