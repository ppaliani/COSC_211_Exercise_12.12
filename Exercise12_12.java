import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise12_12 {
  /** Main method */
  public static void main(String[] args) throws Exception {
    exceptionMethods em = new exceptionMethods(args);
    // Check command line parameter usage
    /*
     * try { em.checkCommand(args); } catch (Exception ex) {
     * System.out.println("Usage: java Exercise12_12 filename"); System.exit(1); }
     */
    // Check if source file exists
    try {
      em.checkSource(args);
    } catch (Exception ex) {
      System.out.println("Source file " + args[0] + " not exist");
      System.exit(2);
    }

    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
      System.out.println("Source file " + args[0] + " not exist");
      System.exit(2);
    }
    StringBuilder buffer = new StringBuilder();
    Scanner input = new Scanner(sourceFile);
    while (input.hasNext()) {
      String s = input.nextLine();
      String s1 = s.trim();
      exceptionMethods e = new exceptionMethods(args, s, s1);
      try {
        e.reformatCheck(s, s1);
      } catch (Exception ex) {
        buffer.append(" {");
        try {
          e.reformator(s, s1);
        } catch (Exception exc) {
          buffer.append("\r\n" + s.replace('{', ' '));
          input.close();
          // Write buffer into the file
          PrintWriter output = new PrintWriter(sourceFile);
          output.print(buffer.toString());
          output.close();
        }
      }
      buffer.append("\r\n" + s);
    }
    input.close();
    // Write buffer into the file
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
  }
}
