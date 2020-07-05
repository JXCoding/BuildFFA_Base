package de.jxc.buildffa.utils;

/**
 * @author: JXCoding on 25.06.2020 at 11:03
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class Data {

    public final String prefix = "§eBuildFFA §9» ",
                        noPerms = prefix + "§cYou dont have the permissions to execute this command.",
                        noPlayer = prefix + "§cYou must be a player to execute this command.";

    public Data() {

    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPerms() {
        return noPerms;
    }

    public String getNoPlayer() {
        return noPlayer;
    }
}
