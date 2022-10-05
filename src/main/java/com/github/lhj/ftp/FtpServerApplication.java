package com.github.lhj.ftp;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;

import java.io.File;

public class FtpServerApplication {

    public static void main(String[] args) throws FtpException {

        FtpServerFactory serverFactory = new FtpServerFactory();

        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();

        userManagerFactory.setFile(new File("users.properties"));

        serverFactory.setUserManager(userManagerFactory.createUserManager());

        FtpServer server = serverFactory.createServer();

        server.start();

    }
}
