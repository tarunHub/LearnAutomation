# Manual Test Cases: Canada IT Club Job Posting Page
## Test Lead Job Position (https://canadaitclub.ca/job/test-lead-5/)

---

## Test Suite 1: Page Load and Navigation

### TC-001: Verify Page Loads Successfully
**Objective:** Ensure the job posting page loads without errors

**Steps:**
1. Navigate to https://canadaitclub.ca/job/test-lead-5/
2. Wait for page to fully load (max 3 seconds)
3. Verify page title displays "Test Lead - Canada IT Club"

**Expected Result:** 
- Page loads successfully
- All elements are visible and accessible
- No error messages or broken images displayed

**Pass/Fail Criteria:** PASS if all conditions are met

---

### TC-002: Verify Navigation Menu is Visible and Functional
**Objective:** Validate the navigation menu displays all menu items

**Steps:**
1. Load the job posting page
2. Verify navigation bar is visible at the top
3. Verify all menu items are present: Home, About Us, Browse Jobs, Working In Canada, Life in Canada

**Expected Result:**
- Navigation menu is sticky/always visible
- All menu items are properly labeled
- Menu items are clickable

**Pass/Fail Criteria:** PASS if all menu items are present and functional

---

### TC-003: Test Navigation Menu Links
**Objective:** Verify each navigation link routes to the correct page

**Steps:**
1. Click on "Home" link in navigation
2. Verify page navigates to https://canadaitclub.ca/
3. Go back and repeat for other menu items:
   - About Us → https://canadaitclub.ca/about-us/
   - Browse Jobs → https://canadaitclub.ca/browse-jobs/
   - Life in Canada → https://canadaitclub.ca/life-in-canada/

**Expected Result:**
- Each link navigates to its corresponding page
- Page loads without errors
- No 404 or broken link errors

**Pass/Fail Criteria:** PASS if all links navigate correctly

---

## Test Suite 2: Job Header Section

### TC-004: Verify Job Title and Key Information Display
**Objective:** Ensure job title and critical metadata are displayed correctly

**Steps:**
1. Load the job posting page
2. Verify job title "Test Lead" is displayed prominently
3. Verify job category "Quality Assurance & Testing" is displayed
4. Verify location "Ontario – Toronto" is displayed
5. Verify posting date "December 16, 2025" is displayed

**Expected Result:**
- Job title appears as H1 heading
- All metadata is visible in the header section
- Formatting is clear and readable

**Pass/Fail Criteria:** PASS if all information displays correctly

---

### TC-005: Verify Employer Logo and Company Link
**Objective:** Validate the employer logo and company profile link

**Steps:**
1. Load the job posting page
2. Verify Canada IT Club logo is visible on the left side
3. Click on the logo or company name link
4. Verify page navigates to employer profile

**Expected Result:**
- Logo displays without distortion
- Logo is clickable and links to company profile
- Company profile page loads successfully

**Pass/Fail Criteria:** PASS if logo is present and link is functional

---

### TC-006: Verify Job Type Badge Display
**Objective:** Ensure job type indicator is correctly displayed

**Steps:**
1. Load the job posting page
2. Look for job type badge/label
3. Verify job type displays as "Contractor"

**Expected Result:**
- Job type badge is visible
- Shows "Contractor"
- Badge styling is distinct (e.g., different color)

**Pass/Fail Criteria:** PASS if job type is correctly displayed

---

## Test Suite 3: Apply Now Button and CTA

### TC-007: Verify Apply Now Button is Visible and Clickable
**Objective:** Validate the call-to-action button for job application

**Steps:**
1. Load the job posting page
2. Locate "Apply Now" button in the header section
3. Verify button styling and color
4. Click the "Apply Now" button

**Expected Result:**
- Button is prominently displayed in blue
- Button text is clear: "Apply Now"
- Button is clickable and responsive

**Pass/Fail Criteria:** PASS if button is visible and clickable

---

### TC-008: Verify Apply Now Button Navigation
**Objective:** Ensure clicking Apply Now redirects to correct application source

**Steps:**
1. Load the job posting page
2. Click "Apply Now" button
3. Wait for page navigation/redirect
4. Verify redirect destination and page loads

**Expected Result:**
- Redirects to LinkedIn post: https://www.linkedin.com/posts/shivam-agnihotri-4152b6185_...
- Page loads successfully
- New tab/window opens (if configured)

