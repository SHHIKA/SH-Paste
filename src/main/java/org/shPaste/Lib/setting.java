package org.shPaste.Lib;

import org.shPaste.Lib.config.Data;
import org.shPaste.Lib.config.Option;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class setting {

    private final Option option;
    private String input = "this is null";
    private final Data data = new Data();

    public setting(Option option){
        this.option = option;
    }

    public void set(){
        System.out.println(" ");
        System.out.println("help でコマンド一覧を表示できます");

        do{
            input = new Scanner(System.in).next();

            switch (input){
                case "help":
                    System.out.println(" ");
                    System.out.println("[CommandName] add");
                    System.out.println("[Description] 新規データを作成します");
                    System.out.println("[CommandName] edit");
                    System.out.println("[Description] 既存のデータを編集します");
                    System.out.println("[CommandName] remove");
                    System.out.println("[Description] 既存のデータを削除します");
                    System.out.println("[CommandName] to");
                    System.out.println("[Description] 既存のデータを表示します");

                    break;

                case "set":
                    newData();
                    break;

                case "remove":
                    System.out.println("削除するDataの名前(DisplayName)を入力してください");
                    showData();

                    option.getList().put(new Scanner(System.in).next(), null);
                    break;

                case "to":
                    for(Data s : option.getList().values()){
                        if(s != null){
                            System.out.println(" ");
                            System.out.println("Name: " + s.getName());
                            System.out.println("Text: " + s.getText());
                            System.out.println("Key: " + s.getKeyText());
                            System.out.println("Modifier: " + s.getModifier());
                        }
                    }

                    break;

                case "save":
                    option.SaveDef();

                    break;

                default:
                    System.out.println("そのコマンドは存在しません: " + input);
                    break;
            }

        } while (!input.equals("!stop"));
    }

    public void newData(){
        System.out.println("名前(DisplayName)を入力してください");
        newData(new Scanner(System.in).next());
    }

    public void newData(String name){
        data.setName(name);

        System.out.println("設定する文字列を入力してください");
        data.setText(new Scanner(System.in).next());

        System.out.println("ショートカットキーを設定します");
        keySet();

        option.setData(data.getKeyText(), data);

        System.out.println("確定しました");
    }

    public void keySet(){
        System.out.println("CTRLキーを使用しますか？ (Y/N)");
        input = new Scanner(System.in).next();
        if(input.equals("Y") || input.equals("y")){
            data.setCtrl(true);
        }

        System.out.println("SHIFTキーを使用しますか？ (Y/N)");
        input = new Scanner(System.in).next();
        if(input.equals("Y") || input.equals("y")){
            data.setShift(true);
        }

        System.out.println("ALTキーを使用しますか？ (Y/N)");
        input = new Scanner(System.in).next();
        if(input.equals("Y") || input.equals("y")){
            data.setAlt(true);
        }

        System.out.println("標準を大文字で入力してください");
        input = new Scanner(System.in).next();

        data.setKeyText(input);
    }

    private void showData(){
        for(Data d : option.getList().values()){
            if(d != null)System.out.println("Name: " + d.getName());
        }
    }
}
