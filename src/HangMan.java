import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * HangMan
 */
public class HangMan {
  // private boolean complete;
  private Words setOfWords = null;
  private char[] auxCharsWord = null, auxHiddenWord = null;
  private String regex = "[a-z]";

  public HangMan(int theme) {
    // this.complete = false;
    this.setOfWords = new Words();
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

  public void showResults() {
    if (checkCompletion()) {
      JOptionPane.showMessageDialog(null, String.valueOf(auxHiddenWord), "YOU WON", JOptionPane.WARNING_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, String.valueOf(auxCharsWord), "YOU LOOSE", JOptionPane.WARNING_MESSAGE);
    }
  }

  private boolean checkCompletion() {
    boolean complete = true;
    for (int i = 0; i < auxHiddenWord.length; i++) {
      if (auxHiddenWord[i] == '*') {
        complete = false;
      }
    }
    return complete;
  }

  private char newChar(int round, int attempt) {
    String ans = "";
    ans = JOptionPane.showInputDialog(null,
        String.valueOf(auxHiddenWord),
        "--try: " + attempt + " --Round: " + round + " --Type in a letter: ",
        JOptionPane.INFORMATION_MESSAGE);
    while (!ans.matches(getRegex())) {
      if (!ans.matches(getRegex())) {
        ans = JOptionPane.showInputDialog(null, String.valueOf(auxHiddenWord),
            "Invalid input: alphabetic characters only",
            JOptionPane.WARNING_MESSAGE);
      }
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

  public void starGame() {
    int rounds = 1, tries = 3;
    while (!checkCompletion()) {
      if (!foundLetter(newChar(rounds, tries))) {
        tries--;
        if (tries <= 0) {
          tries = 5;
          fillUpString();
          rounds++;
          if (rounds > 3)
            break;
        }
      }
    }
  }

}
