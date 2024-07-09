import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 * PanelMenu
 */
public class PanelMenu {
  private HangMan newGame;

  public PanelMenu() {
  }

  public void userMenu() {
    int op = 0;
    while (op != 5) {
      try {
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "GAME HAS STARTED!",
            "<1 | 2 | 3 | 4> or press <5> to end the game"));
        switch (op) {
          case 1:
          case 2:
          case 3:
          case 4:
            newGame = new HangMan(op);
            newGame.starGame();
            newGame.showResults();
            break;
          case 5:
            break;
          default:
            System.out.println("this option is not available for now");
        }
      } catch (NumberFormatException | InputMismatchException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}