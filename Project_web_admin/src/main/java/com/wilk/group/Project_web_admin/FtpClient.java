package com.wilk.group.Project_web_admin;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.PrintWriter;

class FtpClient {

    private String server;
    private int port;
    private String user;
    private String password;
    private FTPClient ftp;

    public FtpClient(String localhost, int serverControlPort, String user, String password) {
    }

    // constructor

    void open() throws IOException {
        ftp = new FTPClient();

        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }

        ftp.login(user, password);
    }

    void close() throws IOException {
        ftp.disconnect();
    }
}