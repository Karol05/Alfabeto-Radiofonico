package Main.Modelo;

public class Key {
    public Object key1, key2;

    public Key(Object key1, Object key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Key))
            return false;
        Key ref = (Key) obj;
        return this.key1.equals(ref.key1) &&
                this.key2.equals(ref.key2);
    }

    @Override
    public int hashCode() {
        return key1.hashCode() ^ key2.hashCode();
    }

}