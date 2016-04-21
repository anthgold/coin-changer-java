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
    String layout = "templates/layout.vtl"; // declares layout
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/input.vtl"); // assigns input template to model
      return new ModelAndView(model, layout); // puts model inside of layout
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    // velocity stuff.

  }
  public static Object giveChange(Integer moneyInput) {
    Integer currentCents = moneyInput;
    Integer[] coinCounts = new Integer[4];
    // Quarter while-loop
    Integer quarterCount = 0;
    coinCounts[0] = quarterCount;
    while(currentCents >= 25) {
      currentCents -= 25;
      coinCounts[0]++;
    }
    // Dime while-loop
    Integer dimeCount = 0;
    coinCounts[1] = dimeCount;
    while(currentCents >= 10) {
      currentCents -= 10;
      coinCounts[1]++;
    }
    // Nickel loop here
    Integer nickelCount = 0;
    coinCounts[2] = nickelCount;
    while(currentCents >= 5) {
      currentCents -= 5;
      coinCounts[2]++;
    }
    // Penny counter here
    Integer pennyCount = currentCents;
    coinCounts[3] = pennyCount;

    System.out.println(Arrays.toString(coinCounts));
    return Arrays.toString(coinCounts);
  }
}

// function giveChange(moneyInput) {
//
// }

// App.giveChange(41);
