package beanWrapper;

/**
 * Created by siren on 2017/6/25.
 */
public interface BeanWrapper {

    public void setPro(Object bean, String pName, String pValue);

    public void setPro(Object bean, String pName, Object value);

}
