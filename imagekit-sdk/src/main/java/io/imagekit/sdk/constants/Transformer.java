package io.imagekit.sdk.constants;

import java.util.HashMap;
import java.util.Map;

public class Transformer {

    private Map<String,String> trans=new HashMap<>();
    private static Transformer transformer;

    public static synchronized Transformer getInstance(){
        if (null!= transformer){
            return transformer;
        }
        transformer =new Transformer();

        transformer.trans.put("height" , "h");
        transformer.trans.put("width" , "w");
        transformer.trans.put("aspectRatio" , "ar");
        transformer.trans.put("quality" , "q");
        transformer.trans.put("crop" , "c");
        transformer.trans.put("cropMode" , "cm");
        transformer.trans.put("x" , "x");
        transformer.trans.put("y" , "y");
        transformer.trans.put("focus" , "fo");
        transformer.trans.put("format" , "f");
        transformer.trans.put("radius" , "r");
        transformer.trans.put("background" , "bg");
        transformer.trans.put("border" , "bo");
        transformer.trans.put("rotation" , "rt");
        transformer.trans.put("blur" , "bl");
        transformer.trans.put("named" , "n");
        transformer.trans.put("overlayImage" , "oi");
        transformer.trans.put("overlayX" , "ox");
        transformer.trans.put("overlayY" , "oy");
        transformer.trans.put("overlayFocus" , "ofo");
        transformer.trans.put("overlayHeight" , "oh");
        transformer.trans.put("overlayWidth" , "ow");
        transformer.trans.put("overlayText" , "ot");
        transformer.trans.put("overlayTextFontSize" , "ots");
        transformer.trans.put("overlayTextFontFamily" , "otf");
        transformer.trans.put("overlayTextColor" , "otc");
        transformer.trans.put("overlayAlpha" , "oa");
        transformer.trans.put("overlayTextTypography" , "ott");
        transformer.trans.put("overlayBackground" , "obg");
        transformer.trans.put("overlayImageTrim" , "oit");
        transformer.trans.put("progressive" , "pr");
        transformer.trans.put("lossless" , "lo");
        transformer.trans.put("trim" , "t");
        transformer.trans.put("metadata" , "md");
        transformer.trans.put("colorProfile" , "cp");
        transformer.trans.put("defaultImage" , "di");
        transformer.trans.put("dpr" , "dpr");
        transformer.trans.put("effectSharpen" , "e-sharpen");
        transformer.trans.put("effectUSM" , "e-usm");
        transformer.trans.put("effectContrast" , "e-contrast");
        transformer.trans.put("effectGray" , "e-grayscale");
        transformer.trans.put("original" , "orig");
        transformer.trans.put("raw", "raw");

        return transformer;
    }

    private Transformer(){

    }

    public String transform(String key){
        return this.trans.get(key)!=null?this.trans.get(key):key;
    }

}
