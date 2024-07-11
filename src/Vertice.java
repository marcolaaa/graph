import java.util.Objects;

public class Vertice {
    Character value;
    public Vertice(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return Objects.equals(value, vertice.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