**Pass/Fail Criteria:** PASS if redirect works and destination is correct

---

### TC-009: Verify Bookmark/Save Button Functionality
**Objective:** Test the save/bookmark button functionality

**Steps:**
1. Load the job posting page
2. Locate the bookmark/save icon (appears to be on right side of header)
3. Click the bookmark icon
4. Verify visual feedback (e.g., icon color change)

**Expected Result:**
- Bookmark button is clickable
- Icon changes appearance when clicked
- Job is saved to user's saved jobs list

**Pass/Fail Criteria:** PASS if bookmark functionality works

---

## Test Suite 4: Job Description Section

### TC-010: Verify Job Description Title and Structure
**Objective:** Ensure job description section is properly formatted

**Steps:**
1. Load the job posting page
2. Scroll to "Job Description" heading
3. Verify heading level and formatting
4. Check all sub-sections are visible

**Expected Result:**
- "Job Description" heading is clearly visible
- Content is organized logically
- All sections load properly

**Pass/Fail Criteria:** PASS if heading and structure are correct

---

### TC-011: Verify Key Details Display
**Objective:** Validate job details metadata in description section

**Steps:**
1. Load the job posting page
2. Verify the following details are displayed:
   - Job Type: "Contractor"
   - Location: "Anywhere"
   - Posted: "Posted 2 days ago"

**Expected Result:**
- All metadata fields are visible
- Information is accurate and up-to-date
- Icons/labels are clear

**Pass/Fail Criteria:** PASS if all details are correctly displayed

---

### TC-012: Verify Job Description Main Text
**Objective:** Ensure main job description is readable and complete

**Steps:**
1. Load the job posting page
2. Locate main job description paragraph
3. Read: "We're Hiring | Test Lead – Onsite (Toronto, ON, Canada)"
4. Verify full description text is present and readable

**Expected Result:**
- Main description is visible
- Text is properly formatted with line breaks
- No truncation of content
- All text is readable without scrolling within text block

**Pass/Fail Criteria:** PASS if description is complete and readable

---

### TC-013: Verify Location Information Display
**Objective:** Validate location details in job description

**Steps:**
1. Load the job posting page
2. Locate "Location: Toronto, ON, Canada (Onsite)" text
3. Verify formatting with blue diamond emoji/icon
4. Verify link "Ontario – Toronto" is present

**Expected Result:**
- Location is clearly displayed
- Emoji/icon appears correctly
- Location link is clickable

**Pass/Fail Criteria:** PASS if location is properly displayed and linked

---

### TC-014: Verify Experience Requirements Display
**Objective:** Ensure experience requirements are clearly stated

**Steps:**
1. Load the job posting page
2. Locate "Experience: 10+ years overall | Minimum 3+ years as a Test Lead"
3. Verify text is visible with blue diamond icon
4. Verify requirements are clear and complete

**Expected Result:**
- Experience requirements are visible
- Numbers are accurate: 10+ years total, 3+ years as Test Lead
- Formatting is consistent with other bullet points

**Pass/Fail Criteria:** PASS if requirements are correctly displayed

---

### TC-015: Verify Key Responsibilities Section
**Objective:** Validate display of job responsibilities

**Steps:**
1. Load the job posting page
2. Locate "Key Responsibilities & Requirements" section with magnifying glass icon
3. Verify all responsibility bullet points are visible:
   - Proven experience as a Test Lead with strong ownership of QA activities
   - Must have hands-on experience in the Banking or Financial domain
   - Strong knowledge of IT QA and Functional Testing
   - In-depth understanding of SDLC, testing methodologies (Agile, Waterfall)...
   - Ability to define quality goals and measurement plans...
   - Extensive experience in system analysis, assessment, programming...
   - Strong expertise in compiling, analyzing, and interpreting test and quality reports

**Expected Result:**
- All 7 responsibility points are visible
- Checkmark icons display correctly
- Text is complete and not truncated
- Line breaks separate each item

**Pass/Fail Criteria:** PASS if all responsibilities are visible and formatted correctly

---

### TC-016: Verify Tools & Technologies Section
**Objective:** Ensure all required tools and technologies are listed

