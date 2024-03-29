public enum Numbers {
        I("I", 1), II("II",2), III("III",3), IV("IV",4), V("V",5), VI("VI",6), VII("VII",7), VIII("VIII",8), IX("IX",9),
        X("X",10 ), XI("XI", 11), XII("XII", 12),XIII("XIII",13), XIV("XIV",14), XV("XV",15), XVI("XVI",16), XVII("XVII",17), XVIII("XVIII",18), XIX("XIX",19),
        XX("XX",20 ), XXI("XXI", 21), XXIV("XXIV", 24), XXV("XXV", 25), XXVII("XXVII", 27), XXVIII("XXVIII", 28),
        XXX("XXX", 30), XXXII("XXXII", 32), XXXV("XXXV", 35), XXXVI("XXXVI", 36),
        XL("XL", 40), XLII("XLII", 42), XLV("XLV", 45), XLVIII("XLVIII", 48), XLIX("XLIX", 49),
        L("L", 50), LIV("LIV", 54), LVI("LVI", 56),
        LX("LX", 60), LXIII("LXIII", 63), LXIV("LXIV", 64),
        LXX("LXX", 70), LXXII("LXXII", 72),
        LXXX("LXXX", 80), LXXXI("LXXXI", 81),
        XC("90", 90),
        C("C", 100);

    private String roman;
    private int arabic;
    private Numbers(String roman, int arabic) {
        this.roman = roman;
        this.arabic = arabic;
    }

    public static int toInt(String key) {
        for (Numbers n : Numbers.values()) {
            if (key.equals(n.roman)) return n.arabic;
        }
        return Integer.parseInt(key);
    }
    public static String toRoman(int key) {
        for (Numbers n : Numbers.values()) {
            if (key == n.arabic) return n.roman;
        }
        return null;
    }
    public static boolean isRoman(String key) {
        for (Numbers n : Numbers.values()) {
            if (key.equals(n.roman)) return true;
        }
        return false;
    }


}
