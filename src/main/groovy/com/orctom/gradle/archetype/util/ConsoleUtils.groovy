package com.orctom.gradle.archetype.util

class ConsoleUtils {

  static final String LINE_SEPARATOR = System.getProperty('line.separator')
  static final String PS1 = "${LINE_SEPARATOR}> ";

  public static String prompt(def message, def defaultValue = null) {
    def msg = "$PS1$message: " + (defaultValue ? "[$defaultValue]" : "")
    if (System.console()) {
      return System.console().readLine(msg) ?: String.valueOf(defaultValue)
    } else {
      Scanner scanner = new Scanner(System.in);
      println "$msg"
      return scanner.nextLine() ?: String.valueOf(defaultValue)
    }
  }
}