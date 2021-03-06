/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.Data;
import Engine.DataUtil;
import Engine.Main;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Poowis
 */
public class ControlPanel extends javax.swing.JPanel {

    private Main main;
    private JTable table;
    private Data result;

    /**
     * Creates new form ControlPanel
     */
    public ControlPanel(Main main, JTable table) {
        this.main = main;
        this.table = table;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        applyOutput = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        alert = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selects = new javax.swing.JTextArea();
        selectsApply = new javax.swing.JButton();
        avg = new javax.swing.JCheckBox();
        mean = new javax.swing.JCheckBox();
        mode = new javax.swing.JCheckBox();
        max = new javax.swing.JCheckBox();
        min = new javax.swing.JCheckBox();
        sd = new javax.swing.JCheckBox();
        variance = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(300, 500));
        setPreferredSize(new java.awt.Dimension(300, 500));

        applyOutput.setText("Apply");
        applyOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyOutputActionPerformed(evt);
            }
        });

        header.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        header.setText("Control Panel");

        alert.setEditable(false);
        alert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setText("Interest Points");

        selects.setColumns(20);
        selects.setRows(5);
        selects.setText("Sample:\ntime = Mon\nid = 607.*\nsale > 100\nsale -10 - -20\n\n");
        jScrollPane1.setViewportView(selects);

        selectsApply.setText("Apply");
        selectsApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectsApplyActionPerformed(evt);
            }
        });

        avg.setSelected(true);
        avg.setText("Average");

        mean.setSelected(true);
        mean.setText("Mean");

        mode.setSelected(true);
        mode.setText("Mode");

        max.setSelected(true);
        max.setText("Max");

        min.setSelected(true);
        min.setText("Min");

        sd.setSelected(true);
        sd.setText("Standard deviation");

        variance.setSelected(true);
        variance.setText("Variance");

        jLabel4.setText("Process into");

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 218, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(header)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(alert, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(variance)
                    .addComponent(sd)
                    .addComponent(avg)
                    .addComponent(mode)
                    .addComponent(mean)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(min)
                        .addGap(18, 18, 18)
                        .addComponent(max))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectsApply)
                        .addGap(18, 18, 18)
                        .addComponent(Clear))
                    .addComponent(applyOutput))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectsApply)
                    .addComponent(Clear))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(max)
                    .addComponent(min))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(variance)
                .addGap(13, 13, 13)
                .addComponent(applyOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        applyOutput.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void applyOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyOutputActionPerformed
        // TODO add your handling code here:
        JFrame popup = new JFrame();
        GridLayout gl = new GridLayout(0, 2);
        System.out.println(gl.getHgap());
        JPanel pn = new JPanel(gl);
        JScrollPane scp = new JScrollPane(pn);
        scp.setPreferredSize(new Dimension(500, 500));
        popup.add(scp);
        applySettings();
        Data dt;
        if (result == null) {
            dt = main.getCurrentWS().getData();
        } else {
            dt = result;
        }
        for (int i = 0; i < dt.getMetaInfo().size(); i++) {
            if (dt.get(0, i) instanceof Double) {
                pn.add(new JLabel(dt.getMetaInfo(i)));
                pn.add(new JLabel());
                HashMap<String, Object> ans = DataUtil.calAll(dt.getCol(i));
                if ((boolean) getSettings().get("min")) {
                    pn.add(new JLabel("  Min"));
                    pn.add(new JLabel(ans.get("min").toString()));
                }
                if ((boolean) getSettings().get("max")) {
                    pn.add(new JLabel("  Max"));
                    pn.add(new JLabel(ans.get("max").toString()));
                }
                if ((boolean) getSettings().get("avg")) {
                    pn.add(new JLabel("  Average"));
                    pn.add(new JLabel(String.format("%.4f", ans.get("avg"))));
                }
                if ((boolean) getSettings().get("mean")) {
                    pn.add(new JLabel("  Mean"));
                    pn.add(new JLabel(String.format("%.4f", ans.get("mean"))));
                }
                if ((boolean) getSettings().get("mode")) {
                    ArrayList<Object> mode = (ArrayList<Object>) ans.get("mode");
                    pn.add(new JLabel("  Mode at " + mode.get(0) + " times"));
                    mode.remove(0);
                    pn.add(new JLabel(ans.get("mode").toString().replaceAll("\\[|\\]", "")));
                }
                if ((boolean) getSettings().get("sd")) {
                    pn.add(new JLabel("  Standard deviation   "));
                    pn.add(new JLabel(String.format("%.4f", ans.get("sd"))));
                }
                if ((boolean) getSettings().get("variance")) {
                    pn.add(new JLabel("  Variance"));
                    pn.add(new JLabel(String.format("%.4f", ans.get("variance"))));
                }
            }
        }
        popup.pack();
        popup.setLocationRelativeTo(null);
        popup.setVisible(true);
    }//GEN-LAST:event_applyOutputActionPerformed

    private void selectsApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectsApplyActionPerformed
        // TODO add your handling code here:
        applySettings();
    }//GEN-LAST:event_selectsApplyActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        selects.setText("");
        result = null;
        setTable(main.getCurrentWS().getData());
    }//GEN-LAST:event_ClearActionPerformed

    private void applySettings() {
        result = DataUtil.select(main.getCurrentWS().getData(), selects.getText());
        setTable(result);
        main.getCurrentWS().setSettings(getSettings());
    }

    public void alert(String text) {
        alert.setText(text);
    }

    private void setTable(Data data) {
        DefaultTableModel model = new DefaultTableModel();
        for (Object column : data.getMetaInfo()) {
            model.addColumn(column);
        }
        for (int i = 0; i < data.getDataSize().get(0); i++) {
            model.addRow(new Object[0]);
            for (int j = 0; j < data.getDataSize().get(1); j++) {
                model.setValueAt(data.get(i, j), i, j);
            }
        }
        table.setModel(model);
    }

    public HashMap<String, Object> getSettings() {
        HashMap settings = new HashMap();
        settings.put("selects", selects.getText());
        settings.put("min", min.isSelected());
        settings.put("max", max.isSelected());
        settings.put("avg", avg.isSelected());
        settings.put("mean", mean.isSelected());
        settings.put("mode", mode.isSelected());
        settings.put("sd", sd.isSelected());
        settings.put("variance", variance.isSelected());
        return settings;
    }

    public void setSettings(HashMap<String, Object> settings) {
        selects.setText((String) settings.get("selects"));
        min.setSelected((boolean) settings.get("min"));
        max.setSelected((boolean) settings.get("max"));
        avg.setSelected((boolean) settings.get("avg"));
        mean.setSelected((boolean) settings.get("mean"));
        mode.setSelected((boolean) settings.get("mode"));
        sd.setSelected((boolean) settings.get("sd"));
        variance.setSelected((boolean) settings.get("variance"));
    }

    public void setDefault() {
        selects.setText("Sample\n"
                + "score = 0\n"
                + "score > 50\n"
                + "score <= 100\n"
                + "name == jame *Note compare exact String\n"
                + "name = A.* *Note compare using Regex\n");
        min.setSelected(true);
        max.setSelected(true);
        avg.setSelected(true);
        mean.setSelected(true);
        mode.setSelected(true);
        sd.setSelected(true);
        variance.setSelected(true);
    }

    public void setHeader() {
        header.setText(main.getCurrentWS().toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JTextField alert;
    private javax.swing.JButton applyOutput;
    private javax.swing.JCheckBox avg;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox max;
    private javax.swing.JCheckBox mean;
    private javax.swing.JCheckBox min;
    private javax.swing.JCheckBox mode;
    private javax.swing.JCheckBox sd;
    private javax.swing.JTextArea selects;
    private javax.swing.JButton selectsApply;
    private javax.swing.JCheckBox variance;
    // End of variables declaration//GEN-END:variables
}