**Steps:**
1. Load the job posting page
2. Locate "Tools & Technologies" section with wrench icon
3. Verify all tools are listed:
   - HP ALM / Quality Center
   - JIRA & Confluence
   - Git or Bitbucket
   - Maven
   - Postman, SoapUI, or similar API testing tools
   - Automated testing frameworks

**Expected Result:**
- All 6 tools/technologies are visible
- Orange square icons display correctly
- Each tool is on separate line
- Text is complete

**Pass/Fail Criteria:** PASS if all tools are listed correctly

---

### TC-017: Verify What We're Looking For Section
**Objective:** Validate the candidate profile description

**Steps:**
1. Load the job posting page
2. Locate "What We're Looking For" section with star icon
3. Verify description text is present and complete

**Expected Result:**
- Section header is visible with star icon
- Description: "A proactive leader who can drive quality initiatives, collaborate with cross-functional teams, and ensure delivery of high-quality software solutions in a fast-paced environment."
- Text is readable and complete

**Pass/Fail Criteria:** PASS if section displays correctly

---

### TC-018: Verify Contact Email Display
**Objective:** Ensure recruiter contact information is visible

**Steps:**
1. Load the job posting page
2. Locate contact email: "Email: Shivam.agnihotri@varite.com"
3. Verify email is displayed as text (clickable or selectable)

**Expected Result:**
- Email address is visible
- Email is clearly formatted
- If clickable, opens email client when clicked

**Pass/Fail Criteria:** PASS if email is visible and accessible

---

## Test Suite 5: Related Jobs Section

### TC-019: Verify Related Jobs Section Heading
**Objective:** Ensure related jobs section displays correctly

**Steps:**
1. Load the job posting page
2. Scroll down to find "Related" section
3. Verify section heading is present

**Expected Result:**
- "Related" heading is visible
- Section is properly labeled

**Pass/Fail Criteria:** PASS if heading is present

---

### TC-020: Verify Related Job Cards Display
**Objective:** Validate display of related job listings

**Steps:**
1. Load the job posting page
2. Locate related jobs:
   - "QA / QC Test Analyst (Mobile + Web + Automation)" - December 6, 2025
   - "QA Automation Developers" - December 4, 2025
   - "Business Systems Analyst (Capital Markets)" - December 18, 2025
3. Verify each card displays job title, date, and "Similar post" label

**Expected Result:**
- All related jobs are displayed
- Each has title, date posted, and "Similar post" label
- Cards are clickable links

**Pass/Fail Criteria:** PASS if all related jobs display correctly

---

### TC-021: Test Related Job Links
**Objective:** Verify related job links navigate correctly

**Steps:**
1. Load the job posting page
2. Click first related job: "QA / QC Test Analyst (Mobile + Web + Automation)"
3. Verify page navigates to: https://canadaitclub.ca/job/qa-qc-test-analyst-mobile-web-automation/
4. Go back and repeat for other related jobs

**Expected Result:**
- Each link navigates to corresponding job posting
- Pages load without errors
- No broken links

**Pass/Fail Criteria:** PASS if all links work correctly

---

## Test Suite 6: Share Section

### TC-022: Verify Share Section Display
**Objective:** Ensure sharing options are visible

**Steps:**
1. Load the job posting page
2. Locate "Share this post" heading
3. Verify share buttons are visible for Twitter and LinkedIn

**Expected Result:**
- "Share this post" heading is displayed
- Share buttons for Twitter and LinkedIn are visible
- Buttons are clickable

**Pass/Fail Criteria:** PASS if share options display correctly

---

### TC-023: Test Twitter Share Button
**Objective:** Verify Twitter share functionality

**Steps:**
1. Load the job posting page
2. Click Twitter share button
3. Verify correct share URL is used

**Expected Result:**
- Opens Twitter sharing interface
- URL matches current page: https://canadaitclub.ca/job/test-lead-5/
- Share dialog opens successfully

**Pass/Fail Criteria:** PASS if Twitter share works

---

### TC-024: Test LinkedIn Share Button
**Objective:** Verify LinkedIn share functionality

**Steps:**
1. Load the job posting page
2. Click LinkedIn share button
3. Verify correct share parameters are passed

**Expected Result:**
- Opens LinkedIn sharing interface
- Correct URL and title are shared
- Share dialog opens successfully

**Pass/Fail Criteria:** PASS if LinkedIn share works

---

## Test Suite 7: Related Jobs Carousel

