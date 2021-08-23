package Day46.Optional;

import java.util.Objects;

/**
 * @ClassName: Boy
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/12 10:06
 **/

public class Boy {
    private Girl girl;

    public Boy() {

    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boy boy = (Boy) o;
        return Objects.equals(girl, boy.girl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(girl);
    }
}
