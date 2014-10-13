logger
======

Wrapper for slf4j Logger that uses format strings. The LoggerFactory is
pre-coded by hand, the Logger itself generated with a python script that
generates methods for up to 20 method arguments.

maven
=====

this project will be available on bintray/jcenter real soon now (tm).

usage
=====

essentially the same as what you're used to - except you can use format strings
to log messages. here's an example:

```java
import net.swisstech.logger.Logger;
import net.swisstech.logger.LoggerFactory;

public class YourClass {

    private static final Logger LOG = LoggerFactory.getLogger(YourClass.class);

    public void yourMethod(String name, int num) {
        LOG.info("Hello, %s!", name)
        LOG.error("Oops %s caused %5d errors!", new Exception("testing"));
    }
}
```

more information
================

* slf4j: http://www.slf4j.org/
* java format strings: http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
