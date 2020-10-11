package com.epam.asus.core.utilites;

import junitx.framework.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueryUtilsTest {

    private final String patternForTest = "SELECT * FROM [cq:Page] AS cqP WHERE ISDESCENDANTNODE(cqP,{0}) " +
            "AND cqP.[jcr:content/cq:lastReplicationAction] = {1} " +
            "AND cqP.[jcr:content/cq:template] = {2}";

    private String expectedSqlStatement;

    private String[] validSearchArgs;
    private String[] invalidSearchArgs;

    @BeforeEach
    void setUp(){
        validSearchArgs = new String[]{"0", "1", "2"};
        invalidSearchArgs = new String[]{"0", "1", "2", "3"};
    }

    @Test
    void createSqlStatementWithValidParams() {
        String sqlStatement = QueryUtils.createSqlStatement(patternForTest, validSearchArgs);

        expectedSqlStatement = "SELECT * FROM [cq:Page] AS cqP WHERE ISDESCENDANTNODE(cqP,'0') " +
                "AND cqP.[jcr:content/cq:lastReplicationAction] = '1' " +
                "AND cqP.[jcr:content/cq:template] = '2'";

        Assert.assertEquals(expectedSqlStatement, sqlStatement);
    }

    @Test
    void createSqlStatementWithInvalidParams() {
        String sqlStatement = QueryUtils.createSqlStatement(patternForTest, invalidSearchArgs);

        expectedSqlStatement = "";

        Assert.assertEquals(expectedSqlStatement, sqlStatement);
    }
}