package com.mikarific.carpetthrundlestoneaddition;

import carpet.api.settings.Rule;
import static carpet.api.settings.RuleCategory.*;

public class CarpetThrundlestoneSettings {
    public static final String THRUNDLESTONE = "thrundlestone";

    @Rule(categories = {THRUNDLESTONE, CREATIVE})
    public static boolean asyncBeaconUpdates = false;

    @Rule(categories = {THRUNDLESTONE, CREATIVE})
    public static boolean asyncBeaconUpdatesUpdatesDirectly = false;

    @Rule(categories = {THRUNDLESTONE, COMMAND})
    public static String commandPalette = "ops";

    @Rule(categories = {THRUNDLESTONE})
    public static boolean dungeonLoggerExcludeNonViable = true;
}
