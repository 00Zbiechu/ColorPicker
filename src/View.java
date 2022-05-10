import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panelTable;
	private JButton tablicaBtn[] = new JButton[64];

	private JButton btnHideShow; //Ukryj/Pokaż paletę kolorów
	private JButton btnDecreaseFontSize; //Zmniejsz czcionkę
	private JButton btnIncreaseFontSize; //Zwiększ czcionkę
	private JRadioButton rdbtnChangeBackground; //Zmień tło
	private JRadioButton rdbtnChangeTextColor; //Zmień kolor tekstu
	private JTextArea txtrWprowadTekst; //Wprowadzanie tekstu
	private JButton btnCommit; //Zatwierdź


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
		
		panelTable = new JPanel();
			panelTable.setLayout(new GridLayout(17,4,2,2));
		panelTable.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		panel_0.setLayout(new BoxLayout(panel_0, BoxLayout.X_AXIS));
		panel_0.add(panelTable);

		for (int i=0; i<64;i++){

			JButton button = new JButton();
			button.setBackground(new Color(rand(0,255),rand(0,255),rand(0,255)));
			button.addActionListener(new MyColorListener());
			tablicaBtn[i] = button;
			panelTable.add(button);

		}
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_0.add(horizontalStrut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		txtrWprowadTekst = new JTextArea();
		txtrWprowadTekst.setLineWrap(true);
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

		rdbtnChangeBackground = new JRadioButton("Zmień kolor tła");
		group.add(rdbtnChangeBackground);
		
		rdbtnChangeTextColor = new JRadioButton("Zmień kolor tekstu");
		group.add(rdbtnChangeTextColor);

		panel_2.add(rdbtnChangeBackground);
		panel_2.add(rdbtnChangeTextColor);

		btnCommit = new JButton("Zatwierdź");
		panel_2.add(btnCommit);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Opcje:");
		panel_3.add(lblNewLabel_1);
		
		btnHideShow = new JButton("Ukryj paletę kolorów");
		panel_3.add(btnHideShow);
		
		btnDecreaseFontSize = new JButton("Zmniejsz rozmiar tekstu");
		panel_3.add(btnDecreaseFontSize);
		
		btnIncreaseFontSize = new JButton("Zwiększ rozmiar tekstu");
		panel_3.add(btnIncreaseFontSize);

		//Dodawanie nasłuchwiaczy, które nie były dodane w WindowBuilder
		addListener(btnHideShow);
		addListener(btnDecreaseFontSize);
		addListener(btnIncreaseFontSize);
		addListener(btnCommit);

	}


	private int rand(int min, int max){

		return (int) ((Math.random()*(max-min))+min);
	}

	private void addListener(JButton button){

		button.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()== btnHideShow){

			Logic.hideColors(panelTable,btnHideShow);

		}else if(e.getSource()==btnDecreaseFontSize){

			Logic.decreaseFontSize(txtrWprowadTekst);

		}else if(e.getSource()==btnIncreaseFontSize){

			Logic.increaseFontSize(txtrWprowadTekst);

		}else if(e.getSource()==btnCommit && rdbtnChangeBackground.isSelected()){

			Logic.changeBackgroundColor(txtrWprowadTekst);

		}else if(e.getSource()==btnCommit && rdbtnChangeTextColor.isSelected()){

			Logic.changeFontColor(txtrWprowadTekst);

		}

	}

	//Nasłuchiwacz tablicy buttonów (jeśli wystąpi zdarzenie, to przemieszcza się po wszystkich elementach pętli
	// i sprawdza gdzie źródło
	class MyColorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			for(int i=0;i<64;i++){

				if(e.getSource()==tablicaBtn[i]){

					Logic.changeDefaultColor(tablicaBtn[i].getBackground());

				}

			}

		}

	}

}
