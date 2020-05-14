package Pages;

import Wrappers.WithCommentaries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoLayer extends BasePage implements WithCommentaries {
    private static final By COMMENT_INPUT_FIELD = By.xpath(".//div[@class = 'comments_add-itx']//child::div[contains(@id,'field_dM')]");
    private static final By SUBMIT_COMMENT_BUTTON = By.xpath(".//button[@data-l = 't,submit']");
    private static final By COMMENT_TEXT = By.xpath(".//div[@class = 'comments_text textWrap']");
    public VideoLayer(WebDriver driver){
        super(driver);
    }
    public VideoLayer typeComment(String text){
        write(text,COMMENT_INPUT_FIELD);
        click(SUBMIT_COMMENT_BUTTON);
        return this;
    }
    public boolean isCommentDisplayed(String text){
        return isDisplayed(getCommentary(text));
    }

}
