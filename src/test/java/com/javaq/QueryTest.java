package com.javaq;

import org.testng.annotations.Test;

import static com.javaq.JavaQ.select;
import static com.javaq.mixins.Orderable.Order.ASC;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Vivek Mittal <vivek.mittal@flipkart.com>
 */
@Test
public class QueryTest {
    public void selectStar() {
        final String sql = select().from("EMPLOYEE").sql();

        assertThat(sql, is("SELECT * FROM EMPLOYEE"));
    }

    public void whereClause() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").where("ID = 1").sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE WHERE ID = 1"));
    }

    public void andOperator() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").where("ID = 1").and("NAME = 'BATMAN'").sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE WHERE ID = 1 AND NAME = 'BATMAN'"));
    }

    public void orOperator() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").where("ID = 1").or("NAME = 'BATMAN'").sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE WHERE ID = 1 OR NAME = 'BATMAN'"));
    }

    public void likeOperator() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").where("NAME").like("%BATMAN%").sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE WHERE NAME LIKE '%BATMAN%'"));
    }

    public void innerJoin() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").join("ADDRESS").on("ADDRESS.ID = EMPLOYEE.ADDRESS_ID").where("ID = 1").or("NAME = 'BATMAN'").sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE INNER JOIN ADDRESS ON ADDRESS.ID = EMPLOYEE.ADDRESS_ID WHERE ID = 1 OR NAME = 'BATMAN'"));
    }

    public void leftJoin() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").leftJoin("ADDRESS").on("ADDRESS.ID = EMPLOYEE.ADDRESS_ID").where("ID = 1").or("NAME = 'BATMAN'").sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE LEFT JOIN ADDRESS ON ADDRESS.ID = EMPLOYEE.ADDRESS_ID WHERE ID = 1 OR NAME = 'BATMAN'"));
    }

    public void inQuery() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").where("ID").in("1", "2").or("NAME = 'BATMAN'").sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE WHERE ID IN ('1', '2') OR NAME = 'BATMAN'"));
    }

    public void inSelectQuery() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").where("ID").in(select("ID").from("AWARD_WINNERS")).or("NAME = 'BATMAN'").sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE WHERE ID IN (SELECT ID FROM AWARD_WINNERS) OR NAME = 'BATMAN'"));
    }

    public void orderBy() {
        final String sql = select("ID", "NAME").from("EMPLOYEE").orderBy("ID", ASC).sql();

        assertThat(sql, is("SELECT ID, NAME FROM EMPLOYEE ORDER BY ID ASC"));
    }

    public void groupBy() {
        final String sql = select("NAME", "COUNT(*)").from("EMPLOYEE").groupBy("NAME").orderBy("COUNT(*)", ASC).sql();

        assertThat(sql, is("SELECT NAME, COUNT(*) FROM EMPLOYEE GROUP BY NAME ORDER BY COUNT(*) ASC"));
    }

    public void limit() {
        final String sql = select("NAME", "COUNT(*)").from("EMPLOYEE").groupBy("NAME").orderBy("COUNT(*)", ASC).limit(10).sql();

        assertThat(sql, is("SELECT NAME, COUNT(*) FROM EMPLOYEE GROUP BY NAME ORDER BY COUNT(*) ASC LIMIT 10"));
    }
}