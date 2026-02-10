package com.automation.utils;

import com.automation.config.ConfigReader;
import com.automation.context.TestContext;
import com.microsoft.playwright.Page;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * VideoRecorder utility class to handle video recording and evidence management
 * for both pass and fail scenarios
 */
public class VideoRecorder {
    
    private TestContext testContext;
    private String scenarioVideoPath;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    
    public VideoRecorder(TestContext testContext) {
        this.testContext = testContext;
        initializeDirectories();
    }
    
    /**
     * Initialize required directories for storing videos
     */
    private void initializeDirectories() {
        try {
            // Create video directory
            Files.createDirectories(Paths.get(ConfigReader.getVideoPath()));
            
            // Create evidence directory
            Files.createDirectories(Paths.get(ConfigReader.getEvidencePath()));
            
            // Create pass and fail subdirectories
            Files.createDirectories(Paths.get(ConfigReader.getEvidencePath() + "pass/"));
            Files.createDirectories(Paths.get(ConfigReader.getEvidencePath() + "fail/"));
            
        } catch (IOException e) {
            System.err.println("Error creating directories: " + e.getMessage());
        }
    }
    
    /**
     * Start video recording for a scenario
     * Note: With Playwright, recording is started when BrowserContext is created
     * This method just prepares the naming convention
     */
    public void startRecording(String scenarioName) {
        String timestamp = dateFormat.format(new Date());
        String sanitizedScenarioName = sanitizeFileName(scenarioName);
        
        // Store the expected video filename pattern
        testContext.setScenarioName(sanitizedScenarioName + "_" + timestamp);
        
        System.out.println("Video recording initialized for scenario: " + scenarioName);
    }
    
    /**
     * Stop recording and handle video based on test result
     * @param isPassed - true if test passed, false if failed
     */
    public void stopRecording(boolean isPassed) {
        if (!ConfigReader.isVideoEnabled()) {
            return;
        }
        
        try {
            Page page = testContext.getPage();
            
            if (page != null && page.video() != null) {
                // Close the page to save the video
                Path videoPath = page.video().path();
                page.close();
                
                // Wait for video to be saved
                Thread.sleep(1000);
                
                // Handle video based on test result
                if (videoPath != null && Files.exists(videoPath)) {
                    handleVideoEvidence(videoPath, isPassed);
                }
            }
        } catch (Exception e) {
            System.err.println("Error stopping video recording: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Handle video evidence based on test result
     * @param originalVideoPath - path to the recorded video
     * @param isPassed - test result
     */
    private void handleVideoEvidence(Path originalVideoPath, boolean isPassed) {
        try {
            String status = isPassed ? "pass" : "fail";
            String scenarioName = testContext.getScenarioName();
            
            // Determine if we should retain the video
            boolean shouldRetain = isPassed ? 
                    ConfigReader.retainEvidenceOnPass() : 
                    ConfigReader.retainEvidenceOnFail();
            
            if (shouldRetain) {
                // Create destination path
                String evidenceFolder = ConfigReader.getEvidencePath() + status + "/";
                String videoFileName = scenarioName + ".webm";
                Path destinationPath = Paths.get(evidenceFolder + videoFileName);
                
                // Move video to evidence folder
                Files.move(originalVideoPath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                
                testContext.setVideoPath(destinationPath.toString());
                
                System.out.println(String.format(
                    "Video saved for %s scenario: %s", 
                    status.toUpperCase(), 
                    destinationPath
                ));
            } else {
                // Delete the video if retention is not required
                Files.deleteIfExists(originalVideoPath);
                System.out.println(String.format(
                    "Video deleted for %s scenario (retention disabled)", 
                    status.toUpperCase()
                ));
            }
            
        } catch (IOException e) {
            System.err.println("Error handling video evidence: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Get video path for the current scenario
     */
    public String getVideoPath() {
        return testContext.getVideoPath();
    }
    
    /**
     * Sanitize scenario name to be used as filename
     */
    private String sanitizeFileName(String fileName) {
        return fileName.replaceAll("[^a-zA-Z0-9-_]", "_");
    }
    
    /**
     * Clean up old videos based on retention policy
     * @param daysToKeep - number of days to keep videos
     */
    public static void cleanupOldVideos(int daysToKeep) {
        try {
            String[] folders = {
                ConfigReader.getEvidencePath() + "pass/",
                ConfigReader.getEvidencePath() + "fail/"
            };
            
            long cutoffTime = System.currentTimeMillis() - (daysToKeep * 24L * 60 * 60 * 1000);
            
            for (String folder : folders) {
                File directory = new File(folder);
                if (directory.exists() && directory.isDirectory()) {
                    File[] files = directory.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file.lastModified() < cutoffTime) {
                                if (file.delete()) {
                                    System.out.println("Deleted old video: " + file.getName());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error cleaning up old videos: " + e.getMessage());
        }
    }
    
    /**
     * Get video file size in MB
     */
    public double getVideoFileSize() {
        try {
            String videoPath = getVideoPath();
            if (videoPath != null) {
                File file = new File(videoPath);
                if (file.exists()) {
                    return file.length() / (1024.0 * 1024.0);
                }
            }
        } catch (Exception e) {
            System.err.println("Error getting video file size: " + e.getMessage());
        }
        return 0.0;
    }
    
    /**
     * Attach video to extent report (returns video path for embedding)
     */
    public String attachVideoToReport() {
        String videoPath = getVideoPath();
        if (videoPath != null && new File(videoPath).exists()) {
            return videoPath;
        }
        return null;
    }
}