package com.github.lhj.ftp;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;

import java.io.File;

public class FtpServerApplication {

    private static final int PORT = 2121;

    public static void main(String[] args) throws FtpException {

        FtpServerFactory serverFactory = new FtpServerFactory();
        //user manager
        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        userManagerFactory.setFile(new File("users.properties"));
        serverFactory.setUserManager(userManagerFactory.createUserManager());
        // custom port
        ListenerFactory factory = new ListenerFactory();
        factory.setPort(PORT);
        serverFactory.addListener("default", factory.createListener());

        FtpServer server = serverFactory.createServer();

        server.start();

    }
}
