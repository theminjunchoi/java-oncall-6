package oncall.domain;

public enum Day {
    WEEKDAY("평일", false),
    WEEKEND("주말", false),
    WEEKDAY_BUT_HOLIDAY("평일", true),
    WEEKEND_AND_HOLIDAY("주말", true);

    private final String dayCategory;
    private final boolean isHoliday;

    Day(String dayCategory, boolean isHoliday) {
        this.dayCategory = dayCategory;
        this.isHoliday = isHoliday;
    }
}
