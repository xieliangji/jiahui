package jc.sugar.JiaHui.jmeter;

import org.apache.jmeter.assertions.XMLAssertion;
import org.apache.jmeter.assertions.gui.*;
import org.apache.jmeter.assertions.jmespath.gui.JMESPathAssertionGui;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.config.gui.LoginConfigGui;
import org.apache.jmeter.config.gui.SimpleConfigGui;
import org.apache.jmeter.control.gui.*;
import org.apache.jmeter.extractor.gui.*;
import org.apache.jmeter.extractor.json.jmespath.gui.JMESPathExtractorGui;
import org.apache.jmeter.extractor.json.jsonpath.gui.JSONPostProcessorGui;
import org.apache.jmeter.modifiers.gui.CounterConfigGui;
import org.apache.jmeter.modifiers.gui.SampleTimeoutGui;
import org.apache.jmeter.modifiers.gui.UserParametersGui;
import org.apache.jmeter.protocol.ftp.config.gui.FtpConfigGui;
import org.apache.jmeter.protocol.ftp.control.gui.FtpTestSamplerGui;
import org.apache.jmeter.protocol.http.config.gui.HttpDefaultsGui;
import org.apache.jmeter.protocol.http.control.gui.AjpSamplerGui;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.gui.CacheManagerGui;
import org.apache.jmeter.protocol.http.gui.CookiePanel;
import org.apache.jmeter.protocol.http.gui.DNSCachePanel;
import org.apache.jmeter.protocol.http.gui.HeaderPanel;
import org.apache.jmeter.protocol.http.modifier.gui.AnchorModifierGui;
import org.apache.jmeter.protocol.http.modifier.gui.RegExUserParametersGui;
import org.apache.jmeter.protocol.http.modifier.gui.URLRewritingModifierGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.java.config.gui.JavaConfigGui;
import org.apache.jmeter.protocol.jdbc.config.DataSourceElement;
import org.apache.jmeter.protocol.tcp.config.gui.TCPConfigGui;
import org.apache.jmeter.reporters.gui.ResultActionGui;
import org.apache.jmeter.sampler.gui.TestActionGui;
import org.apache.jmeter.testbeans.gui.TestBeanGUI;
import org.apache.jmeter.threads.gui.PostThreadGroupGui;
import org.apache.jmeter.threads.gui.SetupThreadGroupGui;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.timers.gui.ConstantTimerGui;
import org.apache.jmeter.timers.gui.GaussianRandomTimerGui;
import org.apache.jmeter.timers.gui.PoissonRandomTimerGui;
import org.apache.jmeter.timers.gui.UniformRandomTimerGui;

public enum JMeterElement {
    TestGuiClassNull(null, null),

    TestPlan(org.apache.jmeter.testelement.TestPlan.class.getSimpleName(), TestPlanGui.class.getSimpleName()),

    ThreadGroup(org.apache.jmeter.threads.ThreadGroup.class.getSimpleName(), ThreadGroupGui.class.getSimpleName()),
    SetupThreadGroup(org.apache.jmeter.threads.SetupThreadGroup.class.getSimpleName(), SetupThreadGroupGui.class.getSimpleName()),
    PostThreadGroup(org.apache.jmeter.threads.PostThreadGroup.class.getSimpleName(), PostThreadGroupGui.class.getSimpleName()),

