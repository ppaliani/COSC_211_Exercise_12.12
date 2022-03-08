import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Exercise12_12Tester {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @Test
  void testreformator() throws Exception {
    String[] args = {};
    String s = "{";
    String s1 = s.trim();
    exceptionMethods em = new exceptionMethods(args, s, s1);
    String actual = em.reformator(s, s1);
    String expected = "{";
    assertEquals(actual, expected);
  }

  @Test
  void testreformatCheck() throws Exception {
    String[] args = {};
    String s = "{";
    String s1 = s.trim();
    exceptionMethods em = new exceptionMethods(args, s, s1);

    Throwable e = null;
    try {
      em.reformatCheck(s, s1);
    } catch (Exception ex) {
      e = ex;
    }
    assertTrue(e instanceof Exception);
  }

  @Test
  void testcheckSource() throws Exception {
    String[] args = {};
    exceptionMethods em = new exceptionMethods(args);
    File sourceFile = new File("C:\\Users\\Paul\\Downloads\\File.txt");
    Throwable e = null;
    try {
      em.checkSource(args, sourceFile);
    } catch (Exception ex) {
      System.out.println("source file does not exist");
      e = ex;
    }
    assertTrue(e instanceof Exception);

  }

  @Test
  void testcheckCommand() throws Exception {
    String[] args = {};
    exceptionMethods em = new exceptionMethods(args);
    Throwable e = null;
    try {
      em.checkCommand(args);
    } catch (Exception ex) {
      System.out.println("args length does not equal 1");
      e = ex;
    }
    assertTrue(e instanceof Exception);
  }

}
