package Layers;

import Pages.BasePage;
import Pages.VideoPage.IMyVideoPage;
import Wrappers.WithCommentaries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class VideoLayer extends BasePage implements WithCommentaries, IVideoLayer {
    private static final By COMMENT_INPUT_FIELD = By.xpath(".//div[@class = 'comments_add-itx']//child::div[contains(@id,'field_dM')]");
    private static final By SUBMIT_COMMENT_BUTTON = By.xpath(".//button[@data-l = 't,submit']");
    private static final By CLOSE_VIDEO_BUTTON = By.xpath(".//div[@class = 'media-layer_close']");
    public VideoLayer(WebDriver driver){
        super(driver);
    }

    @Override
    public IVideoLayer typeComment(String text){
        write(text,COMMENT_INPUT_FIELD);
        click(SUBMIT_COMMENT_BUTTON);
        return this;
    }

    @Override
    public boolean isCommentDisplayed(String text){
        return isDisplayed(getCommentary(text));
    }

    @Override
    public void closeVideo () {
        //click(CLOSE_VIDEO_BUTTON);
        Actions action = new Actions(driver);
        action.moveByOffset(0,0).click();
    }

    @Override
    public IVideoLayer waitToGetInHistory () {
        hardSleep();
        return this;
    }
}
