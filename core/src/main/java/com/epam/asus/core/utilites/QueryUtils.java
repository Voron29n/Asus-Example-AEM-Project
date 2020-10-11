package com.epam.asus.core.utilites;

import org.apache.commons.lang3.StringUtils;

import javax.jcr.RepositoryException;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class QueryUtils {

    private static final String QUERY_VALIDATION_PATTERN = "\\{\\d\\}";

    private QueryUtils() {
    }

    public static String createSqlStatement(String searchPatternQuerySQL2, String[] searchArgs) {

        if (!isSearchPatternQueryValid(searchPatternQuerySQL2, searchArgs)) {
            return "";
        } else {
            MessageFormat searchPattern = new MessageFormat(searchPatternQuerySQL2);

            String[] searchArgWithQuote = QueryUtils.addQuotes(searchArgs);

            return searchPattern.format(searchArgWithQuote);
        }
    }

    public static QueryResult getQueryResult(QueryManager queryManager, String sqlStatement) throws RepositoryException {
        Query query = queryManager.createQuery(sqlStatement, Query.JCR_SQL2);

        return query.execute();
    }

    public static QueryResult getQueryResult(QueryManager queryManager, String sqlStatement, int searchLimit) throws RepositoryException {
        Query query = queryManager.createQuery(sqlStatement, Query.JCR_SQL2);

        query.setLimit(searchLimit);

        return query.execute();
    }



    private static boolean isSearchPatternQueryValid(String searchPatternQuerySQL2, String[] searchArgs) {
        if (StringUtils.isBlank(searchPatternQuerySQL2) || searchArgs == null || searchArgs.length <= 0) {
            return false;
        }

        Pattern pattern = Pattern.compile(QUERY_VALIDATION_PATTERN);
        Matcher matcher = pattern.matcher(searchPatternQuerySQL2);

        return matcher.results().count() == searchArgs.length;
    }

    private static String[] addQuotes(String[] arrays) {
        return Stream.of(arrays)
                .map(QueryUtils::insertQuotes)
                .toArray(String[]::new);
    }

    private static String insertQuotes(String s) {
        return new StringBuilder()
                .append('\'')
                .append(s)
                .append('\'')
                .toString();
    }
}
