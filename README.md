# Logger

## Custom logger configuration

java -cp ...\.m2\repository\org\apache\logging\log4j\log4j-core\2.4.1\log4j-core-2.4.1.jar org.apache.logging.log4j.core.tools.Generate$CustomLogger fr.colindeseroux.logger.MyLogger FATAL=100 ERROR=200 WARN=300 INFO=400 DEBUG=500 FUNCTION=550 > MyLogger.java

## Use

private static final MyLogger L = MyLogger.create(UserService.class);

L.fatal("");
L.error("");
L.warn("");
L.info("");
L.debug("");
L.function("");