package com.julinar.siswaservice.util;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Collections of common utility functions.
 */
public final class CommonUtil {

    /**
     * Check if object is array or iterable object
     * will return false if null
     *
     * @param obj object to be check
     * @return true if object is array or iterable
     */
    public static boolean isArrayOrCollection(Object obj) {
        if (null != obj) {
            if (obj.getClass().isArray()) {
                return true;
            } else {
                return ClassUtils.isAssignable(obj.getClass(), Collection.class);
            }
        }
        return false;
    }

    public static String setToString(Set<?> listId) {
        if (listId.size() > 1) {
            return StringUtils.substringBetween(listId.toString(), "[", "]").replaceAll("\\s", "");
        } else {
            return listId.toString();
        }
    }

    public static List<Long> extractStringSeparatedByComma(Optional<String> input) {
        if (input.isPresent() && StringUtils.isNotEmpty(input.get())) {
            return new ArrayList<>(Arrays.asList(input.get().split(",")))
                    .stream().map(Long::valueOf).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static boolean isTrueNull(Boolean field) {
        return Objects.requireNonNullElse(field, false);
    }


}
