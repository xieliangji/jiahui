package jc.sugar.JiaHui.jmeter;

/**
 * 2021/5/21 17:33
 * Code by 谢良基
 */
public interface JMeterElementType {
    String TestPlan = "TestPlan";

    /** ThreadGroups */
    String SetupThreadGroup = "SetupThreadGroup";
    String PostThreadGroup = "PostThreadGroup";
    String ThreadGroup = "ThreadGroup";
    String ArrivalsThreadGroup = "ArrivalsThreadGroup";

    /** Controllers */
    String IfController = "IfController";
    String TransactionController = "TransactionController";
    String LoopController = "LoopController";
    String WhileController = "WhileController";
    String ForeachController = "ForeachController";
    String IncludeController = "IncludeController";
    String RunTime = "RunTime";
    String CriticalSectionController = "CriticalSectionController";
    String InterleaveControl = "InterleaveControl";
    String OnceOnlyController = "OnceOnlyController";
    String RecordingController = "RecordingController";
    String GenericController = "GenericController";
    String RandomController = "RandomController";
    String RandomOrderController = "RandomOrderController";
    String ThroughputController = "ThroughputController";
    String SwitchController = "SwitchController";
    String ModuleController = "ModuleController";

    /** Sampler */
    String HttpTestSample = "HttpTestSample";
    String TestAction = "TestAction";
    String DebugSampler = "DebugSampler";
    String JSR223Sampler = "JSR223Sampler";
    String AjpSampler = "AjpSampler";
    String AccessLogSampler = "AccessLogSampler";
    String BeanShellSampler = "BeanShellSampler";
    String BoltSampler = "BoltSampler";
    String FTPSampler = "FTPSampler";
    String GraphQLHTTPSampler = "GraphQLHTTPSampler";
    String JDBCSampler = "JDBCSampler";
    String PublisherSampler = "PublisherSampler";
    String JMSSampler = "JMSSampler";
    String SubscriberSampler = "SubscriberSampler";
    String JUnitSampler = "JUnitSampler";
    String JavaSampler = "JavaSampler";
    String LDAPExtSampler = "LDAPExtSampler";
    String LDAPSampler = "LDAPSampler";
    String SystemSampler = "SystemSampler";
    String SmtpSampler = "SmtpSampler";
    String TCPSampler = "TCPSampler";
    String MailReaderSampler = "MailReaderSampler";


    /** Config Element */
    String CSVDataSet = "CSVDataSet";
    String HeaderManager = "HeaderManager";
    String CookieManager = "CookieManager";
    String CacheManager = "CacheManager";
    String HttpDefaults = "HttpDefaults";
    String BoltConnectionElement = "BoltConnectionElement";
    String DNSCacheManager = "DNSCacheManager";
    String FtpConfig = "FtpConfig";
    String AuthManager = "AuthManager";
    String JDBCDataSource = "JDBCDataSource";
    String JavaConfig = "JavaConfig";
    String LdapExtConfig = "LdapExtConfig";
    String LdapConfig = "LdapConfig";
    String TCPConfig = "TCPConfig";
    String KeystoreConfig = "KeystoreConfig";
    String Arguments = "Arguments";
    String LoginConfig = "LoginConfig";
    String SimpleConfig = "SimpleConfig";
    String CounterConfig = "CounterConfig";
    String RandomVariableConfig = "RandomVariableConfig";

    // 前置处理器
    String JSR223PreProcessor = "JSR223PreProcessor";
    String UserParameters = "UserParameters";
    String AnchorModifier = "AnchorModifier";
    String URLRewritingModifier = "URLRewritingModifier";
    String JDBCPreProcessor = "JDBCPreProcessor";
    String SampleTimeout = "SampleTimeout";
    String RegExUserParameters = "RegExUserParameters";
    String BeanShellPreProcessor = "BeanShellPreProcessor";

    // 后置处理器
    String HtmlExtractor = "HtmlExtractor";
    String JMESPathExtractor = "JMESPathExtractor";
    String JSONPostProcessor = "JSONPostProcessor";
    String RegexExtractor = "RegexExtractor";
    String BoundaryExtractor = "BoundaryExtractor";
    String JSR223PostProcessor = "JSR223PostProcessor";
    String JDBCPostProcessor = "JDBCPostProcessor";
    String XPath2Extractor = "XPath2Extractor";
    String XPathExtractor = "XPathExtractor";
    String ResultAction = "ResultAction";
    String DebugPostProcessor = "DebugPostProcessor";
    String BeanShellPostProcessor = "BeanShellPostProcessor";

    // 断言
    String ResponseAssertion = "ResponseAssertion";
    String JSONPathAssertion = "JSONPathAssertion";
    String SizeAssertion = "SizeAssertion";
    String JSR223Assertion = "JSR223Assertion";
    String XPath2Assertion = "XPath2Assertion";
    String HTMLAssertion = "HTMLAssertion";
    String JMESPathAssertion = "JMESPathAssertion";
    String MD5HexAssertion = "MD5HexAssertion";
    String SMIMEAssertion = "SMIMEAssertion";
    String XMLSchemaAssertion = "XMLSchemaAssertion";
    String XMLAssertion = "XMLAssertion";
    String XPathAssertion = "XPathAssertion";
    String DurationAssertion = "DurationAssertion";
    String CompareAssertion = "CompareAssertion";
    String BeanShellAssertion = "BeanShellAssertion";

    // 定时器
    String ConstantTimer = "ConstantTimer";
    String UniformRandomTimer = "UniformRandomTimer";
    String PreciseThroughputTimer = "PreciseThroughputTimer";
    String ConstantThroughputTimer = "ConstantThroughputTimer";
    String JSR223Timer = "JSR223Timer";
    String SyncTimer = "SyncTimer";
    String PoissonRandomTimer = "PoissonRandomTimer";
    String GaussianRandomTimer = "GaussianRandomTimer";
    String BeanShellTimer = "BeanShellTimer";
}
