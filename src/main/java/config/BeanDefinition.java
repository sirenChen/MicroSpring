package config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siren Chen.
 * Encapsulate the Bean Tag information in XmlConfig file
 */
public class BeanDefinition {
    private String id;
    private String className;

    private List<PropertyDefinition> properties = new ArrayList<PropertyDefinition>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<PropertyDefinition> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDefinition> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "config.BeanDefinition{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", properties=" + properties +
                '}';
    }
}
