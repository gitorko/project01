package com.demo.basics.designpatterns._10_facade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * makes the subsystem easier to use
 */
enum DbType {
    ORACLE, MYSQL;
}

public class FacadePatternTest {
    @Test
    public void test() {
        Assertions.assertEquals("mysql report", HelperFacade.generateReport(DbType.MYSQL));
        Assertions.assertEquals("oracle report", HelperFacade.generateReport(DbType.ORACLE));
    }
}

class MysqlHelper {

    public String mysqlReport() {
        return "mysql report";
    }
}

class OracleHelper {

    public String oracleReport() {
        return "oracle report";
    }

}

class HelperFacade {

    public static String generateReport(DbType db) {
        switch (db) {
            case ORACLE:
                OracleHelper ohelper = new OracleHelper();
                return ohelper.oracleReport();
            case MYSQL:
                MysqlHelper mhelper = new MysqlHelper();
                return mhelper.mysqlReport();
            default:
                return "";
        }
    }
}
