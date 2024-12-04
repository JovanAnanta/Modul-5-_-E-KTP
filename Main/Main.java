package Main;

import Controller.*;
import Model.*;
import View.*;

public class Main {
    public static void main(String[] args) {
        KTP model = new KTP();
        FormInput view = new FormInput();
        Controller controller = new Controller(model, view);

        view.setVisible(true);
    }
}
