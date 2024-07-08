package mainClasses.poo.git;

import javax.swing.JOptionPane;

/**
 * MenuPanel
 */
public class MenuPanel {
  private AhorcadoJuego newGame;

  public MenuPanel() {
  }

  public void userMenu() {
    int op = 1;
    while (op != 5) {
      op = Integer.parseInt(JOptionPane.showInputDialog(null,
          "Enter a number for the type of theme of the set for the words or press 5 to end the game",
          "\n1, \n2, \n3, \n4"));
      switch (op) {
        case 1:
        case 2:
        case 3:
        case 4:
          newGame = new AhorcadoJuego(op - 1);
          newGame.starGame();
          newGame.showResults();
          break;
        case 5: break;
        default:
          System.out.println("this option is not available for now");
      }
    }
  }

}