import java.util.Random;

public class Words {
  private String[][] newSetWords;
  private final String setWords[][] = {
      { "Python", "Java", "CCS", "Cobol", "JavaScript", "React", "NodeJS" },
      { "logic", "binary", "programming", "variable", "array", "structure" },
      { "mathematics", "algebra", "calculus", "trigonometry", "estadistic" },
      { "motherboard", "cpu", "memory", "hardware", "interface", "driver" }
  };

  public Words() {
  }

  public Words(String[][] setWords) {
    this.newSetWords = setWords;
  }

  public String[][] getWords() {
    return this.newSetWords;
  }

  public String getWord(int pos) {
    Random randomNumber = new Random();
    return setWords[pos][randomNumber.nextInt(5)];
  }

}
