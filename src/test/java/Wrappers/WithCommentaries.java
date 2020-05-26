package Wrappers;

import org.openqa.selenium.By;

public interface WithCommentaries {
    default By getCommentary(String text) {
        return By.xpath(".//div[@class = 'comments_text textWrap']//child::div[text() = '" + text + "']");
    }
}