### TC-025: Verify Related Jobs Carousel Displays
**Objective:** Ensure related jobs carousel section displays correctly

**Steps:**
1. Load the job posting page
2. Scroll to "Related Jobs" section at bottom
3. Verify multiple job cards are visible in carousel format

**Expected Result:**
- Carousel section displays at least 3-4 job cards
- Jobs displayed include SDET, QA Lead with Wire Payments, QA Analyst, Backend QA Engineer, etc.
- Cards are properly formatted

**Pass/Fail Criteria:** PASS if carousel displays correctly

---

### TC-026: Verify Related Jobs Carousel Navigation (if applicable)
**Objective:** Test carousel navigation if scroll/arrow buttons exist

**Steps:**
1. Load the job posting page
2. Look for carousel navigation arrows or scroll functionality
3. If present, test navigation

**Expected Result:**
- Navigation buttons/scroll works smoothly
- Can view all jobs in carousel
- No jobs are hidden or inaccessible

**Pass/Fail Criteria:** PASS if navigation works or is not needed

---

## Test Suite 8: Job Overview Section

### TC-027: Verify Job Overview Sidebar Displays
**Objective:** Ensure job overview information sidebar is visible

**Steps:**
1. Load the job posting page
2. Look for "Job Overview" heading in right sidebar
3. Verify all overview fields are present:
   - Date Posted
   - Location
   - Expiration date
   - Work Location Type

**Expected Result:**
- "Job Overview" heading is visible
- All fields are displayed with values
- Information is accurate

**Pass/Fail Criteria:** PASS if overview section displays correctly

---

### TC-028: Verify Date Posted Information
**Objective:** Validate date posted display in overview

**Steps:**
1. Load the job posting page
2. Locate "Date Posted" field in Job Overview
3. Verify value: "December 16, 2025"

**Expected Result:**
- Date field is visible
- Date matches posting date: December 16, 2025
- Date format is consistent

**Pass/Fail Criteria:** PASS if date is correct

---

### TC-029: Verify Location Information in Overview
**Objective:** Validate location display in overview sidebar

**Steps:**
1. Load the job posting page
2. Locate "Location" field in Job Overview
3. Verify value: "Ontario – Toronto"
4. Verify link is clickable

**Expected Result:**
- Location field is visible
- Shows correct location: Ontario – Toronto
- Location is clickable link

**Pass/Fail Criteria:** PASS if location is correct and linked

---

### TC-030: Verify Expiration Date Display
**Objective:** Validate job expiration date

**Steps:**
1. Load the job posting page
2. Locate "Expiration date" field in Job Overview
3. Verify value: "December 31, 2025"

**Expected Result:**
- Expiration date field is visible
- Date shows: December 31, 2025
- Date is in future (current date is December 18, 2025)

**Pass/Fail Criteria:** PASS if expiration date is correct

---

### TC-031: Verify Work Location Type Display
**Objective:** Validate work location type

**Steps:**
1. Load the job posting page
2. Locate "Work Location Type" field in Job Overview
3. Verify value: "On-site"

**Expected Result:**
- Field displays "On-site"
- Label is clear
- Matches job description mentioning "Onsite (Toronto)"

**Pass/Fail Criteria:** PASS if work location type is correct

---

## Test Suite 9: Employer Information Section

### TC-032: Verify Employer Information Section Displays
**Objective:** Ensure employer information section is visible

**Steps:**
1. Load the job posting page
2. Scroll to find "Employer Information" heading
3. Verify employer name: "Canada IT Club" is displayed

**Expected Result:**
- "Employer Information" heading is visible
- Employer name is clearly displayed
- Company details are present

**Pass/Fail Criteria:** PASS if section displays correctly

---

### TC-033: Test View Company Profile Link
**Objective:** Verify link to employer company profile

**Steps:**
1. Load the job posting page
2. Locate "View Company Profile" link
3. Click the link
4. Verify navigation to company profile

**Expected Result:**
- Link is clickable
- Navigates to https://canadaitclub.ca/employer/canada-it-club/
- Company profile page loads successfully

**Pass/Fail Criteria:** PASS if link works

---

### TC-034: Verify Employer Description Display
**Objective:** Ensure company description is visible

**Steps:**
1. Load the job posting page
2. Locate employer description text
3. Verify text: "Canada IT Club is a dynamic community that brings together IT professionals from across Canada, fostering collaboration, knowledge sharing, and career growth."

