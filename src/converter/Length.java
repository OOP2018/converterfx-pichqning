package converter;

/**
 * Enum is really class with a a fixed set of static
 * instances (defined inside the enum).
 * We will use an enum for Length units
 * @author Pichaaun Popukdee
 */
    public enum Length {
        Meter(1.00),
        Centimeter(0.01),
        Kilometer(1000),
        Mile(1609.344),
        Foot(0.30480),
        Wa(2.000),
        AU(149597870700.0)
        ;

        // attributes of the enum members
        private final double value;
        private Length( double value) {
            this.value = value;
        }
        public double getValue() {
            return value;
        }

    }



