package swip.ch02locatingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

class ColumnNumberFinder {

    private final String headerText;

    ColumnNumberFinder(String headerText) {
        this.headerText = headerText;
    }

    public int find(SearchContext context) {
        for (int columnNumber = 1; ; columnNumber++) {
            if (context
                    .findElement(By.cssSelector(String.format("th:nth-child(%d)", columnNumber)))
                    .getText().equals(headerText)) {
                return columnNumber;
            }
        }
    }
}