**Expected Result:**
- Description is visible and complete
- Text is readable
- No truncation

**Pass/Fail Criteria:** PASS if description displays correctly

---

## Test Suite 10: Footer Section

### TC-035: Verify Footer Helpful Resources Section
**Objective:** Ensure helpful resources links are displayed

**Steps:**
1. Load the job posting page
2. Scroll to bottom of page
3. Locate "Helpful Resources" heading
4. Verify links are present:
   - About Us
   - Privacy Policy
   - Terms & Conditions

**Expected Result:**
- All three links are visible
- Links are clickable
- Proper formatting

**Pass/Fail Criteria:** PASS if resources section displays correctly

---

### TC-036: Test Helpful Resources Links
**Objective:** Verify helpful resources links navigate correctly

**Steps:**
1. Load the job posting page
2. Click "About Us" link
3. Verify navigation to https://canadaitclub.ca/about-us/
4. Go back and test Privacy Policy and Terms & Conditions links

**Expected Result:**
- All links navigate to correct pages
- Pages load successfully
- No broken links

**Pass/Fail Criteria:** PASS if all links work

---

### TC-037: Verify Social Media Links Display
**Objective:** Ensure social media links are visible

**Steps:**
1. Load the job posting page
2. Scroll to bottom
3. Locate "Reach Us" section
4. Verify social media links:
   - LinkedIn
   - WhatsApp
   - YouTube
   - Instagram

**Expected Result:**
- All 4 social media links are visible
- Links are properly labeled
- Links are clickable

**Pass/Fail Criteria:** PASS if social links display correctly

---

### TC-038: Test Social Media Links
**Objective:** Verify social media links navigate correctly

**Steps:**
1. Load the job posting page
2. Click on each social media link (LinkedIn, WhatsApp, YouTube, Instagram)
3. Verify each opens correct social media profile/channel

**Expected Result:**
- LinkedIn: https://www.linkedin.com/company/canada-it-club/
- WhatsApp: https://www.whatsapp.com/channel/0029VaYMzw8JENy5XiHyeG2L
- YouTube: https://www.youtube.com/@canada_it_club
- Instagram: https://www.instagram.com/canada.it.club/
- All links open successfully

**Pass/Fail Criteria:** PASS if all social links work correctly

---

### TC-039: Verify Feedback Section
**Objective:** Ensure feedback/feature request section is visible

**Steps:**
1. Load the job posting page
2. Scroll to bottom
3. Locate "Request Feature / Send Feedback" section
4. Verify email: hello@canadaitclub.ca is displayed

**Expected Result:**
- Section heading is visible
- Email address is displayed
- Email is clickable or selectable

**Pass/Fail Criteria:** PASS if feedback section displays correctly

---

### TC-040: Verify Copyright Information
**Objective:** Ensure copyright notice is displayed

**Steps:**
1. Load the job posting page
2. Scroll to very bottom
3. Verify copyright text is present

**Expected Result:**
- Copyright notice displayed: "© 2024 Canada IT Club. All Right Reserved."
- Text is visible at bottom of page

**Pass/Fail Criteria:** PASS if copyright notice is visible

---

## Test Suite 11: Responsive Design & Cross-Browser

### TC-041: Verify Page Responsive on Mobile (if applicable)
**Objective:** Test page layout on mobile devices

**Steps:**
1. Load the job posting page
2. Resize browser to mobile dimensions (375x667 for iPhone SE)
3. Verify all content is readable
4. Check button sizes are touch-friendly
5. Verify navigation collapses properly

**Expected Result:**
- Page layout adapts to mobile size
- All content is accessible without horizontal scroll
- Buttons are at least 44x44 pixels
- Navigation is properly formatted for mobile

**Pass/Fail Criteria:** PASS if responsive layout works correctly

---

### TC-042: Verify Page Responsive on Tablet (if applicable)
**Objective:** Test page layout on tablet devices

**Steps:**
1. Load the job posting page
2. Resize browser to tablet dimensions (768x1024)
3. Verify layout is optimized for tablet
4. Check readability and spacing

**Expected Result:**
- Page layout is optimized for tablet view
- Content is properly arranged
- Navigation is accessible

**Pass/Fail Criteria:** PASS if responsive layout works correctly

---

