import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import lombok.Data;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class Task3 {

    int iterator = 0;
    ElementsCollection elements;
    int numberOfFilmsToCheck = 5;
    String imdbUrl = "https://www.imdb.com/chart/top/";

    @BeforeMethod
    public void getCollectionOfFilmsToClick() {
        elements = $$(".ipc-lockup-overlay__screen");
    }

    @AfterMethod
    public void resetIterator() { if (iterator == (numberOfFilmsToCheck - 1)) iterator = 0; }

    @Test (dataProvider = "filmTitles")
    public void checkFilmsNames(String filmTitle) {
        Selenide.open(imdbUrl);
        Selenide.$(elements.get(iterator)).click();
        Selenide.$(".hero__primary-text").shouldHave(Condition.text(filmTitle));
        iterator++;
    }

    //fixme: change cssSelector
    @Test (dataProvider = "filmYears")
    public void checkFilmsYears(String filmYear) {
        Selenide.open(imdbUrl);
        Selenide.$(elements.get(iterator)).click();
        Selenide.$("sc-e226b0e3-3.dwkouE")
                .shouldHave(Condition.text(filmYear));
        iterator++;
    }

    //fixme: change cssSelector
    @Test (dataProvider = "filmRatings")
    public void checkFilmsRatings(String filmRating) {
        Selenide.open(imdbUrl);
        Selenide.$(elements.get(iterator)).click();
        Selenide.$("//li[@class='ipc-inline-list__item' and @role='presentation']")
                .shouldHave(Condition.text(filmRating));
        iterator++;
    }

    @DataProvider(name = "filmRatings")
    public Iterator<Object[]> ratings() {
        List<String> ratingsOfFilms = getFilmsRating(imdbUrl);
        List<Object[]> data = ratingsOfFilms.stream()
                .limit(numberOfFilmsToCheck)
                .map(name -> new Object[]{name})
                .toList();

        return data.iterator();
    }

    @DataProvider(name = "filmYears")
    public Iterator<Object[]> years() {
        List<String> yearsOfFilms = getFilmsYears(imdbUrl);
        List<Object[]> data = yearsOfFilms.stream()
                .limit(numberOfFilmsToCheck)
                .map(name -> new Object[]{name})
                .toList();

        return data.iterator();
    }

    @DataProvider(name = "filmTitles")
    public Iterator<Object[]> films() {

        List<String> titlesOfFilms = getFilmsTitles(imdbUrl);

        List<Object[]> data = titlesOfFilms.stream()
                .limit(numberOfFilmsToCheck)
                .map(name -> new Object[]{name})
                .toList();

        return data.iterator();

    }

    public List<String> getFilmsTitles(String url) {
        List<String> filmNamesTemp = new ArrayList<>();
        Selenide.open(url);
        ElementsCollection names = $$(".ipc-metadata-list.ipc-metadata-list--dividers-between.sc-71ed9118-0.kxsUNk.compact-list-view.ipc-metadata-list--base .ipc-title__text");
        names.forEach(element -> filmNamesTemp.add(element.getText()));
        return removeNumbers(filmNamesTemp);
    }

    public List<String> getFilmsYears(String url) {
        List<String> filmYearsTemp = new ArrayList<>();
        Selenide.open(url);
        ElementsCollection years = $$(".sc-1e00898e-7.hcJWUf.cli-title-metadata .sc-1e00898e-8.hsHAHC.cli-title-metadata-item");
        years.forEach(element -> filmYearsTemp.add(element.getText()));
        return filterYears(filmYearsTemp);
    }

    public List<String> getFilmsRating(String url) {
        List<String> filmsRating = new ArrayList<>();
        Selenide.open(url);
        ElementsCollection ratings = $$(".ipc-rating-star.ipc-rating-star--base.ipc-rating-star--imdb.ratingGroup--imdb-rating");
        for (org.openqa.selenium.WebElement element : ratings) {
            String ariaLabel = element.getAttribute("aria-label");
            if (ariaLabel != null && ariaLabel.startsWith("IMDb rating: ")) {
                String rating = ariaLabel.replace("IMDb rating: ", "");
                filmsRating.add(rating);
            }
        }
        return filmsRating;
     }

    private List<String> removeNumbers(List<String> filmNamesTemp) {
        List<String> cleanedList = new ArrayList<>();

        for (String input : filmNamesTemp) {
            String cleanedTitle = input.replaceAll("^\\d+\\.\\s*", "");
            cleanedList.add(cleanedTitle);
        }

        return cleanedList;
    }

    private List<String> filterYears(List<String> filmYears) {
        List<String> yearsList = new ArrayList<>();
        Pattern yearPattern = Pattern.compile("\\b\\d{4}\\b");

        for (String input : filmYears) {
            Matcher matcher = yearPattern.matcher(input);
            while (matcher.find()) {
                yearsList.add(matcher.group());
            }
        }

        return yearsList;
    }
}

