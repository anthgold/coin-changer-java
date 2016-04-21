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

  @Test
  public void giveChange_twentyFiveCents_oneQuarter() {
    App testApp = new App();
    Integer expected = 1;
    assertEquals(expected, testApp.giveChange(25));
  }
  @Test
  public void giveChange_sixtyCents_twoQuarters() {
    App testApp = new App();
    Integer expected = 2;
    assertEquals(expected, testApp.giveChange(60));
  }

}
