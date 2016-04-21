import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("");
  }

  @Test  // nameOfFunction_testCase_expectedResult()
  public void giveChange_twentyFiveCents_oneQuarter() {
    App testApp = new App();
    String expected = "[1, 0, null, null]"; // maps the string
    assertEquals(expected, testApp.giveChange(25));
  }
  @Test
  public void giveChange_sixtyCents_twoQuarters() {
    App testApp = new App();
    String expected = "[2, 1, null, null]";
    assertEquals(expected, testApp.giveChange(60));
  }
  @Test
  public void giveChange_tenCents_oneDime() {
    App testApp = new App();
    String expected = "[0, 1, null, null]";  // should fail
    assertEquals(expected, testApp.giveChange(10));
  }

}
