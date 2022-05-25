package service.ui;

import java.util.Arrays;

import com.codeborne.selenide.SelenideElement;
import com.spanning.automation.frontend.enums.Feature;
import com.spanning.automation.frontend.enums.IgnoredElements;
import com.spanning.automation.frontend.service.ui.UiTestExecutor.UiExecutorType;
import org.openqa.selenium.By;

import static com.spanning.automation.frontend.enums.IgnoredElements.AVATAR;
import static com.spanning.automation.frontend.enums.IgnoredElements.CREATED_HELP_DATE;
import static com.spanning.automation.frontend.enums.IgnoredElements.DATE;
import static com.spanning.automation.frontend.enums.IgnoredElements.EXPIRE_DATE;
import static com.spanning.automation.frontend.enums.IgnoredElements.SWITCH_ACTION;
import static org.apache.commons.lang3.ArrayUtils.addAll;

public class ScreenshotService {

  private static final UiTestExecutor UI_TEST_EXECUTOR = UiTestExecutorFactory.getInstance().get(UiExecutorType.UPDATE);

  /**
   * These are dynamically changing radmin elements.
   */
  private static final By[] COMMON_IGNORED_ELEMENTS = new By[]{
      AVATAR.getElement(),
      CREATED_HELP_DATE.getElement(),
      DATE.getElement(),
      EXPIRE_DATE.getElement(),
      SWITCH_ACTION.getElement()
  };

  private ScreenshotService() {
  }

  public static void uiExecutor(
      final Feature feature,
      final By... ignoredElements
  ) {
    UI_TEST_EXECUTOR.execute(feature, addAll(ignoredElements, COMMON_IGNORED_ELEMENTS));
  }

  public static void uiExecutor(
      final SelenideElement element,
      final Feature feature,
      final IgnoredElements... ignoredElements
  ) {
    UI_TEST_EXECUTOR.execute(element, feature,
        Arrays.stream(ignoredElements)
            .map(IgnoredElements::getElement)
            .toArray(By[]::new));
  }

}
