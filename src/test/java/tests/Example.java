package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static service.ui.Feature.EXAMPLE;
import static service.ui.ScreenshotService.uiExecutor;

public class Example {

  @Test
  public void test() {
    open("https://www.google.ru/");
    uiExecutor(EXAMPLE);
  }
}
