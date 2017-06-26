package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Siren Chen.
 * Encapsulate the Bean Tag information in XmlConfig file
 */
public class BeanDefinition {
    private String id;
    private String className;

    private Map<String, PropertyDefinition> propertyDefinitions = new HashMap<String, PropertyDefinition>();

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

    public Map<String, PropertyDefinition> getPropertyDefinitions() {
        return propertyDefinitions;
    }

    public void setPropertyDefinitions(Map<String, PropertyDefinition> propertyDefinitions) {
        this.propertyDefinitions = propertyDefinitions;
    }


    @Override
    public String toString() {
        return "BeanDefinition{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", propertyDefinitions=" + propertyDefinitions +
                '}';
    }
}
