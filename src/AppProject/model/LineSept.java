package AppProject.model;

public class LineSept {
    private String item;
    private double price;
    private int count;
    private InvoiceSept invoice;

    public LineSept(String item, double price, int count, InvoiceSept invoice) {
        this.item = item;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public String toCSV() {
        return invoice.getNum() + "," + item + "," + price + "," + count;
    }
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceSept getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceSept invoice) {
        this.invoice = invoice;
    }
    
    public double getTotal() {
        return getCount() * getPrice();
    }

    @Override
    public String toString() {
        return "Line{" + "item=" + item + ", price=" + price + ", count=" + count + '}';
    }
    
}
