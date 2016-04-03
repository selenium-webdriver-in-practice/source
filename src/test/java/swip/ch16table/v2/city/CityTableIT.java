package swip.ch16table.v2.city;


import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import swip.ch15pageflow.v2.framework.Browser;
import swip.ch15pageflow.v2.framework.BrowserRunner;
import swip.ch15pageflow.v2.framework.Element;
import swip.ch16table.domain.City;
import swip.ch16table.v2.table.Table;
import swip.ch16table.v2.table.TableContents;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static swip.ch15pageflow.locators.TagName.TABLE;

@RunWith(BrowserRunner.class)
public class CityTableIT {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Inject
    private Browser browser;

    private final static Function<List<Element>, City> MAPPER_NON_JAVA_8 =
        new Function<List<Element>, City>() {
            @Override
            public City apply(List<Element> cells) {
                return new City(
                    Integer.parseInt(cells.get(0).getText()),
                    cells.get(1).getText(),
                    cells.get(2).getText()
                );
            }
        };

    private static final TableContents<City> EXPECTED = new TableContents<>(
        Arrays.asList("Id", "City Name", "State Name"),
        Arrays.asList(
            new City(1, "Xian", "Shanxi")
            , new City(2, "Guangzhou", "Guangdong")
            , new City(3, "Shaoguan", "Guangdong")
            , new City(4, "Tianjin", "Tianjin")
            , new City(5, "Changsha", "Huana")
            , new City(6, "Shenzhen", "Guangzhou")
            , new City(7, "Hong Kong", "Hong Kong")
            , new City(8, "Hangzhou", "Zhejiang")
            , new City(9, "Singapore", "Singapore")
            , new City(9, "New York", "New York")
            , new City(10, "Sydney", "New South Wales")
            , new City(11, "Dallas", "Texas")
        )
    );

    private static final TableContents<City> EXPECTED_FAILURE = new TableContents<>(
        Arrays.asList("Id", "City Name", "State Name"),
        Arrays.asList(
            new City(1, "Xian", "Shanxi")
            , new City(2, "Guangzhou", "Guangdong")
            , new City(3, "Shaoguan", "Guangdong")
            , new City(4, "Dallas", "Texas")
        )
    );

    @Test
    public void testReadFromTableJava8() {

        browser.get("/city-table.html");

        Table<City> table = new Table<>(browser.untilFound(TABLE),
            (cells) ->
                new City(
                    Integer.parseInt(cells.get(0).getText()),
                    cells.get(1).getText(),
                    cells.get(2).getText()
                )
        );

        TableContents<City> actual = table.getContents();

        assertEquals(EXPECTED.describeDiff(actual), EXPECTED, actual);
    }

    @Test
    @Ignore("You can remove this to run it and check the output")
    public void testReadFromTableButFailed() {

        browser.get("/city-table.html");

        Table<City> table = new Table<>(
            browser.untilFound(TABLE), MAPPER_NON_JAVA_8
        );

        TableContents<City> actual = table.getContents();

        assertEquals(EXPECTED_FAILURE.describeDiff(actual), EXPECTED_FAILURE, actual);
    }

}
