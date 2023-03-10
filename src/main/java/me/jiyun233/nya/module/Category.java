package me.jiyun233.nya.module;

import me.jiyun233.nya.utils.IconFontKt;

public enum Category {
    COMBAT("Combat", IconFontKt.TARGET, false),
    MOVEMENT("Movement", IconFontKt.METER, false),
    VISUAL("Visual", IconFontKt.EYE, false),
    WORLD("World", IconFontKt.EARTH, false),
    EXPLOITS("Exploits",IconFontKt.MAGIC_WAND,false),
    FUNCTION("Function", IconFontKt.COGS, false),
    CLIENT("Client", IconFontKt.EQUALIZER, false),
    HUD("Hud", IconFontKt.PENCLI, true);

    private final String name;
    private final String icon;
    public final boolean isHud;

    Category(String name, String icon, boolean isHud) {
        this.name = name;
        this.icon = icon;
        this.isHud = isHud;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
