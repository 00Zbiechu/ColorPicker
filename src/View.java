import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class View extends JFrame {
	

	private JPanel contentPane;
	public static JTable table;
	public static JButton btnNewButton;
	public static JButton btnNewButton_1;
	public static JButton btnNewButton_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	public static JTextArea txtrWprowadTekst;
	private JButton btnNewButton_3;

	//MVC
	Model model = new Model();


	public View() {
		
		
		setTitle("ColorPicker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_0 = new JPanel();
		contentPane.add(panel_0);
		
		table = new JTable(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setPreferredWidth(15);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(15);
		table.getColumnModel().getColumn(5).setPreferredWidth(15);
		table.getColumnModel().getColumn(6).setPreferredWidth(15);
		table.getColumnModel().getColumn(7).setPreferredWidth(15);

		panel_0.setLayout(new BoxLayout(panel_0, BoxLayout.X_AXIS));
		panel_0.add(table);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_0.add(horizontalStrut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		txtrWprowadTekst = new JTextArea();
		txtrWprowadTekst.setText("Wprowadź tekst...");
		panel_1.add(txtrWprowadTekst);
		txtrWprowadTekst.setRows(15);
		txtrWprowadTekst.setColumns(40);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Zmień kolor:");
		panel_2.add(lblNewLabel);

		ButtonGroup group = new ButtonGroup();

		rdbtnNewRadioButton = new JRadioButton("Zmień kolor tła");
		group.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Zmień kolor tekstu");
		group.add(rdbtnNewRadioButton_1);

		panel_2.add(rdbtnNewRadioButton);
		panel_2.add(rdbtnNewRadioButton_1);

		btnNewButton_3 = new JButton("Zatwierdź");
		panel_2.add(btnNewButton_3);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Opcje:");
		panel_3.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Ukryj paletę kolorów");
		panel_3.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Zmniejsz rozmiar tekstu");
		panel_3.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Zwiększ rozmiar tekstu");
		panel_3.add(btnNewButton_2);
	}

	//Metoda umożliwiająca dodanie listenera do przycisków - dodanie odbędzie się z klasy kontroler,
	// gdzie został utworzony listener
	public void addMyListener(ActionListener listener){

		btnNewButton.addActionListener(listener);
		btnNewButton_1.addActionListener(listener);
		btnNewButton_2.addActionListener(listener);



	}
	
	
	

}
