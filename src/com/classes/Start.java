package com.classes;

import com.classes.serverSide.answers.Request;

public class Start {
    public static String status = "Nothing Yet";
    public static Connection connection;
    public static String name;
    public static String password;

    public Start(Sender sender){
        boolean isWorking = true;
        while(isWorking){
            switch(Terminal.readLine("Выберите действие:\n1. Авторизация\n2. Регистрация")){
                case "1":
                    if(Authorization(sender)) {
                        isWorking = false;
                    }
                    break;
                case "2":
                    if(Registration(sender)){
                        isWorking = false;
                    }
                    break;
                default:System.out.println("Такого варианта ответа не существует");
            }
        }
    }


    public boolean Registration(Sender sender){
        boolean inName = true;
        boolean inPassword = true;
        boolean isSent = false;
        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (inName) {
                System.out.println("Для выхода из меню напишите exit");
                name = Terminal.readLine("Введите имя пользователя (не менее 5 символов)");
                if(name.equals("exit")){
                    return false;
                }
                if (name.length() >= 5) {
                    inName = false;
                } else System.out.println("Такое имя не подходит");
            }
            while (inPassword) {
                password = Terminal.readLine("Введите пароль пользователя (не менее 5 символов)");
                if(name.equals("exit")){
                    return false;
                }
                if (password.length() >= 5) {
                    inPassword = false;
                } else System.out.println("Такой пароль не подходит");
            }
            if(!isSent) {
                Request request = new Request(name, "auth", name, password);
                sender.send(request);
                isSent = true;
            }else if(status.equals("AllFine")&&status!=null){
                return true;
            } else if(status.equals("AlreadyInUse")&&status!=null){
                System.out.println("Такой аккаунт уже занят.");
                status = "Nothing Yet";
                inName = true;
                inPassword = true;
                isSent = false;
            }
        }

    }

    public boolean Authorization(Sender sender){
        boolean inName = true;
        boolean inPassword = true;
        boolean isSent = false;
        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (inName) {
                System.out.println("Для выхода из меню напишите exit");
                name = Terminal.readLine("Введите свое имя");
                if(name.equals("exit")){
                    return false;
                }
                if (name.length() >= 5) {
                    inName = false;
                } else System.out.println("Вы ввели неверное имя");
            }
            while (inPassword) {
                password = Terminal.readLine("Введите пароль");
                if(name.equals("exit")){
                    return false;
                }
                if (password.length() >= 5) {
                    inPassword = false;
                } else System.out.println("Вы ввели неверный пароль");
            }
            if(!isSent) {
                Request request = new Request(name, "login", name, password);
                sender.send(request);
                isSent = true;
            }else if(status.equals("AllFine")){
                return true;
            } else if(status.equals("AlreadyInUse")){
                System.out.println("Пользователь уже авторизирован.");
                status = "Nothing Yet";
                inName = true;
                inPassword = true;
                isSent = false;
            }else if(status.equals("WrongPassword")){
                System.out.println("Неверно введен пароль.");
                status = "Nothing Yet";
                inName = true;
                inPassword = true;
                isSent = false;
            }
        }
    }
}
