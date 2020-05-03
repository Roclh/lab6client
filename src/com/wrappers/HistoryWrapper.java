package com.wrappers;

import java.util.PriorityQueue;
import java.util.Queue;

public class HistoryWrapper {
    private static Queue<String> scriptHistory = new PriorityQueue<>();


    /**
     * Переменные, хранящие в себе последние 6 команд
     */
    private static String command6 = "";
    private static String command5 = "";
    private static String command4 = "";
    private static String command3 = "";
    private static String command2 = "";
    private static String command1 = "";

    private static int kol_command = 0;


    /**
     * Метод, который добавляет в объект history введенную команду со смещением всех комманд вверх
     * Если уже хранится 6 команд, то 6 команда удаляется, и на ее место встают предыдущие команжы
     * @param command
     * Команда, которую нужно занести в историю
     */
    public static void add(String command) {
        if (!command.equals("")) {
            kol_command++;
            if (kol_command > 6) kol_command = 6;
            switch (kol_command) {
                case 1:
                    command1 = command;
                    break;
                case 2:
                    command2 = command1;
                    command1 = command;
                    break;
                case 3:
                    command3 = command2;
                    command2 = command1;
                    command1 = command;
                    break;
                case 4:
                    command4 = command3;
                    command3 = command2;
                    command2 = command1;
                    command1 = command;
                    break;
                case 5:
                    command5 = command4;
                    command4 = command3;
                    command3 = command2;
                    command2 = command1;
                    command1 = command;
                    break;
                default:
                    command6 = command5;
                    command5 = command4;
                    command4 = command3;
                    command3 = command2;
                    command2 = command1;
                    command1 = command;
            }
        }
    }

    /**
     * Метод, который добавляет в историю строчку, которая является путём до скрпита
     * Если путь до скрипта не уникальный, то возвращает false
     * @param scriptPath
     * Путь до скрипта, который нужно сохранить
     * @return
     * Возвращает true или false, в зависимости от результата ввода скрипта в коллекцию
     */
    public static boolean addScriptPath(String scriptPath){
        if(scriptHistory.contains(scriptPath)){
            return false;
        }
        if(scriptHistory.offer(scriptPath)){
            return true;
        }   else {
            System.out.println("Произошла ошибка");
            return false;
        }
    }

    /**
     * Метод, который удаляет путь до указанного скрипта
     * @param scriptPath
     * Путь до скрипта, который необходимо удалить
     */
    public static void popScriptPath(String scriptPath){
        if(!scriptHistory.contains(scriptPath)) return;
        for(String string : scriptHistory){
            if(string.equals(scriptPath)) {
                scriptHistory.remove(string);
                return;
            }
        }
    }

    public static String printHistory() {
        String ans = "";
        if (!command6.equals("")) ans = ans + "6. " + command6 + "\n";
        if (!command5.equals("")) ans = ans + "5. " + command5 + "\n";
        if (!command4.equals("")) ans = ans + "4. " + command4 + "\n";
        if (!command3.equals("")) ans = ans + "3. " + command3 + "\n";
        if (!command2.equals("")) ans = ans + "2. " + command2 + "\n";
        if (!command1.equals("")) ans = ans + "1. " + command1 + "\n";
        return ans;
    }
}
