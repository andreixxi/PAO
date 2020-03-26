public interface Washable {

    //public static final by default, urm declarari sunt echivalente
    public static final int impervious = 0;
    static int resistant = 1;
    final int fragile = 2;
    public int explosive = 3;

    // public abstract
    void wash();

    //public
    default boolean needsWashing() {
        System.out.println("by default, wash everything");
        return true;
    }

}
