
import java.util.Arrays;
import javax.swing.JOptionPane;

public class AhorcadoJuego {
  private boolean complete;
  private Words setOfWords = null;
  private char[] auxCharsWord = null, auxHiddenWord = null;
  private String regex = "[a-z]";

  public AhorcadoJuego(int theme) {
    this.setOfWords = new Words();
    this.complete = false;
    this.auxCharsWord = setOfWords.getWord(theme - 1).toLowerCase().toCharArray();
    this.auxHiddenWord = new char[auxCharsWord.length];
    fillUpString();
  }

  private void fillUpString() {
    Arrays.fill(auxHiddenWord, '*');
  }

  public String getRegex() {
    return regex;
  }

  private void checkCompletion() {
    complete = true;
    for (int i = 0; i < auxHiddenWord.length; i++) {
      if (auxHiddenWord[i] == '*') {
        complete = false;
      }
    }
  }

  private char newChar(int round, int att) {
    String ans = "";
    ans = JOptionPane.showInputDialog(null,
    String.valueOf(auxHiddenWord),
    "\ntry: " + att + " Round: " + round + " Type in a letter: ",
    JOptionPane.INFORMATION_MESSAGE);
    while (!ans.matches(regex)) {
      if (!ans.matches(regex)) {
        ans = JOptionPane.showInputDialog(null, String.valueOf(auxHiddenWord), "Invalid input: try again", JOptionPane.WARNING_MESSAGE);
      }
      System.out.println(ans.matches(regex));
    }
    return ans.toCharArray()[0];
  }

  private boolean foundLetter(char letter) {
    boolean found = false;
    for (int i = 0; i < auxCharsWord.length; i++) {
      if (auxCharsWord[i] == letter && auxHiddenWord[i] == '*') {
        auxHiddenWord[i] = letter;
        found = true;
      }
    }
    return found;
  }

  public void showResults() {
    if (complete) {
      JOptionPane.showMessageDialog(null, String.valueOf(auxHiddenWord), "YOU WON", JOptionPane.WARNING_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, String.valueOf(auxCharsWord), "YOU LOOSE", JOptionPane.WARNING_MESSAGE);
    }
  }

  public void starGame() {
    int rounds = 1, tries = 3;
    while (!complete) {
      if (!foundLetter(newChar(rounds, tries))) {
        tries--;
        if (tries <= 0) {
          tries = 5;
          fillUpString();
          rounds++;
          if (rounds > 3)
            break;
        }
      } else
        checkCompletion();
    }
  }

}
