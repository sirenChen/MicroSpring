package beanDefinitionReader;

import config.BeanDefinitionRegistry;

/**
 * Created by siren on 2017/6/25.
 */
public interface BeanDefinitionReader {

    public BeanDefinitionRegistry read(String path) throws Exception;

}
