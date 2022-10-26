package com.general;

import com.database.App;
import com.database.Select;
import com.members.AddMember;
import com.menus.HomeMenu;

public class AlexTestMain {
    public static void main(String[] args) {
        // Loads the members from the database
        AddMember.loadMembers();

        HomeMenu.show();
    }
}
