\*\*

\# 4-Score Fitness App Wireframes

Note: This document is intended for the admin\_kb and provides detailed wireframes for the 4-Score Fitness App, incorporating the latest schema updates and design decisions. It aims for high specificity in view layouts and routing, with detailed descriptions of UI elements, typography, and interactions.

\#\# I. Authentication & Onboarding Views

These views handle user authentication and initial onboarding.

\#\#\# 1\. Landing Page View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
      
\- Presidential seal watermark:  
    

\- Image: \[Presidential Seal SVG\]  
      
\- Opacity: 0.15  
      
\- Position: Center, behind logo  
      
\- Size: 60 dp  
    

\- 4-Score logo:  
    

\- Image: \[4-Score Logo SVG\]  
      
\- Position: Centered horizontally and vertically within the banner  
      
\- Size: 50 dp  
    

\- Hero Section:  
    

\- Bold patriotic imagery:  
    

\- Image: \[High-resolution image of an American flag waving or a powerful patriotic scene\]  
      
\- Layout: Full-width, covers the entire section below the header  
      
\- Content Fit: Cover  
    

\- Headline:  
    

\- Text: "Achieve Your Peak Fitness with the F.O.U.R. Score System"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 36 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
      
\- Alignment: Center  
      
\- Margin: 24 dp below the image  
    

\- Content:  
    

\- App value proposition:  
    

\- Layout: Vertical list with icons  
      
\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Spacing: 16 dp between items  
      
\- F.O.U.R. SCORE framework:  
    

\- Forge:  
    

\- Text: "Forge: Build Strength"  
      
\- Icon: \[Icon for strength training\]  
    

\- Optimize:  
    

\- Text: "Optimize: Refine Nutrition"  
      
\- Icon: \[Icon for nutrition\]  
    

\- Unite:  
    

\- Text: "Unite: Connect with Community"  
      
\- Icon: \[Icon for community\]  
    

\- Recover:  
    

\- Text: "Recover: Maximize Rest"  
      
\- Icon: \[Icon for rest\]  
    

\- App screenshots carousel:  
    

\- Layout: Horizontal scrolling list  
      
\- Item width: 280 dp  
      
\- Item height: 480 dp  
      
\- Spacing: 16 dp between items  
      
\- Captions:  
    

\- Font: Poppins, Medium  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Position: Below each screenshot  
    

\- Testimonials section:  
    

\- Layout: Horizontal scrolling list of cards  
      
\- Card width: 320 dp  
      
\- Card height: 160 dp  
      
\- Card style:  
    

\- Background: \#171717  
      
\- Border Radius: 8 dp  
    

\- User photos:  
    

\- Shape: Circular  
      
\- Size: 48 dp  
      
\- Margin: 16 dp left  
    

\- Quotes:  
    

\- Font: Poppins, Italic  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Margin: 16 dp  
    

\- User Name:  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 12dp  
      
\- Color: \#96854A  
    

\- CTA Buttons:  
    

\- "Sign Up" button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 16 dp below testimonials  
      
\- Action: Navigates to the Sign-Up/Register View  
    

\- "Learn More" button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#520606 (Navy Blue)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Action: Scrolls to the F.O.U.R. principles section  
    

\- Footer:  
    

\- Layout: Vertical list  
      
\- F.O.U.R. principles:  
    

\- Icons: \[Custom F.O.U.R. icons\]  
      
\- Text:  
    

\- Font: Poppins, Medium  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Descriptions:  
    

\- Font: Poppins, Regular  
      
\- Size: 10 dp  
      
\- Color: \#DAE1E9  
    

\- Legal text:  
    

\- Font: Poppins, Light  
      
\- Size: 10 dp  
      
\- Color: \#DAE1E9  
      
\- Alignment: Center  
    

\- Privacy policy link:  
    

\- Font: Poppins, Regular  
      
\- Size: 10 dp  
      
\- Color: \#96854A (Gold)  
      
\- Alignment: Center  
      
\- Action: Opens privacy policy in a webview  
    

\- Routing:  
    

\- On initial app load, if the user is not authenticated, display this view.  
      
\- "Sign Up" button navigates to Sign-up/Register View.  
      
\- "Learn More" button scrolls to the F.O.U.R. principles section.  
    

\#\#\# 2\. Sign-in View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
      
\- Presidential seal watermark:  
    

\- Image: \[Presidential Seal SVG\]  
      
\- Opacity: 0.15  
      
\- Position: Center, behind logo  
      
\- Size: 60 dp  
    

\- 4-Score logo:  
    

\- Image: \[4-Score Logo SVG\]  
      
\- Position: Centered horizontally and vertically within the banner  
      
\- Size: 50 dp  
    

\- Form:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp between form fields  
      
\- Username/Email field:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder text: "Enter your username or email"  
      
\- Keyboard type: email-address  
      
\- Padding: 12 dp  
    

\- Password field:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder text: "Enter your password"  
      
\- Password visibility toggle icon:  
    

\- Icon: \[Eye icon\]  
      
\- Position: Right side of the field  
      
\- Action: Toggles password visibility  
      
\- Padding: 12 dp  
    

\- "Remember Me" checkbox:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
    

\- Style: Custom checkbox with gold checkmark  
      
\- Margin: 16 dp top  
    

\- "Forgot Password?" link:  
    

\- Text: "Forgot Password?"  
      
\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#96854A (Gold)  
      
\- Action: Navigates to the Reset Password View  
      
\- Alignment: Right  
    

\- Sign-in button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
      
\- Action: Attempts to sign in the user. On success, navigates to The Range (Home View). On failure, displays an error message.  
    

\- Alternative: "Sign up" link for new users:  
    

\- Text: "New user? Sign up"  
      
\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#96854A (Gold)  
      
\- Action: Navigates to the Sign-Up/Register View  
      
\- Alignment: Center  
    

\- Footer:  
    

\- Layout: Vertical list  
      
\- Legal text:  
    

\- Font: Poppins, Light  
      
\- Size: 10 dp  
      
\- Color: \#DAE1E9  
      
\- Alignment: Center  
    

\- Privacy policy link:  
    

\- Font: Poppins, Regular  
      
\- Size: 10 dp  
      
\- Color: \#96854A (Gold)  
      
\- Alignment: Center  
      
\- Action: Opens privacy policy in a webview  
    

\- Routing:  
    

\- This view is accessible from the Landing Page and the Sign-up/Register View.  
      
\- Successful sign-in navigates to The Range (Home View).  
      
\- "Forgot Password?" link navigates to Reset Password View.  
      
\- "New user? Sign up" navigates to Sign-up/Register View.  
    

\#\#\# 3\. Sign-up/Register View

\- Header: Same as Sign-in View  
      
\- Form:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Username field:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder: "Enter Username"  
      
\- Padding: 12 dp  
    

\- Email field:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder text: "Enter your email"  
      
\- Keyboard type: email-address  
      
\- Padding: 12 dp  
    

\- Password field:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder text: "Enter your password"  
      
\- Password visibility toggle: \[Icon\]  
      
\- Padding: 12 dp  
    

\- Confirm password field:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder text: "Confirm your password"  
      
\- Password visibility toggle: \[Icon\]  
      
\- Padding: 12 dp  
    

\- Basic info fields (optional, collapsible section):  
    

\- Layout: Vertical list, collapsible  
      
\- Toggle Label:  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 14dp  
      
\- Color: \#DAE1E9  
    

\- First Name:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder: "First Name"  
      
\- Padding: 12 dp  
    

\- Last Name:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder: "Last Name"  
      
\- Padding: 12 dp  
    

\- Date of Birth:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder: "Date of Birth"  
      
\- Padding: 12 dp  
    

\- Gender:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder: "Gender"  
      
\- Padding: 12 dp  
    

\- Location:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder: "Location"  
      
\- Padding: 12 dp  
    

\- Terms acceptance checkbox:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
      
\- Text: "I agree to the Terms of Service and Privacy Policy"  
    

\- Links:  
    

\- Terms of Service:  
    

\- Font: Poppins, Semi-Bold  
      
\- Color: \#96854A  
      
\- Action: Opens Terms of Service in a webview  
    

\- Privacy Policy:  
    

\- Font: Poppins, Semi-Bold  
      
\- Color: \#96854A  
      
\- Action: Opens Privacy Policy in a webview  
    

\- Style: Custom checkbox with gold checkmark  
      
\- Margin: 16 dp top  
    

\- Registration Button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
      
\- Action: Attempts to register the user. On success, navigates to a profile completion screen (not detailed here). On failure, displays an error message.  
    

\- Alternative: "Already have an account? Sign in" link:  
    

\- Text: "Already have an account? Sign in"  
      
\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#96854A (Gold)  
      
\- Action: Navigates to the Sign-in View  
      
\- Alignment: Center  
    

\- Routing:  
    

\- This view is accessible from the Landing Page and the Sign-in View.  
      
\- Successful registration navigates to a profile completion screen (not detailed here).  
      
\- "Already have an account? Sign in" link navigates to Sign-in View.  
    

\#\#\# 4\. Reset Password View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
      
\- Presidential seal watermark:  
    

\- Image: \[Presidential Seal SVG\]  
      
\- Opacity: 0.15  
      
\- Position: Center, behind logo  
      
\- Size: 60 dp  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Email input field:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: \#171717 (Dark)  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Placeholder text: "Enter your email address"  
      
\- Keyboard type: email-address  
      
\- Padding: 12 dp  
    

\- Security verification:  
    

\- Component: reCAPTCHA or security question  
      
\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Instructions:  
    

\- Font: Poppins, Regular  
      
\- Size: 12dp  
      
\- Color: \#DAD1E9  
    

\- Submit button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
      
\- Action: Sends a password reset link to the provided email address. Displays a success/failure message.  
    

\- Footer:  
    

\- Layout: Vertical list  
      
\- Support contact information:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
      
\- Text: "For support, contact us at support@4score.com or call us at 1-800-4SCORE"  
      
\- Alignment: Center  
    

\- Routing:  
    

\- This view is accessible from the Sign-in View ("Forgot Password?" link).  
    

\#\# II. Core Navigation Views

These views provide the primary navigation structure for the app.

\#\#\# 6\. The Range (Home View)

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
      
\- Presidential seal watermark:  
    

\- Image: \[Presidential Seal SVG\]  
      
\- Opacity: 0.15  
      
\- Position: Center, behind logo  
      
\- Size: 60 dp  
    

