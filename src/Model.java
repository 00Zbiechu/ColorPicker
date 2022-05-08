import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.Random;

public class Model extends AbstractTableModel {

    private byte rowNumber = 8;
    private byte colNumber = 8;

    private Object cell[][] = new Object[rowNumber][colNumber];
    private String[] labelForTableColumns = {"","","","","","","",""};

    Model(){

        fillTableColors();

    }

    public void fillTableColors() {

        for (int i = 0; i < rowNumber; i++) {

            for (int j = 0; j < colNumber; j++) {

                //Obiekt generatora liczba pseudolosowych
                Random rand = new Random();

                //Losowanie wartości RGB
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();


                cell[i][j]="";


            }
        }
    }


    @Override
    public int getRowCount() {
        return rowNumber;
    }

    @Override
    public int getColumnCount() {
        return colNumber;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return cell[i][i1];
    }

    public void hideColors(JTable table,JButton jButton){

        if(table.isVisible()){

            table.setVisible(false);
            jButton.setText("Pokaż paletę kolorów");

        }else{

            table.setVisible(true);
            jButton.setText("Ukryj paletę kolorów");

        }

    }

    public void increaseFontSize(JTextArea textArea){

        float size = textArea.getFont().getSize();
        size = size+1;

        Font smaller = textArea.getFont().deriveFont(size);
        textArea.setFont(smaller);

    }

    public void decreaseFontSize(JTextArea textArea){

        float size = textArea.getFont().getSize();
        size = size-1;

        Font smaller = textArea.getFont().deriveFont(size);
        textArea.setFont(smaller);

    }

}
