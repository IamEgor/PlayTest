package utils;

public class Helper {

    public String tempString;

    public static class SingletonHolder {
        public static final Helper HOLDER_INSTANCE = new Helper();
    }

    public static Helper getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
