import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public int inimenu() {
        Integer res = 0;
        boolean avanzar = false;

        Scanner in = new Scanner(System.in);

        while(avanzar == false)
        {
            System.out.println("1 - Buscar por codigo");
            System.out.println("2 - Buscar por nome");
            System.out.println("3 - sair");
            try
            {
                res = in.nextInt();
                avanzar = true;
            }
            catch(InputMismatchException err)
            {
                System.err.println("Valor inválido, intente nuevamente ingresando una de las ocpciones listadas.");
                //	in.next();
            }
        }

        return res;
    }
}