package com.dpcsa.compon.components;

import com.dpcsa.compon.base.BaseComponent;
import com.dpcsa.compon.base.Screen;
import com.dpcsa.compon.interfaces_classes.IBase;
import com.dpcsa.compon.json_simple.Field;
import com.dpcsa.compon.param.ParamComponent;

public class SplashComponent extends BaseComponent {
    public SplashComponent(IBase iBase, ParamComponent paramMV, Screen multiComponent) {
        super(iBase, paramMV, multiComponent);
    }

    @Override
    public void initView() {
        preferences.setSplashNameScreen(paramMV.intro + "," + paramMV.auth + "," + paramMV.main);
        int isc = preferences.getSplashScreen();
        if (isc == 0 && paramMV.intro.length() == 0) {
            isc = 1;
            preferences.setSplashScreen(isc);
        }
        switch (preferences.getSplashScreen()) {
            case 0:
                iBase.startScreen(paramMV.intro, false);
                break;
            case 1:
                if (paramMV.auth.length() == 0) {
                    isc = 2;
                    preferences.setSplashScreen(isc);
                    iBase.startScreen(paramMV.main, false);
                } else {
                    iBase.startScreen(paramMV.auth, false);
                }
                break;
            case 2:
                iBase.startScreen(paramMV.main, false);
                break;
        }
        iBase.backPressed();
    }

    @Override
    public void changeData(Field field) {

    }
}
