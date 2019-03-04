package raman.noodlebot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class noodle extends ListenerAdapter {
    public static void main(String[] args)throws LoginException{
            Timer timer = new Timer();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 21);
            calendar.set(Calendar.MINUTE, 30);
            calendar.set(Calendar.SECOND, 0);
            Date time = calendar.getTime();

            //Turn On
            JDABuilder builder = new JDABuilder(AccountType.BOT);
            builder.setToken("NDExMjEzNDA3MjQ1NTY1OTUy.D1QkNw.yRP2fM97cjDtUIrvwpgj_WYQJmI");
            builder.setStatus(OnlineStatus.ONLINE);
            builder.setGame(Game.playing("witchyo gurl || >help"));
            timer.schedule(new dailyMessages(), time);
            builder.addEventListener(new messageEvents());
            builder.build();
        }
    }