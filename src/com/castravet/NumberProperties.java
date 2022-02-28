package com.castravet;

public enum NumberProperties {
    EVEN("EVEN"),
    ODD("ODD"),
    BUZZ("BUZZ"),
    DUCK("DUCK"),
    PALINDROMIC("PALINDROMIC"),
    GAPFUL("GAPFUL"),
    SPY("SPY"),
    SQUARE("SQUARE"),
    SUNNY("SUNNY"),
    JUMPING("JUMPING"),
    HAPPY("HAPPY"),
    SAD("SAD"),
    NEGATIVE_EVEN("-EVEN"),
    NEGATIVE_ODD("-ODD"),
    NEGATIVE_BUZZ("-BUZZ"),
    NEGATIVE_DUCK("-DUCK"),
    NEGATIVE_PALINDROMIC("-PALINDROMIC"),
    NEGATIVE_GAPFUL("-GAPFUL"),
    NEGATIVE_SPY("-SPY"),
    NEGATIVE_SQUARE("-SQUARE"),
    NEGATIVE_SUNNY("-SUNNY"),
    NEGATIVE_JUMPING("-JUMPING"),
    NEGATIVE_HAPPY("-HAPPY"),
    NEGATIVE_SAD("-SAD");

    private String property;

    NumberProperties(String property){
        this.property=property;
    }

    public static NumberProperties isPropertyPresent(String text) {
        for (NumberProperties b : NumberProperties.values()) {
            if (b.property.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public static String getProperty(NumberProperties property) {
        return property.property;
    }


}
