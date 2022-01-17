package org.shPaste.Lib;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.shPaste.Lib.config.Data;
import org.shPaste.Lib.config.Option;
import org.shPaste.Main;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class KeyHook implements NativeKeyListener {

    private boolean isRun = false;

    public KeyHook() {
        if (!GlobalScreen.isNativeHookRegistered()) {
            try {
                //フックを登録
                GlobalScreen.registerNativeHook();
            } catch (NativeHookException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    //キーを押したとき
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        Option option = Main.getOption();
        String input = NativeKeyEvent.getKeyText(e.getKeyCode());

        System.out.println(input);

        //切り替え
        if(input.equals("P") && e.getModifiers() == KeyEvent.CTRL_MASK + KeyEvent.ALT_MASK){
            isRun = !isRun;
            System.out.println(isRun);
        }

        //終了コード
        if(input.equals("P") && e.getModifiers() == KeyEvent.CTRL_MASK + KeyEvent.ALT_MASK + KeyEvent.ALT_MASK){
            System.exit(0);
        }

        if(!isRun) return;

        //コピペ処理
        if(option.getData(input) != null){
            System.out.println(input + "AAA");

            if(e.getModifiers() != option.getData(input).getModifier()) return;

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selection = new StringSelection(option.getData(input).getText());
            clipboard.setContents(selection, null);

            System.out.println("Paste: " + option.getData(input).getText());
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}
