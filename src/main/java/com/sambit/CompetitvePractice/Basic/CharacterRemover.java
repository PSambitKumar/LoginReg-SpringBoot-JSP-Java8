package com.sambit.CompetitvePractice.Basic;

import java.util.regex.Pattern;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 18-Apr-2024 : 09:12 AM
 */

public class CharacterRemover {
    public static String removeNonAllowedCharacters(String input) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9`~!@#$%^&*()\\-_=+\\[\\]{}\\\\|;:'\"<>,./?\\s]");
//        Pattern pattern = Pattern.compile("[^0-9`~!@#$%^&*()\\-_=+\\[\\]{}\\\\|;:'\"<>,./?a-zA-Z ¤©ª«¬¯°±²³´µ¶·¸¹º»¼½¾¿÷ÆĲŒœƔƕƋƕƜƝƢƸƾǅǊǋǽǾǼɁɀȾɎʒəɼʰʲʱʴʳʵʶʷʸˁˀˇˆ˟ˠ˩˧Ͱͱͳʹͼͻͺ͵ͿΏΔΘΞΛΣΠΦΧΨΩΪΫάέήίΰαβδεθηκλμξπςρφχψωϊϋϏώϑϐϓϒϔϕϖϠϟϞϝϜϡϢϤϣϧϫϬϮϯϰϱ₠₡₢₣₤₥₦₧₨₩₪₫€₭₮₯₰₱₲₳₴₵₶₷₸₹₺₻₼₽₾₿⅐⅑⅒⅓⅔⅕⅖⅗⅘⅙⅚⅛⅜⅝⅞⅟℠℡™℣ℤ℥Ω℧ℨ℩KÅℬℭ℮ℯ⇀⇁ↀↁↂↃↄ⇔⇕⇖⇗⇘⇙⇚⇛⇜⇝⇞⇟⇠⇡⇢⇣⇤⇥⇦⇧⇨⅀⅁⅂⅃⅄ⅅⅆⅇⅈⅉ⅊⅋⅌⅍ⅎ⅏ⅱⅲⅳⅴⅵⅶⅷⅸⅹⅺⅻⅼⅽ]");
        return pattern.matcher(input).replaceAll("");
    }

    public static void main(String[] args) {
        String input = "Neonates <1200 g ORNeonates of any weight with at least one of the following conditions: • Severe Respiratory Failure requiring High Frequency Ventilation or inhaled Nitric Oxide (iNO) • Multisystem failure requiring multiple organ support including mechanical ventilation and multiple inotropes • Reuiring parenteral nutrition Critical congenital heart disease (excluding surgical costs)The above list is illustrative but not limited to these conditions. The package includes mandatory stay and food of the mother in the hospital for breastfeeding, Kangaroo Mother Care (KMC) and Family centered care";
        String result = removeNonAllowedCharacters(input);
        System.out.println(result);
    }
}
