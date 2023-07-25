package org.example;

import org.kohsuke.args4j.Option;

/**
 * コマンドライン引数の格納先兼定義
 */
public class Options {
  @Option(name = "-h", aliases = { "--host" }, required = true, usage = "Target host name")
  public String host;

  @Option(name = "-s", aliases = { "--start" }, required = true, usage = "Start port number")
  public Integer start;

  @Option(name = "-e", aliases = { "--end" }, required = true, usage = "End port number")
  public Integer end;

  @Option(name = "-t", aliases = { "--thread" }, usage = "Number of threads")
  public Integer thread = 3;

  @Option(name = "-w", aliases = { "--wait" }, usage = "Wait time (ms)")
  public Integer wait = 1000;
}
