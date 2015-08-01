JavaQ
=======
[![Build Status](https://travis-ci.org/vivekmittal/javaq.svg?branch=master)](https://travis-ci.org/vivekmittal/javaq)
[![License](http://img.shields.io/:license-mit-blue.svg)](https://github.com/vivekmittal/javaq/blob/master/LICENSE)

<b><i>Java DSL for SQL</i></b>

Add javaq to your project
-------

Repository

    <repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>

Dependency

	<dependency>
	    <groupId>com.github.vivekmittal</groupId>
	    <artifactId>javaq</artifactId>
	    <version>v1.0.0</version>
	</dependency>

Using JavaQ
-------
import static com.javaq.JavaQ.select;

<b>Select All</b>
<pre>
    select().from("EMPLOYEE").sql() 
</pre>

<b>Where Clause</b>
<pre>
    select("ID", "NAME").from("EMPLOYEE").where("ID = 1").sql()
</pre>

<b>Operators (AND/OR/LIKE/IN)</b>
- AND/OR
<pre>
    select("ID", "NAME").from("EMPLOYEE")
        .where("ID = 1").and("NAME = 'BATMAN'")
        .sql()
</pre>
<pre>
    select("ID", "NAME").from("EMPLOYEE")
        .where("ID = 1").or("NAME = 'BATMAN'")
        .sql()
</pre>
- IN
<pre>
    select("ID", "NAME").from("EMPLOYEE")
        .where("ID")
          .in(select("ID").from("AWARD_WINNERS"))
        .or("NAME = 'BATMAN'")
        .sql()
</pre>
<pre>
    select("ID", "NAME").from("EMPLOYEE")
        .where("ID").in("1", "2")
        .sql()
</pre>
- LIKE
<pre>
    select("ID", "NAME").from("EMPLOYEE")
        .where("NAME").like("%BATMAN%")
        .sql()
</pre>

<b>Joins</b>
- INNER JOIN
<pre>
    select("ID", "NAME").from("EMPLOYEE")
        .join("ADDRESS").on("ADDRESS.ID = EMPLOYEE.ADDRESS_ID")
        .where("ID = 1").or("NAME = 'BATMAN'")
        .sql()
</pre>
- LEFT JOIN
<pre>
    select("ID", "NAME").from("EMPLOYEE")
        .leftJoin("ADDRESS").on("ADDRESS.ID = EMPLOYEE.ADDRESS_ID")
        .where("ID = 1").or("NAME = 'BATMAN'")
        .sql()
</pre>

<b>Order By</b>
<pre>
    select("ID", "NAME").from("EMPLOYEE")
        .orderBy("ID", Order.OrderType.ASC)
        .sql()
</pre>

<b>Group By</b>
<pre>
    select("NAME", "COUNT(\*)").from("EMPLOYEE")
        .groupBy("NAME")
        .orderBy("COUNT(\*)", ASC)
        .sql()
</pre>

<b>Limit</b>
<pre>
    select("NAME", "COUNT(\*)").from("EMPLOYEE")
          .groupBy("NAME")
          .orderBy("COUNT(\*)", ASC)
          .limit(10)
          .sql()
</pre>

CONTRIBUTING
-------
Feel free to raise any issues or PR

LICENSE
-------
MIT
