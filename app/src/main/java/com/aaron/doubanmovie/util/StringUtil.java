package com.aaron.doubanmovie.util;

import java.util.List;

/**
 * Created by OA on 2016/1/26.
 */
public class StringUtil {

    public static String formatStringList(List<String> list, String separator) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));

            if (i != list.size() - 1) {
                sb.append(separator);
            }
        }

        return sb.toString();
    }

    public static String formatStringList(List<String> list) {
        return formatStringList(list, "/");
    }

}
