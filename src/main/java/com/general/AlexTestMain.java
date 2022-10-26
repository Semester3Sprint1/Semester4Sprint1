package com.general;

import com.database.App;
import com.database.Select;
import com.members.AddMember;
import com.menus.HomeMenu;

public class AlexTestMain {
    public static void main(String[] args) {
        System.out.println("Loading database...");
        // Loads the members from the database
        AddMember.loadMembers();
        System.out.println("Load completed. Launching program.\n");

        HomeMenu.show();
    }
}
