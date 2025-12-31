@CanadaITClub @JobPosting
Feature: Canada IT Club Test Lead Job Posting Page
  As a job seeker or site visitor
  I want to interact with the job posting page
  So that I can view job details and apply for positions

  # ==================== TEST SUITE 1: Page Load and Navigation ====================

  @PageLoad @Smoke
  Scenario: Verify page loads successfully
    Given I navigate to the Canada IT Club job posting page
    And I wait for the page to fully load
    When the page loading completes
    Then the page title should display "Test Lead - Canada IT Club"
    And all page elements should be visible and accessible
    And no error messages or broken images should be displayed

  @Navigation @Smoke
  Scenario: Verify navigation menu is visible and functional
    Given I am on the Canada IT Club job posting page
    And the page has fully loaded
    When I look at the navigation menu
    Then the navigation bar should be visible at the top
    And all menu items should be present:
      | Menu Item |
      | Home |
      | About Us |
      | Browse Jobs |
      | Working In Canada |
      | Life in Canada |
    And all menu items should be clickable

  @Navigation @Links
  Scenario: Test navigation menu links
    Given I am on the Canada IT Club job posting page
    When I click on "Home" in the navigation menu
    Then I should be navigated to "https://canadaitclub.ca/"
    And the page should load without errors

    When I click on "About Us" in the navigation menu
    Then I should be navigated to "https://canadaitclub.ca/about-us/"
    
    When I click on "Browse Jobs" in the navigation menu
    Then I should be navigated to "https://canadaitclub.ca/browse-jobs/"
    
    When I click on "Life in Canada" in the navigation menu
    Then I should be navigated to "https://canadaitclub.ca/life-in-canada/"
    And no 404 or broken link errors should occur

  # ==================== TEST SUITE 2: Job Header Section ====================

  @Header @Content
  Scenario: Verify job title and key information display
    Given I am on the Canada IT Club job posting page
    When the page fully loads
    Then the job title "Test Lead" should be displayed prominently
    And the job category "Quality Assurance & Testing" should be displayed
    And the location "Ontario – Toronto" should be displayed
    And the posting date "December 16, 2025" should be displayed
    And the job title should appear as an H1 heading
    And all metadata should be visible in the header section
    And the formatting should be clear and readable

  @Header @Logo
  Scenario: Verify employer logo and company link
    Given I am on the Canada IT Club job posting page
    When I look for the Canada IT Club logo
    Then the logo should be visible on the left side
    And the logo should display without distortion
    And the logo should be clickable

    When I click on the logo or company name link
    Then the page should navigate to the employer profile
    And the company profile page should load successfully

  @Header @Badge
  Scenario: Verify job type badge display
    Given I am on the Canada IT Club job posting page
    When I look for the job type badge
    Then the job type badge should be visible
    And the badge should display "Contractor"
    And the badge styling should be distinct with different color

  # ==================== TEST SUITE 3: Apply Now Button and CTA ====================

  @CTA @ApplyButton @Smoke
  Scenario: Verify Apply Now button is visible and clickable
    Given I am on the Canada IT Club job posting page
    When I look for the "Apply Now" button
    Then the button should be prominently displayed in blue
    And the button text should be clear: "Apply Now"
    And the button should be clickable and responsive

  @CTA @ApplyButton @Navigation
  Scenario: Verify Apply Now button navigation
    Given I am on the Canada IT Club job posting page
    When I click the "Apply Now" button
    And I wait for page navigation
    Then I should be redirected to the LinkedIn post
    And the page should load successfully
    And a new tab or window should open

  @CTA @Bookmark
  Scenario: Verify bookmark or save button functionality
    Given I am on the Canada IT Club job posting page
    When I locate the bookmark or save icon
    And I click the bookmark icon
    Then the icon should change appearance
    And the job should be saved to the user's saved jobs list

  # ==================== TEST SUITE 4: Job Description Section ====================

  @Description @Structure
  Scenario: Verify job description title and structure
    Given I am on the Canada IT Club job posting page
    When I scroll to the "Job Description" section
    Then the "Job Description" heading should be clearly visible
    And the heading level and formatting should be correct
    And all subsections should be visible
    And the content should be organized logically
    And all sections should load properly

  @Description @Details
  Scenario: Verify key details display
    Given I am on the Canada IT Club job posting page
    When I look at the description section
    Then the following details should be displayed:
      | Field | Value |
      | Job Type | Contractor |
      | Location | Anywhere |
      | Posted | Posted 2 days ago |
    And all metadata fields should be visible
    And the information should be accurate and up-to-date
    And icons or labels should be clear

  @Description @MainText
  Scenario: Verify job description main text
    Given I am on the Canada IT Club job posting page
    When I locate the main job description paragraph
    Then the description should start with "We're Hiring | Test Lead – Onsite (Toronto, ON, Canada)"
    And the full description text should be present
    And the text should be properly formatted with line breaks
    And no truncation of content should occur
    And all text should be readable without scrolling

  @Description @Location
  Scenario: Verify location information display
    Given I am on the Canada IT Club job posting page
    When I look for location information
    Then the location "Toronto, ON, Canada (Onsite)" should be displayed
    And the location should have a blue diamond icon
    And the location link "Ontario – Toronto" should be present
    And the location link should be clickable

  @Description @Experience
  Scenario: Verify experience requirements display
    Given I am on the Canada IT Club job posting page
    When I look for experience requirements
    Then the text should display "Experience: 10+ years overall | Minimum 3+ years as a Test Lead"
    And the text should have a blue diamond icon
    And the experience requirements should be clear and complete
    And the numbers should be accurate: 10+ years total, 3+ years as Test Lead
    And the formatting should be consistent with other bullet points

  @Description @Responsibilities
  Scenario: Verify key responsibilities section
    Given I am on the Canada IT Club job posting page
    When I locate the "Key Responsibilities & Requirements" section
    Then the section should have a magnifying glass icon
    And all 7 responsibility points should be visible:
      | Responsibility |
      | Proven experience as a Test Lead with strong ownership of QA activities |
      | Must have hands-on experience in the Banking or Financial domain |
      | Strong knowledge of IT QA and Functional Testing |
      | In-depth understanding of SDLC, testing methodologies (Agile, Waterfall) |
      | Ability to define quality goals and measurement plans |
      | Extensive experience in system analysis, assessment, programming |
      | Strong expertise in compiling, analyzing, and interpreting test and quality reports |
    And checkmark icons should display correctly
    And all text should be complete and not truncated

  @Description @Tools
  Scenario: Verify tools and technologies section
    Given I am on the Canada IT Club job posting page
    When I locate the "Tools & Technologies" section
    Then the section should have a wrench icon
    And all 6 tools and technologies should be listed:
      | Tool |
      | HP ALM / Quality Center |
      | JIRA & Confluence |
      | Git or Bitbucket |
      | Maven |
      | Postman, SoapUI, or similar API testing tools |
      | Automated testing frameworks |
    And orange square icons should display correctly
    And each tool should be on separate line
    And all text should be complete

  @Description @Candidate
  Scenario: Verify what we're looking for section
    Given I am on the Canada IT Club job posting page
    When I locate the "What We're Looking For" section
    Then the section should have a star icon
    And the section header should be visible
    And the description should state: "A proactive leader who can drive quality initiatives, collaborate with cross-functional teams, and ensure delivery of high-quality software solutions in a fast-paced environment."
    And the text should be readable and complete

  @Description @Contact
  Scenario: Verify contact email display
    Given I am on the Canada IT Club job posting page
    When I look for contact information
    Then the contact email "Shivam.agnihotri@varite.com" should be displayed
    And the email should be clearly formatted
    And the email should be selectable
    And if clickable, it should open the email client when clicked

  # ==================== TEST SUITE 5: Related Jobs Section ====================

  @Related @Section
  Scenario: Verify related jobs section heading
    Given I am on the Canada IT Club job posting page
    When I scroll down to find the "Related" section
    Then the "Related" section heading should be present
    And the section should be properly labeled

  @Related @Cards
  Scenario: Verify related job cards display
    Given I am on the Canada IT Club job posting page
    When I look for related jobs
    Then the following related jobs should be displayed:
      | Job Title | Date |
      | QA / QC Test Analyst (Mobile + Web + Automation) | December 6, 2025 |
      | QA Automation Developers | December 4, 2025 |
      | Business Systems Analyst (Capital Markets) | December 18, 2025 |
    And each card should display job title, date posted, and "Similar post" label
    And each card should be clickable

  @Related @Links
  Scenario: Test related job links
    Given I am on the Canada IT Club job posting page
    When I click on the first related job "QA / QC Test Analyst (Mobile + Web + Automation)"
    Then the page should navigate to "https://canadaitclub.ca/job/qa-qc-test-analyst-mobile-web-automation/"
    And the page should load without errors

    When I go back and click on the next related job
    Then it should navigate to the corresponding job posting
    And pages should load without errors
    And no broken links should exist

  # ==================== TEST SUITE 6: Share Section ====================

  @Share @Section
  Scenario: Verify share section display
    Given I am on the Canada IT Club job posting page
    When I scroll to the share section
    Then the "Share this post" heading should be displayed
    And share buttons for Twitter and LinkedIn should be visible
    And the buttons should be clickable

  @Share @Twitter
  Scenario: Test Twitter share button
    Given I am on the Canada IT Club job posting page
    When I click the Twitter share button
    Then the Twitter sharing interface should open
    And the correct share URL should be used: "https://canadaitclub.ca/job/test-lead-5/"
    And the share dialog should open successfully

  @Share @LinkedIn
  Scenario: Test LinkedIn share button
    Given I am on the Canada IT Club job posting page
    When I click the LinkedIn share button
    Then the LinkedIn sharing interface should open
    And the correct URL and title should be shared
    And the share dialog should open successfully

  # ==================== TEST SUITE 7: Related Jobs Carousel ====================

  @Carousel @Display
  Scenario: Verify related jobs carousel displays
    Given I am on the Canada IT Club job posting page
    When I scroll to the "Related Jobs" section at the bottom
    Then the carousel section should display at least 3-4 job cards
    And the jobs should include positions like SDET, QA Lead, QA Analyst, Backend QA Engineer
    And all cards should be properly formatted

  @Carousel @Navigation
  Scenario: Verify related jobs carousel navigation if applicable
    Given I am on the Canada IT Club job posting page
    And I can see the related jobs carousel
    When I look for carousel navigation arrows or scroll functionality
    Then the navigation should work smoothly if present
    And I should be able to view all jobs in carousel
    And no jobs should be hidden or inaccessible

  # ==================== TEST SUITE 8: Job Overview Section ====================

  @Overview @Sidebar
  Scenario: Verify job overview sidebar displays
    Given I am on the Canada IT Club job posting page
    When I look for the "Job Overview" section in the right sidebar
    Then the "Job Overview" heading should be visible
    And all overview fields should be present:
      | Field |
      | Date Posted |
      | Location |
      | Expiration date |
      | Work Location Type |
    And all fields should display values
    And the information should be accurate

  @Overview @DatePosted
  Scenario: Verify date posted information
    Given I am on the Canada IT Club job posting page
    When I look at the "Date Posted" field in Job Overview
    Then the value should display "December 16, 2025"
    And the date format should be consistent
    And the date should match the posting date

  @Overview @Location
  Scenario: Verify location information in overview
    Given I am on the Canada IT Club job posting page
    When I look at the "Location" field in Job Overview
    Then the value should display "Ontario – Toronto"
    And the location should be a clickable link

  @Overview @ExpirationDate
  Scenario: Verify expiration date display
    Given I am on the Canada IT Club job posting page
    When I look at the "Expiration date" field in Job Overview
    Then the value should display "December 31, 2025"
    And the date should be in the future

  @Overview @WorkLocation
  Scenario: Verify work location type display
    Given I am on the Canada IT Club job posting page
    When I look at the "Work Location Type" field in Job Overview
    Then the field should display "On-site"
    And the label should be clear
    And it should match the job description mentioning "Onsite (Toronto)"

  # ==================== TEST SUITE 9: Employer Information Section ====================

  @Employer @Section
  Scenario: Verify employer information section displays
    Given I am on the Canada IT Club job posting page
    When I scroll to find the "Employer Information" section
    Then the "Employer Information" heading should be visible
    And the employer name "Canada IT Club" should be displayed
    And the company details should be present

  @Employer @Profile
  Scenario: Test view company profile link
    Given I am on the Canada IT Club job posting page
    When I locate and click the "View Company Profile" link
    Then the page should navigate to "https://canadaitclub.ca/employer/canada-it-club/"
    And the company profile page should load successfully
    And the link should be clickable

  @Employer @Description
  Scenario: Verify employer description display
    Given I am on the Canada IT Club job posting page
    When I look at the employer description section
    Then the description should be visible and complete
    And the text should display: "Canada IT Club is a dynamic community that brings together IT professionals from across Canada, fostering collaboration, knowledge sharing, and career growth."
    And the text should be readable
    And no truncation should occur

  # ==================== TEST SUITE 10: Footer Section ====================

  @Footer @Resources
  Scenario: Verify footer helpful resources section
    Given I am on the Canada IT Club job posting page
    When I scroll to the bottom of the page
    And I look for the "Helpful Resources" section
    Then the heading should be displayed
    And the following links should be present:
      | Link |
      | About Us |
      | Privacy Policy |
      | Terms & Conditions |
    And all links should be clickable
    And proper formatting should be applied

  @Footer @ResourceLinks
  Scenario: Test helpful resources links
    Given I am on the Canada IT Club job posting page
    When I click the "About Us" link in the footer
    Then I should be navigated to "https://canadaitclub.ca/about-us/"

    When I click the "Privacy Policy" link
    Then I should be navigated to the Privacy Policy page

    When I click the "Terms & Conditions" link
    Then I should be navigated to the Terms & Conditions page
    And all links should navigate to correct pages
    And pages should load successfully
    And no broken links should exist

  @Footer @Social
  Scenario: Verify social media links display
    Given I am on the Canada IT Club job posting page
    When I scroll to the "Reach Us" section at the bottom
    Then the following social media links should be visible:
      | Social Media |
      | LinkedIn |
      | WhatsApp |
      | YouTube |
      | Instagram |
    And all links should be properly labeled
    And all links should be clickable

  @Footer @SocialLinks
  Scenario: Test social media links
    Given I am on the Canada IT Club job posting page
    When I click on each social media link
    Then LinkedIn should open: "https://www.linkedin.com/company/canada-it-club/"
    And WhatsApp should open: "https://www.whatsapp.com/channel/0029VaYMzw8JENy5XiHyeG2L"
    And YouTube should open: "https://www.youtube.com/@canada_it_club"
    AndInstagram should open: "https://www.instagram.com/canada.it.club/"
    And all links should open successfully

  @Footer @Feedback
  Scenario: Verify feedback section
    Given I am on the Canada IT Club job posting page
    When I scroll to the bottom of the page
    And I look for the "Request Feature / Send Feedback" section
    Then the section heading should be visible
    And the email "hello@canadaitclub.ca" should be displayed
    And the email should be clickable or selectable

  @Footer @Copyright
  Scenario: Verify copyright information
    Given I am on the Canada IT Club job posting page
    When I scroll to the very bottom of the page
    Then the copyright notice should be displayed
    And the notice should state: "© 2024 Canada IT Club. All Right Reserved."
    And the text should be visible at the bottom of the page

  # ==================== TEST SUITE 11: Responsive Design & Cross-Browser ====================

  @Responsive @Mobile
  Scenario: Verify page responsive on mobile
    Given I am on the Canada IT Club job posting page
    When I resize the browser to mobile dimensions (375x667)
    Then the page layout should adapt to mobile size
    And all content should be readable
    And no horizontal scroll should be required
    And button sizes should be at least 44x44 pixels
    And the navigation should be properly formatted for mobile

  @Responsive @Tablet
  Scenario: Verify page responsive on tablet
    Given I am on the Canada IT Club job posting page
    When I resize the browser to tablet dimensions (768x1024)
    Then the page layout should be optimized for tablet view
    And content should be properly arranged
    And the navigation should be accessible
    And content should be properly arranged

  @CrossBrowser @Chrome
  Scenario: Test browser compatibility - Chrome
    Given I have Chrome browser open
    When I navigate to the Canada IT Club job posting page
    Then the page should load without errors
    And all elements should render correctly
    And all interactive elements should work properly

  @CrossBrowser @Firefox
  Scenario: Test browser compatibility - Firefox
    Given I have Firefox browser open
    When I navigate to the Canada IT Club job posting page
    Then the page should load without errors
    And all elements should render correctly
    And all interactive elements should work properly

  @CrossBrowser @Safari
  Scenario: Test browser compatibility - Safari
    Given I have Safari browser open
    When I navigate to the Canada IT Club job posting page
    Then the page should load without errors
    And all elements should render correctly
    And all interactive elements should work properly

  # ==================== TEST SUITE 12: Performance & Accessibility ====================

  @Performance @PageLoad
  Scenario: Verify page load performance
    Given I open the DevTools Performance tab
    When I navigate to the Canada IT Club job posting page
    And I measure the page load time
    Then the page should fully load within 3 seconds
    And no major performance warnings should appear
    And the DOM Content Loaded should complete before Load event

  @Accessibility @AltText
  Scenario: Verify accessibility - text alternatives for images
    Given I am on the Canada IT Club job posting page
    When I use an accessibility inspector like Lighthouse or WAVE
    Then all images should have appropriate alt text
    And alt text should be descriptive
    And emoji images should be properly labeled

  @Accessibility @Headings
  Scenario: Verify heading hierarchy
    Given I am on the Canada IT Club job posting page
    When I inspect the heading structure using an accessibility tool
    Then the heading levels should be logical:
      | Level | Content |
      | H1 | Test Lead |
      | H2 | Job Overview / Employer Information / Helpful Resources / Reach Us |
      | H3 | Job Description / Related / Share this post |
      | H4 | Related Jobs |
    And no heading levels should be skipped
    And the hierarchy should be proper for accessibility

  @Accessibility @Contrast
  Scenario: Verify color contrast
    Given I am on the Canada IT Club job posting page
    When I check the color contrast using a contrast checker
    Then all text should have sufficient contrast ratio
    And contrast ratio should meet WCAG AA standards (4.5:1 for normal text)
    And text should be readable for users with color blindness
    And no text should be too light or too dark

  @Accessibility @KeyboardNavigation
  Scenario: Verify keyboard navigation
    Given I am on the Canada IT Club job posting page
    When I press the Tab key repeatedly to navigate through elements
    Then all interactive elements should be reachable via Tab
    And the focus indicator should be visible
    And there should be no keyboard traps
    And buttons should activate with Enter key
    And links should follow with Enter key
    And Shift+Tab should allow reverse navigation

  # ==================== TEST SUITE 13: Content Accuracy & Validation ====================

  @Content @EmailValidation
  Scenario: Verify email format validity
    Given I am on the Canada IT Club job posting page
    When I locate the contact email "Shivam.agnihotri@varite.com"
    Then the email should follow standard format: localpart@domain.com
    And the domain should appear to be valid
    And there should be no obvious typos in the email

  @Content @ExternalLinks
  Scenario: Verify all external links are functional
    Given I am on the Canada IT Club job posting page
    When I test all external links including:
      | Link |
      | Apply Now button (LinkedIn) |
      | All navigation links |
      | All social media links |
      | All related job links |
    Then no HTTP 404 errors should occur
    And all external sites should load successfully
    And no timeout errors should occur

  @Content @DateConsistency
  Scenario: Verify date consistency
    Given I am on the Canada IT Club job posting page
    When I compare dates across different sections:
      | Section | Expected Date |
      | Header | December 16, 2025 |
      | Job Overview | December 16, 2025 |
      | Posted timestamp | 2 days ago |
    Then all dates should be consistent
    And relative dates should match absolute dates
    And no conflicting date information should exist

  @Content @LocationConsistency
  Scenario: Verify location consistency
    Given I am on the Canada IT Club job posting page
    When I check location references across the page
    Then all references should refer to the same place (Toronto)
    And no conflicting location information should exist
    And the work type (On-site) should align with the description

  @Content @JobTypeConsistency
  Scenario: Verify job type consistency
    Given I am on the Canada IT Club job posting page
    When I check job type references:
      | Reference |
      | Header |
      | Job Description |
      | Badge |
    Then the job type "Contractor" should appear consistently
    And no conflicting job type information should exist

  # ==================== TEST SUITE 14: Error Handling ====================

  @ErrorHandling @404
  Scenario: Verify 404 handling for invalid URLs
    Given I navigate to an invalid job URL "https://canadaitclub.ca/job/invalid-job-id/"
    When the page attempts to load
    Then an appropriate 404 error page should display
    Or the page should redirect to the job listing
    And the user should not be left confused

  @ErrorHandling @Network
  Scenario: Verify network error handling
    Given I am on the Canada IT Club job posting page
    When I open DevTools and simulate offline mode
    And I refresh the page
    Then an appropriate offline message should display
    And retry or navigation options should be suggested
    And no broken layout should display

  # ==================== TEST SUITE 15: Data Validation & Security ====================

  @Security @DataExposure
  Scenario: Verify no sensitive data exposure
    Given I am on the Canada IT Club job posting page
    When I inspect the page source and network requests
    Then no exposed API keys should be visible
    And no exposed credentials should be visible
    And no unencrypted sensitive data should be exposed
    And the email should be protected from exploitation
    And no internal system information should be exposed

  @Security @HTTPS
  Scenario: Verify HTTPS connection
    Given I load the Canada IT Club job posting page
    Then the URL should show HTTPS
    And a green lock icon should appear in the browser
    And no mixed content warnings should display

  @Security @FormSecurity
  Scenario: Verify form security if applicable
    Given I am on the Canada IT Club job posting page
    When I identify any forms on the page
    Then forms should submit via HTTPS
    And no sensitive data should appear in URLs
    And CSRF protection should be implemented

  # ==================== TEST SUITE 16: Functional Edge Cases ====================

  @EdgeCase @JavaScriptDisabled
  Scenario: Verify page with JavaScript disabled
    Given I disable JavaScript in the browser settings
    When I load the Canada IT Club job posting page
    Then the page content should still be readable
    And basic navigation should work if a no-script fallback exists
    And graceful degradation should occur

  @EdgeCase @Caching
  Scenario: Verify page caching
    Given I load the Canada IT Club job posting page
    When I note the load time
    And I reload the page
    Then the cached load should be faster than the initial load

    When I hard refresh the page
    Then a fresh version should load
    And appropriate cache headers should be set

  @EdgeCase @URLEncoding
  Scenario: Verify URL encoding
    Given I edit the URL with special characters
    When I navigate to the modified URL
    Then the page should handle it gracefully
    And various encoded/non-encoded URL formats should be handled
    And no encoding errors should occur

  @EdgeCase @PageTitle
  Scenario: Verify page title accuracy
    Given I load the Canada IT Club job posting page
    When I check the browser tab title
    Then the title should display "Test Lead - Canada IT Club"
    And the title should be descriptive
    And the title should match the page content

  # ==================== TEST SUITE 17: SEO & Metadata ====================

  @SEO @MetaDescription
  Scenario: Verify meta description
    Given I load the Canada IT Club job posting page
    When I view the page source
    Then the meta description should be present
    And the description should be relevant to the job posting
    And the description length should be appropriate (120-160 characters)

  @SEO @OpenGraph
  Scenario: Verify open graph tags
    Given I load the Canada IT Club job posting page
    When I view the page source
    Then the following Open Graph meta tags should be present:
      | Tag |
      | og:title |
      | og:description |
      | og:image |
      | og:url |
    And tags should contain appropriate content
    And the image URL should be valid

  @SEO @Canonical
  Scenario: Verify canonical tag
    Given I load the Canada IT Club job posting page
    When I view the page source
    Then the canonical tag should exist
    And it should point to "https://canadaitclub.ca/job/test-lead-5/"
    And it should help with SEO and duplicate content handling
