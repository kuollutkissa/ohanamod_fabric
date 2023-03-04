package com.kuollutkissa.susmod.entity.variants;

public enum AmogusVariant{
    RED(0), BLUE(1), GREEN(2),
    PINK(3), ORANGE(4), YELLOW(5),
    BLACK(6), WHITE(7), PURPLE(8),
    BROWN(9), CYAN(10), LIME(11),
    MAROON(12), ROSE(13), BANANA(14),
    GRAY(15), TAN(16), CORAL(17);

    private static final AmogusVariant[] BY_ID = {
            RED, BLUE, GREEN,
            PINK, ORANGE, YELLOW,
            BLACK, WHITE, PURPLE,
            BROWN, CYAN, LIME,
            MAROON, ROSE, BANANA,
            GRAY, TAN, CORAL};
    private int id;

    public static AmogusVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public int getId() {
        return id;
    }
    AmogusVariant(int id) {this.id=id;}
}
