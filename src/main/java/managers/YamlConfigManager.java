package managers;

import config.YAMLConfig;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class YamlConfigManager {
    static YAMLConfig yamlConfig;

    public static YAMLConfig getInstance(){
        if (yamlConfig == null)
            init();
        return yamlConfig;
    }

    public static void init(){
        Yaml yaml = new Yaml(new Constructor(YAMLConfig.class));
        InputStream yamlInputStream = YamlConfigManager.class.getClassLoader().getResourceAsStream("configuration.yml");
        yamlConfig = yaml.load(yamlInputStream);
    }
}
