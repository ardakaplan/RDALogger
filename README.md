  [![](https://jitpack.io/v/ardakaplan/RDALogger.svg)](https://jitpack.io/#ardakaplan/RDALogger)
<img src="https://raw.githubusercontent.com/ardakaplan/RDALogger/master/images/image.png">  

## What is this for?
You can see your log with **code line number**, **wrapper method** and **class name**. 

And if you click the anchor, you can jump the log line.

Now **kotlin** support is enabled =)

<img src="https://raw.githubusercontent.com/ardakaplan/RDALogger/master/images/output.png">  

## Prerequisites  
  
Add this in your root `build.gradle` file (**not** your module (app) `build.gradle` file):  
  
```gradle  
allprojects {  
   repositories {  
      ...  
      maven { url "https://jitpack.io" }  
   }  
}  
``` 

## Dependency  
  
Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):  
  
```gradle  
dependencies {  
   ...  
   implementation 'com.github.ardakaplan:RDALogger:#latest_version'
}  
```  
  
## Configuration  
  
Starting **RDALogger**
  
```java  
RDALoggerConfig.setup("TAG NAME")//label that you want to see in logcat (ex. application name)
                .enableLogging(true);//enable log mechanizm, default is false
```
  
## Usage  
  
You can find a method for each situation. Every method calls its original **android.util.Log** method with special features.
  
Info Log:
  
``` java  
RDALogger.info("info");
```  
Debug Log:
  
``` java  
RDALogger.debug("debug");
```  
Verbose Log:
  
``` java  
RDALogger.verbose("verbose"); 
```  
Warn Log:
  
``` java  
RDALogger.warn("warn");  
```  
Error Log:
  
``` java  
RDALogger.error("error");
```  
Error Log only throwable:
  
``` java  
RDALogger.error(new Throwable());
```  
  
Error Log with throwable:
``` java  
RDALogger.error("error", new Throwable());
```  

## Logcat Output
You can see your log with **code line number**, **wrapper method** and **class name**. 

And if you click the anchor, you can jump the log line.

<img src="https://raw.githubusercontent.com/ardakaplan/RDALogger/master/images/output.png">  
 

## Change Log

 - **v1.0.0**
	 - Library created
  - **v2.0.0**
	- Adding kotlin support