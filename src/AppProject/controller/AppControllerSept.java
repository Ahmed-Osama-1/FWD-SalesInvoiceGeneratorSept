package AppProject.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import AppProject.model.HeaderModelSept;
import AppProject.model.InvoiceSept;
import AppProject.model.LineSept;
import AppProject.model.LineModelSept;
import AppProject.view.HeaderDialogSept;
import AppProject.view.LineDialogSept;
import AppProject.view.AppFrameSept;


public class AppControllerSept implements ActionListener, ListSelectionListener {

    private AppFrameSept frame;
    private HeaderDialogSept headerDialog;
    private LineDialogSept lineDialog;

    public AppControllerSept(AppFrameSept frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionListener");

        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "New Invoice":
                newInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "New Line":
                newLine();
                break;
            case "Delete Line":
                deleteLine();
                break;
            case "Load Files":
                loadFiles(null, null);
                break;
            case "Save Data":
                saveData();
                break;
            case "newInvoiceOK":
                newInvoiceOK();
                break;
            case "newInvoiceCancel":
                newInvoiceCancel();
                break;
            case "newLineOK":
                newLineOK();
                break;
            case "newLineCancel":
                newLineCancel();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("ListSelectionListener");

        int row = frame.getInvoicesTable().getSelectedRow();
        System.out.println("Selected Row: " + row);
        if (row > -1 && row < frame.getInvoices().size()) {
            InvoiceSept inv = frame.getInvoices().get(row);
            frame.getCustNameLabel().setText(inv.getCustomer());
            frame.getInvDateLabel().setText(frame.sdf.format(inv.getDate()));
            frame.getInvNumLabel().setText("" + inv.getNum());
            frame.getInvTotalLabel().setText("" + inv.getTotal());

            List<LineSept> lines = inv.getLines();
            frame.getLinesTable().setModel(new LineModelSept(lines));
        } else {
            frame.getCustNameLabel().setText("");
            frame.getInvDateLabel().setText("");
            frame.getInvNumLabel().setText("");
            frame.getInvTotalLabel().setText("");

            frame.getLinesTable().setModel(new LineModelSept(new ArrayList<LineSept>()));
        }

    }

    private void newInvoice() {
        headerDialog = new HeaderDialogSept(frame);
        headerDialog.setVisible(true);
    }

    private void deleteInvoice() {
        int row = frame.getInvoicesTable().getSelectedRow();
        if (row != -1) {
            frame.getInvoices().remove(row);
            ((HeaderModelSept) frame.getInvoicesTable().getModel()).fireTableDataChanged();
        }
    }

    private void newLine() {
        int selectedInv = frame.getInvoicesTable().getSelectedRow();
        if (selectedInv != -1) {
            lineDialog = new LineDialogSept(frame);
            lineDialog.setVisible(true);
        }
    }

    private void deleteLine() {
        int row = frame.getLinesTable().getSelectedRow();
        if (row != -1) {
            int headerRow = frame.getInvoicesTable().getSelectedRow();
            LineModelSept lineTableModel = (LineModelSept) frame.getLinesTable().getModel();
            lineTableModel.getLines().remove(row);
            lineTableModel.fireTableDataChanged();
            ((HeaderModelSept) frame.getInvoicesTable().getModel()).fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(headerRow, headerRow);
        }
    }

