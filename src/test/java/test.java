import config.XmlConfigManager;

/**
 * Created by sirenchen on 2017/2/26.
 */
public class test {

    public static void main(String[] args) {

        BeanFactory beanFactory = new BeanFactory(XmlConfigManager.getBeanConfig("xmlConfig.xml"));

        Service service = (Service) beanFactory.getBean("service");
        Dao dao = (Dao) beanFactory.getBean("dao");

        service.save();
        System.out.println(dao.getDaoInt());
    }

}
