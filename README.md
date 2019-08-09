**DESCRIPTION**

With this library, you can log your message with some info;
- method name
- class name
- line number
- anchor link

Anchor link is the most valueable thing I think. With this link, when you click log, system opens to this line of code.



To use library, you must do implementations below.

<br>
in root level gradle


    allprojects {

        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

<br>
in app level gradle

    dependencies { 
        implementation 'com.github.ardakaplan:RDALogger:1.0.0' 
    }
<br>
<br>
For initializing library, you should start like this (in Application.class or before first use)

    RDALogger.start("TAG NAME").enableLogging(true);
<br>
<br>
And than you can log whatever you want;

    RDALogger.info("info");
    RDALogger.debug("debug");
    RDALogger.verbose("verbose");
    RDALogger.warn("warn");
    RDALogger.error("error");
    RDALogger.error(new Throwable());
    RDALogger.error("error", new Throwable());

<br>
<br>
And finally output shows you all you want (class name, method name, anchor link, message)

    08-09 11:13:06.023 20025-20025/com.ardakaplan.application
    I/Application: IN CLASS : (ENApplication.java:29) /// IN METHOD :
    onCreate info

**CHANGE LOG**

`v1.0.0`

- Library created

`v1.0.1`

- Readme completed =)

[![](https://jitpack.io/v/ardakaplan/RDALogger.svg)](https://jitpack.io/#ardakaplan/RDALogger)