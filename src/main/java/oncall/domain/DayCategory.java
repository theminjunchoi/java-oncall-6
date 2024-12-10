package oncall.domain;

public enum DayCategory {
    WEEKDAY("평일", false),
    WEEKEND("주말", false),
    WEEKDAY_BUT_HOLIDAY("평일", true),
    WEEKEND_AND_HOLIDAY("주말", true);

    private final String dayCategoryName;
    private final boolean isHoliday;

    DayCategory(String dayCategoryName, boolean isHoliday) {
        this.dayCategoryName = dayCategoryName;
        this.isHoliday = isHoliday;
    }
}
