public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  String indexProblem = "Index must be greater than 0 and less than the length of the CharSequence.";
  String badInput = "Your end index is less than your start index that is not allowed.";
  String nullBad = "Null inputs are not allowed.";
  public static void main(String[] args) {

    // sole constructor test
    MyString msg = new MyString("droid");
    System.out.println("MyString msg = new MyString(\"charlotte\")");

    // toString()
    System.out.println("msg: " + msg);                                                  // "droid"

    // length()
    System.out.println("msg.length(): " + msg.length());                                // 5

    System.out.println();

    // charAt() exception catch
    System.out.println("msg.charAt(-1):");
    try {
      System.out.println(msg.charAt(-1));                             // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    System.out.println("msg.charAt(15):");
    try {
      System.out.println(msg.charAt(15));                             // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // charAt()
    System.out.println("msg.charAt(0): " + msg.charAt(0));                              // "d"
    System.out.println("msg.charAt(3): " + msg.charAt(3));                              // "i"

    System.out.println();

    // subSequence() exception catch
    // start < 0
    System.out.println("msg.subSequence(-1,4):");
    try {
      System.out.println(msg.subSequence(-1,4));                      // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // end < 0
    System.out.println("msg.subSequence(1,-4):");
    try {
      System.out.println(msg.subSequence(1,-4));                      // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // start > end
    System.out.println("msg.subSequence(11,4):");
    try {
      System.out.println(msg.subSequence(11,4));                      // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // end > length()
    System.out.println("msg.subSequence(1,14):");
    try {
      System.out.println(msg.subSequence(1,14));                      // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // subSequence()
    System.out.println("msg.subSequence(0,3): " + msg.subSequence(0,3));                // "dro"
    System.out.println("msg.subSequence(2,5): " + msg.subSequence(2,5));                // "oid"

    System.out.println();

    // compareTo()
    System.out.println("msg.compareTo(\"droid\"): " + msg.compareTo("droid"));          // 0
    System.out.println("msg.compareTo(\"bat\"): " + msg.compareTo("bat"));              // 1
    System.out.println("msg.compareTo(\"seventh\"): " + msg.compareTo("seventh"));      // -1
    System.out.println("msg.compareTo(\"drank\"): " + msg.compareTo("drank"));          // 1
    System.out.println("msg.compareTo(\"drunk\"): " + msg.compareTo("drunk"));          // -1
  }
  //Constructor
  public MyString(CharSequence s) {
    data = new char[s.length()];
    for (int i = 0 ; i < s.length(); i++) {
      data[i] = s.charAt(i);
    }
  }
  //charAt - returns the character at the specified index. Throws an excpetion if the index is invalid.
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
  //subSequence - returns the CharSequence between the specified indices. Throws an exception if the indices are invalid.
  public CharSequence subSequence(int start, int end) {
    String output = "";
    int len = data.length;
    if ((start < 0 || end < 0) || (start > len || end > len)) {
      throw new IndexOutOfBoundsException(indexProblem);
    }
    else if (start > end) {
      throw new IndexOutOfBoundsException(badInput);
    }
    else {
      for (int i = start; i < end; i++) {
        output += this.charAt(i);
      }
    }
    return output;
  }
  //Turns the CharSequence into a String.
  public String toString() {
    String output = "";
    for (int i = 0; i < data.length; i++) {
      output += data[i];
    }
    return output;
  }
  //Returns -1 if this comes before input in the dictionary.
  //Returns 0 if the this CharSequence and the input CharSequence are the same.
  //Returns 1 if this comes after input in the dictionary.
  //Throws an exception if either this or input is null.
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
  //Helper function for compareTo(), converts all chars to their ASCII values.
  public int[] toASCII(CharSequence input) {
    int[] returner = new int[input.length()];
    for (int i = 0; i < returner.length; i++) {
      int inQ = input.charAt(i);
      returner[i] = inQ;
    }
    return returner;
  }
}
