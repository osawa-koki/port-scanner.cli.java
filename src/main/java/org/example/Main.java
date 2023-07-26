package org.example;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.util.Arrays;
import java.util.Comparator;

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

    Scanner.host = options.host;
    Scanner.timeout = options.wait;

    Scanner[] scanners = new Scanner[options.end - options.start + 1];
    Thread[] threads = new Thread[options.thread];

    for (int i = options.start; i <= options.end; i++) {
      System.out.println("Checking port: " + i);
      Scanner scanner = new Scanner(i);
      scanners[i - options.start] = scanner;
      threads[i % options.thread] = scanner;
      scanner.start();
      if (i % options.thread == 0 || i == options.end) {
        for (Thread th : threads) {
          try {
            th.join();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }

    Arrays.sort(scanners, Comparator.comparingInt(a -> a.port));

    for (Scanner scanner : scanners) {
      System.out.println((scanner.isOpen ? "🔴 Open  " : "🔵 Closed") + ": " + scanner.port);
    }

    System.exit(0);
  }
}
