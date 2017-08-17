import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by joseret on 8/4/17.
 */


public class SimpleAppWebTest {
  @Test
  public void homePage() throws Exception {
    String version = System.getenv("GAE_SIMPLEAPP_VERSION");
    String textToCheck = System.getenv("GAE_SIMPLEAPP_TEXT_TO_CHECK");
    if (textToCheck == null) {
      textToCheck = "WTF!";
    }
    try (final WebClient webClient = new WebClient()) {
      System.out.println("version[" + version +"]");
      System.out.println("textToCheck[" + textToCheck +"]");
      final HtmlPage page = webClient.getPage("https://appenginesimpleapp-default-" + version + "-dot-cicd-174318.appspot.com/");
//      Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

      final String pageAsXml = page.asXml();
//      Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

      final String pageAsText = page.asText();
      Assert.assertTrue("Checking" + textToCheck, pageAsText.contains("Hello, PSO - GCloud Demo!"));
    }
  }

}
