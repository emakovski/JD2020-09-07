package by.it.makovsky.jd02_05;


import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Lang manager = Lang.EA;
        manager.setLocale(Locale.ENGLISH);
        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        System.out.println(manager.get(Message.WELCOME));
        System.out.println(manager.get(Message.QUESTION));
        System.out.println(manager.get(User.FIRSTNAME));
        System.out.println(manager.get(User.LASTNAME));
    }
}
