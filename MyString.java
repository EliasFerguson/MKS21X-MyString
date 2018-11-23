public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  String indexProblem = "Index must be greater than 0 and less than the length of the CharSequence.";
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
    return this.data.length;
  }
  public CharSequence subSequence(int start, int end) {

  }
  public String toString() {
    String output = "";
    for (int i = 0; i < data.length; i++) {
      output += data[i];
    }
    return output;
  }
}
