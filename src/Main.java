import com.classes.*;
import com.classes.serverSide.answers.Request;
import com.enums.Country;
import com.enums.EyeColor;
import com.enums.HairColor;
import com.wrappers.AllCommands;
import com.wrappers.HistoryWrapper;
import com.wrappers.Person;
import com.wrappers.UserCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        AllCommands allCommands = new AllCommands();
        Scanner sc = new Scanner(System.in);
        DatagramChannel datagramChannel = DatagramChannel.open();
        SocketAddress socketAddress = null;
        while(true){
            try {
                int port = Integer.parseInt(Terminal.readLine("Введите порт сервера:"));
                socketAddress = new InetSocketAddress("localhost", port);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        Listener listener = new Listener(datagramChannel, socketAddress);
        listener.start();

        Sender sender = new Sender(datagramChannel, socketAddress);
        System.out.println("Клиент готов к работе.");
        new Start(sender);
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Введите команду:");
            UserCommand userCommand = CommandTranslator.translateCommand(sc.nextLine());
            if (allCommands.getQueue().contains(userCommand.getCommand())) {
                if (userCommand.getCommand().equals("execute_script")) {
                    execute_script(userCommand.getArg1(), sender);
                } else if(userCommand.getCommand().equals("add")&&userCommand.getArg1().equals("")){
                    add(sender);
                }else if (userCommand.getCommand().equals("exit") && userCommand.getArg1().equals("")) {
                    sender.send(new Request(Start.connection.getUserName(), "exit", "", ""));
                    System.out.println("Завершение работы клиента.");
                    System.exit(0);
                } else if (userCommand.getCommand().equals("exit") && !userCommand.getArg1().equals("")) {
                    System.out.println("У данной команды нету второго аргумента");
                } else {
                    Request request = new Request(Start.connection.getUserName(),userCommand.getCommand(), userCommand.getArg1(), userCommand.getArg2());
                    sender.send(request);
                }
            }

        }
    }


    public static void execute_script(String filepath, Sender sender) throws FileNotFoundException {
        File file = new File(filepath);
        if (file.exists() && file.canRead()) {
            if (HistoryWrapper.addScriptPath(filepath)) {
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()) {
                    UserCommand userCommand1 = CommandTranslator.translateCommand(fileReader.nextLine());
                    if(userCommand1.getCommand().equals("execute_script")){
                        execute_script(userCommand1.getArg1(), sender);
                    }
                    Request request = new Request(Start.connection.getUserName(),userCommand1.getCommand(), userCommand1.getArg1(), userCommand1.getArg2());
                    sender.send(request);
                }
                HistoryWrapper.popScriptPath(filepath);
            } else System.out.println("Эта команда вызовет рекурсию, по этому она будет игнорирована");
        }
    }

    public static void add(Sender sender){
        Person person = new Person();
        String buf;
        while (true) {
            buf = Terminal.readLine("Введите имя").trim();
            if (!buf.equals("")) {
                person.setName(buf);
                break;
            } else System.out.println("Имя введено неверно");
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите координату X").trim();
                if (!buf.equals("") && (Long.parseLong(buf) < Long.MAX_VALUE && Long.parseLong(buf) > Long.MIN_VALUE)) {
                    person.getCoordinates().setX(Long.parseLong(buf));
                    break;
                } else System.out.println("Координата X введена неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Координата X введена неверно");
            }
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите координату Y").trim();
                if (!buf.equals("") && (Float.parseFloat(buf) < Float.MAX_VALUE || Float.parseFloat(buf) > Float.MIN_VALUE)) {
                    person.getCoordinates().setY(Float.parseFloat(buf));
                    break;
                } else System.out.println("Координата Y введена неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Координата Y введена неверно");
            }
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите рост").trim();
                if (!buf.equals("") && (Float.parseFloat(buf) > 0 || Float.parseFloat(buf) < Float.MAX_VALUE)) {
                    person.setHeight(Float.parseFloat(buf));
                    break;
                } else System.out.println("Рост введен неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Рост введена неверно");
            }
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите цвет глаз (Возможные цвета: RED, BLUE, YELLOW)").trim();
                if (!buf.equals("")) {
                    person.setEyeColor(EyeColor.valueOf(buf.toUpperCase()));
                    break;
                } else System.out.println("Цвет глаз введен неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Цвет глаз введен неверно");
            }
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите цвет волос (Возможные цвета: GREEN, BLACK, PINK, YELLOW, ORANGE, WHITE)").trim();
                if (!buf.equals("")) {
                    person.setHairColor(HairColor.valueOf(buf.toUpperCase()));
                    break;
                } else System.out.println("Цвет волос введен неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Цвет волос введен неверно");
            }
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите национальность (Возможные национальности: INDIA, VATICAN, NORTH_AMERICA, JAPAN)").trim();
                if (!buf.equals("")) {
                    person.setNationality(Country.valueOf(buf.toUpperCase()));
                    break;
                } else System.out.println("Национальность введена неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Национальность введена неверно");
            }
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите координату локации X").trim();
                if (!buf.equals("") && (Integer.parseInt(buf) < Integer.MAX_VALUE || Integer.parseInt(buf) > Integer.MIN_VALUE)) {
                    person.getLocation().setX(Integer.parseInt(buf));
                    break;
                } else System.out.println("Координата X введена неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Координата X введена неверно");
            }
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите координату локации Y").trim();
                if (!buf.equals("") && (Float.parseFloat(buf) < Float.MAX_VALUE || Float.parseFloat(buf) > Float.MIN_VALUE)) {
                    person.getLocation().setY(Float.parseFloat(buf));
                    break;
                } else System.out.println("Координата Y введена неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Координата Y введена неверно");
            }
        }
        while (true) {
            try {
                buf = Terminal.readLine("Введите координату локации Z").trim();
                if (!buf.equals("") && (Float.parseFloat(buf) < Float.MAX_VALUE || Float.parseFloat(buf) > Float.MIN_VALUE)) {
                    person.getLocation().setY(Float.parseFloat(buf));
                    break;
                } else System.out.println("Координата Z введена неверно");
            } catch (IllegalArgumentException e) {
                System.out.println("Координата Z введена неверно");
            }
        }
        UserCommand userCommand = new UserCommand("add", CommandTranslator.translatePerson(person));
        Request request = new Request(Start.connection.getUserName(),userCommand.getCommand(), userCommand.getArg1(), userCommand.getArg2());
        sender.send(request);
    }
}