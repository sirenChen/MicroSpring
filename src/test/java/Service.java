/**
 * Created by sirenchen on 2017/2/26.
 */
public class Service {
    private Dao dao;

    public void save() {

        System.out.println("Service save");
        dao.save();

    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
