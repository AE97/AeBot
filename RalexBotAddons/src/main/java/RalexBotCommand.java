/*
 * Copyright (C) 2013 Lord_Ralex
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import net.ae97.ralexbot.RalexBot;
import net.ae97.ralexbot.api.EventField;
import net.ae97.ralexbot.api.EventType;
import net.ae97.ralexbot.api.Listener;
import net.ae97.ralexbot.api.events.CommandEvent;
import net.ae97.ralexbot.api.sender.Sender;
import net.ae97.ralexbot.api.users.BotUser;
import org.pircbotx.PircBotX;

public class RalexBotCommand extends Listener {

    @Override
    @EventType(event = EventField.Command)
    public void runEvent(CommandEvent event) {
        Sender target = event.getChannel();
        if (target == null) {
            target = event.getUser();
        }
        target.sendMessage("Hello. I am " + BotUser.getBotUser().getNick() + " " + RalexBot.VERSION + " using PircBotX " + PircBotX.VERSION);
    }

    @Override
    public String[] getAliases() {
        return new String[]{
            BotUser.getBotUser().getNick().toLowerCase(),
            "version"
        };
    }
}
