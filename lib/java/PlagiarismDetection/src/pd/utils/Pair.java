package pd.utils;

import java.util.Objects;

public class Pair {
  private int first;
  private int second;

  public Pair() {

  }

  public Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }

  public int getFirst() {
    return first;
  }

  public void setFirst(int first) {
    this.first = first;
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second) + Objects.hash(second, first);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Pair other = (Pair) obj;

    return (this.first == other.getFirst() && this.second == other.getSecond())
      || (this.first == other.getSecond() && this.second == other.getFirst());
  }

  @Override
  public String toString() {
    String result = String.format("Pair idx01: %d, idx02: %d", this.first, this.second);
    return result;
  }  

  
  




  
}
