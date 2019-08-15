package za.co.mkhabelalucas.simplerestfulapi.constatns;

public class Constants {

    public static String ADDED_SUCCESSFUL = "{" +
            "   \"code\": \"200\"," + "\n" +
            "   \"message\": \"success\"," + "\n" +
            "}";

    public static String FAILED = "{" +
            "   \"code\": \"999\"," + "\n" +
            "   \"message\": \"failed to save news\"," + "\n" +
            "}";

    public static String NEWS_BODY_REQUIRED = "News body required";
    public static String ID_REQUIRED = "Id required";
    public static String DELETED_SUCCESSFUL = "{" +
            "   \"code\": \"200\"," + "\n" +
            "   \"message\": \"successfully deleted news\"," + "\n" +
            "}";
}
