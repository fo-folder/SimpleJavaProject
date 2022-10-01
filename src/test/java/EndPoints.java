import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * Отделила энд-поинты для удобства и соблюдения принципа DRY
 */
public final class EndPoints {
    public static final String specBear = "/bear/{id}";
    public static final String allBears = "/bear";

}