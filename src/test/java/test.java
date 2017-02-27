/**
 * Created by sirenchen on 2017/2/26.
 */
public class test {

    public static void main(String[] args) {

        MyBeanFactory beanFactory = new MyBeanFactory("xmlConfig.xml");

        Service service = (Service) beanFactory.container.get("service");

        service.save();
    }

}
