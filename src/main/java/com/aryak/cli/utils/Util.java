package com.aryak.cli.utils;

import java.util.Set;
import java.util.function.BiPredicate;

public class Util {

    public static BiPredicate<Set<String>, String> exists = (map, key) -> map.contains(key);
}
