/*
 * Created by JFormDesigner on Tue Sep 10 20:40:04 EEST 2013
 */

package edu.mmor.l1;

import edu.mmor.l1.Functions.Function10;
import edu.mmor.l1.Functions.Function13;
import edu.mmor.l1.MethodsOfOptimization.GoldMethod;

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

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        if (comboBox1.getSelectedIndex() == 0) {
            double x = new GoldMethod(-0.5, 0.5, Double.parseDouble(textField2.getText())).calculate(new Function10());
            textArea1.setText("Корень функции: " + x);
            textArea1.setText(textArea1.getText() + "\nЗначение функции:" + new Function10().calculate(x));
        } else {
            double x = new GoldMethod(0.2, 0.95, Double.parseDouble(textField2.getText())).calculate(new Function13());
            textArea1.setText("Корень функции: " + x);
            textArea1.setText(textArea1.getText() + "\nЗначение функции:" + new Function13().calculate(x));
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
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        //---- button1 ----
        button1.setText("\u041c\u0435\u0442\u043e\u0434 \u0437\u043e\u043b\u043e\u0442\u043e\u0433\u043e \u0441\u0435\u0447\u0435\u043d\u0438\u044f");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
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
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(button1)
                        .addComponent(scrollPane1))
                    .addContainerGap(7, Short.MAX_VALUE))
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addContainerGap())
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
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