\- 4-Score logo:  
    

\- Image: \[4-Score Logo SVG\]  
      
\- Position: Centered horizontally and vertically within the banner  
      
\- Size: 50 dp  
    

\- Scrollable Content:  
    

\- Layout: Vertical scrolling list  
      
\- Spacing: 24 dp between sections  
      
\- Quick stats dashboard (today's progress):  
    

\- Layout: Horizontal list of metric cards  
      
\- Card width: 160 dp  
      
\- Card height: 120 dp  
      
\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Display of key metrics:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Workouts Completed:  
    

\- Number:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF  
    

\- Progress bar:  
    

\- Color: \#5D2121  
      
\- Height: 8dp  
    

\- Streak Days:  
    

\- Number:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF  
    

\- Icon: \[Fire icon\]  
      
\- Color: \#96854A  
    

\- Total Progress:  
    

\- Percentage:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24dp  
      
\- Color: \#FFFFFF  
    

\- Circular progress indicator:  
    

\- Color: \#96854A  
      
\- Radius: 40 dp  
    

\- Hydration Level:  
    

\- Visual representation: Water droplet icon  
      
\- Fill Color: \#96854A  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24dp  
      
\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 14dp  
      
\- Color: \# DAE1E9  
    

\- F.O.U.R. buttons in 2x2 grid:  
    

\- Layout: 2x2 grid  
      
\- Button size: 140 dp x 140 dp  
      
\- Spacing: 16 dp between buttons  
      
\- Each button:  
    

\- Background: \#520606 (Navy Blue)  
      
\- Border Radius: 8 dp  
      
\- Icon: \[Custom F.O.U.R. icon\]  
      
\- Icon size: 48 dp  
      
\- Label:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Action: Navigates to the corresponding section (ForgeScreen, OptimizeScreen, UniteScreen, RecoverScreen).  
    

\- Featured blog articles:  
    

\- Layout: Horizontal scrolling list of cards  
      
\- Card width: 320 dp  
      
\- Card height: 200 dp  
      
\- Spacing: 16 dp between cards  
      
\- Each card:  
    

\- Thumbnail image:  
    

\- Size: 100% width, 60% height  
      
\- Content Fit: Cover  
      
\- Border Radius: 8 dp (top corners)  
    

\- Title:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Margin: 8 dp  
    

\- Excerpt:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
      
\- Margin: 8 dp  
    

\- Action: Navigates to the full blog post (within the app or in a webview).  
    

\- Stacked feature sections (1x4 vertical):  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp between sections  
      
\- Forge section:  
    

\- Title:  
    

\- Text: "Forge Your Strength"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Workout preview:  
    

\- Card with a representative exercise  
      
\- Action: Navigates to Forge \- Workout Planner View  
    

\- Optimize section:  
    

\- Title:  
    

\- Text: "Optimize Your Nutrition"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Nutrition summary:  
    

\- Daily calorie and macro overview  
      
\- Action: Navigates to Optimize \- Nutrition Planning View  
    

\- Unite section:  
    

\- Title:  
    

\- Text: "Unite with the Community"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Community updates:  
    

\- Latest posts, events  
      
\- Action: Navigates to Unite \- Social Hub Main View  
    

\- Recover section:  
    

\- Title:  
    

\- Text: "Recover Effectively"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Sleep metrics:  
    

\- Last night's sleep score, sleep quality  
      
\- Action: Navigates to Recover \- Sleep Tracker Summary View  
    

\- Calendar widget:  
    

\- Component: Custom calendar widget  
      
\- Small month view:  
    

\- Dimensions: 200 dp x 200 dp  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Dots indicating days with scheduled activities:  
    

\- Color: \#5D2121 (workouts), \#520606 (meals), \#96854A (challenges), \#4CAF50 (recovery)  
    

\- Action: Tapping a day shows details below the calendar, navigates to full Calendar View.  
    

\- Events section:  
    

\- Title:  
    

\- Text: "Upcoming Events"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Layout: Vertical list of event cards (2-3)  
      
\- Event cards:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Event name:  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Date and time:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Location:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Action: Navigates to Events View.  
    

\- Trackers collection preview:  
    

\- Title:  
    

\- Text: "My Trackers"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Brief overview of user's active trackers:  
    

\- Workout, nutrition, sleep  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Action: Navigates to The Census \- Trackers Collection View  
    

\- Liberty Bells timers preview:  
    

\- Title:  
    

\- Text: "My Timers"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Quick access to recently used or favorite timers  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
      
\- Action: Navigates to Liberty Bells \- Timers Collection View  
    

\- Maps integration section:  
    

\- Title:  
    

\- Text: "Fitness Locations Near You"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of nearby fitness locations, parks, etc.  
      
\- Map component (Google Maps SDK)  
      
\- Action: Opens map view (Google Maps SDK)  
    

\- Wearables connection section:  
    

\- Title:  
    

\- Text: "Connect Your Wearable"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Information and call to action to connect wearable devices (e.g., Apple Watch, Fitbit)  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
      
\- Action: Opens device connection flow.  
    

\- Persistent Elements:  
    

\- F.O.U.R. bottom navigation tabs:  
    

\- Layout: Fixed bottom bar  
      
\- Height: 80 dp  
      
\- Background: \#171717 (Dark)  
      
\- Icons and labels for Forge, Optimize, Unite, Recover, Profile  
      
\- Active tab highlighted (white text, gold icon)  
      
\- Inactive tabs ( \#DAE1E9 text, \#96854A icon)  
      
\- Font: Poppins, Medium  
      
\- Size: 12 dp  
      
\- Action: Provide consistent navigation to main sections  
    

\- Swolemate chatbot button:  
    

\- Type: Floating button  
      
\- Position: Bottom right corner  
      
\- Size: 64 dp  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 32 dp  
      
\- Icon: \[Swolemate logo\]  
      
\- Icon size: 32 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Action: Opens Swolemate Chatbot View (modal or full screen)  
    

\- Routing:  
    

\- This view is the main home screen, displayed after successful login.  
      
\- Tapping on F.O.U.R. buttons, featured sections, calendar, events, trackers, and timers previews navigates to their respective views.  
      
\- Bottom navigation tabs provide persistent access to main sections.  
      
\- Chatbot button provides access to the Swolemate Chatbot.  
    

\#\#\# 7\. User Profile View

\- Header:  
    

\- Profile banner:  
    

\- Height: 200 dp  
      
\- Background: \#520606 (Navy Blue)  
    

\- User image:  
    

\- Shape: Circular  
      
\- Size: 120 dp  
      
\- Position: Centered horizontally at the bottom of the banner  
      
\- Border: 4 dp solid \#96854A (Gold)  
    

\- User's name:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Position: Below the user image  
      
\- Alignment: Center  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- User details section:  
    

\- Layout: Horizontal list  
      
\- Username:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
    

\- Action buttons:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- "Show Data":  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#520606 (Navy Blue)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Action: Navigates to The Census \- Progress Logs Main View  
    

\- "Edit Profile":  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#520606 (Navy Blue)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Action: Opens a modal or navigates to a profile edit screen (not detailed here).  
    

\- Stats section with 4 metric cards:  
    

\- Layout: 2x2 grid  
      
\- Card width: 160 dp  
      
\- Card height: 120 dp  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Title:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Value:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Visual representation for each stat (progress bars, icons):  
    

\- Workouts: Number of workouts completed, progress bar  
      
\- Streak: Current workout streak in days, fire icon  
      
\- Progress: Overall fitness progress (percentage), circular progress indicator  
      
\- Hydration: Current hydration level, water droplet icon  
    

\- Activity feed with recent actions:  
    

\- Title:  
    

\- Text: "Recent Activity"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Layout: Vertical list  
      
\- Each activity item:  
    

\- Timestamp:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
    

\- Activity description:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Link to relevant detail:  
    

\- Font: Poppins, Semi-Bold  
      
\- Color: \#96854A  
    

\- Community posts & challenges section:  
    

\- Title:  
    

\- Text: "Community Activity"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Layout: Vertical list  
      
\- Display of user's latest posts and active challenges  
      
\- Each item:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Notification toggle:  
    

\- Switch to enable/disable notifications for this section  
      
\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 12dp  
      
\- Color: \#DAE1E9  
    

\- Invite section:  
    

\- Title:  
    

\- Text: "Invite Friends"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Unique invite code display:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#96854A (Gold)  
      
\- Background: \#171717  
      
\- Padding: 8dp  
      
\- Border Radius: 8dp  
      
\- Text Alignment: Center  
    

\- Share button:  
    

\- Icon: \[Share icon\]  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 8dp  
      
\- Action: Opens share sheet to share the invite code  
      
\- Padding: 12 dp  
    

\- Navigation:  
    

\- F.O.U.R. bottom tabs plus profile icon  
      
\- Profile icon highlighted to indicate the current view  
    

\- Routing:  
    

\- This view is accessible from the bottom navigation bar (profile icon).  
      
\- "Show Data" button navigates to The Census \- Progress Logs Main View.  
      
\- "Edit Profile" button opens a modal or navigates to a profile edit screen.  
    

\#\#\# 8\. User Settings View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Settings"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp between sections  
      
\- Account settings section:  
    

\- Title:  
    

\- Text: "Account Settings"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Username:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Email address:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Password change option:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Action: Navigates to User Account View for detailed account management.  
    

\- Font: Poppins, Semi-Bold  
      
\- Color: \#96854A  
    

\- Notification preferences toggles:  
    

\- Title:  
    

\- Text: "Notification Preferences"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Push notifications:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Toggle switch  
    

\- Email notifications:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Toggle switch  
    

\- In-app notifications:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Toggle switch  
    

\- Granular control for different notification types (e.g., workout reminders, community updates):  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 14dp  
      
\- Color: \#DAE1E9  
    

\- Privacy controls:  
    

\- Title:  
    

\- Text: "Privacy Controls"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Profile visibility:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Selection control (e.g., radio buttons, dropdown)  
    

\- Data sharing options:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Checkboxes  
    

\- Location services:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Toggle switch  
    

\- App appearance settings:  
    

\- Title:  
    

\- Text: "Appearance"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Theme selection (light/dark):  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Selection control (e.g., radio buttons, dropdown)  
    

\- Font size:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Slider or stepper  
    

\- Subscription management link:  
    

\- Text: "Manage Subscription"  
      
\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#96854A (Gold)  
      
\- Action: Opens RevenueCat subscription management UI (within the app or in a webview).  
    

\- Data management options:  
    

\- Title:  
    

\- Text: "Data Options"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Export data:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Button  
    

\- Delete account:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Button  
    

\- Support and feedback links:  
    

\- Title:  
    

\- Text: "Support"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- FAQ/Help Center:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Action: Opens FAQ  
    

\- Contact Us form:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Action: Opens Form  
    

\- Report a problem:  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 16dp  
      
\- Color: \#DAE1E9  
    

\- Action: Opens form  
    

\- Action Buttons:  
    

\- Save changes button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Text: "Save Changes"  
      
\- Action: Saves the user's settings.  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
    

\- Routing:  
    

\- This view is accessible from the User Profile View or a settings icon in the main navigation.  
    

\#\#\# 9\. User Account View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Account"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Profile information summary:  
    

\- Username:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Email address:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Profile picture:  
    

\- Shape: Circular  
      
\- Size: 80 dp  
    

\- Subscription status:  
    

\- Current subscription tier:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Next billing date:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Action: Link to manage subscription (RevenueCat)  
    

\- Font: Poppins, Semi-Bold  
      
\- Color: \#96854A  
    

\- Billing information:  
    

\- Payment method:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Billing address:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Payment history link:  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 16 dp  
      
\- Color: \#96854A  
    

\- Account security options:  
    

\- Change password:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Two-factor authentication:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Connected services list (e.g., Google, Facebook):  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Action Buttons:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- Edit account:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#520606 (Navy Blue)  
      
\- Border Radius: 8 dp  
      
\- Text: "Edit Account"  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Action: Opens a modal or navigates to a detailed profile edit screen.  
    

\- Manage subscription:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Manage Subscription"  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Action: Opens RevenueCat subscription management UI.  
    

\- Routing:  
    

\- This view is accessible from the User Settings View (Account settings section).  
    

\#\# III. Forge (Workout) Views

These views handle workout planning, execution, and tracking.

\#\#\# 10\. Forge \- Workout Planner View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
      
\- Presidential seal watermark:  
    

\- Image: \[Presidential Seal SVG\]  
      
\- Opacity: 0.15  
      
\- Position: Center, behind logo  
      
\- Size: 60 dp  
    

\- Title:  
    

\- Text: "Forge"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Workout category tabs:  
    

\- Layout: Horizontal scrolling list  
      
\- Tab width: Auto  
      
\- Tab height: 48 dp  
      
\- Active tab style:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121  
      
\- Border Radius: 8dp  
    

\- Inactive tab style:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: Transparent  
      
\- Border Radius: 8dp  
    

\- Tabs: "Featured," "Strength," "Cardio," "Yoga," "Custom"  
      
\- Action: Filters the workout cards below.  
    

\- Workout cards:  
    

\- Layout: Vertical list, scrollable  
      
\- Card width: 100%  
      
\- Card height: 160 dp  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style:  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Workout name:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Text Transform: Uppercase  
      
\- Margin: 8 dp  
    

\- Duration, energy, difficulty metrics:  
    

\- Layout: Horizontal list  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
      
\- Spacing: 16dp  
      
\- Icons: \[Clock icon\], \[Fire icon\], \[Star icon\]  
    

\- Preview of exercises:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
      
\- Max lines: 3  
      
\- Margin: 8 dp  
    

\- Start button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Text: "Start"  
      
\- Action: Navigates to Forge \- Active Workout View  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- "Create Custom Workout" button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#96854A (Gold)  
      
\- Background: Transparent  
      
\- Border: 2 dp solid \#96854A (Gold)  
      
\- Border Radius: 8 dp  
      
\- Text: "Create Custom Workout"  
      
\- Action: Navigates to a custom workout creation flow (not detailed here).  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- Recent workouts section:  
    

\- Title:  
    

\- Text: "Recent Workouts"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Layout: Horizontal scrolling list  
      
\- Card width: 320 dp  
      
\- Card height: 160 dp  
      
\- Spacing: 16 dp  
      
\- Display of user's recently performed workouts (3-5)  
      
\- Action: Quick access to restart those workouts  
    

\- Navigation:  
    

\- F.O.U.R. bottom tabs with Forge highlighted  
    

\- Routing:  
    

\- This view is accessible from the bottom navigation bar (Forge tab) or the home screen.  
      
\- Tapping a workout card's "Start" button navigates to Forge \- Active Workout View.  
      
\- "Create Custom Workout" button navigates to a custom workout creation flow.  
    

\#\#\# 11\. Forge \- Workout Detail View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Workout name:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Workout stats bar:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16dp  
      
\- Time (estimated duration):  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Icon: \[Clock icon\]  
    

\- Energy (calories burned estimate):  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Icon: \[Fire icon\]  
    

\- Difficulty (rating, e.g., 1-5 stars):  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Stars: \[Star icons\]  
    

\- Exercise list:  
    

\- Layout: Vertical list, scrollable  
      
\- Spacing: 16 dp  
      
\- Each exercise:  
    

\- Exercise icon/thumbnail:  
    

\- Size: 64 dp x 64 dp  
      
\- Shape: Rounded rectangle  
      
\- Content Fit: Cover  
      
\- Border Radius: 8 dp  
    

\- Name and description:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp (name), 12 dp (description)  
      
\- Color: \#FFFFFF (name), \#DAE1E9 (description)  
    

\- Sets/reps/duration values:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
    

\- Chevron (right side) for detailed view (optional, if exercises have further details)  
    

\- Start button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Text: "Start Workout"  
      
\- Action: Navigates to Forge \- Active Workout View  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
    

\- Share and save options:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- Share icon:  
    

\- Icon: \[Share icon\]  
      
\- Color: \#FFFFFF  
      
\- Size: 32dp  
      
\- Action: Opens share sheet  
    

\- Save icon:  
    

\- Icon: \[Save icon\]  
      
\- Color: \#FFFFFF  
      
\- Size: 32dp  
      
\- Action: Adds to user's saved workouts  
    

\- Navigation:  
    

\- Back button:  
    

\- Icon: \[Back arrow icon\]  
      
\- Color: \#FFFFFF  
      
\- Position: Top left  
      
\- Action: Navigates back to Forge \- Workout Planner View  
    

\- F.O.U.R. bottom tabs  
    

\- Routing:  
    

\- This view is accessible by tapping on a workout card in Forge \- Workout Planner View.  
      
\- "Start Workout" button navigates to Forge \- Active Workout View.  
    

\#\#\# 12\. Forge \- Active Workout View

\- Header:  
    

\- Timer display:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 60 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Workout name:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Current exercise details:  
    

\- Exercise name:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Description:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
      
\- Alignment: Center  
    

\- Visual demonstration:  
    

\- Component: Image or animation  
      
\- Size: 100% width, auto height  
      
\- Content Fit: Contain  
      
\- Border Radius: 8 dp  
    

\- Progress indicators:  
    

\- Exercise X of Y:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Progress bar:  
    

\- Color: \#5D2121  
      
\- Height: 16 dp  
      
\- Border Radius: 8 dp  
    

\- Controls:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- Previous button:  
    

\- Icon: \[Back arrow icon\]  
      
\- Color: \#FFFFFF  
      
\- Action: Goes to previous exercise  
      
\- Disabled state: Opacity 0.5  
    

\- Pause/Play button:  
    

\- Icon: \[Pause icon\] or \[Play icon\]  
      
\- Color: \#FFFFFF  
      
\- Action: Toggles workout state  
    

\- Next button:  
    

\- Icon: \[Forward arrow icon\]  
      
\- Color: \#FFFFFF  
      
\- Action: Goes to next exercise  
      
\- Disabled state: Opacity 0.5  
    

\- Rep counter (if applicable):  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 14dp  
      
\- Color: \# DAE1E9  
    

\- Large digital display of current rep count  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 48 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Footer:  
    

\- Layout: Horizontal scrolling list  
      
\- Quick access to the remaining exercises in the workout (small thumbnails or list)  
      
\- Thumbnail size: 80 dp x 80 dp  
      
\- Spacing: 8 dp  
      
\- Action: Tapping a thumbnail navigates to that exercise  
    

\- Routing:  
    

\- This view is accessible by tapping "Start" in Forge \- Workout Detail View or Forge \- Workout Planner View.  
    

\#\#\# 13\. Forge \- Workout Calendar View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Workout Calendar"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Month view calendar:  
    

\- Component: Custom calendar component  
      
\- Days with scheduled workouts indicated:  
    

\- Indicator: Deep red dot below the day number  
    

\- Action: Tapping a day shows workout details below the calendar.  
      
\- Dimensions: 100% width, 300 dp height  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Day detail section:  
    

\- Layout: Vertical list  
      
\- Title:  
    

\- Text: "Workout Details"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18dp  
      
\- Color: \#FFFFFF  
    

\- List of scheduled workouts for the selected day  
      
\- Each workout:  
    

\- Workout name:  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Start time:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Link to workout detail:  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 14 dp  
      
\- Color: \#96854A  
    

\- Quick add workout button:  
    

\- Type: Floating button  
      
\- Icon: "+"  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 32 dp  
      
\- Action: Opens a modal or navigates to a quick workout scheduling flow.  
      
\- Position: Bottom right  
      
\- Padding: 12 dp  
    

\- Upcoming workout reminders:  
    

\- Title:  
    

\- Text: "Upcoming Workouts"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of upcoming workouts (1-3)  
      
\- Each reminder:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Push notification for workout reminders  
    

\- Navigation:  
    

\- F.O.U.R. tabs with Forge highlighted  
    

\- Routing:  
    

\- This view is accessible from the Forge section or the main calendar.  
    

\#\#\# 14\. Forge \- Workout Tracker View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Workout History"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Timeline view of completed workouts:  
    

\- Layout: Vertical list, reverse chronological order  
      
\- Each workout entry:  
    

\- Date and time:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Workout name:  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Key metrics (duration, calories burned):  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Link to workout details:  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 14 dp  
      
\- Color: \#96854A  
    

\- Stats summary:  
    

\- Title:  
    

\- Text: "Workout Summary"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Total workouts completed:  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Favorite workout types (with percentages):  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Progress graphs:  
    

\- Title:  
    

\- Text: "Progress Overview"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Visualizations of strength and endurance progress over time  
      
\- Interactive charts (e.g., line graphs)  
      
\- Metrics:  
    

\- Weight lifted (strength)  
      
\- Distance covered (endurance)  
      
\- Workout frequency  
    

\- Achievement highlights:  
    

\- Title:  
    

\- Text: "My Achievements"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of earned workout achievements  
      
\- Layout: Horizontal scrolling list  
      
\- Achievement cards  
    

\- Badge icon  
      
\- Achievement name  
      
\- Completion date  
    

\- Filters:  
    

\- Title:  
    

\- Text: "Filters"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Layout: Horizontal list  
      
\- Date range (start and end date):  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Component: Date range picker  
    

\- Workout type (dropdown):  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Component: Dropdown  
    

\- Metrics (selectable metrics to display in graphs):  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Component: Checkboxes  
    

\- Routing:  
    

\- This view is accessible from the Forge section.  
    

\#\# IV. Optimize (Nutrition) Views

These views handle nutrition planning, tracking, and grocery ordering.

\#\#\# 15\. Optimize \- Nutrition Planning View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Optimize"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Meal plan tabs:  
    

\- Layout: Horizontal tabs  
      
\- Tabs: "Today," "Week View"  
      
\- "Today" shows meals for the current day.  
      
\- "Week View" shows an overview of the week's plan.  
      
\- Active tab style:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 8dp  
    

\- Inactive tab style:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Background: Transparent  
      
\- Border Radius: 8dp  
    

\- Meal cards for breakfast, lunch, dinner, snacks:  
    

\- Layout: Vertical list  
      
\- Card width: 100%  
      
\- Card height: 120 dp  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Meal name and time:  
    

\- Font: Poppins, Semi-Bold (name), Regular (time)  
      
\- Size: 16 dp (name), 12 dp (time)  
      
\- Color: \#FFFFFF (name), \#DAE1E9 (time)  
      
\- Margin: 8 dp  
    

\- Calorie and macro info:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
      
\- Layout: Horizontal list  
      
\- Values: Calories, Protein, Carbs, Fat  
    

\- Food thumbnails:  
    

\- Size: 80 dp x 80 dp  
      
\- Shape: Rounded rectangle  
      
\- Content Fit: Cover  
      
\- Border Radius: 8 dp  
    

\- Edit button:  
    

\- Icon: \[Pencil icon\]  
      
\- Color: \#FFFFFF  
      
\- Action: Navigates to meal editing  
      
\- Position: Top right  
      
\- Padding: 8dp  
    

\- Nutrition summary with macro breakdown:  
    

\- Title:  
    

\- Text: "Nutrition Summary"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Daily totals for calories, protein, carbs, fat  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Progress bars or a pie chart visualizing macro distribution  
    

\- Recommended meals section:  
    

\- Title:  
    

\- Text: "Recommended Meals"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Meal suggestions based on user preferences and goals  
      
\- Layout: Horizontal scrolling list  
      
\- Spacing: 16 dp  
      
\- Meal cards similar to the ones above  
    

\- Action Button: "Plan New Meal"  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow  
      
\- Text: "Plan New Meal"  
      
\- Action: Navigates to a meal planning flow (not detailed here)  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
    

\- Routing:  
    

\- This view is accessible from the bottom navigation bar (Optimize tab).  
    

\#\#\# 16\. Optimize \-Nutrition Calendar View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Meal Calendar"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Calendar view with meal indicators:  
    

\- Component: Custom calendar component  
      
\- Month view  
      
\- Days with planned meals indicated:  
    

\- Indicator: Small food icon  
    

\- Action: Tapping a day shows meal details below the calendar.  
      
\- Dimensions: 100% width, 300 dp height  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \# DAE1E9  
    

\- Day detail showing all planned meals:  
    

\- Layout: Vertical list  
      
\- Title:  
    

\- Text: "Meal Details"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Meal name  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Time  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Calorie and macro information  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Link to meal editing  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 14 dp  
      
\- Color: \#96854A  
    

\- Nutrition totals for selected day:  
    

\- Title:  
    

\- Text: "Daily Totals"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Calories, protein, carbs, fat  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Quick meal template options:  
    

\- Title:  
    

\- Text: "Meal Templates"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Buttons or a dropdown for common meal templates (e.g., "Quick Breakfast," "Post-Workout Shake")  
      
\- Layout: Horizontal list  
      
\- Each option:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 8dp  
      
\- Padding: 8dp  
    

\- Navigation:  
    

\- F.O.U.R. tabs with Optimize highlighted  
    

\- Routing:  
    

\- This view is accessible from the Optimize section.  
    

\#\#\# 17\. Optimize \- Instacart Ordering View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Grocery Order"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Ingredient list from meal plan:  
    

\- Layout: Vertical list  
      
\- Each ingredient:  
    

\- Name:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Quantity:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Adjustable controls: "+" and "-" buttons  
    

\- Image (if available):  
    

\- Size: 80 dp x 80 dp  
      
\- Shape: Rounded rectangle  
      
\- Content Fit: Cover  
      
\- Border Radius: 8 dp  
    

\- Quantity adjustments:  
    

\- "+" and "-" buttons to change ingredient quantities  
      
\- Layout: Horizontal list  
      
\- Button size: 32 dp  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 16dp  
    

\- Alternative suggestions:  
    

\- Title:  
    

\- Text: "Alternatives"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display alternative ingredients (e.g., different brands)  
      
\- Layout: Horizontal scrolling list  
      
\- Card width: 200 dp  
      
\- Card height: 100 dp  
      
\- Spacing: 16 dp  
      
\- Each suggestion:  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Instacart integration button:  
    

\- Button to send the ingredient list to Instacart  
      
\- Action: Opens Instacart app or website with pre-filled cart.  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#4CAF50 (Green)  
      
\- Border Radius: 8 dp  
      
\- Text: "Add to Instacart Cart"  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- Order summary with estimated cost:  
    

\- Title:  
    

\- Text: "Order Summary"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Total cost of the order  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Estimated delivery fee  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Action Buttons:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- "Add to Cart":  
    

\- Color: Green  
      
\- Text: "Add to Instacart Cart"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#4CAF50 (Green)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- "Checkout" (If direct checkout is implemented):  
    

\- Color: Deep Red  
      
\- Text: "Checkout"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- Routing:  
    

\- This view is accessible from the Optimize \- Nutrition Planning View (e.g., from a "Order Groceries" button).  
    

\#\#\# 18\. Optimize \- Nutrition Supplement View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Supplements"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Current supplement regimen:  
    

\- Title:  
    

\- Text: "My Supplements"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- List of supplements the user is currently taking  
      
\- Each supplement:  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Dosage and frequency information  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Recommended supplements based on goals:  
    

\- Title:  
    

\- Text: "Recommendations"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Supplements suggested for the user's fitness goals  
      
\- Layout: Horizontal scrolling list  
      
\- Card width: 320 dp  
      
\- Card height: 160 dp  
      
\- Spacing: 16 dp  
    

\- Supplement cards:  
    

\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Name and image  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Benefits description  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Dosage information  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- "Add to Regimen" button:  
    

\- Action: Adds the supplement to the user's current regimen.  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 8 dp  
    

\- Integration with shop for purchasing:  
    

\- Link to purchase supplements (either within the app or an external shop)  
      
\- Font: Poppins, Semi-Bold  
    

\- Size: 16 dp  
      
\- Color: \#96854A  
    

\- Routing:  
    

\- This view is accessible from the Optimize section.  
    

\#\#\# 19\. Optimize \- Nutrition Tracker View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Nutrition Log"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Daily food log entries:  
    

\- Layout: Vertical list  
      
\- List of food items the user has consumed  
      
\- Each entry:  
    

\- Food name and quantity  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Time of consumption  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Calorie and macro information  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Quick add food button:  
    

\- Button to quickly add a food item  
      
\- Action: Opens a food input form or search.  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp  
    

\- Barcode scanner access:  
    

\- Button to open the camera for barcode scanning  
      
\- Action: Opens the camera and integrates with a barcode scanning library.  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp  
    

\- Calorie and macro progress bars:  
    

\- Visual representation of daily calorie and macro intake vs. goals  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Water intake tracker:  
    

\- Display of daily water intake  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
      
\- Controls to add water (e.g., "+" button, cups)  
    

\- Nutrition insights section:  
    

\- Title:  
    

\- Text: "Insights"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Tips and recommendations based on the user's logged nutrition.  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Routing:  
    

\- This view is accessible from the Optimize section.  
    

\#\# V. Unite (Social) Views

These views handle social interaction and community features.

\#\#\# 20\. Unite \- Social Hub Main View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Unite"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Community feed with posts from connections:  
    

\- Layout: Vertical list, reverse chronological order  
      
\- Post types:  
    

\- Workouts (shared workout sessions)  
      
\- Meals (shared meal plans/recipes)  
      
\- Achievements (fitness milestones)  
      
\- Questions (user questions to the community)  
    

\- Each post:  
    

\- User avatar and name  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Timestamp  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Post content (text, images, videos)  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Workout/meal/achievement details (if applicable)  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Interaction buttons:  
    

\- Layout: Horizontal list  
      
\- Spacing: 16 dp  
      
\- Like (heart icon)  
    

\- Icon: \[Heart icon\]  
      
\- Size: 32dp  
      
\- Color: \#FFFFFF  
      
\- Action: Toggles "like" status  
    

\- Comment (comment icon, opens comment section)  
    

\- Icon: \[Comment icon\]  
      
\- Size: 32dp  
      
\- Color: \#FFFFFF  
      
\- Action: Opens comment section  
    

\- Share (share icon, opens share sheet)  
    

\- Icon: \[Share icon\]  
      
\- Size: 32dp  
      
\- Color: \#FFFFFF  
      
\- Action: Opens share sheet  
    

\- Post creation card at top:  
    

\- Input field to create a new post  
    

\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#DAE1E9  
      
\- Placeholder: "Share an update..."  
      
\- Background: \#171717  
      
\- Border Radius: 8dp  
      
\- Padding: 12dp  
    

\- Options to add media (image, video)  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Post type selector  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Trending topics section:  
    

\- Title:  
    

\- Text: "Trending Topics"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of popular hashtags or discussion topics  
      
\- Layout: Horizontal scrolling list  
      
\- Each topic:  
    

\- Font: Poppins, Semi-Bold  
    

\- Size: 14 dp  
      
\- Color: \#96854A  
      
\- Background: \#171717  
      
\- Border Radius: 16dp  
      
\- Padding: 8dp  
    

\- Suggested connections:  
    

\- Title:  
    

\- Text: "Suggested Connections"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- List of users the user might know  
      
\- Layout: Horizontal scrolling list  
      
\- Card width: 320 dp  
      
\- Card height: 100 dp  
      
\- Spacing: 16 dp  
      
\- Each user:  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- "Add Friend" buttons  
    

\- Font: Mandrel Ext Extra-bold  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 8 dp  
    

\- Navigation:  
    

\- F.O.U.R. tabs with Unite highlighted  
    

\- Routing:  
    

\- This view is accessible from the bottom navigation bar (Unite tab).  
    

\#\#\# 21\. Unite \- Social Calendar View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Community Calendar"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Calendar view with community events:  
    

\- Component: Custom calendar component  
      
\- Month view  
      
\- Days with events indicated:  
    

\- Indicator: Gold dot  
    

\- Action: Tapping a day shows event details below.  
      
\- Dimensions: 100% width, 300 dp height  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \# DAE1E9  
    

\- Event cards:  
    

\- Layout: Vertical list  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Event name and type (e.g., "Group Workout," "Nutrition Workshop")  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Date and time  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Participation count (number of attendees)  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- "Join" button:  
    

\- Action: Adds the user to the event's attendee list.  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 8 dp  
    

\- My events section:  
    

\- Title:  
    

\- Text: "My Events"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- List of events the user is attending  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Create event button (for eligible users, e.g., coaches):  
    

\- Action: Opens an event creation form.  
      
\- Font: Mandrel Ext Extra-bold    
    \* Size: 16 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp vertical, 24 dp horizontal    
    \* Margin: 8 dp  
    

\- Routing:  
    

\- This view is accessible from the Unite section.  
    

\#\#\# 22\. Pony Express \- Messaging Main View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Messages"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Conversation list:  
    

\- Layout: Vertical list, scrollable  
      
\- Each conversation:  
    

\- User avatar and name  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Preview of last message (snippet)  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
      
\- Max Lines: 1  
    

\- Timestamp (of last message)  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Unread indicators (badge with number of unread messages)  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 14 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 16dp  
      
\- Padding: 4dp  
    

\- Action: Tapping a conversation opens the Pony Express \- Message Conversation View  
    

\- Search contacts field:  
    

\- Input field to search for users  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#DAE1E9    
    \* Placeholder: "Search contacts..."    
    \* Background: \#171717    
    \* Border Radius: 8dp    
    \* Padding: 12dp  
    

\- New message button:  
    

\- Type: Floating button  
      
\- Icon: "+" or "New Message"  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 32 dp  
      
\- Action: Opens a contact selector to start a new conversation.  
      
\- Position: Bottom right  
      
\- Padding: 12 dp  
    

\- Message filtering options:  
    

\- Tabs or a dropdown to filter conversations (e.g., "All," "Unread," "Groups")  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Routing:  
    

\- This view is accessible from the Unite section.  
    

\#\#\# 23\. Pony Express \- Message Conversation View

\- Header:  
    

\- Conversation name (with user avatar, if it's a one-on-one chat)  
    

\- Font: Mandrel Ext Extra-bold    
    \* Size: 20 dp    
    \* Color: \#FFFFFF  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 8 dp  
      
\- Message bubbles:  
    

\- Reverse chronological order (newest at the bottom)  
      
\- Styling:  
    

\- Sent messages:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#520606 (Navy Blue)  
      
\- Border Radius: 8 dp (top left, top right, bottom right)  
      
\- Padding: 12 dp  
    

\- Received messages:  
    

\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp (top left, top right, bottom left)  
      
\- Padding: 12 dp  
    

\- Timestamp indicators (small text below each message)  
    

\- Font: Poppins, Regular  
    

\- Size: 10 dp  
      
\- Color: \#DAE1E9  
    

\- Media sharing options (icons for image, video, audio)  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Typing indicator:  
    

\- Display when the other user is typing  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Workout/meal plan sharing tools:  
    

\- Buttons or integrated UI to share workouts or meal plans directly within the chat.  
      
\- Font: Mandrel Ext Extra-bold    
    \* Size: 14 dp    
    \* Color: \#FFFFFF    
    \* Background: \#96854A    
    \* Border Radius: 8dp    
    \* Padding: 8dp  
    

\- Input:  
    

\- Message field:  
    

\- Input field for typing messages  
      
\- Placeholder text: "Type your message..."  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#DAE1E9    
    \* Background: \#171717    
    \* Border Radius: 8dp    
    \* Padding: 12dp  
    

\- Send button:  
    

\- Icon: Send arrow  
      
\- Color: \#FFFFFF  
      
\- Glow: Blue glow effect  
      
\- Action: Sends the message.  
      
\- Padding: 8dp  
      
\- Border Radius: 8dp  
      
\- Background: \#5D2121  
    

\- Routing:  
    

\- This view is accessible by tapping on a conversation in the Pony Express \- Messaging Main View.  
    

\#\# VI. Recover (Rest & Recovery) Views

These views handle sleep tracking and recovery features.

\#\#\# 24\. Recover \- Sleep Tracker Summary View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Recover"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Sleep score card:  
    

\- Overall rating of last night's sleep (e.g., "Excellent," "Good," "Fair," "Poor")  
      
\- Visual representation (e.g., a circular gauge)  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#DAE1E9  
    

\- Last night's sleep details:  
    

\- Total sleep duration  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Time in each sleep stage (deep, light, REM)  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Sleep quality graphs:  
    

\- Visualizations of sleep stages throughout the night  
      
\- Line graph or area chart  
    

\- Weekly sleep pattern visualization:  
    

\- Overview of sleep consistency and duration over the past week  
      
\- Bar chart or calendar view  
    

\- Sleep recommendations based on data:  
    

\- Tips for improving sleep quality based on the user's sleep patterns.  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Action Button: "Set Sleep Goal"  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow  
      
\- Text: "Set Sleep Goal"  
      
\- Action: Navigates to a sleep goal setting flow.  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
    

\- Routing:  
    

\- This view is accessible from the bottom navigation bar (Recover tab).  
    

\#\#\# 25\. Recover \- Sleep Log View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Sleep Log"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Calendar view with sleep quality indicators:  
    

\- Component: Custom calendar component  
      
\- Month view  
      
\- Days with sleep logs indicated (e.g., with color-coded dots representing sleep quality)  
      
\- Action: Tapping a day shows the sleep log details below.  
      
\- Dimensions: 100% width, 300 dp height  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \# DAE1E9  
    

\- Daily sleep entries:  
    

\- For the selected day  
      
\- Each entry:  
    

\- Duration and quality rating  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp (duration), 16 dp (quality)  
      
\- Color: \#FFFFFF  
    

\- Sleep and wake times  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Disturbances noted (e.g., "Awoke once," "Restless sleep")  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Weekly and monthly averages:  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Export data option:  
    

\- Button to export sleep log data (e.g., as CSV)  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible from the Recover section.  
    

\#\#\# 26\. Recover \- Sleep Timer View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Sleep Timer"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Set bedtime and wake time controls:  
    

\- Time pickers for setting bedtime and wake time  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- Sleep sounds selection:  
    

\- List of white noise or calming sounds (from Firebase Storage)  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
      
\- Preview and volume controls  
    

\- Alarm configuration:  
    

\- Alarm sound selection  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
      
\- Snooze options  
    

\- Smart wake-up window setting:  
    

\- Option to wake up the user during a light sleep stage within a specified window.  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Sleep routine reminder options:  
    

\- Reminders to start the sleep timer and wind down.  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Action Button: "Start Sleep Timer"  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow  
      
\- Text: "Start Sleep Timer"  
      
\- Action: Starts the sleep timer.  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
    

\- Routing:  
    

\- This view is accessible from the Recover section.  
    

\#\#\# 27\. Recover \- Sleep Schedule Calendar View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Sleep Schedule"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Calendar showing sleep/wake pattern:  
    

\- Component: Custom calendar component  
      
\- Dimensions: 100% width, 300 dp height  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \# DAE1E9  
      
\- Visual representation of the user's sleep schedule over the week  
      
\- Sleep and wake times are displayed on the calendar  
    

\- Consistency metrics:  
    

\- Metrics showing how consistent the user's sleep schedule is.  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Schedule adjustment tools:  
    

\- Tools to adjust the user's sleep schedule  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Sleep debt calculator:  
    

\- Calculates the user's sleep debt.  
      
\- Font: Poppins, Regular  
    

\#\#\# 28\. Liberty Bells \- Timers Collection View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Liberty Bells"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Timer category cards:  
    

\- Layout: Vertical list or grid  
      
\- Each card:  
    

\- Card style:  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Timer category:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Icon representing the category:  
    

\- Size: 48 dp  
    

\- Action: Navigates to the corresponding timer view (e.g., Forge \- Liberty Bells \- Workout Timer View).  
    

\- Categories:  
    

\- Workout timers  
      
\- Fasting timers  
      
\- Sleep timers  
      
\- Custom timers  
    

\- Recent timers section:  
    

\- Title:  
    

\- Text: "Recent Timers"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of recently used timers  
      
\- Layout: Horizontal scrolling list  
      
\- Card Width: 320 dp  
      
\- Card Height: 100 dp  
      
\- Spacing: 16 dp  
      
\- Action: Quick access to restart them  
    

\- Quick start buttons for favorites:  
    

\- Title:  
    

\- Text: "Favorite Timers"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of user's favorite timers  
      
\- Layout: Horizontal scrolling list  
      
\- Card Width: 320 dp  
      
\- Card Height: 100 dp  
      
\- Spacing: 16 dp  
    

\- Action Button: "Create New Timer"  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow  
      
\- Text: "Create New Timer"  
      
\- Action: Navigates to a custom timer creation flow.  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
    

\- Routing:  
    

\- This view is accessible from the main navigation or other relevant sections.  
    

\#\#\# 29\. Forge \- Liberty Bells \- Workout Timer View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Workout timer type:  
    

\- e.g., "Interval Timer," "Stopwatch"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Large timer display:  
    

\- Digital display of the timer value (minutes, seconds, milliseconds)  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 80 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Interval visualization:  
    

\- Visual representation of work/rest intervals (if applicable)  
      
\- Progress bar or circular indicator  
      
\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Work/rest period indicators:  
    

\- Labels or icons indicating the current phase (work or rest)  
      
\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Sound/vibration settings:  
    

\- Controls to customize timer alerts  
      
\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Timer controls:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- Start, Pause, Reset buttons  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp  
    

\- Save as preset option:  
    

\- Button to save the current timer configuration as a preset.  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#520606 (Navy Blue)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible from the Liberty Bells \- Timers Collection View (Workout timers category).  
    

\#\#\# 30\. Optimize \- Liberty Bells \- Fasting Timer View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Fasting Timer"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Circular progress indicator:  
    

\- Visual representation of the fasting duration  
      
\- Radius: 120 dp  
      
\- Stroke Width: 16 dp  
      
\- Progress Color: \#5D2121  
      
\- Background Color: \#171717  
    

\- Current fast duration:  
    

\- Display of elapsed time  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 48 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Fast type selection:  
    

\- Options to choose common fasting protocols (16:8, 20:4, etc.)  
      
\- Layout: Horizontal list  
      
\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Spacing: 8dp  
    

\- Start/end time display:  
    

\- Display of the scheduled start and end times  
      
\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Fasting stage indicators:  
    

\- Visual cues for different fasting stages (e.g., "Fed," "Post-Absorptive," "Fasting")  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Hydration reminders:  
    

\- Optional reminders to drink water during the fast  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Action Buttons:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- Start:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Start"  
      
\- Action: Starts the timer  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- Pause:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Pause"  
      
\- Action: Pauses the timer  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- End Fast:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "End Fast"  
      
\- Action: Ends the timer  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- Routing:  
    

\- This view is accessible from the Liberty Bells \- Timers Collection View (Fasting timers category).  
    

\#\#\# 31\. Optimize \- Carbo-tracker \+ Carbo Timer View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Carb Tracker"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Daily carb consumption display:  
    

\- Display of the user's daily carb intake in grams  
      
\- Progress bar towards daily goal  
      
\- Font: Poppins, Regular  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Meal-by-meal carb breakdown:  
    

\- Carb intake for each meal of the day  
      
\- Layout: Vertical list  
      
\- Each meal:  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Carb cycling phase indicator:  
    

\- Indicates the current phase of the user's carb cycling plan (e.g., high-carb, low-carb)  
      
\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Timer for carb refeed window:  
    

\- Timer for the user's carb refeed window, if applicable  
      
\- Font: Mandrel Ext Extra-bold  
    

\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Alignment: Center  
    

\- Recommendations based on workout schedule:  
    

\- Carb intake recommendations based on the user's workout schedule  
      
\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Action Button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Log carb intake"  
      
\- Opens a form to log carb intake  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
    

\- Routing:  
    

\- This view is accessible from the Optimize section.  
    

\#\# VIII. The Frontier (Challenges) Views

These views handle community fitness challenges.

\#\#\# 32\. The Frontier \- Community Challenges Main View

\- Header:  
    

\- Deep red banner:  
    

\- Color: \#5D2121 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "The Frontier Challenge Zone"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#96854A (Gold)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Featured challenge banner:  
    

\- Large banner showcasing the current featured challenge  
      
\- Image and brief description  
      
\- Height: 200 dp  
      
\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Challenge category tabs:  
    

\- Tabs to filter challenges (e.g., "Featured," "Popular," "My Challenges")  
      
\- Layout: Horizontal list  
      
\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#DAE1E9  
    

\- Challenge cards:  
    

\- Layout: Vertical list, scrollable  
      
\- Card width: 100%  
      
\- Card height: 160 dp  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Challenge name:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Text Transform: Uppercase  
      
\- Margin: 8 dp  
    

\- Description and duration:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
      
\- Margin: 8 dp  
    

\- Difficulty indicator (e.g., 1-5 stars):  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
      
\- Stars: \[Star icons\]  
    

\- Participation count (number of participants)  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9 (Dirty/Worn White)  
    

\- "Join Challenge" button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Text: "Join Challenge"  
      
\- Action: Adds the user to the challenge.  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- My active challenges section:  
    

\- Title:  
    

\- Text: "My Challenges"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- List of challenges the user has joined  
      
\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Navigation:  
    

\- F.O.U.R. tabs with appropriate highlight  
    

\- Routing:  
    

\- This view is accessible from the main navigation.  
    

\#\#\# 33\. The Frontier \- Challenge Attempt/Completion Feed View

\- Header:  
    

\- Deep red banner:  
    

\- Color: \#5D2121 (solid fill)  
      
\- Height: 80 dp  
    

\- Challenge name:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Challenge description and rules:  
    

\- Title:  
    

\- Text: "Description"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Progress tracker:  
    

\- Visual representation of the user's progress in the challenge  
      
\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Community feed of participants' updates:  
    

\- Reverse chronological order  
      
\- Each update:  
    

\- User avatar and name  
    

\- Font: Poppins, Semi-Bold  
      
\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Timestamp  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Progress update (text, images, videos)  
    

\- Font: Poppins, Regular  
      
\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Leaderboard preview:  
    

\- Title:  
    

\- Text: "Leaderboard"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Top 3-5 participants  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Link to full leaderboard  
    

\- Font: Poppins, Semi-Bold  
    

\- Size: 14 dp  
      
\- Color: \#96854A  
    

\- Achievement milestones  
    

\- Title:  
    

\- Text: "Achievements"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of achievements earned in the challenge  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Action Buttons:  
    

\- Layout: Horizontal list  
      
\- Spacing: 16 dp  
      
\- Post update:  
    

\- Button to share a progress update  
      
\- Action: Opens a modal or form to create a post.  
      
\- Font: Mandrel Ext Extra-bold    
    \* Size: 16 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp  
    

\- View leaderboard:  
    

\- Action: Navigates to The Frontier \- Challenge Leaderboard View  
      
\- Font: Mandrel Ext Extra-bold    
    \* Size: 16 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible by tapping on a challenge card in The Frontier \- Community Challenges Main View.  
    

\#\#\# 34\. The Frontier \- Challenge Dual View

\- Header:  
    

\- Deep red banner:  
    

\- Color: \#5D2121 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Challenge Duel"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Head-to-head comparison display:  
    

\- User vs. opponent  
      
\- User avatars and names  
    

\- Font: Poppins, Semi-Bold  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- User vs opponent stats:  
    

\- Key metrics being tracked in the duel  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Progress bars for both participants:  
    

\- Visual representation of progress  
    

\- Activity feed with dual updates:  
    

\- Title:  
    

\- Text: "Duel Activity"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Updates specific to the duel  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Countdown to challenge end:  
    

\- Title:  
    

\- Text: "Time Remaining"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of remaining time  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- Action Button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Send encouragement/taunt"  
      
\- Button to send a message to the opponent  
      
\- Action: Opens a chat interface.  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- Routing:  
    

\- This view is accessible from a dual challenge invitation or from the main challenge view.  
    

\#\#\# 35\. The Frontier \- Challenge Team View

\- Header:  
    

\- Deep red banner:  
    

\- Color: \#5D2121 (solid fill)  
      
\- Height: 80 dp  
    

\- Team name:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Team roster with individual contributions:  
    

\- List of team members  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Display of each member's progress  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Team progress toward goal:  
    

\- Overall team progress  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- Team chat/message board:  
    

\- Communication channel for team members  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Competition standings:  
    

\- Team's ranking in the challenge  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Team strategy section:  
    

\- Area for team members to discuss strategy  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Action Buttons:  
    

\- Layout: Horizontal list  
      
\- Spacing: 16 dp  
      
\- Contribute progress:  
    

\- Button to log progress  
      
\- Action: Opens a progress input form.  
      
\- Font: Mandrel Ext Extra-bold    
    \* Size: 16 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp  
    

\- Message team:  
    

\- Button to open the team chat  
      
\- Action: Opens the chat interface.  
      
\- Font: Mandrel Ext Extra-bold    
    \* Size: 16 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible from a team challenge or the main challenge view.  
    

\#\#\# 36\. The Frontier \- Challenge Leaderboard View

\- Header:  
    

\- Deep red banner:  
    

\- Color: \#5D2121 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Leaderboard"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Ranking list:  
    

\- Vertical list  
      
\- Each entry:  
    

\- Position number  
    

\- Font: Mandrel Ext Extra-bold  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- User avatars/names  
    

\- Font: Poppins, Semi-Bold  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Progress metrics  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Achievement badges  
    

\- Size: 24dp  
    

\- My ranking highlight:  
    

\- Highlight the user's position in the leaderboard  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- Filter options:  
    

\- Layout: Horizontal list  
      
\- Spacing: 16 dp  
      
\- Options: "Friends," "Local (users in the same area)," "Global (all users)"  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Action Button:  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Share ranking"  
      
\- Button to share the user's ranking  
      
\- Action: Opens a share sheet.  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- Routing:  
    

\- This view is accessible from a challenge view.  
    

\#\#\# 37\. The Frontier \- Challenge Achievements and Rewards View

\- Header:  
    

\- Deep red banner:  
    

\- Color: \#5D2121 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Achievements"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Achievement cards:  
    

\- Layout: Vertical list or grid  
      
\- Card width: 100%  
      
\- Card height: 120 dp  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Badge icon and name  
    

\- Font: Poppins, Semi-Bold  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Requirements to earn  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Completion status (e.g., "Earned," "In Progress," "Locked")  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
    

\- Associated rewards:  
    

\- Title:  
    

\- Text: "Rewards"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Display of rewards for each achievement  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Reward redemption section:  
    

\- Area to redeem earned rewards  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Achievement history:  
    

\- Title:  
    

\- Text: "My Achievements"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- List of earned achievements  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Progress toward next achievements:  
    

\- Title:  
    

\- Text: "Progress"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Visual representation of progress  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Routing:  
    

\- This view is accessible from the challenge section.  
    

\#\# IX. The Census (Analytics) Views

These views handle user progress tracking and analytics.

\#\#\# 38\. The Census \- Progress Logs Main View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "The Census"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Overall progress summary:  
    

\- High-level overview of the user's fitness progress  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Key metrics dashboard:  
    

\- Display of important metrics:  
    

\- Total workouts  
    

\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Average sleep duration  
    

\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Weight change  
    

\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Other relevant data  
    

\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Recent logs section:  
    

\- Title:  
    

\- Text: "Recent Logs"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- List of recent activity logs  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Progress charts and graphs:  
    

\- Title:  
    

\- Text: "Progress Charts"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Visualizations of progress over time  
      
\- Chart types: line graphs, bar charts  
    

\- Goal tracking visualization:  
    

\- Title:  
    

\- Text: "Goal Progress"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Progress towards set fitness goals  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Action Button: "Add new log entry"    
    \* Font: Mandrel Ext Extra-bold    
    \* Size: 20 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Glow: Blue glow    
    \* Text: "Add New Log Entry"    
    \* Action: Opens a log entry form.    
    \* Padding: 12 dp vertical, 24 dp horizontal    
    \* Margin: 24 dp top  
      
\- Routing:  
    

\- This view is accessible from the main navigation.  
    

\#\#\# 39\. The Census \- Trackers Collection View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Trackers"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Tracker category cards:  
    

\- Layout: Vertical list or grid  
      
\- Card width: 100%  
      
\- Card height: 120 dp  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Tracker category  
    

\- Font: Mandrel Ext Extra-bold  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Icon  
    

\- Size: 48dp  
    

\- Description  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Action: Navigates to the corresponding tracker view.  
    

\- Categories:  
    

\- Workout trackers  
      
\- Nutrition trackers  
      
\- Body measurement trackers  
      
\- Financial fitness trackers  
      
\- Step counter  
    

\- Quick access to recent trackers  
    

\- Title:  
    

\- Text: "Recent Trackers"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
    

\- Color: \#FFFFFF (White)    
    \* Layout: Horizontal scrolling list    
    \* Card Width: 320 dp    
    \* Card Height: 100 dp    
    \* Spacing: 16 dp  
    

\- Action Button: "Create custom tracker"  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Create custom tracker"  
      
\- Action: Opens a custom tracker creation flow  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
      
\- Margin: 24 dp top  
    

\- Routing:  
    

\- This view is accessible from the main navigation.  
    

\#\#\# 40\. The Census \- Financial Fitness Budget Tracker View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Financial Fitness"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Monthly budget overview  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- Fitness-related expense categories  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
      
\- Layout: Horizontal list  
      
\- Categories: "Equipment", "Memberships", "Events", "Coaching"  
    

\- Expense vs. budget visualization  
    

\- Chart component (bar or line)  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Recent transactions list  
    

\- Title:  
    

\- Text: "Recent Transactions"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Layout: Vertical list  
      
\- Each transaction:  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Savings goals for fitness equipment/events  
    

\- Title:  
    

\- Text: "Savings Goals"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Action Buttons:  
    

\- Layout: Horizontal list  
      
\- Spacing: 16 dp  
      
\- Add expense  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Add expense"  
      
\- Action: Opens a form to add an expense  
      
\- Padding: 12 dp  
    

\- Adjust budget  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Adjust budget"  
      
\- Action: Opens a form to adjust budget  
      
\- Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible from the Census section.  
    

\#\#\# 41\. The Census \- Step Counter View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Step Counter"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Daily step count with progress to goal  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- Weekly step chart  
    

\- Chart component (bar or line)  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Distance and calorie estimates  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
      
\- Layout: Horizontal list  
    

\- Step streak information  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Walking route map integration  
    

\- Map Component (Google Maps SDK)  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Action Button: "Set step goal"    
    \* Font: Mandrel Ext Extra-bold    
    \* Size: 20 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Text: "Set step goal"    
    \* Action: Opens a form to set step goal    
    \* Padding: 12 dp vertical, 24 dp horizontal    
    \* Margin: 24 dp top  
      
\- Routing:  
    

\- This view is accessible from the Census section.  
    

\#\#\# 42\. Bill of Results \- Detailed Analytics Reports View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Analytics"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Comprehensive data dashboard  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Customizable time period selector  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Component: Date range picker  
    

\- Report categories:  
    

\- Layout: Horizontal list  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
      
\- Categories:  
    

\- Weight/body composition  
      
\- Workout performance  
      
\- Nutrition adherence  
      
\- Sleep quality  
      
\- Recovery metrics  
    

\- Export and share options  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9    
    \* Layout: Horizontal list  
    

\- Filters:  
    

\- Metric selection  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Date range  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Comparison tools  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Routing:  
    

\- This view is accessible from the Census section.  
    

\#\# X. Additional Features

\#\#\# 43\. Subscription Tier View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Membership"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Tier comparison cards:  
    

\- Layout: Horizontal scrolling list  
      
\- Card width: 320 dp  
      
\- Card height: 400 dp  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Tier name  
    

\- Font: Mandrel Ext Extra-bold  
    

\- Size: 20 dp  
      
\- Color: \#FFFFFF  
    

\- Features  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#DAE1E9  
      
\- Layout: Vertical list  
    

\- Price  
    

\- Font: Mandrel Ext Extra-bold  
    

\- Size: 18 dp  
      
\- Color: \#96854A  
    

\- Current tier indicator  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- Pricing information  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Special offers  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#96854A  
    

\- Action Buttons:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- Upgrade options (deep red, blue glow)  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 20 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Text: "Upgrade"  
      
\- Action: Navigates to a subscription upgrade flow  
      
\- Padding: 12 dp vertical, 24 dp horizontal  
    

\- Routing:  
    

\- This view is accessible from user settings or profile.  
    

\#\#\# 44\. Shopping \- Branded and Affiliates View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Category tabs  
    

\- Layout: Horizontal list  
      
\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#DAE1E9  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Search bar with gold border  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#DAE1E9    
    \* Background: \#171717    
    \* Border: 2 dp solid \#96854A (Gold)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp    
    \* Placeholder: "Search Products"  
    

\- Product cards  
    

\- Layout: Vertical list  
      
\- Card width: 100%  
      
\- Card height: 320  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Product image  
    

\- Size: 100% width, 60% height  
      
\- Content Fit: Cover  
      
\- Border Radius: 8 dp (top corners)  
    

\- Name and description  
    

\- Font: Poppins, Regular  
    

\- Size: 14 dp  
      
\- Color: \#FFFFFF  
    

\- Price in gold text  
    

\- Font: Mandrel Ext Extra-bold  
    

\- Size: 18 dp  
      
\- Color: \#96854A  
    

\- "Add to Cart" button (green)  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#4CAF50 (Green)  
      
\- Border Radius: 8 dp  
      
\- Text: "Add to Cart"  
      
\- Padding: 12 dp  
    

\- Category filters  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9    
    \* Layout: Horizontal list  
    

\- Featured products section  
    

\- Title:  
    

\- Text: "Featured Products"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Layout: Horizontal scrolling list  
      
\- Spacing: 16 dp  
    

\- Navigation:  
    

\- Shopping cart icon with item count  
    

\- Icon: \[Shopping cart icon\]  
      
\- Color: \#FFFFFF  
      
\- Badge with item count  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 16dp  
      
\- Padding: 4dp  
    

\- Routing:  
    

\- This view is accessible from the main navigation  
    

\#\#\# 45\. Checkout Cart View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Your Cart"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Cart item list  
    

\- Layout: Vertical list  
      
\- Each item  
    

\- Product thumbnails  
    

\- Size: 80 dp x 80 dp  
      
\- Shape: Rounded rectangle  
      
\- Content Fit: Cover  
      
\- Border Radius: 8 dp  
    

\- Names and prices  
    

\- Font: Poppins, Regular  
    

\- Size: 16 dp (name), 14 dp (price)  
      
\- Color: \#FFFFFF (name), \#96854A(price)  
    

\- Quantity controls  
    

\- Layout: Horizontal list  
      
\- Font: Mandrel Ext Extra-bold  
    

\- Size: 20 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 16dp  
      
\- Padding: 4dp  
    

\- Remove option  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Order summary  
    

\- Title:  
    

\- Text: "Order Summary"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Promo code field  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#DAE1E9    
    \* Background: \#171717    
    \* Border: 2 dp solid \#96854A (Gold)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp    
    \* Placeholder: "Enter Promo Code"  
    

\- Shipping options  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Action Button: "Checkout"    
    \* Font: Mandrel Ext Extra-bold    
    \* Size: 20 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Glow: Blue glow effect (box-shadow)    
    \* Text: "Checkout"    
    \* Action: Navigates to checkout process    
    \* Padding: 12 dp vertical, 24 dp horizontal    
    \* Margin: 24 dp top  
      
\- Routing:  
    

\- This view is accessible from the Shopping View  
    

\#\#\# 46\. About Us View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "About 4-Score"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Brand story with patriotic theme  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- F.O.U.R. philosophy explanation  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Team/founders section  
    

\- Title:  
    

\- Text: "Our Team"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF    
    \* Layout: Horizontal scrolling list    
    \* Card Width: 200 dp    
    \* Card Height: 240 dp    
    \* Spacing: 16 dp  
    

\- Mission and values  
    

\- Title:  
    

\- Text: "Mission & Values"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Testimonials from users  
    

\- Title:  
    

\- Text: "Testimonials"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9    
    \* Layout: Horizontal scrolling list    
    \* Card Width: 320 dp    
    \* Card Height: 160 dp    
    \* Spacing: 16 dp  
    

\- Contact information  
    

\- Title:  
    

\- Text: "Contact Us"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Routing:  
    

\- This view is accessible from the main navigation or footer  
    

\#\#\# 47\. Calendar View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Calendar"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Month/week/day view options  
    

\- Layout: Horizontal list  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Events color-coded by type:  
    

\- Component: Custom calendar component  
      
\- Dimensions: 100% width, 300 dp height  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \# DAE1E9  
      
\- Workouts (deep red)  
      
\- Meals (navy blue)  
      
\- Challenges (gold)  
      
\- Recovery (green)  
    

\- Add event button  
    

\- Type: Floating button  
      
\- Icon: "+"  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 32 dp  
      
\- Action: Opens a modal or navigates to an event creation flow.  
      
\- Position: Bottom right  
      
\- Padding: 12 dp  
    

\- Day detail panel showing scheduled activities  
    

\- Title:  
    

\- Text: "Event Details"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Routing:  
    

\- This view is accessible from the main navigation  
    

\#\#\# 48\. Events View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Events"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Upcoming events list  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Event cards  
    

\- Layout: Vertical list  
      
\- Card width: 100%  
      
\- Card height: 160 dp  
      
\- Spacing: 16 dp  
      
\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Event name and type  
    

\- Font: Poppins, Semi-Bold  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
    

\- Date, time, location  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Participation info  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- "Join" button  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp  
    

\- Event categories  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9    
    \* Layout: Horizontal list  
    

\- Create event option (for eligible users)  
    

\- Font: Mandrel Ext Extra-bold    
    \* Size: 16 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible from the main navigation or calendar view  
    

\#\#\# 49\. Swolemate Chatbot View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Swolemate"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Chat interface  
    

\- Height: 60% of screen  
      
\- Message bubbles:  
    

\- AI messages  
    

\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#5D2121  
      
\- Border Radius: 8 dp (top left, top right, bottom left)  
      
\- Padding: 12 dp  
    

\- User messages  
    

\- Font: Poppins, Regular  
    

\- Size: 16 dp  
      
\- Color: \#FFFFFF  
      
\- Background: \#520606  
      
\- Border Radius: 8 dp (top left, top right, bottom right)  
      
\- Padding: 12 dp  
    

\- Typing indicator  
    

\- Font: Poppins, Regular  
    

\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Quick reply suggestions  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF    
    \* Layout: Horizontal list    
    \* Spacing: 8dp  
    

\- Contextual recommendations  
    

\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Fitness question suggestions  
    

\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Input:  
    

\- Message field with send button  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#DAE1E9    
    \* Background: \#171717    
    \* Border: 2 dp solid \#96854A (Gold)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp    
    \* Placeholder: "Type your message..."  
      
\- Send button  
    

\- Icon: \[Send icon\]  
      
\- Color: \#FFFFFF  
      
\- Glow: Blue glow effect  
      
\- Action: Sends the message.  
      
\- Padding: 8dp  
      
\- Border Radius: 8dp  
      
\- Background: \#5D2121  
    

\- Persistent:  
    

\- Minimized chatbot button on all app screens  
      
\- Type: Floating button  
    

\- Position: Bottom right corner  
      
\- Size: 64 dp  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 32 dp  
      
\- Icon: \[Swolemate logo\]  
      
\- Icon size: 32 dp  
      
\- Glow: Blue glow effect (box-shadow)  
      
\- Action: Opens Swolemate Chatbot View (modal or full screen)  
    

\- Routing:  
    

\- This view is accessible from a button  
    

\#\#\# 50\. The Apparatus \- Camera View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Camera"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Camera viewfinder  
    

\- Full screen  
    

\- Capture controls  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- Icons for capture  
    

\- Mode selection  
    

\- Layout: Horizontal list  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
      
\- Options:  
    

\- Photo  
      
\- Video  
      
\- Form check  
      
\- Progress pic  
    

\- Gallery access  
    

\- Button to open device gallery  
      
\- Font: Mandrel Ext Extra-bold    
    \* Size: 16 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Padding: 12 dp  
    

\- Sharing options  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- Icons for sharing  
    

\- Routing:  
    

\- This view is accessible from within other views  
    

\#\#\# 51\. Pioneers \- Coaches Feature View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Pioneers"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Featured coaches carousel  
    

\- Layout: Horizontal scrolling list  
      
\- Card Width: 320 dp  
      
\- Card Height: 400 dp  
      
\- Spacing: 16 dp  
    

\- Coach specialty categories  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF    
    \* Layout: Horizontal list  
    

\- Coach cards  
    

\- Each card:  
    

\- Card style  
    

\- Background: \#171717  
      
\- Border Radius: 8dp  
    

\- Profile photo  
    

\- Shape: Circular  
      
\- Size: 80 dp  
    

\- Name and credentials  
    

\- Font: Poppins, Semi-Bold (name)  
      
\- Size: 16 dp (name), 12 dp(credentials)  
      
\- Color: \#FFFFFF (name), \#DAE1E9 (credentials)  
    

\- Specialty areas  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
    

\- Rating and reviews  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
      
\- Stars: \[Star icons\]  
    

\- "View Profile" button  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp  
    

\- Matching service for finding ideal coach  
    

\- Button  
      
\- Font: Mandrel Ext Extra-bold    
    \* Size: 16 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Text: "Find a Coach"    
    \* Action: Navigates to a coach matching flow    
    \* Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible from the main navigation  
    

\#\#\# 52\. Pioneers \- Coach Profile View

\- Header:  
    

\- Coach name with profile image  
    

\- Font: Mandrel Ext Extra-bold    
    \* Size: 24 dp    
    \* Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Bio and credentials  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp (bio), 12 dp (credentials)    
    \* Color: \#DAE1E9 (bio), \#96854A (credentials)  
    

\- Specialty areas  
    

\- Title:  
    

\- Text: "Specialties"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9    
    \* Layout: Horizontal list  
    

\- Training philosophy  
    

\- Title:  
    

\- Text: "Philosophy"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Client testimonials  
    

\- Title:  
    

\- Text: "Testimonials"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9    
    \* Layout: Horizontal scrolling list    
    \* Card Width: 320 dp    
    \* Card Height: 160 dp    
    \* Spacing: 16 dp  
    

\- Available services and pricing  
    

\- Title:  
    

\- Text: "Services & Pricing"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9    
    \* Layout: Vertical list  
    

\- Training packages  
    

\- Title:  
    

\- Text: "Packages"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9    
    \* Layout: Horizontal scrolling list    
    \* Card Width: 320 dp    
    \* Card Height: 160 dp    
    \* Spacing: 16 dp  
    

\- Action Buttons:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- "Book Session"  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "Book Session"  
      
\- Action: Navigates to Pioneers \- Coach Payment/Checkout View  
      
\- Padding: 12 dp  
    

\- "Message"  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#520606 (Navy Blue)  
      
\- Border Radius: 8 dp  
      
\- Text: "Message"  
      
\- Action: Opens Pony Express \- Message Conversation View with the coach  
      
\- Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible from Pioneers \- Coaches Feature View  
    

\#\#\# 53\. Pioneers \- Coach Payment/Checkout View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Booking"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Selected service details  
    

\- Font: Poppins, Regular    
    \* Size: 16 dp    
    \* Color: \#FFFFFF  
    

\- Coach information  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Pricing breakdown  
    

\- Title:  
    

\- Text: "Price Details"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Payment method selection  
    

\- Title:  
    

\- Text: "Payment"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9    
    \* Component: Payment method selector  
    

\- Booking date/time selection  
    

\- Title:  
    

\- Text: "Schedule"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 18 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9    
    \* Component: Date/time picker  
    

\- Terms acceptance  
    

\- Label:  
    

\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \#DAE1E9  
      
\- Text: "I agree to the Terms of Service"  
    

\- Links:  
    

\- Terms of Service:  
    

\- Font: Poppins, Semi-Bold  
      
\- Color: \#96854A  
      
\- Action: Opens Terms of Service in a webview  
    

\- Style: Custom checkbox with gold checkmark  
      
\- Margin: 16 dp  
    

\- Action Button: "Complete Booking"    
    \* Font: Mandrel Ext Extra-bold    
    \* Size: 20 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Glow: Blue glow effect (box-shadow)    
    \* Text: "Complete Booking"    
    \* Action: Completes the booking and navigates to a confirmation screen    
    \* Padding: 12 dp vertical, 24 dp horizontal    
    \* Margin: 24 dp top  
      
\- Routing:  
    

\- This view is accessible from Pioneers \- Coach Profile View  
    

\#\#\# 54\. Pioneers \- Coach Live Video Chat View

\- Header:  
    

\- Coach name with session timer  
    

\- Font: Mandrel Ext Extra-bold    
    \* Size: 20 dp    
    \* Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Video feed (coach and user)  
    

\- Component: Video chat component  
      
\- Layout: Split screen  
    

\- Audio controls  
    

\- Mute/Unmute  
      
\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Chat sidebar for notes/links  
    

\- Component: Chat component  
      
\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Screen sharing option  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Form check tools  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF    
    \* Layout: Horizontal list  
    

\- Session recording option  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#FFFFFF  
    

\- Action Buttons:  
    

\- Layout: Horizontal list, centered  
      
\- Spacing: 16 dp  
      
\- End call  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#5D2121 (Deep Red)  
      
\- Border Radius: 8 dp  
      
\- Text: "End Call"  
      
\- Action: Ends the call  
      
\- Padding: 12 dp  
    

\- Mute, camera toggle  
    

\- Font: Mandrel Ext Extra-bold  
      
\- Size: 16 dp  
      
\- Color: \#FFFFFF (White)  
      
\- Background: \#520606 (Navy Blue)  
      
\- Border Radius: 8 dp  
      
\- Padding: 12 dp  
    

\- Routing:  
    

\- This view is accessible from Pioneers \- Coach Profile View upon starting a session  
    

\#\#\# 55\. Pioneers \- Schedule/Calendar View

\- Header:  
    

\- Navy blue banner:  
    

\- Color: \#520606 (solid fill)  
      
\- Height: 80 dp  
    

\- Title:  
    

\- Text: "Coaching Schedule"  
      
\- Font: Mandrel Ext Extra-bold  
      
\- Size: 24 dp  
      
\- Color: \#FFFFFF (White)  
    

\- Content:  
    

\- Layout: Vertical list  
      
\- Spacing: 24 dp  
      
\- Calendar with booked sessions  
    

\- Component: Custom calendar component  
      
\- Dimensions: 100% width, 300 dp height  
      
\- Font: Poppins, Regular  
      
\- Size: 12 dp  
      
\- Color: \# DAE1E9  
    

\- Available time slots  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Coach availability indicator  
    

\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Session type indicators  
    

\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Upcoming session reminders  
    

\- Font: Poppins, Regular    
    \* Size: 12 dp    
    \* Color: \#DAE1E9  
    

\- Reschedule tools  
    

\- Font: Poppins, Regular    
    \* Size: 14 dp    
    \* Color: \#DAE1E9  
    

\- Action Button: "Book New Session"    
    \* Font: Mandrel Ext Extra-bold    
    \* Size: 20 dp    
    \* Color: \#FFFFFF (White)    
    \* Background: \#5D2121 (Deep Red)    
    \* Border Radius: 8 dp    
    \* Text: "Book New Session"    
    \* Action: Opens Pioneers \- Coach Profile View    
    \* Padding: 12 dp vertical, 24 dp horizontal    
    \* Margin: 24 dp top  
      
\- Routing:  
    

\- This view is accessible from the Pioneers section.  
    

Each view consistently maintains the brand elements:

\- Dark theme (\#171717) background  
      
\- Navy blue (\#520606) and deep red (\#5D2121) primary colors  
      
\- Dirty/worn white (\#DAE1E9) text  
      
\- Metallic gold/brass (\#96854A) accents and borders  
      
\- Presidential seal as subtle background on banners  
      
\- Blue glow effect on primary action buttons  
      
\- F.O.U.R. framework consistently represented in navigation and organization  
    

    
\*\*  