    public void loadFiles(String headrPath, String linePath) {
        File headerFile = null;
        File lineFile = null;
        if (headrPath == null && linePath == null) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                headerFile = fc.getSelectedFile();
                result = fc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    lineFile = fc.getSelectedFile();
                }
            }
        } else {
            headerFile = new File(headrPath);
            lineFile = new File(linePath);
        }

        if (headerFile != null && lineFile != null) {
            try {
            
                List<String> headerLines = Files.lines(Paths.get(headerFile.getAbsolutePath())).collect(Collectors.toList());
                
                List<String> lineLines = Files.lines(Paths.get(lineFile.getAbsolutePath())).collect(Collectors.toList());
                
                
                frame.getInvoices().clear();
                for (String headerLine : headerLines) {
                    String[] parts = headerLine.split(",");  
                    String numString = parts[0];
                    String dateString = parts[1];
                    String name = parts[2];
                    int num = Integer.parseInt(numString);
                    Date date = AppFrameSept.sdf.parse(dateString);
                    InvoiceSept inv = new InvoiceSept(num, name, date);
                  
                    frame.getInvoices().add(inv);
                }
                System.out.println("Check point");
                for (String lineLine : lineLines) {
                    
                    String[] parts = lineLine.split(",");
                   
                    int num = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int count = Integer.parseInt(parts[3]);
                    InvoiceSept inv = getInvoiceByNum(num);
                    LineSept line = new LineSept(name, price, count, inv);
                    inv.getLines().add(line);
                }
                System.out.println("Check point");
                frame.getInvoicesTable().setModel(new HeaderModelSept(frame.getInvoices()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private InvoiceSept getInvoiceByNum(int num) {
        for (InvoiceSept inv : frame.getInvoices()) {
            if (num == inv.getNum()) {
                return inv;
            }
        }
        return null;
    }

    private void saveData() {
        String invoicesData = "";
        String linesData = "";
        for (InvoiceSept invoice : frame.getInvoices()) {
            invoicesData += invoice.toCSV();
            invoicesData += "\n";
            for (LineSept line : invoice.getLines()) {
                linesData += line.toCSV();
                linesData += "\n";
            }
        }

        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fc.getSelectedFile();
            result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File lineFile = fc.getSelectedFile();
                try {
                    FileWriter headerFW = new FileWriter(headerFile);
                    headerFW.write(invoicesData);
                    headerFW.flush();
                    headerFW.close();

                    FileWriter lineFW = new FileWriter(lineFile);
                    lineFW.write(linesData);
                    lineFW.flush();
                    lineFW.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error while saving data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void newInvoiceOK() {
        String customer = headerDialog.getCustNameField().getText();
        String date = headerDialog.getInvDateField().getText();
        headerDialog.setVisible(false);
        headerDialog.dispose();
        int num = getNextInvoiceNum();
        try {
            Date invDate = frame.sdf.parse(date);
            InvoiceSept inv = new InvoiceSept(num, customer, invDate);
            frame.getInvoices().add(inv);
            ((HeaderModelSept) frame.getInvoicesTable().getModel()).fireTableDataChanged();
        } catch (ParseException pex) {
            JOptionPane.showMessageDialog(frame, "Error in date format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getNextInvoiceNum() {
        int num = 1;
        for (InvoiceSept inv : frame.getInvoices()) {
            if (inv.getNum() > num) {
                num = inv.getNum();
            }
        }
        return num + 1;
    }

    private void newInvoiceCancel() {
        headerDialog.setVisible(false);
        headerDialog.dispose();
    }

    private void newLineOK() {
        int selectedInv = frame.getInvoicesTable().getSelectedRow();
        if (selectedInv != -1) {
            InvoiceSept inv = frame.getInvoices().get(selectedInv);
            String name = lineDialog.getItemNameField().getText();
            String priceStr = lineDialog.getItemPriceField().getText();
            String countStr = lineDialog.getItemCountField().getText();
            lineDialog.setVisible(false);
            lineDialog.dispose();
            double price = Double.parseDouble(priceStr);
            int count = Integer.parseInt(countStr);
            LineSept line = new LineSept(name, price, count, inv);
            inv.getLines().add(line);
            ((LineModelSept) frame.getLinesTable().getModel()).fireTableDataChanged();
            ((HeaderModelSept) frame.getInvoicesTable().getModel()).fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(selectedInv, selectedInv);
        }
    }

    private void newLineCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
    }

}
