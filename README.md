JavaQ
=======

[![Join the chat at https://gitter.im/vivekmittal/javaq](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/vivekmittal/javaq?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/vivekmittal/javaq.svg?branch=master)](https://travis-ci.org/vivekmittal/javaq)
[![Maven Release](https://img.shields.io/github/release/vivekmittal/javaq.svg?label=maven)](https://jitpack.io/#vivekmittal/javaq/v1.0.0)
[![License](http://img.shields.io/:license-mit-blue.svg)](https://github.com/vivekmittal/javaq/blob/master/LICENSE)

<b><i>Java DSL for SQL</i></b>

JavaQ takes care of building the sql query for you, rescuing you from the pain of remembering syntax for different dialects. With Java's static typing, JavaQ reduces the chances of making structural mistakes in the query.

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
    select("NAME", "COUNT(*)").from("EMPLOYEE")
        .groupBy("NAME")
        .orderBy("COUNT(*)", ASC)
        .sql()
</pre>

<b>Limit</b>
<pre>
    select("NAME", "COUNT(*)").from("EMPLOYEE")
          .groupBy("NAME")
          .orderBy("COUNT(*)", ASC)
          .limit(10)
          .sql()
</pre>

What's next?
-------
- Generate queries for different SQL Dialects
- Integrate with JDBC APIs
- Generate update queries

CONTRIBUTING
-------
Interested in contributing to JavaQ ? Here are some ways you can do that
- Raise issues/bugs
- Update documentation
- Contribute in open issues/improvements/features
- Any new ideas

Feel free to raise pull requests :)

LICENSE
-------
MIT
