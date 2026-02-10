package com.automatiom.hooks;

import com.automation.config.ConfigReader;
import com.automation.context.TestContext;
import com.automation.factory.PlaywrightFactory;
import com.automation.utils.ScreenshotUtil;
import com.automation.utils.VideoRecorder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Hooks class for setup and teardown operations
 */
public class Hooks {
    
    private TestContext testContext;
    private PlaywrightFactory playwrightFactory;
    private VideoRecorder videoRecorder;
    private ScreenshotUtil screenshotUtil;
    
    public Hooks(TestContext testContext) {
        this.testContext = testContext;
        this.playwrightFactory = new PlaywrightFactory(testContext);
        this.videoRecorder = new VideoRecorder(testContext);
        this.screenshotUtil = new ScreenshotUtil(testContext);
    }
    
    /**
     * Before hook - runs before each scenario
     */
    @Before
    public void setUp(Scenario scenario) {
        System.out.println("==========================================");
        System.out.println("Starting Scenario: " + scenario.getName());
        System.out.println("==========================================");
        
        // Initialize browser
        playwrightFactory.initializeBrowser();
        
        // Start video recording
        if (ConfigReader.isVideoEnabled()) {
            videoRecorder.startRecording(scenario.getName());
        }
    }
    
    /**
     * After hook - runs after each scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("==========================================");
        System.out.println("Scenario: " + scenario.getName());
        System.out.println("Status: " + scenario.getStatus());
        System.out.println("==========================================");
        
        // Capture screenshot on failure
        if (scenario.isFailed()) {
            byte[] screenshot = screenshotUtil.captureFailureScreenshot(scenario.getName());
            if (screenshot != null) {
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        }
        
        // Stop video recording based on test result
        if (ConfigReader.isVideoEnabled()) {
            boolean isPassed = !scenario.isFailed();
            videoRecorder.stopRecording(isPassed);
            
            // Attach video path to scenario for reporting
            String videoPath = videoRecorder.attachVideoToReport();
            if (videoPath != null) {
                double videoSize = videoRecorder.getVideoFileSize();
                scenario.log(String.format("Video Evidence: %s (Size: %.2f MB)", videoPath, videoSize));
            }
        }
        
        // Close browser
        playwrightFactory.closeBrowser();
        
        // Clear scenario context
        testContext.clearContext();
        
        System.out.println("Browser closed and resources cleaned up");
    }
    
    /**
     * Hook for cleanup after all scenarios (can be used for cleaning old videos)
     */
    @After(order = 0)
    public void cleanupOldEvidence() {
        // Uncomment to enable automatic cleanup of videos older than 7 days
        // VideoRecorder.cleanupOldVideos(7);
    }
}