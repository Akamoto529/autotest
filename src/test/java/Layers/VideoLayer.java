package Layers;

import Pages.BasePage;
import Wrappers.WithCommentaries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoLayer extends BasePage implements WithCommentaries, IVideoLayer {
    private static final By COMMENT_INPUT_FIELD = By.xpath(".//div[@class = 'comments_add-itx']//child::div[contains(@id,'field_dM')]");
    private static final By SUBMIT_COMMENT_BUTTON = By.xpath(".//button[@data-l = 't,submit']");
    private static final By DELETE_COMMENT_BUTTON = By.xpath(".//a[contains(@class,'comments_remove')]");

    public VideoLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    public IVideoLayer typeComment(String text) {
        write(text, COMMENT_INPUT_FIELD);
        click(SUBMIT_COMMENT_BUTTON);
        return this;
    }

    @Override
    public boolean isCommentDisplayed(String text) {
        return isDisplayed(getCommentary(text));
    }

    @Override
    public void closeVideo() {
        clickOnOffset(0, 0);
    }

    @Override
    public IVideoLayer waitToGetInHistory() {
        hardSleep();
        return this;
    }

    @Override
    public IVideoLayer deleteComment(String text) {
        moveToElementAndClick(getCommentary(text), DELETE_COMMENT_BUTTON);
        return this;
    }
}