### TC-043: Test Browser Compatibility - Chrome
**Objective:** Verify page works correctly in Chrome browser

**Steps:**
1. Open Chrome browser
2. Navigate to https://canadaitclub.ca/job/test-lead-5/
3. Verify page loads correctly
4. Test all interactive elements

**Expected Result:**
- Page loads without errors
- All elements render correctly
- Interactive elements work properly

**Pass/Fail Criteria:** PASS if page works in Chrome

---

### TC-044: Test Browser Compatibility - Firefox
**Objective:** Verify page works correctly in Firefox browser

**Steps:**
1. Open Firefox browser
2. Navigate to https://canadaitclub.ca/job/test-lead-5/
3. Verify page loads correctly
4. Test all interactive elements

**Expected Result:**
- Page loads without errors
- All elements render correctly
- Interactive elements work properly

**Pass/Fail Criteria:** PASS if page works in Firefox

---

### TC-045: Test Browser Compatibility - Safari
**Objective:** Verify page works correctly in Safari browser

**Steps:**
1. Open Safari browser
2. Navigate to https://canadaitclub.ca/job/test-lead-5/
3. Verify page loads correctly
4. Test all interactive elements

**Expected Result:**
- Page loads without errors
- All elements render correctly
- Interactive elements work properly

**Pass/Fail Criteria:** PASS if page works in Safari

---

## Test Suite 12: Performance & Accessibility

### TC-046: Verify Page Load Performance
**Objective:** Ensure page loads within acceptable timeframe

**Steps:**
1. Open DevTools (F12)
2. Go to Performance/Network tab
3. Navigate to https://canadaitclub.ca/job/test-lead-5/
4. Measure page load time

**Expected Result:**
- Page fully loads within 3 seconds
- No major performance warnings
- DOM Content Loaded before Load event

**Pass/Fail Criteria:** PASS if page load is < 3 seconds

---

### TC-047: Verify Accessibility - Text Alternatives for Images
**Objective:** Ensure images have alt text

**Steps:**
1. Load the job posting page
2. Use accessibility inspector (Lighthouse) or WAVE
3. Check all images have appropriate alt text
4. Verify emoji images have descriptions

**Expected Result:**
- All images have alt text
- Alt text is descriptive
- Emoji images are properly labeled

**Pass/Fail Criteria:** PASS if all images have alt text

---

### TC-048: Verify Heading Hierarchy
**Objective:** Ensure proper heading structure for accessibility

**Steps:**
1. Load the job posting page
2. Use accessibility inspector or extension
3. Verify heading levels are logical (H1, H2, H3)
4. Check no heading levels are skipped

**Expected Result:**
- H1: "Test Lead" (job title)
- H3: "Job Description", "Related", "Share this post"
- H4: "Related Jobs"
- H2: "Job Overview", "Employer Information", "Helpful Resources", "Reach Us"
- Proper hierarchy with no skipped levels

**Pass/Fail Criteria:** PASS if heading structure is correct

---

### TC-049: Verify Color Contrast
**Objective:** Ensure sufficient color contrast for readability

**Steps:**
1. Load the job posting page
2. Use color contrast checker (e.g., WebAIM)
3. Check text colors against background colors
4. Test both light and dark text elements

**Expected Result:**
- All text has sufficient contrast ratio (WCAG AA: 4.5:1 for normal text)
- Readable for users with color blindness
- No text is too light or too dark

**Pass/Fail Criteria:** PASS if all contrast ratios meet WCAG AA standards

---

### TC-050: Verify Keyboard Navigation
**Objective:** Ensure page is navigable using keyboard only

**Steps:**
1. Load the job posting page
2. Press Tab key repeatedly to navigate through elements
3. Verify all interactive elements are reachable
4. Test Shift+Tab for reverse navigation
5. Verify Enter key activates buttons/links

**Expected Result:**
- All interactive elements can be accessed via Tab
- Focus indicator is visible
- No keyboard traps
- Buttons activate with Enter key
- Links follow with Enter key

**Pass/Fail Criteria:** PASS if full keyboard navigation works

---

## Test Suite 13: Content Accuracy & Validation

### TC-051: Verify Email Format Validity
**Objective:** Ensure contact email is valid format

**Steps:**
1. Load the job posting page
2. Locate contact email: "Shivam.agnihotri@varite.com"
3. Validate email format

