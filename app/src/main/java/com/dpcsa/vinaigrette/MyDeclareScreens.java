package com.dpcsa.vinaigrette;

import com.dpcsa.compon.base.DeclareScreens;

public class MyDeclareScreens extends DeclareScreens {

    public final static String SPLASH = "splash", INTRO = "INTRO", AUTH = "auth", MAIN = "main",
            AUTH_PHONE = "AUTH_PHONE", AUTH_CODE = "AUTH_CODE";

    @Override
    public void declare() {
        activity(SPLASH, R.layout.activity_splash)
                .componentSplash(INTRO, AUTH, MAIN);

        activity(INTRO, R.layout.activity_tutorial)
                .component(TC.PAGER_V,
                        model(JSON, getString(R.string.json_tutorial)),
                        view(R.id.pager, R.layout.item_tutorial)
                                .visibilityManager(visibility(R.id.contin, "contin"),
                                        visibility(R.id.proceed, "proceed"))
                                .setIndicator(R.id.indicator).setFurtherView(R.id.further),
                        navigator(
                                handler(R.id.skip, VH.NEXT_SCREEN_SPLASH),
                                handler(R.id.proceed, VH.NEXT_SCREEN_SPLASH),
                                handler(R.id.contin, VH.PAGER_PLUS)));

        activity(AUTH, R.layout.activity_auth)
                .fragmentsContainer(R.id.content_frame, AUTH_PHONE);

        fragment(AUTH_PHONE, R.layout.fragment_auth_phone)
                .component(TC.PANEL_ENTER, null,
                        view(R.id.panel),
                        navigator(handler(R.id.done, VH.CLICK_SEND, model(POST, Api.LOGIN, "login,password"),
                                after(start(AUTH_CODE)), true, R.id.login, R.id.password)), 0);


        activity(MAIN, R.layout.activity_main);
    }
}
