package testng1;

import org.testng.IExecutionListener;

public class TestNGExecutionListener implements IExecutionListener {
    public void onExecutionStart() {
        System.out.println("TestNG is staring the execution");
    }
    public void onExecutionFinish() {
        System.out.println("Generating the Masterthought Report");
        GenerateReports.GenerateMasterthoughtReport();
        System.out.println("TestNG has finished, the execution");
    }
}