**Expected Result:**
- Email follows standard format: localpart@domain.com
- Domain appears to be valid
- No obvious typos in email

**Pass/Fail Criteria:** PASS if email format is valid

---

### TC-052: Verify All External Links Are Functional
**Objective:** Ensure no broken links on page

**Steps:**
1. Load the job posting page
2. Test all external links:
   - Apply Now button (LinkedIn)
   - All navigation links
   - All social media links
   - All related job links

**Expected Result:**
- No HTTP 404 errors
- All external sites load successfully
- No timeout errors

**Pass/Fail Criteria:** PASS if all links are functional

---

### TC-053: Verify Date Consistency
**Objective:** Ensure dates are consistent throughout page

**Steps:**
1. Load the job posting page
2. Compare dates across sections:
   - Header: December 16, 2025
   - Job Overview: December 16, 2025
   - Posted: 2 days ago (should calculate to December 16)

**Expected Result:**
- All dates are consistent
- Relative dates (e.g., "2 days ago") match absolute dates
- No conflicting date information

**Pass/Fail Criteria:** PASS if all dates are consistent

---

### TC-054: Verify Location Consistency
**Objective:** Ensure location information is consistent

**Steps:**
1. Load the job posting page
2. Check location references:
   - Header: Ontario – Toronto
   - Job Description: Toronto, ON, Canada (Onsite)
   - Job Overview: Ontario – Toronto
   - Work Location Type: On-site

**Expected Result:**
- All location references refer to same place (Toronto)
- No conflicting location information
- Work type (On-site) aligns with description

**Pass/Fail Criteria:** PASS if location is consistent

---

### TC-055: Verify Job Type Consistency
**Objective:** Ensure job type is consistently displayed

**Steps:**
1. Load the job posting page
2. Check job type references:
   - Header: Contractor
   - Job Description: Contractor
   - Badge: Contractor

**Expected Result:**
- Job type "Contractor" appears consistently
- No conflicting job type information

**Pass/Fail Criteria:** PASS if job type is consistent

---

## Test Suite 14: Error Handling

### TC-056: Verify 404 Handling for Invalid URLs
**Objective:** Test error handling for invalid job URLs

**Steps:**
1. Navigate to https://canadaitclub.ca/job/invalid-job-id/
2. Verify appropriate error message or redirect

**Expected Result:**
- Displays 404 error page or redirects to job listing
- User is not left confused

**Pass/Fail Criteria:** PASS if error is handled gracefully

---

### TC-057: Verify Network Error Handling
**Objective:** Test page behavior with network issues

**Steps:**
1. Load the job posting page
2. Open DevTools and simulate offline mode
3. Refresh page
4. Observe error handling

**Expected Result:**
- Displays appropriate offline message
- Suggests retry or navigation options
- Doesn't display broken layout

**Pass/Fail Criteria:** PASS if offline error is handled gracefully

---

## Test Suite 15: Data Validation & Security

### TC-058: Verify No Sensitive Data Exposure
**Objective:** Ensure no sensitive data is exposed on page

**Steps:**
1. Load the job posting page
2. Inspect page source and network requests
3. Check for:
   - Exposed API keys
   - Exposed credentials
   - Unencrypted sensitive data

**Expected Result:**
- No sensitive credentials visible
- Email is protected (not exploitable)
- No internal system information exposed

**Pass/Fail Criteria:** PASS if no sensitive data is exposed

---

### TC-059: Verify HTTPS Connection
**Objective:** Ensure page is served over secure connection

**Steps:**
1. Load the job posting page
2. Check URL bar for HTTPS indicator
3. Verify SSL certificate

**Expected Result:**
- URL shows HTTPS://
- Green lock icon appears in browser
- No mixed content warnings

**Pass/Fail Criteria:** PASS if page is served over HTTPS

---

### TC-060: Verify Form Security (if applicable)
**Objective:** Test security of any forms on page

**Steps:**
1. Load the job posting page
2. Identify any forms (Apply, etc.)
3. Verify forms use HTTPS
4. Check for CSRF protection tokens

**Expected Result:**
- Forms submit via HTTPS
- No sensitive data in URLs
- CSRF protection implemented

**Pass/Fail Criteria:** PASS if forms are secure

---

## Test Suite 16: Functional Edge Cases

### TC-061: Verify Page with JavaScript Disabled
**Objective:** Test page functionality without JavaScript

