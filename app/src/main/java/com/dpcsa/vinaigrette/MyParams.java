package com.dpcsa.vinaigrette;

import com.dpcsa.compon.param.AppParams;

public class MyParams extends AppParams {
    @Override
    public void setParams() {
        baseUrl =  "http://examples.delta.branderstudio.com/";

        youtubeApiKey = R.string.youtube_api_key;
        progressViewId = R.layout.dialog_progress;
        idStringDefaultErrorTitle = R.string.er_title_def;
        errorDialogViewId = R.id.error_dialog;
        idStringERRORINMESSAGE = R.string.er_message;
        idStringNOCONNECTION_TITLE = R.string.er_connect_title;
        idStringNOCONNECTIONERROR = R.string.er_connect;
        idStringTIMEOUT = R.string.er_timeout;
        idStringSERVERERROR = R.string.er_server_error;
        idStringJSONSYNTAXERROR = R.string.er_json_syntax;
    }
}
