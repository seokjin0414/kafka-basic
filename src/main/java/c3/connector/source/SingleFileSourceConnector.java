package c3.connector.source;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleFileSourceConnector extends SourceConnector {

    private final Logger logger = LoggerFactory.getLogger(SingleFileSourceConnector.class);

    private Map<String, String> configProperties;

    @Override
    public String version() {
        return "3.4";
    }

    @Override
    public void start(Map<String, String> props) {
        this.configProperties = props;
        try {
            new SingleFileSourceConnectorConfig(props);
        } catch (ConfigException e) {
            throw new ConnectException(e.getMessage(), e);
        }
    }

    // 보통 1개의 connector 당 1개의 task
    @Override
    public Class<? extends Task> taskClass() {
        return SingleFileSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        List<Map<String, String>> taskConfigs = new ArrayList<>();
        Map<String, String> taskProps = new HashMap<>();
        taskProps.putAll(configProperties);
        for (int i = 0; i < maxTasks; i++) {
            taskConfigs.add(taskProps);
        }
        return taskConfigs;
    }

    @Override
    public ConfigDef config() {
        return SingleFileSourceConnectorConfig.CONFIG;
    }

    @Override
    public void stop() {
    }
}