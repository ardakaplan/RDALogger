package com.ardakaplan.rdalogger;

import kotlin.Metadata;

/**
 * Created by Arda Kaplan at 4.08.2021 - 15:02
 * <p>
 * ardakaplan101@gmail.com
 */
public class RDALogFullData {

    private final LogType logType;
    private final String className;
    private final int lineNumber;
    private final String methodName;
    private final String pureLog;
    private String anchorLink;

    public RDALogFullData(LogType logType, String className, int lineNumber, String methodName, String pureLog) {
        this.logType = logType;
        this.className = className;
        this.lineNumber = lineNumber;
        this.methodName = methodName;
        this.pureLog = pureLog;

        try {

            Class<?> act = Class.forName(Thread.currentThread().getStackTrace()[6].getClassName());

            if (act.getAnnotation(Metadata.class) != null) {

                anchorLink = "(" + className + ".kt:" + lineNumber + ")";

            } else {

                anchorLink = "(" + className + ".java:" + lineNumber + ")";
            }

        } catch (ClassNotFoundException ignored) {

            anchorLink = "could't find the class";
        }
    }

    public String getAnchorLink() {
        return anchorLink;
    }

    public LogType getLogType() {
        return logType;
    }

    public String getClassName() {
        return className;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getPureLog() {
        return pureLog;
    }

    @Override
    public String toString() {

        return "LogcatLog{" + "className='" + className + '\'' +
                ", lineNumber=" + lineNumber +
                ", methodName='" + methodName + '\'' +
                ", pureLog='" + pureLog + '\'' +
                '}';
    }


}
