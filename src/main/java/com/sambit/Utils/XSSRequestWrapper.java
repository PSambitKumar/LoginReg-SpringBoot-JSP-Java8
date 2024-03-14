package com.sambit.Utils;

import java.util.regex.Pattern;

/**
 * @Project : TMS Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 14-Mar-2024 : 2:45 PM
 */

public class XSSRequestWrapper {
    private static Pattern[] patterns = new Pattern[]{
            // Script fragments
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
            // src='...'
            Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // lonely script tags
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // eval(...)
            Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // expression(...)
            Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // javascript:...
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            // vbscript:...
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
            // onload(...)=...
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("<html>(.*?)</html>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("</html>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<html(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("<div>(.*?)</div>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("</div>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<div>(.*?)", Pattern.CASE_INSENSITIVE),
            Pattern.compile("app.alert(.*)", Pattern.CASE_INSENSITIVE),
            Pattern.compile("alert(.*)", Pattern.CASE_INSENSITIVE)
    };
    public static String stripXSS(String value) {
        if (value != null) {
            value = value.replaceAll("\0", "");

            // Remove all sections that match a pattern
            for (Pattern scriptPattern : patterns){
                value = scriptPattern.matcher(value).replaceAll("");
            }
        }
        return value;
    }
    public static boolean stripXSSForCheck(String value) {
        Boolean result=true;
        if (value != null) {
            int count=value.length();
            value = value.replaceAll("\0", "");

            // Remove all sections that match a pattern
            for (Pattern scriptPattern : patterns){
                value = scriptPattern.matcher(value).replaceAll("");
            }

            if(value.length()==count) {
                result=true;
            }else {
                result=false;
            }
        }
        return result;
    }
}