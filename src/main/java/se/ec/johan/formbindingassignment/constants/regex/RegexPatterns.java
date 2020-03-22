package se.ec.johan.formbindingassignment.constants.regex;

public class RegexPatterns {

    public static final String EMAIL_REGEX = "^(?:(?:[\\w\\.\\-_]+@[\\w\\d]+(?:\\.[\\w]{2,6})+)[,;]?\\s?)+$";
    public static final String PHONE_REGEX = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    public static final String CITY_REGEX = "";
    public static final String ZIPCODE_REGEX = "^(s-|S-){0,1}[0-9]{3}\\s?[0-9]{2}$";
    public static final String PASSWORD_REGEX = "^(?=.*\\d).{4,8}$";

}