**Steps:**
1. Disable JavaScript in browser settings
2. Load the job posting page
3. Verify basic content is still accessible
4. Test if critical functionality works

**Expected Result:**
- Page content is still readable
- Basic navigation works if no-script fallback is present
- Graceful degradation

**Pass/Fail Criteria:** PASS if page is usable without JavaScript

---

### TC-062: Verify Page Caching
**Objective:** Test page caching behavior

**Steps:**
1. Load the job posting page
2. Note load time
3. Reload page (Ctrl+R)
4. Note load time for cached version
5. Hard refresh (Ctrl+Shift+R)
6. Note load time for fresh version

**Expected Result:**
- Cached load is faster than initial load
- Hard refresh loads fresh content
- Appropriate cache headers are set

**Pass/Fail Criteria:** PASS if caching works correctly

---

### TC-063: Verify URL Encoding
**Objective:** Test handling of special characters in URL

**Steps:**
1. Manually edit URL with special characters
2. Verify page handles gracefully
3. Test with various encoded/non-encoded URLs

**Expected Result:**
- URL is properly encoded
- Page handles various URL formats
- No encoding errors

**Pass/Fail Criteria:** PASS if URL encoding is handled correctly

---

### TC-064: Verify Page Title Accuracy
**Objective:** Ensure browser tab title is accurate

**Steps:**
1. Load the job posting page
2. Check browser tab title
3. Verify it matches "Test Lead - Canada IT Club"

**Expected Result:**
- Tab title shows "Test Lead - Canada IT Club"
- Title is descriptive
- Title matches page content

**Pass/Fail Criteria:** PASS if page title is correct

---

## Test Suite 17: SEO & Metadata

### TC-065: Verify Meta Description
**Objective:** Ensure meta description is set correctly

**Steps:**
1. Load the job posting page
2. View page source (Ctrl+U)
3. Search for <meta name="description">
4. Verify description is present and relevant

**Expected Result:**
- Meta description exists
- Description is relevant to job posting
- Description length is appropriate (120-160 chars)

**Pass/Fail Criteria:** PASS if meta description is correct

---

### TC-066: Verify Open Graph Tags
**Objective:** Ensure social media sharing metadata is correct

**Steps:**
1. Load the job posting page
2. View page source
3. Check for Open Graph meta tags:
   - og:title
   - og:description
   - og:image
   - og:url

**Expected Result:**
- All relevant OG tags are present
- Tags contain appropriate content
- Image URL is valid

**Pass/Fail Criteria:** PASS if Open Graph tags are correct

---

### TC-067: Verify Canonical Tag
**Objective:** Ensure canonical URL is set

**Steps:**
1. Load the job posting page
2. View page source
3. Search for <link rel="canonical">
4. Verify it matches current URL

**Expected Result:**
- Canonical tag exists
- Points to: https://canadaitclub.ca/job/test-lead-5/
- Helps with SEO and duplicate content

**Pass/Fail Criteria:** PASS if canonical tag is correct

---

## Summary

**Total Test Cases:** 67

**Test Suites:**
1. Page Load and Navigation (3 TCs)
2. Job Header Section (6 TCs)
3. Apply Now Button and CTA (3 TCs)
4. Job Description Section (9 TCs)
5. Related Jobs Section (3 TCs)
6. Share Section (3 TCs)
7. Related Jobs Carousel (2 TCs)
8. Job Overview Section (5 TCs)
9. Employer Information Section (3 TCs)
10. Footer Section (6 TCs)
11. Responsive Design & Cross-Browser (5 TCs)
12. Performance & Accessibility (5 TCs)
13. Content Accuracy & Validation (5 TCs)
14. Error Handling (2 TCs)
15. Data Validation & Security (3 TCs)
16. Functional Edge Cases (4 TCs)
17. SEO & Metadata (3 TCs)

**Recommended Testing Priority:**
- High: TC-001, TC-007, TC-008, TC-013, TC-023, TC-024, TC-059
- Medium: TC-002, TC-004, TC-010, TC-027, TC-052
- Low: TC-041, TC-043, TC-044, TC-045, TC-065, TC-066, TC-067

---

**Document Version:** 1.0  
**Last Updated:** December 18, 2025  
**Test Environment:** Canada IT Club Job Portal (canadaitclub.ca)
