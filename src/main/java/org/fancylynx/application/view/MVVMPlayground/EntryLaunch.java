package org.fancylynx.application.view.MVVMPlayground;

import java.io.IOException;

public class EntryLaunch {
    public static void main(String[] args) throws IOException {
        System.out.println("LAUNCH MVVM ENTRY TEST");
        Entry.launch(Entry.class, args);
    }
}