    HttpTestSample(HTTPSamplerProxy.class.getSimpleName(), HttpTestSampleGui.class.getSimpleName()),
    AjpSampler(org.apache.jmeter.protocol.http.sampler.AjpSampler.class.getSimpleName(), AjpSamplerGui.class.getSimpleName()),
    JDBCSampler(org.apache.jmeter.protocol.jdbc.sampler.JDBCSampler.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    TCPSampler(org.apache.jmeter.protocol.tcp.sampler.TCPSampler.class.getSimpleName(), TCPConfigGui.class.getSimpleName()),
    JSR223Sampler(org.apache.jmeter.protocol.java.sampler.JSR223Sampler.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    BoltSampler(org.apache.jmeter.protocol.bolt.sampler.BoltSampler.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    FTPSampler(org.apache.jmeter.protocol.ftp.sampler.FTPSampler.class.getSimpleName(), FtpTestSamplerGui.class.getSimpleName()),
    TestAction(org.apache.jmeter.sampler.TestAction.class.getSimpleName(), TestActionGui.class.getSimpleName()),
    DebugSampler(org.apache.jmeter.sampler.DebugSampler.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),

    IfController(org.apache.jmeter.control.IfController.class.getSimpleName(), IfControllerPanel.class.getSimpleName()),
    TransactionController(org.apache.jmeter.control.TransactionController.class.getSimpleName(), TransactionControllerGui.class.getSimpleName()),
    LoopController(org.apache.jmeter.control.LoopController.class.getSimpleName(), LoopControlPanel.class.getSimpleName()),
    WhileController(org.apache.jmeter.control.WhileController.class.getSimpleName(), WhileControllerGui.class.getSimpleName()),
    ForeachController(org.apache.jmeter.control.ForeachController.class.getSimpleName(), ForeachControlPanel.class.getSimpleName()),
    IncludeController(org.apache.jmeter.control.IncludeController.class.getSimpleName(), IncludeControllerGui.class.getSimpleName()),
    RunTime(org.apache.jmeter.control.RunTime.class.getSimpleName(), RunTimeGui.class.getSimpleName()),
    CriticalSectionController(org.apache.jmeter.control.CriticalSectionController.class.getSimpleName(), CriticalSectionControllerGui.class.getSimpleName()),
    InterleaveControl(org.apache.jmeter.control.InterleaveControl.class.getSimpleName(), InterleaveControlGui.class.getSimpleName()),
    OnceOnlyController(org.apache.jmeter.control.OnceOnlyController.class.getSimpleName(), OnceOnlyControllerGui.class.getSimpleName()),
    GenericController(org.apache.jmeter.control.GenericController.class.getSimpleName(), LogicControllerGui.class.getSimpleName()),
    RandomController(org.apache.jmeter.control.RandomController.class.getSimpleName(), RandomControlGui.class.getSimpleName()),
    RandomOrderController(org.apache.jmeter.control.RandomOrderController.class.getSimpleName(), RandomOrderControllerGui.class.getSimpleName()),
    ThroughputController(org.apache.jmeter.control.ThroughputController.class.getSimpleName(), ThroughputControllerGui.class.getSimpleName()),
    SwitchController(org.apache.jmeter.control.SwitchController.class.getSimpleName(), SwitchControllerGui.class.getSimpleName()),
    ModuleController(org.apache.jmeter.control.ModuleController.class.getSimpleName(), ModuleControllerGui.class.getSimpleName()),

    CSVDataSet(org.apache.jmeter.config.CSVDataSet.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    HeaderManager(org.apache.jmeter.protocol.http.control.HeaderManager.class.getSimpleName(), HeaderPanel.class.getSimpleName()),
    CookieManager(org.apache.jmeter.protocol.http.control.CookieManager.class.getSimpleName(), CookiePanel.class.getSimpleName()),
    CacheManager(org.apache.jmeter.protocol.http.control.CacheManager.class.getSimpleName(), CacheManagerGui.class.getSimpleName()),
    DNSCacheManager(org.apache.jmeter.protocol.http.control.DNSCacheManager.class.getSimpleName(), DNSCachePanel.class.getSimpleName()),
    JDBCDataSource(DataSourceElement.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    JavaConfig(org.apache.jmeter.protocol.java.config.JavaConfig.class.getSimpleName(), JavaConfigGui.class.getSimpleName()),
    KeystoreConfig(org.apache.jmeter.config.KeystoreConfig.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    LoginConfig(org.apache.jmeter.config.LoginConfig.class.getSimpleName(), LoginConfigGui.class.getSimpleName()),
    SimpleConfig(ConfigTestElement.class.getSimpleName(), SimpleConfigGui.class.getSimpleName()),
    CounterConfig(org.apache.jmeter.modifiers.CounterConfig.class.getSimpleName(), CounterConfigGui.class.getSimpleName()),
    RandomVariableConfig(org.apache.jmeter.config.RandomVariableConfig.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    Arguments(org.apache.jmeter.config.Arguments.class.getSimpleName(), ArgumentsPanel.class.getSimpleName()),
    TCPConfig(ConfigTestElement.class.getSimpleName(), TCPConfigGui.class.getSimpleName()),
    HttpDefaults(ConfigTestElement.class.getSimpleName(), HttpDefaultsGui.class.getSimpleName()),
    FTPConfig(ConfigTestElement.class.getSimpleName(), FtpConfigGui.class.getSimpleName()),
    BoltConnectionElement(org.apache.jmeter.protocol.bolt.config.BoltConnectionElement.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),

    JSR223PreProcessor(org.apache.jmeter.modifiers.JSR223PreProcessor.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    JDBCPreProcessor(org.apache.jmeter.protocol.jdbc.processor.JDBCPreProcessor.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    UserParameters(org.apache.jmeter.modifiers.UserParameters.class.getSimpleName(), UserParametersGui.class.getSimpleName()),
    AnchorModifier(org.apache.jmeter.protocol.http.modifier.AnchorModifier.class.getSimpleName(), AnchorModifierGui.class.getSimpleName()),
    URLRewritingModifier(org.apache.jmeter.protocol.http.modifier.URLRewritingModifier.class.getSimpleName(), URLRewritingModifierGui.class.getSimpleName()),
    SampleTimeout(org.apache.jmeter.modifiers.SampleTimeout.class.getSimpleName(), SampleTimeoutGui.class.getSimpleName()),
    RegExUserParameters(org.apache.jmeter.protocol.http.modifier.RegExUserParameters.class.getSimpleName(), RegExUserParametersGui.class.getSimpleName()),

    JSR223PostProcessor(org.apache.jmeter.extractor.JSR223PostProcessor.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    JDBCPostProcessor(org.apache.jmeter.protocol.jdbc.processor.JDBCPostProcessor.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    HtmlExtractor(org.apache.jmeter.extractor.HtmlExtractor.class.getSimpleName(), HtmlExtractorGui.class.getSimpleName()),
    JMESPathExtractor(org.apache.jmeter.extractor.json.jmespath.JMESPathExtractor.class.getSimpleName(), JMESPathExtractorGui.class.getSimpleName()),
    JSONPostProcessor(org.apache.jmeter.extractor.json.jsonpath.JSONPostProcessor.class.getSimpleName(), JSONPostProcessorGui.class.getSimpleName()),
    RegexExtractor(org.apache.jmeter.extractor.RegexExtractor.class.getSimpleName(), RegexExtractorGui.class.getSimpleName()),
    BoundaryExtractor(org.apache.jmeter.extractor.BoundaryExtractor.class.getSimpleName(), BoundaryExtractorGui.class.getSimpleName()),
    XPath2Extractor(org.apache.jmeter.extractor.XPath2Extractor.class.getSimpleName(), XPath2ExtractorGui.class.getSimpleName()),
    XPathExtractor(org.apache.jmeter.extractor.XPathExtractor.class.getSimpleName(), XPathExtractorGui.class.getSimpleName()),
    ResultAction(org.apache.jmeter.reporters.ResultAction.class.getSimpleName(), ResultActionGui.class.getSimpleName()),
    DebugPostProcessor(org.apache.jmeter.extractor.DebugPostProcessor.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),

    JSR223Assertion(org.apache.jmeter.assertions.JSR223Assertion.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    ResponseAssertion(org.apache.jmeter.assertions.ResponseAssertion.class.getSimpleName(), AssertionGui.class.getSimpleName()),
    JSONPathAssertion(org.apache.jmeter.assertions.JSONPathAssertion.class.getSimpleName(), JSONPathAssertionGui.class.getSimpleName()),
    SizeAssertion(org.apache.jmeter.assertions.SizeAssertion.class.getSimpleName(), SizeAssertionGui.class.getSimpleName()),
    XPath2Assertion(org.apache.jmeter.assertions.XPath2Assertion.class.getSimpleName(), XPath2AssertionGui.class.getSimpleName()),
    HTMLAssertion(org.apache.jmeter.assertions.HTMLAssertion.class.getSimpleName(), HTMLAssertionGui.class.getSimpleName()),
    JMESPathAssertion(org.apache.jmeter.assertions.jmespath.JMESPathAssertion.class.getSimpleName(), JMESPathAssertionGui.class.getSimpleName()),
    MD5HexAssertion(org.apache.jmeter.assertions.MD5HexAssertion.class.getSimpleName(), MD5HexAssertionGUI.class.getSimpleName()),
    XMLSchemaAssertion(org.apache.jmeter.assertions.XMLSchemaAssertion.class.getSimpleName(), XMLSchemaAssertionGUI.class.getSimpleName()),
    XMLAssertion(org.apache.jmeter.assertions.XMLAssertion.class.getSimpleName(), XMLAssertionGui.class.getSimpleName()),
    XPathAssertion(org.apache.jmeter.assertions.XPathAssertion.class.getSimpleName(), XPathAssertionGui.class.getSimpleName()),
    DurationAssertion(org.apache.jmeter.assertions.DurationAssertion.class.getSimpleName(), DurationAssertionGui.class.getSimpleName()),
    CompareAssertion(org.apache.jmeter.assertions.CompareAssertion.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),

    JSR223Timer(org.apache.jmeter.timers.JSR223Timer.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    ConstantTimer(org.apache.jmeter.timers.ConstantTimer.class.getSimpleName(), ConstantTimerGui.class.getSimpleName()),
    UniformRandomTimer(org.apache.jmeter.timers.UniformRandomTimer.class.getSimpleName(), UniformRandomTimerGui.class.getSimpleName()),
    PreciseThroughputTimer(org.apache.jmeter.timers.poissonarrivals.PreciseThroughputTimer.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    ConstantThroughputTimer(org.apache.jmeter.timers.ConstantThroughputTimer.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    SyncTimer(org.apache.jmeter.timers.SyncTimer.class.getSimpleName(), TestBeanGUI.class.getSimpleName()),
    PoissonRandomTimer(org.apache.jmeter.timers.PoissonRandomTimer.class.getSimpleName(), PoissonRandomTimerGui.class.getSimpleName()),
    GaussianRandomTimer(org.apache.jmeter.timers.GaussianRandomTimer.class.getSimpleName(), GaussianRandomTimerGui.class.getSimpleName()),;


    private String testClass;

    private String guiClass;

    JMeterElement(String testClass, String guiClass){
        this.testClass = testClass;
        this.guiClass = guiClass;
    }

    public String getTestClass() {
        return testClass;
    }

    public void setTestClass(String testClass) {
        this.testClass = testClass;
    }

    public String getGuiClass() {
        return guiClass;
    }

    public void setGuiClass(String guiClass) {
        this.guiClass = guiClass;
    }
}
