package AppProject.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LineModelSept extends AbstractTableModel {

    private String[] cols = {"Item", "Unit Price", "Count", "Total"};
    private List<LineSept> lines;

    public LineModelSept(List<LineSept> lines) {
        this.lines = lines;
    }

    public List<LineSept> getLines() {
        return lines;
    }
    
    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LineSept line = lines.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return line.getItem();
            case 1: return line.getPrice();
            case 2: return line.getCount();
            case 3: return line.getTotal();
        }
        return "";
    }
    
}

