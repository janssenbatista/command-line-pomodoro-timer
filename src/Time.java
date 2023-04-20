public enum Time {
    WORK_TIME(25),
    BREAK_TIME(5),
    LONG_BREAK_TIME(15);

    final int value;

    Time(int value) {
        this.value = value;
    }
}
