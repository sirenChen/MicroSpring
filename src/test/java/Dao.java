/**
 * Created by sirenchen on 2017/2/26.
 */
public class Dao {
    private int daoInt;

    public void save() {
        System.out.println("Dao save");
    }

    public void setDaoInt(int daoInt) {
        this.daoInt = daoInt;
    }

    public int getDaoInt() {
        return daoInt;
    }
}
