import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.io.Console;
import java.util.regex.Pattern;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    // String layout = "templates/layout.vtl";
    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/input.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    // velocity stuff.

  }
  public static Object giveChange(Integer moneyInput) {
    Integer currentCents = moneyInput;
    Integer[] coinCounts = new Integer[4];
    Integer quarterCount = 0;
    coinCounts[0] = quarterCount;
    while(currentCents >= 25) {
      currentCents -= 25;
      coinCounts[0]++;
    }
    System.out.println(Arrays.toString(coinCounts));
    return coinCounts[0];
  }
}

// function giveChange(moneyInput) {
//
// }

// App.giveChange(41);