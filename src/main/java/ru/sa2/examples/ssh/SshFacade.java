package ru.sa2.examples.ssh;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

/**
 * Created by AlVyaSmirnov on 19.03.2015.
 */
public class SshFacade {

    public java.util.logging.Logger LOG = Logger.getLogger(getClass().getName());

    private Session session;
    private ChannelExec channelExec;
    private ChannelShell channelShell;
    private InputStream inputStream = System.in;
    private PrintStream outputStream = System.out;
    private PrintStream errorStream = System.err;

    public SshFacade(String user, String password, String host, int port) throws JSchException { //todo ?????? ??????????
        JSch jsch = new JSch();
        jsch.setKnownHosts("src/main/resources/known_hosts");
        JSch.setConfig("StrictHostKeyChecking", "no");
        session = jsch.getSession(user, host, port);
        session.setPassword(password);
        session.setDaemonThread(true);
        session.connect();
    }

    public int execCommand(String command) throws JSchException {
        return execCommand(command, false);
    }

    public int execCommand(String command, boolean runWithSudo) throws JSchException {

        LOG.info("Run command:\t" + command);

        if (channelExec == null || channelExec.isClosed() || !channelExec.isConnected()) {
            initChannelExec();
        }

        channelExec.setPty(runWithSudo);

        channelExec.setCommand(command);
        channelExec.connect(30000);
        return channelExec.getExitStatus();
    }

    public void sendFile(File local, File remote, boolean createPathIfNotExists){
        //todo send file via scp
    }

    public void getFile(File remote, File local, boolean createPathIfNotExists){
        //todo get file via scp
    }

    public void runShell() throws JSchException {
        if (channelShell == null) {
            initChannelShell();
        }

        channelShell.connect();
    }

    public void disconnect() {
        destroy();
    }

    private void destroy() {
        session.disconnect();
        closeChannel(channelExec);
        closeChannel(channelShell);
    }

    private void closeChannel(Channel channelToClose) {
        if (channelToClose != null) channelToClose.disconnect();
    }

    private void initChannelExec() throws JSchException {
        channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setInputStream(null);
        channelExec.setOutputStream(outputStream, true);
        channelExec.setErrStream(errorStream, true);
    }

    private void initChannelShell() throws JSchException {
            channelShell = (ChannelShell) session.openChannel("shell");
            channelShell.setInputStream(inputStream, true);
            channelShell.setOutputStream(outputStream, true);
        }

}
