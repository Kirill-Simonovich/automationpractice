package service.ui;

import static com.codeborne.selenide.Browsers.CHROME;

public enum Feature {

  CUSTOMER_ROW("/common_elements/customer_row.tiff");


  private static final String BASE_SCREENSHOT_PATH = "src/test/resources/expected-ui/";
  final String expectedUiScreenshot;

  Feature(final String screenShotPath) {
    // change if that need
    final String browser = CHROME;
    this.expectedUiScreenshot = BASE_SCREENSHOT_PATH + browser + screenShotPath;
  }

  public String getExpectedUiScreenshot() {
    return this.expectedUiScreenshot;
  }
}
