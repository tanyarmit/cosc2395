package com.rmit.javaparadisegui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayImage extends JPanel {

  public static void main(String[] args) {
    JFrame jf = new JFrame("testing showing an image");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setBounds(10, 10, 200, 200);
    JTextField tf = new JTextField(10);
    String fileName = "images/cross.gif";
    ImageIcon icon = new ImageIcon(fileName);
    if (icon == null)
      tf.setText("icon = null");
    else
      tf.setText("icon != null");

    JLabel lblFrame = new JLabel("Looking for icon");
    lblFrame.setIcon(icon);
    jf.add(lblFrame, BorderLayout.CENTER);
    jf.add(tf, BorderLayout.SOUTH);
    jf.setVisible(true);
    // JOptionPane.showMessageDialog(
    // null,
    // fileName,
    // "Java Paradise", JOptionPane.INFORMATION_MESSAGE,
    // icon);

  }
}
