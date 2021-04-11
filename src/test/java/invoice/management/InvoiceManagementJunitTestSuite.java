package invoice.management;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class InvoiceManagementJunitTestSuite {
    SummaryGeneratingListener listener = new SummaryGeneratingListener();

    public void runAll() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectPackage("invoice.management.repo"))
                .filters(includeClassNamePatterns(".*Test"))
                .build();
        Launcher launcher = LauncherFactory.create();

//        TestPlan testPlan = launcher.discover(request);

        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);
    }

    public static void main(String[] args) {
        InvoiceManagementJunitTestSuite runner = new InvoiceManagementJunitTestSuite();
        runner.runAll();

        TestExecutionSummary summary = runner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));

        runner.runAll();

        summary = runner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));
    }
}
