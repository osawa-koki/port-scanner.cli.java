package org.example;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) throws CmdLineException {

    Options options = new Options();
    CmdLineParser parser = new CmdLineParser(options);
    parser.parseArgument(args);

    System.out.println("host: " + options.host);
    System.out.println("start: " + options.start);
    System.out.println("end: " + options.end);
    System.out.println("thread: " + options.thread);
    System.out.println("wait: " + options.wait);
  }
}
