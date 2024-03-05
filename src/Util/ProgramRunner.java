package Util;

import Core.User;
import view.UserView;

import java.io.IOException;

public class ProgramRunner {
    private static void ProgramRunner() throws IOException {
        UserView userView = new UserView();
        User user = userView.createUser();
        userView.saveInfile(user);
    }
    public static void Run() throws IOException {
        ProgramRunner();
    }
}
