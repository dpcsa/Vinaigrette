package com.dpcsa.vinaigrette;

import com.dpcsa.compon.base.DeclareScreens;

public class MyDeclareScreens extends DeclareScreens {

    public final static String MAIN = "main";

    @Override
    public void declare() {
        activity(MAIN, R.layout.activity_main);
    }
}
