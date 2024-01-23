import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.example.TrelloRest.BoardCreator;
import org.example.TrelloRest.BoardDTO;
import org.example.TrelloRest.CardCreator;
import org.example.TrelloRest.CardDTO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class Task2 extends TrelloRestApiBaseTest{

    CardDTO testCard;
    BoardDTO testBoard;
    Map<String, Object> requestBodyAuthPart = new HashMap<>();
    String key = "778c7e48a0a3b04eaf4850262f937ba5";
    String token = "ATTAe9790de6a88643fae200060a12b6b7683be922d5bd6e7e673aed066bd75efe2e9196A6FD";

    private final String LOGIN_URL = "https://id.atlassian.com/login?application=trello&continue=https%3A%2F%2Ftrello.com%2Fauth%2Fatlassian%2Fcallback%3Fdisplay%3DeyJ2ZXJpZmljYXRpb25TdHJhdGVneSI6InNvZnQifQ%253D%253D&display=eyJ2ZXJpZmljYXRpb25TdHJhdGVneSI6InNvZnQifQ%3D%3D";
    private final String EMAIL = "taras.stepaniuk@holywater.tech";
    private final String PASS = "Taras_test1";

    @BeforeClass
    public void initiateAuth() {
        requestBodyAuthPart.put("key", key);
        requestBodyAuthPart.put("token", token);
    }

    @BeforeClass
    public void createTestCard(){
        testCard = CardCreator.createCardOnlyRequired();
        testBoard = BoardCreator.createBoardOnlyRequires();
    }

    //Oauth -- протокол авторизації
    @Test(priority = 1, groups = "access")
    public void logIn() throws InterruptedException {

        Selenide.open(LOGIN_URL);
        Selenide.$("#username").setValue(EMAIL).pressEnter();
        Selenide.$("#password").setValue(PASS).pressEnter();
        Thread.sleep(5000);
        Selenide.$("span[aria-label=\"Taras Stepaniuk (tarasstepaniuk)\"]").exists();



    }

    @Test(priority = 2, dependsOnGroups = "access")
    public void getBoard() {

        given()
                .spec(REQUEST_SPEC)
                .body(requestBodyAuthPart)
                .when()
                .get("/boards/" + testBoard.getId() + "/")
                .then()
                .spec(RESPONSE_SPEC)
                .body("id", equalTo(testBoard.getId()))
                .body("name", equalTo(testBoard.getBoardName()));
    }

    @Test(priority = 3, dependsOnGroups = "access")
    public void createCard() {

        //prepare the request
        Map<String, Object> requestBody = new HashMap<>(requestBodyAuthPart);
        requestBody.put("idList", testCard.getListId());
        requestBody.put("name", testCard.getCardName());

        //send request + asserts
        String.valueOf(testCard.setId(given()
                                .spec(REQUEST_SPEC)
                                .body(requestBody)
                                .when()
                                .post("/cards")
                                .then()
                                .spec(RESPONSE_SPEC)
                                .body("id", notNullValue())
                                .body("name", equalTo(testCard.getCardName()))
                                .body("idList", equalTo(testCard.getListId()))
                                .extract()
                                .path("id")
        ));

        System.out.println(testCard.getId());
    }


    @Test(priority = 4, dependsOnMethods = "createCard")
    public void updateCard() {

        Map<String, Object> requestBody = new HashMap<>(requestBodyAuthPart);
        requestBody.put("desc", testCard.getDescription());

        given()
                .spec(REQUEST_SPEC)
                .body(requestBody)
                .when()
                .put("/cards/" + testCard.getId())
                .then()
                .spec(RESPONSE_SPEC)
                .body("desc", equalTo(testCard.getDescription()));
    }

    @Test(priority = 5, dependsOnMethods = "createCard")
    public void addCommentToCard() {

        Map<String, Object> requestBody = new HashMap<>(requestBodyAuthPart);
        requestBody.put("text", testCard.getComment());

        given()
                .spec(REQUEST_SPEC)
                .body(requestBody)
                .when()
                .post("/cards/" + testCard.getId() + "/actions/comments")
                .then()
                .spec(RESPONSE_SPEC);
    }

    @Test(priority = 6, dependsOnMethods = "createCard")
    public void deleteCard() {

        given()
                .spec(REQUEST_SPEC)
                .body(requestBodyAuthPart)
                .when()
                .delete("/cards/" + testCard.getId())
                .then()
                .spec(RESPONSE_SPEC);
    }
}
