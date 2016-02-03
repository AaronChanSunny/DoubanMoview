package com.aaron.doubanmovie.util;

import com.aaron.doubanmovie.network.model.InTheaters;
import com.aaron.doubanmovie.network.model.Movie;

import java.util.List;

/**
 * Created by OA on 2016/1/26.
 */
public class MovieParser {

    private static final String SEPARATOR = "/";

    public static String parseDirectorsInTheaters(List<InTheaters.Movie.Director> directors) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < directors.size(); i++) {
            sb.append(directors.get(i).getName());

            if (i != directors.size() - 1) {
                sb.append(SEPARATOR);
            }
        }

        return sb.toString();
    }

    public static String parseDirectors(List<Movie.Director> directors) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < directors.size(); i++) {
            sb.append(directors.get(i).getName());

            if (i != directors.size() - 1) {
                sb.append(SEPARATOR);
            }
        }

        return sb.toString();
    }

    public static String parseCasts(List<Movie.Cast> casts) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < casts.size(); i++) {
            sb.append(casts.get(i).getName());

            if (i != casts.size() - 1) {
                sb.append(SEPARATOR);
            }
        }

        return sb.toString();
    }

    public static String parseCastsInTheaters(List<InTheaters.Movie.Cast> casts) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < casts.size(); i++) {
            sb.append(casts.get(i).getName());

            if (i != casts.size() - 1) {
                sb.append(SEPARATOR);
            }
        }

        return sb.toString();
    }

    public static String parseGenres(List<String> genres) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < genres.size(); i++) {
            sb.append(genres.get(i));

            if (i != genres.size() - 1) {
                sb.append(SEPARATOR);
            }
        }

        return sb.toString();
    }

}
