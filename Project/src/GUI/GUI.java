/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.Data;
import Engine.Main;
import Engine.WorkSpace;
import Exception.FileException;
import InputAndOutput.MainIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Poowis
 */
public class GUI extends JFrame {

    Main main;

    JMenuBar mb;
    JMenu file, loadWS, data;
    JMenuItem newWS, importWS, exportWS, save, saveExit;
    JMenuItem importData, updateData;

    ControlPanel ctpn;
    JScrollPane scrollPane;
    JTable table;
    JTextField alert;
    JLabel control;

    public void init() {

//Load Main
        try {
            main = MainIO.loadMain();
        } catch (FileException | IOException | ClassNotFoundException ex) {
            main = new Main();
        }

//Menu Bar
        mb = new JMenuBar();

        file = new JMenu("File");
        newWS = new JMenuItem("New WorkSpace");
        loadWS = new JMenu("Load Recent WorkSpace");
        importWS = new JMenuItem("Import WorkSpace");
        exportWS = new JMenuItem("Export WorkSpace");
        save = new JMenuItem("Save");
        saveExit = new JMenuItem("Save and Exit");

        mb.add(file);
        file.add(newWS);
        file.add(loadWS);
        file.add(importWS);
        file.add(exportWS);
        file.add(new JSeparator());
        file.add(save);
        file.add(saveExit);

        data = new JMenu("Data");
        importData = new JMenuItem("Import Data");
        updateData = new JMenuItem("Refresh Data");
        mb.add(data);
        data.add(importData);
        data.add(updateData);

        setJMenuBar(mb);

//Table
        table = new JTable();
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        add(scrollPane);

//Control Panel
        ctpn = new ControlPanel(main, table);
        add(ctpn, BorderLayout.EAST);

//Set JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Data");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);

//Add Action
        newWS.addActionListener((ActionEvent evt) -> {
            main.getCurrentWS().setSettings(ctpn.getSettings());
            try {
                main.newWS();
                update();
            } catch (FileException | IOException ex) {
                ctpn.alert(ex.toString());
            }
        });
        importWS.addActionListener((ActionEvent evt) -> {
            main.getCurrentWS().setSettings(ctpn.getSettings());
            try {
                String path = getWSPath("Import WorkSpace", "Import");
                if (path != null) {
                    main.importWS(path);
                    update();
                }
            } catch (FileException | IOException | ClassNotFoundException ex) {
                ctpn.alert(ex.toString());
            }
        });
        exportWS.addActionListener((ActionEvent evt) -> {
            try {
                String path = getWSPath("Export WorkSpace", "Export");
                if (path != null) {
                    main.exportWS(path);
                }
            } catch (FileException | IOException | ClassNotFoundException ex) {
                ctpn.alert(ex.toString());
            }
        });
        save.addActionListener((ActionEvent evt) -> {
            try {
                MainIO.saveMain(main);
            } catch (IOException ex) {
                ctpn.alert(ex.toString());
            }
        });
        saveExit.addActionListener((ActionEvent evt) -> {
            try {
                MainIO.saveMain(main);
                System.exit(0);
            } catch (IOException ex) {
                ctpn.alert(ex.toString());
            }
        });
        importData.addActionListener((ActionEvent evt) -> {
            try {
                String path = getDataPath("Import Data", "Import");
                if (path != null) {
                    main.importData(path);
                    update();
                }
            } catch (FileException | IOException ex) {
                ctpn.alert(ex.toString());
            }
        });
        updateData.addActionListener((ActionEvent evt) -> {
            try {
                main.update();
                update();
            } catch (FileException | IOException ex) {
                ctpn.alert(ex.toString());
            }
        });
        update();
    }

    private void updateCtPn() {
        if (main.getCurrentWS() != null && main.getCurrentWS().getSettings() != null) {
            ctpn.setSettings(main.getCurrentWS().getSettings());
        } else {
            ctpn.setDefault();
        }
    }

    private void updateTable() {
        if (main.getCurrentWS() != null && main.getCurrentWS().getData() != null) {
            Data dt = main.getCurrentWS().getData();
            DefaultTableModel model = new DefaultTableModel();
            for (Object column : dt.getMetaInfo()) {
                model.addColumn(column);
            }
            for (int i = 0; i < dt.getDataSize().get(0); i++) {
                model.addRow(new Object[0]);
                for (int j = 0; j < dt.getDataSize().get(1); j++) {
                    model.setValueAt(dt.get(i, j), i, j);
                }
            }
            table.setModel(model);
        } else {
            table.setModel(new DefaultTableModel());
        }
    }

    private HashMap<JMenuItem, Integer> WSmap;

    private void updateRecentWS() {
        WSmap = new HashMap<>();
        loadWS.removeAll();
        Integer i = 0;
        for (WorkSpace ws : main.getRecentWS()) {
            JMenuItem jmi = new JMenuItem(ws.toString());      
            loadWS.add(jmi, 0);
            WSmap.put(jmi, i++);
            jmi.addActionListener((ActionEvent evt) -> {
                main.getCurrentWS().setSettings(ctpn.getSettings());
                try {
                    main.loadWS(WSmap.get((JMenuItem) evt.getSource()));
                    update();
                } catch (IOException | FileException ex) {
                    ctpn.alert("cannot load WorkSpace");
                }
            });
        }
    }

    private void update() {
        updateTable();
        updateRecentWS();
        updateCtPn();
        ctpn.setHeader();
        
    }

    private String getWSPath(String dialog, String button) {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jf.setFileFilter(new FileNameExtensionFilter("WorkSpace", "ws"));
        jf.setDialogTitle(dialog);
        jf.setApproveButtonText(button);
        if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return jf.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    private String getDataPath(String dialog, String button) {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jf.setFileFilter(new FileNameExtensionFilter("Data .csv .excel", "csv", "xlsx", "xls"));
        jf.setDialogTitle(dialog);
        jf.setApproveButtonText(button);
        if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return jf.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    public static void main(String[] args) {
        GUI obj = new GUI();
        obj.init();
    }

}
