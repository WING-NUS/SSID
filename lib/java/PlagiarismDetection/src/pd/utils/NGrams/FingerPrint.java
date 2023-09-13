package pd.utils.NGrams;

import java.math.BigInteger;

public class FingerPrint {
  private BigInteger hash;
  private NGram nGram;
  private int window;
  private int indexWithinWindow;
  private int line;

  public FingerPrint() {

  }
  

  public FingerPrint(BigInteger hash, NGram nGram, int window, int indexWithinWindow) {
    this.hash = hash;
    this.nGram = nGram;
    this.window = window;
    this.indexWithinWindow = indexWithinWindow;
    this.line = nGram.getCodeStartLine();
  }

  public BigInteger getHash() {
    return hash;
  }

  public void setHash(BigInteger hash) {
    this.hash = hash;
  }

  public int getWindow() {
    return window;
  }

  public void setWindow(int window) {
    this.window = window;
  }

  public int getLine() {
    return line;
  }

  public void setLine(int line) {
    this.line = line;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    FingerPrint fingerPrint = (FingerPrint) obj;

    return this.nGram.equals(fingerPrint.getnGram()) && this.window == fingerPrint.getWindow() && this.indexWithinWindow == fingerPrint.getIndexWithinWindow();
  }

  @Override
  public String toString() {
    String result = String.format("NGram: %s, line: %d, window: %d, index: %d, hash: %d", nGram.nGramValue(), line, window, indexWithinWindow, hash);
    return result;
  }


  public NGram getnGram() {
    return nGram;
  }

  public void setnGram(NGram nGram) {
    this.nGram = nGram;
  }

  public int getIndexWithinWindow() {
    return indexWithinWindow;
  }

  public void setIndexWithinWindow(int indexWithinWindow) {
    this.indexWithinWindow = indexWithinWindow;
  }

}
