package com.dpcsa.vinaigrette;

import com.dpcsa.compon.base.DeclareScreens;

public class MyDeclareScreens extends DeclareScreens {

    public final static String SPLASH = "splash", TUTORIAL = "tutorial", AUTH = "auth", MAIN = "main";

    @Override
    public void declare() {
        activity(SPLASH, R.layout.activity_splash)
                .componentSplash(TUTORIAL, AUTH, MAIN);

        activity(TUTORIAL, R.layout.activity_tutorial)
                .component(TC.PAGER_V, model(Api.TUTORIAL)
                                .internetProvider(TestInternetProvider.class),
                        new ParamView(R.id.pager, R.layout.item_tutorial)
                                .visibilityManager(visibility(R.id.contin, "contin"),
                                        visibility(R.id.proceed, "proceed"))
                                .setIndicator(R.id.indicator).setFurtherView(R.id.further),
                        new Navigator().add(R.id.skip, context.getString(R.string.tutorial), true)
                                .add(R.id.skip, context.getString(R.string.auth))
                                .add(R.id.skip, ViewHandler.TYPE.BACK)
                                .add(R.id.proceed, context.getString(R.string.tutorial), true)
                                .add(R.id.proceed, context.getString(R.string.auth))
                                .add(R.id.proceed, ViewHandler.TYPE.BACK)
                                .add(R.id.contin, ViewHandler.TYPE.PAGER_PLUS));

        activity(context.getString(R.string.auth), R.layout.activity_auth)
                .addFragmentsContainer(R.id.content_frame, context.getString(R.string.auth_phone));




        activity(MAIN, R.layout.activity_main);
    }
}
