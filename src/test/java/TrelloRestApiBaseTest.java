import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TrelloRestApiBaseTest {

    public final static RequestSpecification REQUEST_SPEC =
            new RequestSpecBuilder()
                    .setContentType("application/json")
                    .setBaseUri("https://api.trello.com/1")
                    .addHeader("Accept", "application/json")
                    .build();

    public final static ResponseSpecification RESPONSE_SPEC =
            new ResponseSpecBuilder()
                    .expectResponseTime(Matchers.lessThanOrEqualTo(3L), TimeUnit.SECONDS)
                    .expectContentType(ContentType.JSON)
                    .expectStatusCode(200)
                    .build();

    @BeforeSuite
    public void addFilters() {
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
    }

}
