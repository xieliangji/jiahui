package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.jdbc.config.DataSourceElement;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.JDBCDataSource, testGuiClass = JMeterElement.JDBCDataSource)
public class JDBCDataSourceMapper extends JMeterElementMapperRoot<DataSourceElement> {

    public static final String WEB_DATA_SOURCE = "dataSource";

    public static final String WEB_POOL_MAX = "poolMax";

    public static final String WEB_TIMEOUT = "timeout";

    public static final String WEB_TRIM_INTERVAL = "trimInterval";

    public static final String WEB_AUTOCOMMIT = "autocommit";

    public static final String WEB_TRANSACTION_ISOLATION = "transactionIsolation";

    public static final String WEB_PREINIT = "preinit";

    public static final String WEB_INIT_QUERY = "initQuery";

    public static final String WEB_KEEP_ALIVE = "keepAlive";

    public static final String WEB_CONNECTION_AGE = "connectionAge";

    public static final String WEB_CHECK_QUERY = "checkQuery";

    public static final String WEB_DB_URL = "dbUrl";

    public static final String WEB_DRIVER = "driver";

    public static final String WEB_USERNAME = "username";

    public static final String WEB_PASSWORD = "password";

    public static final String WEB_CONNECTION_PROPERTIES = "connectionProperties";

    private JDBCDataSourceMapper(DataSourceElement element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JDBCDataSourceMapper(Map<String, Object> attributes){
        this(new DataSourceElement(), attributes);
    }

    public JDBCDataSourceMapper(DataSourceElement element){
        this(element, new HashMap<>());
    }

    @Override
    public DataSourceElement fromAttributes() {
        element.setProperty(WEB_DATA_SOURCE, getString(attributes.get(WEB_DATA_SOURCE)));
        element.setProperty(WEB_POOL_MAX, getString(attributes.get(WEB_POOL_MAX)));
        element.setProperty(WEB_TIMEOUT, getString(attributes.get(WEB_TIMEOUT)));
        element.setProperty(WEB_TRIM_INTERVAL, getString(attributes.get(WEB_TRIM_INTERVAL)));
        element.setProperty(WEB_AUTOCOMMIT, getBoolean(attributes.get(WEB_AUTOCOMMIT)));
        element.setProperty(WEB_TRANSACTION_ISOLATION, getString(attributes.get(WEB_TRANSACTION_ISOLATION)));
        element.setProperty(WEB_PREINIT, getBoolean(attributes.get(WEB_PREINIT)));
        element.setProperty(WEB_INIT_QUERY, getString(attributes.get(WEB_INIT_QUERY)));
        element.setProperty(WEB_KEEP_ALIVE, getBoolean(attributes.get(WEB_KEEP_ALIVE)));
        element.setProperty(WEB_CONNECTION_AGE, getString(attributes.get(WEB_CONNECTION_AGE)));
        element.setProperty(WEB_CHECK_QUERY, getString(attributes.get(WEB_CHECK_QUERY)));
        element.setProperty(WEB_DB_URL, getString(attributes.get(WEB_DB_URL)));
        element.setProperty(WEB_USERNAME, getString(attributes.get(WEB_USERNAME)));
        element.setProperty(WEB_PASSWORD, getString(attributes.get(WEB_PASSWORD)));
        element.setProperty(WEB_CONNECTION_PROPERTIES, getString(attributes.get(WEB_CONNECTION_PROPERTIES)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.JDBCDataSource);

        attributes.put(WEB_DATA_SOURCE, element.getPropertyAsString(WEB_DATA_SOURCE));
        attributes.put(WEB_POOL_MAX, element.getPropertyAsString(WEB_POOL_MAX));
        attributes.put(WEB_TIMEOUT, element.getPropertyAsString(WEB_TIMEOUT));
        attributes.put(WEB_TRIM_INTERVAL, element.getPropertyAsString(WEB_TRIM_INTERVAL));
        attributes.put(WEB_AUTOCOMMIT, element.getPropertyAsBoolean(WEB_AUTOCOMMIT));
        attributes.put(WEB_TRANSACTION_ISOLATION, element.getPropertyAsString(WEB_TRANSACTION_ISOLATION));
        attributes.put(WEB_PREINIT, element.getPropertyAsBoolean(WEB_PREINIT));
        attributes.put(WEB_INIT_QUERY, element.getPropertyAsString(WEB_INIT_QUERY));
        attributes.put(WEB_KEEP_ALIVE, element.getPropertyAsBoolean(WEB_KEEP_ALIVE));
        attributes.put(WEB_CONNECTION_AGE, element.getPropertyAsString(WEB_CONNECTION_AGE));
        attributes.put(WEB_CHECK_QUERY, element.getPropertyAsString(WEB_CHECK_QUERY));
        attributes.put(WEB_DB_URL, element.getPropertyAsString(WEB_DB_URL));
        attributes.put(WEB_USERNAME, element.getPropertyAsString(WEB_USERNAME));
        attributes.put(WEB_PASSWORD, element.getPropertyAsString(WEB_PASSWORD));
        attributes.put(WEB_CONNECTION_PROPERTIES, element.getPropertyAsString(WEB_CONNECTION_PROPERTIES));

        return attributes;
    }
}
