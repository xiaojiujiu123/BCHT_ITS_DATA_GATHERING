package com.bcht.its.storage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class CMD {

    public static Process CMD(String cmd){
        Process pr = null;
        try {
            cmd = "cmd.exe /c "+cmd;
            System.out.println(cmd);
            pr = Runtime.getRuntime().exec(cmd);
            new Thread(new cmdResult(pr.getInputStream())).start();
            new Thread(new cmdResult(pr.getErrorStream())).start();
            pr.getOutputStream().close();
        } catch (Exception e) {
            System.out.println("命令行出错！");
            e.printStackTrace();
        }

        return pr;
    }

    public static int getPid(Process process) {
        try {
            Class<?> cProcessImpl = process.getClass();
            Field fPid = cProcessImpl.getDeclaredField("pid");
            if (!fPid.isAccessible()) {
                fPid.setAccessible(true);
            }
            return fPid.getInt(process);
        } catch (Exception e) {
            return -1;
        }
    }

    public static Process CMD(String cmd,String ...args){
        return CMD(String.format(cmd, args));
    }

    public static Process runCMD(String cmd){
        Process p = null;
        try {
            cmd = "cmd.exe /c start "+cmd;
            System.out.println(cmd);
            p = Runtime.getRuntime().exec(cmd);
            new Thread(new cmdResult(p.getInputStream())).start();
            new Thread(new cmdResult(p.getErrorStream())).start();
            p.getOutputStream().close();
        } catch (Exception e) {
            System.out.println("命令行出错！");
            e.printStackTrace();
        }
        return p;
    }

    public static Process runCMD(String cmd,String ...args){
        return runCMD(String.format(cmd, args));
    }

    static class cmdResult implements Runnable{
        private InputStream ins;

        public cmdResult(InputStream ins){
            this.ins = ins;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(ins,"GBK"));
                String line = null;
                while ((line=reader.readLine())!=null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}