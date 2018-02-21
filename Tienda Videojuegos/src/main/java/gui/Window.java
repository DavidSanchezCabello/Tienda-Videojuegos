package main.java.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	JTabbedPane pesta�as = new JTabbedPane();
	
	JPanel pnVid = new JPanel();
	JPanel pnCli = new JPanel();
	JPanel pnVent = new JPanel();
	JButton btnNuevo = new JButton("NUEVO");
	JButton btnBorrar = new JButton("BORRAR");
	JButton btnModi = new JButton("MODIFICAR");
	JButton btnVer = new JButton("VER");
	
	JTable tabla1 = new JTable();
	JScrollPane scroll = new JScrollPane(tabla1);
	
	public Window() {
		setLayout(null);
		setTitle("Men�");
		//add(scroll);
		//pack();
		pesta�as.setBounds(60, 0, 500, 500);
		pesta�as.addTab("Videojuegos", pnVid);
		pesta�as.addTab("Clientes", pnCli);
		pesta�as.addTab("Ventas", pnVent);
		add(pesta�as);
		
		//pnVid.add(scroll);
		
		btnNuevo.setBounds(5, 20, 50, 50);
		//icono al bot�n
		ImageIcon img = new ImageIcon("nuevo.png");
		btnNuevo.setIcon(img);
		
		btnBorrar.setBounds(5, 80, 50, 50);
		ImageIcon img2 = new ImageIcon("borrar.png");
		btnBorrar.setIcon(img2);
		
		btnVer.setBounds(5, 140, 50, 50);
		ImageIcon img3 = new ImageIcon("ver.png");
		btnVer.setIcon(img3);
		
		btnModi.setBounds(5, 200, 50, 50);
		ImageIcon img4 = new ImageIcon("modi.png");
		btnModi.setIcon(img4);
		
		add(btnNuevo);
		add(btnBorrar);
		add(btnVer);
		add(btnModi);

		
		
		scroll.setPreferredSize(new Dimension(400, 150));
		//add(scroll, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		//setResizable(false);
	}

	

}