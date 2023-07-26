package org.example;

public class Scanner extends Thread {
  public static String host;
  public static int timeout;
  public int port;
  public boolean isOpen;

  public Scanner(int port) {
    this.port = port;
  }

  public void run() {
    try {
      java.net.Socket socket = new java.net.Socket();
      socket.connect(new java.net.InetSocketAddress(host, this.port), timeout);
      socket.close();
      this.isOpen = true;
    } catch (java.io.IOException e) {
      this.isOpen = false;
    }
  }
}
