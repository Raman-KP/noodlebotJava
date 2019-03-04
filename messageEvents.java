package raman.noodlebot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class messageEvents extends ListenerAdapter {
    public static String prefix = ">";
    public static String[] friendCodeProfiles = new String[10];
    public static String friendCodes = "Tharsan: SW-6781-6902-9305 \n Raj: SW-2902-6105-7131 \n Xavier: SW-3013-3861-3242 \n Keigan: SW-8135-8671-8609 \n Tyler King: SW-5788-4208-6781 \n Carlos: SW-5291-5908-8695";
    public static String mainCDescription = "";

    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("message received: " + event.getAuthor().getName() + " : " + event.getMessage().getContentDisplay());

        if(event.getMessage().getContentRaw().equals(prefix + "ping")){
            event.getChannel().sendMessage("pong").queue();

        }else if(event.getMessage().getContentRaw().equals(prefix + "help")){
            EmbedBuilder helpEmb = new EmbedBuilder();
            helpEmb.setColor(new Color(128, 0, 255));
            helpEmb.setTitle("Commands", null);
            helpEmb.setDescription(">ramansHeight [number to convert] \n >spotify \n >friendCodes \n >addFCode [SW-XXXX-XXXX-XXXX] [name]");
            //helpEmb.addField("Title of field", "test of field", false);
            helpEmb.setThumbnail("https://i.imgur.com/4cmwZNG.png");
            helpEmb.addBlankField(false);
            event.getChannel().sendMessage(helpEmb.build()).queue();

        }else if(event.getMessage().getContentRaw().startsWith(prefix + "ramansHeight")){
            String msg = event.getMessage().getContentDisplay();
            String[] msgRHArray = msg.split(" ");
            String heightStr = msgRHArray[1];
            double heightDbl = Double.parseDouble(heightStr);
            double ramans = (heightDbl/5.2);
            event.getChannel().sendMessage(heightStr + " is " + ramans + " ramans").queue();

        }else if(event.getMessage().getContentRaw().startsWith(prefix + "spotify")){
            EmbedBuilder spotEmb = new EmbedBuilder();
            spotEmb.setColor(new Color(29, 185, 84));
            spotEmb.setTitle("Owed for Spotify", null);
            spotEmb.setDescription("Money owed to Raman for spotify: \n E-Transfer: RamanjotPooni@hotmail.com");
            spotEmb.addField("Ryan", "-$22.50", true);
            spotEmb.addField("Tharsan", "Covered - Whole Year", true);
            spotEmb.addField("Manraaj", "$7.50", true);
            spotEmb.addField("Tyler", "$0.00", true);
            spotEmb.addField("Xavier", "$2.50", true);
            spotEmb.setThumbnail("https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Spotify_logo_without_text.svg/2000px-Spotify_logo_without_text.svg.png");
            event.getChannel().sendMessage(spotEmb.build()).queue();

        }else if(event.getMessage().getContentRaw().startsWith(prefix + "friendCodes")){
            EmbedBuilder ninEmb = new EmbedBuilder();
            ninEmb.setColor(new Color(228, 0, 15));
            ninEmb.setTitle("Nintendo Switch Online Friend Codes", null);
            ninEmb.setDescription(friendCodes);
            ninEmb.setThumbnail("https://seeklogo.net/wp-content/uploads/2016/10/nintendo-switch-logo-preview-400x400.png");
            event.getChannel().sendMessage(ninEmb.build()).queue();

        }else if(event.getMessage().getContentRaw().startsWith(prefix + "addFCode")){
            String addCodeRaw = event.getMessage().getContentDisplay();
            String[] codeSplit = addCodeRaw.split(" ");
            String[] friendCodeArrayCheck = codeSplit[1].split("-");

            if(codeSplit[0].equalsIgnoreCase(">addFCode") && friendCodeArrayCheck[0].equals("SW")){
                int numberCheckOne = Integer.parseInt(friendCodeArrayCheck[1]);
                int numberCheckTwo = Integer.parseInt(friendCodeArrayCheck[2]);
                int numberCheckThree = Integer.parseInt(friendCodeArrayCheck[3]);
                if(((numberCheckOne > 999) && (numberCheckOne < 10000)) && ((numberCheckTwo > 999) && (numberCheckTwo < 10000)) && ((numberCheckThree > 999) && (numberCheckThree < 10000))){
                    String tempCode = String.format("%s: SW-%s-%s-%s", codeSplit[2], friendCodeArrayCheck[1], friendCodeArrayCheck[2], friendCodeArrayCheck[3]);
                    friendCodes = friendCodes.concat("\n" + tempCode);
                    event.getChannel().sendMessage("Code Added :)").queue();
                }else{
                    event.getChannel().sendMessage("Invalid code. Please make sure the code begins with SW").queue();
                }
            }
        }else if(event.getMessage().getContentRaw().startsWith(prefix + "removeFCode")){
            //Checks for name
            //Need to make directory for saved "code profiles"
        }
    }
}
