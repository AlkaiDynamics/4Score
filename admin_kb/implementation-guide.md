# 4-Score Fitness: Implementation Guide

## Converting Existing Documents

This guide provides step-by-step instructions for implementing the Code Descriptor system across your 4-Score fitness app documentation.

## 1. Wireframe Conversion Process

### Step 1: Identify Component Blocks
Review each wireframe section and identify distinct UI components like headlines, buttons, and input fields.

### Step 2: Map Properties
For each component, map the existing properties to Code Descriptor attributes:
- Text content → `text` attribute
- Font family → `font` attribute
- Font size → `size` attribute
- Colors → `color` and `background` attributes
- Spacing → `margin` and `padding` attributes

### Step 3: Define Layout Structure
Identify how components relate to each other and wrap them in appropriate `<Layout>` tags.

### Step 4: Add Interactions
Add `<Action>` tags for buttons and interactive elements.

### Step 5: Connect Data
Add `<DataBinding>` tags where dynamic content will be displayed.

## 2. Example Conversions

### Landing Page Hero Section

#### Original Format:
```
Landing Page:
- Header:
  - Logo:
    - Image: 4-Score Logo
    - Size: 48 dp x 48 dp
    - Position: Top-left
  - Sign In Button:
    - Text: "Sign In"
    - Font: Poppins, SemiBold
    - Size: 14 dp
    - Color: #FFFFFF (White)
    - Background: #520606 (Deep Red)
    - Position: Top-right
    - Padding: 8 dp horizontal, 6 dp vertical
```

#### Code Descriptor Format:
```xml
<Layout type="Row" justify="space-between" align="center" padding="16 16 16 16">
  <Component type="Image" source="4ScoreLogo" width="48" height="48" />
  
  <Component
    type="Button"
    text="Sign In"
    font="Poppins"
    weight="SemiBold"
    size="14"
    color="#FFFFFF"
    background="#520606"
    padding="6 8 6 8"
    onPress="<Action type='Navigation' target='SignInView' />"
    testID="signInButton"
  />
</Layout>
```

### User Profile Schema

#### Original Format:
```
User:
- userId: string (primary key)
- username: string
- email: string
- profilePicture: string (URL)
- dateJoined: timestamp
- bio: string
- fitnessGoals: array of strings
- metrics: object
  - height: number
  - weight: number
  - age: number
- Relationships:
  - One-to-many with workouts
  - One-to-many with achievements
```

#### Code Descriptor Format:
```xml
User:
- userId: <DataType type="string" required="true" />
- username: <DataType type="string" required="true" min="3" max="20" />
- email: <DataType type="string" required="true" pattern="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" />
- profilePicture: <DataType type="string" default="defaultAvatar.png" />
- dateJoined: <DataType type="timestamp" default="serverTimestamp()" />
- bio: <DataType type="string" max="250" />
- fitnessGoals: <DataType type="array" />
- metrics:
  - height: <DataType type="number" min="0" />
  - weight: <DataType type="number" min="0" />
  - age: <DataType type="number" min="13" max="120" />
- Relationships:
  - workouts: <Relationship type="OneToMany" target="Workout" field="userId" cascade="delete" />
  - achievements: <Relationship type="OneToMany" target="Achievement" field="userId" />
```

## 3. Integration with React Native Implementation

When using the Code Descriptor system with AI to generate React Native code, specify the following to ensure consistent implementation:

```
Please implement the following UI using React Native with styled-components. 
Follow the Code Descriptor syntax exactly for component styling and structure:

<Layout type="Container" padding="16 16 16 16" background="#121212">
  <Component 
    type="Headline" 
    text="Today's Workout" 
    font="Mandrel Ext" 
    weight="Bold" 
    size="28" 
    color="#FFFFFF" 
    margin="0 0 24 0" 
  />
  
  <Layout type="List" spacing="16">
    <!-- Exercise components here -->
  </Layout>
</Layout>
```

## 4. File Conversion Priorities

1. **High Priority:**
   - 4-Score Wireframes.md (main UI reference)
   - Schema Structure.txt (for data modeling)

2. **Medium Priority:**
   - Core Entities and Relationships.txt (for backend integration)
   - Any user flow diagrams

3. **Lower Priority:**
   - 4-Score Fitness App - Full Stack List.txt (mostly descriptive)

## 5. DevVibe Interaction Tips

When using the Code Descriptor system with AI assistants:

1. **Clear Introduction:** Start by explaining you're using the Code Descriptor system
   ```
   I'm using a Code Descriptor system for precise UI implementation. Please follow these XML-like tags exactly when generating code.
   ```

2. **Specific Requests:** Frame requests clearly
   ```
   Generate the React Native component for this Login screen:
   <Layout type="Container" padding="24 24 24 24" background="#121212">
     <!-- Components here -->
   </Layout>
   ```

3. **Review Strategy:** Ask for specific checks
   ```
   Please verify that all margins, paddings, and font specifications from the Code Descriptors have been accurately implemented.
   ```

4. **Iteration:** Be specific about changes
   ```
   The button component needs updating. Please change:
   <Component type="Button" background="#520606" />
   To:
   <Component type="Button" background="#8A0B0B" />
   ```

## 6. Integration with Firebase

When instructing AI to connect your UI to Firebase using Code Descriptors:

```xml
<DataBinding source="user.workouts" />
```

Should generate appropriate Firebase code:

```javascript
import { collection, query, where, getDocs } from 'firebase/firestore';

// Generated code to fetch workouts
const workoutsRef = collection(db, "workouts");
const q = query(workoutsRef, where("userId", "==", user.id));
const workoutSnapshots = await getDocs(q);
const workouts = workoutSnapshots.docs.map(doc => ({ id: doc.id, ...doc.data() }));
```

## 7. Testing Guidance

Instruct the AI to include testIDs based on your Code Descriptors:

```
When generating React Native components, please convert the testID attribute from Code Descriptors directly to testID props for easy testing with React Native Testing Library.
```
