package by.it.tarasevich.jd01_09;

class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else

            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else

            return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value * ((Scalar) other).value;
            return new Scalar(sub);
        } else

            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value / ((Scalar) other).value;
            return new Scalar(sub);
        } else

            return other.div(this);
    }


    @Override
    public String toString() {

        return Double.toString(value);
    }
}

