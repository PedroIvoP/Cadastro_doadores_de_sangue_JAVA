package APP;

import MODEL.Doador;
import VIEW.Menu;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Doador> doadores = new ArrayList<>();

        Menu.Principal(doadores);
    }

}


