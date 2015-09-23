package ru.sa2.examples.ssh;

import com.jcraft.jsch.JSchException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Smirnov (AlVyaSmirnov) on 23.09.2015.
 *
 */
public class Main {
    static List<String> hosts = new ArrayList<String>();

    {
        hosts.add("bd-01.vps.at-consulting.ru");
        hosts.add("bd-02.vps.at-consulting.ru");
        hosts.add("bd-03.vps.at-consulting.ru");
        hosts.add("bd-04.vps.at-consulting.ru");
        hosts.add("bd-05.vps.at-consulting.ru");
        hosts.add("bd-06.vps.at-consulting.ru");
        hosts.add("bd-07.vps.at-consulting.ru");
        hosts.add("bd-08.vps.at-consulting.ru");
        hosts.add("bd-09.vps.at-consulting.ru");
        hosts.add("bd-10.vps.at-consulting.ru");

    }

    public static void main(String[] args) throws JSchException {
        SshFacade ssh = new SshFacade("******", "******", "192.168.36.82", 22);
//        ssh.execCommand("pwd");
//        ssh.execCommand("ls");
//        ssh.execCommand("date");
//        ssh.execCommand("hostname");
        ssh.execCommand("echo ****** | sudo -S ls", true);
//        ssh.runShell();
        ssh.disconnect();
    }
}
