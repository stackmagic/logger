logger
======

Wrapper for slf4j Logger that uses format strings. The LoggerFactory is
pre-coded by hand, the Logger itself generated with a python script that
generates methods for up to 20 method arguments.

[find it on search.maven.org](https://search.maven.org/search?q=g:net.swisstech%20a:logger)
[ ![TravicCI](https://travis-ci.com/stackmagic/logger.svg?branch=master) ](https://travis-ci.com/stackmagic/logger)

downloading
===========

gradle
------

```groovy
dependencies {
    compile 'net.swisstech:logger:+'
}
```

maven
-----

```xml
<dependency>
    <groupId>net.swisstech</groupId>
    <artifactId>logger</artifactId>
    <version>...</version>
</dependency>
```

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

        // simple log
        LOG.info("Hello, %s!", name);

        // exception/throwable is always the last argument
        // and NOT part of the format string
        LOG.error("Oops %s caused %5d errors!", name, num, new Exception("testing"));
    }
}
```

more information
================

* slf4j: http://www.slf4j.org/
* java format strings: http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax

