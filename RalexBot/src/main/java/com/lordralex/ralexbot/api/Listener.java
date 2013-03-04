package com.lordralex.ralexbot.api;

import com.lordralex.ralexbot.RalexBot;
import com.lordralex.ralexbot.api.events.*;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Listener {

    public final Map<EventField, EventType> priorities = new EnumMap<>(EventField.class);

    public void setup() {
    }

    public final void declareValues(Class thisClass) {
        try {
            Method[] methods = thisClass.getDeclaredMethods();
            for (Method method : methods) {
                EventType event = method.getAnnotation(EventType.class);
                if (event == null) {
                    continue;
                }
                System.out.println("    *Event " + event.event().name() + " was added with priority " + event.priority().name());
                priorities.put(event.event(), event);
            }
        } catch (SecurityException ex) {
            RalexBot.getLogger().log(Level.SEVERE, "Security issue", ex);
        }
    }

    public void runEvent(CommandEvent event) {
    }

    public void runEvent(MessageEvent event) {
    }

    public void runEvent(JoinEvent event) {
    }

    public void runEvent(NoticeEvent event) {
    }

    public void runEvent(PartEvent event) {
    }

    public void runEvent(PrivateMessageEvent event) {
    }

    public void runEvent(QuitEvent event) {
    }

    public void runEvent(NickChangeEvent event) {
    }

    public void runEvent(ActionEvent event) {
    }

    public String[] getAliases() {
        return new String[0];
    }
}
