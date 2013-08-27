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
package net.ae97.aebot.api;

import net.ae97.aebot.api.events.JoinEvent;
import net.ae97.aebot.api.events.ActionEvent;
import net.ae97.aebot.api.events.PermissionEvent;
import net.ae97.aebot.api.events.NickChangeEvent;
import net.ae97.aebot.api.events.PrivateMessageEvent;
import net.ae97.aebot.api.events.NoticeEvent;
import net.ae97.aebot.api.events.ConnectionEvent;
import net.ae97.aebot.api.events.KickEvent;
import net.ae97.aebot.api.events.PartEvent;
import net.ae97.aebot.api.events.QuitEvent;
import net.ae97.aebot.api.events.Event;
import net.ae97.aebot.api.events.MessageEvent;
import net.ae97.aebot.api.events.CommandEvent;

public enum EventField {

    Message(MessageEvent.class),
    Command(CommandEvent.class),
    Join(JoinEvent.class),
    NickChange(NickChangeEvent.class),
    Notice(NoticeEvent.class),
    Part(PartEvent.class),
    PrivateMessage(PrivateMessageEvent.class),
    Quit(QuitEvent.class),
    Action(ActionEvent.class),
    Kick(KickEvent.class),
    Permission(PermissionEvent.class),
    Connection(ConnectionEvent.class);
    private final Class eventClass;

    private EventField(Class cl) {
        eventClass = cl;
    }

    private boolean isIt(Class test) {
        if (eventClass.getName().equalsIgnoreCase(test.getName())) {
            return true;
        }
        return false;
    }

    public static EventField getEvent(Event event) {
        for (EventField evt : EventField.values()) {
            if (evt.isIt(event.getClass())) {
                return evt;
            }
        }
        return null;
    }
}