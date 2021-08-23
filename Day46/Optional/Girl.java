package Day46.Optional;

import java.util.Objects;

/**
 * @ClassName: Girl
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/12 10:06
 **/

public class Girl {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Girl() {

    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Girl girl = (Girl) o;
        return Objects.equals(name, girl.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
