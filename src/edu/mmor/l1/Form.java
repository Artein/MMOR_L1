/*
 * Created by JFormDesigner on Tue Sep 10 20:40:04 EEST 2013
 */

package edu.mmor.l1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author DTSHNICK DTSHNICK
 */
public class Form extends JFrame {
    public Form() {
        initComponents();
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (comboBox1.getSelectedIndex()==0)
        {
            textField1.setText("[-0.5; 0.5] max");
        }
        else
        {
            textField1.setText("[-0.2; 0.95] max");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - DTSHNICK DTSHNICK
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u0424\u0443\u043d\u043a\u0446\u0438\u044f");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel(new String[] {
            "\u0424\u0443\u043d\u043a\u0446\u0438\u044f \u211610",
            "\u0424\u0443\u043d\u043a\u0446\u0438\u044f \u211613"
        }));
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                comboBox1ItemStateChanged(e);
            }
        });

        //---- textField1 ----
        textField1.setText("[-0.5; 0.5] max");

        //---- label2 ----
        label2.setText("\u0418\u043d\u0442\u0435\u0440\u0432\u0430\u043b \u0438 \u044d\u043a\u0441\u0442\u0440\u0435\u043c\u0443\u043c");

        //---- label3 ----
        label3.setText("Eps");

        //---- textField2 ----
        textField2.setText("0.001");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(label3))
                    .addContainerGap(214, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main (String[] args)
    {
        new Form().setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - DTSHNICK DTSHNICK
    private JLabel label1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
