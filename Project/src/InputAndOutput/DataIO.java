/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndOutput;

import Exception.FileException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Poowis
 */
public class DataIO {

    public DataIO() {

    }

    public static ArrayList<ArrayList<Object>> getData(String path) throws FileNotFoundException, IOException, FileException {
        File file = new File(path);
        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        if (file.exists()) {
            String ext = FilenameUtils.getExtension(path);
            if (ext.equalsIgnoreCase("csv")) {
                try (BufferedReader input = new BufferedReader(new FileReader(file));) {
                    String line;
                    line = input.readLine();
                    if (line == null) {
                        throw new FileException("File is Empty");
                    }
                    ArrayList<Object> meta = new ArrayList<>();
                    for (String value : line.split(",")) {
                        value = ((String) value).strip();
                        value = ((String) value).replaceAll("^\"|\"$", "");
                        meta.add(value);
                    }
                    data.add(meta);
                    while ((line = input.readLine()) != null) {
                        ArrayList<Object> row = new ArrayList<>();
                        for (Object value : line.split(",")) {
                            try {
                                value = Double.parseDouble((String) value);
                                row.add(value);
                            } catch (NumberFormatException ex) {
                                value = ((String) value).strip();
                                value = ((String) value).replaceAll("^\"|\"$", "");
                                row.add(value);
                            }
                        }
                        data.add(row);
                    }
                }
            } else if (ext.equalsIgnoreCase("xls") || ext.equalsIgnoreCase("xlsx")) {
                try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));) {
                    String s = (String) JOptionPane.showInputDialog(null, "Please Insert excel sheet number", "Excel sheet", JOptionPane.PLAIN_MESSAGE);
                    Integer page;
                    XSSFSheet sheet;
                    try {
                        page = Integer.parseInt(s) - 1;
                    } catch (Exception ex) {
                        throw new FileException("That is not a number");
                    }
                    try {
                        sheet = workbook.getSheetAt(page);
                    } catch (Exception ex) {
                        throw new FileException("Sheet does not Exist");
                    }
                    Row row0 = sheet.getRow(0);
                    ArrayList<Object> rowA = new ArrayList<>();
                    for (Cell cell : row0) {
                        String value;
                        value = cell.toString().strip();
                        value = ((String) value).replaceAll("^\"|\"$", "");
                        rowA.add(value);
                    }
                    data.add(rowA);
                    sheet.removeRow(row0);
                    for (Row row : sheet) {
                        rowA = new ArrayList<>();
                        for (Cell cell : row) {
                            Object value;
                            try {
                                value = Double.parseDouble(cell.toString());
                                rowA.add(value);
                            } catch (NumberFormatException ex) {
                                value = cell.toString().strip();
                                value = ((String) value).replaceAll("^\"|\"$", "");
                                rowA.add(value);
                            }
                        }
                        data.add(rowA);
                    }
                }
            }
        } else {
            throw new FileException("File does not exist");
        }
        return data;
    }

}
