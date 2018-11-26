public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  String indexProblem = "Index must be greater than 0 and less than the length of the CharSequence.";
  String badInput = "Your end index is less than your start index that is not allowed.";
  String nullBad = "Null inputs are not allowed.";
  public MyString(CharSequence s) {
    data = new char[s.length()];
    for (int i = 0 ; i < s.length(); i++) {
      data[i] = s.charAt(i);
    }
  }
  public char charAt(int idx) {
    if (idx < 0 || idx > (data.length - 1)) {
      throw new IndexOutOfBoundsException(indexProblem);
    }
    else {
      return data[idx];
    }
  }
  public int length() {
    return data.length;
  }
  public CharSequence subSequence(int start, int end) {
    String output = "";
    int len = data.length - 1;
    if ((start < 0 || end < 0) || (start > len || end > len)) {
      throw new IndexOutOfBoundsException(indexProblem);
    }
    else if (start > end) {
      throw new IllegalArgumentException(badInput);
    }
    else {
      for (int i = start; i < end; i++) {
        output += this.charAt(i);
      }
    }
    return output;
  }
  public String toString() {
    String output = "";
    for (int i = 0; i < data.length; i++) {
      output += data[i];
    }
    return output;
  }
  public int compareTo(CharSequence input) {
    if (input == null || this == null) {
      throw new NullPointerException(nullBad);
    }
    int[] x = toASCII(this);
    int[] y = toASCII(input);
    for (int i = 0; i < Math.min(x.length, y.length); i++) {
      if (x[i] < y[i]) {
        return -1;
      }
      else if (x[i] > y[i]) {
        return 1;
      }
    }
    if (x.length > y.length) {
      return 1;
    }
    if (x.length < y.length) {
      return -1;
    }
    return 0;
  }
  public int[] toASCII(CharSequence input) {
    int[] returner = new int[input.length()];
    for (int i = 0; i < returner.length; i++) {
      int inQ = input.charAt(i);
      returner[i] = inQ;
    }
    return returner;
  }
}
