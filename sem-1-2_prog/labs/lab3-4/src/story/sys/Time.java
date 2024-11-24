package story.sys;

public record Time() {
    static private int sleepable = 1;
    static public void sleep(long seconds) {
        try {
            if (sleepable == 1) {
                Thread.sleep(seconds * 1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void skipSleep() {
        sleepable = (sleepable + 1) % 2;
    }
}
