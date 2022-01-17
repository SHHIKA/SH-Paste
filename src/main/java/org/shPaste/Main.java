package org.shPaste;

import org.jnativehook.GlobalScreen;
import org.shPaste.Lib.KeyHook;
import org.shPaste.Lib.config.Option;
import org.shPaste.Lib.setting;

import java.util.logging.LogManager;

public class Main {
    private static Option option;

    public static void main(String[] args) {
        option = new Option();
        option.LoadDef();

        if(args.length != 0){
            if(args[0].equals("setting")){
                new setting(option).set();
                return;
            }
        }

        GlobalScreen.addNativeKeyListener(new KeyHook());

        LogManager.getLogManager().reset();

        System.out.println("Main");
    }

    public static Option getOption(){
        return option;
    }
}
