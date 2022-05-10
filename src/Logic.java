import javax.swing.*;
import java.awt.*;

public class Logic {

    public static Color color = Color.BLACK;

    public static void hideColors(JPanel panel,JButton jButton){

        if(panel.isVisible()){

            panel.setVisible(false);
            jButton.setText("Pokaż paletę kolorów");

        }else{

            panel.setVisible(true);
            jButton.setText("Ukryj paletę kolorów");

        }

    }

    public static void increaseFontSize(JTextArea textArea){

        float size = textArea.getFont().getSize();
        size = size+1;

        Font smaller = textArea.getFont().deriveFont(size);
        textArea.setFont(smaller);

    }

    public static void decreaseFontSize(JTextArea textArea){

        float size = textArea.getFont().getSize();
        size = size-1;

        Font smaller = textArea.getFont().deriveFont(size);
        textArea.setFont(smaller);

    }

    //Zmiana domyślnego koloru możliwa z poziomu innej klasy
    public static void changeDefaultColor(Color colorButton){
        color = colorButton;
    }


    public static void changeBackgroundColor(JTextArea textArea){

        textArea.setBackground(color);

    }

    public static void changeFontColor(JTextArea textArea){

        textArea.setForeground(color);

    }

}
