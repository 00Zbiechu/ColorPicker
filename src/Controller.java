import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    Model model;
    View view;

    Controller(Model model, View view){

        this.model = model;
        this.view = view;

        //Metoda dodająca mojego własnego nasłuchiwacza do buttonów w tabeli
        view.addMyListener(new MyListener());

    }

    //Klasa wewnętrzna, żebym miał dostęp do utworzonych viewTable i modelTable :)
    class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()== View.btnNewButton){

                model.hideColors(View.table, View.btnNewButton);

            }else if(e.getSource()==View.btnNewButton_1){

                model.decreaseFontSize(View.txtrWprowadTekst);

            }else if(e.getSource()==View.btnNewButton_2){

                model.increaseFontSize(View.txtrWprowadTekst);

            }

        }

    }


}
