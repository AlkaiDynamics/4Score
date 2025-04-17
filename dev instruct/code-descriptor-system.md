# 4-Score Fitness: DevVibe Code Descriptor System

## Overview

This system provides structured tags to complement natural language instructions when working with AI coding assistants. These descriptors create unambiguous, machine-readable instructions that lead to more consistent and accurate code generation.

## Core Descriptor Types

### Components

```xml
<Component 
  type="[ComponentType]"
  text="[Content]"
  font="[FontFamily]"
  weight="[FontWeight]"
  size="[FontSize]"
  color="[TextColor]"
  background="[BackgroundColor]"
  align="[TextAlignment]"
  margin="[Top Right Bottom Left]"
  padding="[Top Right Bottom Left]"
  onPress="[Action]"
  testID="[TestIdentifier]"
/>
```

**Component Types:**
- Headline
- Title
- Subtitle
- Body
- Caption
- Button
- Input
- Image
- Icon
- Card
- Toggle
- Checkbox
- RadioButton
- Dropdown
- Tab
- Timer
- Progress

### Layout Structures

```xml
<Layout 
  type="[LayoutType]"
  direction="[Direction]"
  justify="[JustifyContent]"
  align="[AlignItems]"
  spacing="[Gap]"
  padding="[Top Right Bottom Left]"
  margin="[Top Right Bottom Left]"
  background="[Color]"
>
  [Child Components]
</Layout>
```

**Layout Types:**
- Container
- Stack
- Row
- Column
- Grid
- ScrollView
- List
- Section
- TabView
- Modal

### Actions

```xml
<Action 
  type="[ActionType]"
  target="[TargetScreen/Function]"
  params="[Parameters]"
  condition="[Condition]"
/>
```

**Action Types:**
- Navigation
- Submit
- API
- Toggle
- Increment
- Decrement
- StartTimer
- StopTimer
- ShowModal
- HideModal
- SignIn
- SignOut

### Data Binding

```xml
<DataBinding 
  source="[DataSource]"
  format="[FormatFunction]"
  default="[DefaultValue]"
  condition="[DisplayCondition]"
/>
```

### Data Types

```xml
<DataType 
  type="[DataType]"
  required="[true/false]"
  min="[MinValue]"
  max="[MaxValue]"
  pattern="[RegexPattern]"
  default="[DefaultValue]"
/>
```

**Common Data Types:**
- string
- number
- boolean
- date
- array
- object
- enum
- reference

### Relationships

```xml
<Relationship 
  type="[RelationshipType]"
  target="[TargetEntity]"
  field="[FieldName]"
  cascade="[CascadeAction]"
/>
```

**Relationship Types:**
- OneToOne
- OneToMany
- ManyToOne
- ManyToMany

## Implementation Examples

### Original Wireframe Format

```
- Headline:
  - Text: "Achieve Your Peak Fitness with the F.O.U.R. Score System"
  - Font: Mandrel Ext Extra-bold
  - Size: 36 dp
  - Color: #DAE1E9 (Dirty/Worn White)
  - Alignment: Center
  - Margin: 24 dp below the image
```

### Code Descriptor Format

```xml
<Component 
  type="Headline" 
  text="Achieve Your Peak Fitness with the F.O.U.R. Score System" 
  font="Mandrel Ext" 
  weight="Extra-bold" 
  size="36" 
  color="#DAE1E9" 
  align="center" 
  margin="0 0 24 0" 
/>
```

### SignUp Button Example

```xml
<Component
  type="Button"
  text="Sign Up"
  font="Poppins"
  weight="SemiBold"
  size="16"
  color="#FFFFFF"
  background="#520606"
  align="center"
  padding="12 24 12 24"
  margin="16 0 0 0"
  onPress="<Action type='Navigation' target='SignUpView' />"
  testID="signUpButton"
/>
```

### List Layout Example

```xml
<Layout type="List" direction="vertical" spacing="24" padding="16 16 16 16">
  <Component type="Title" text="Workout History" font="Poppins" size="20" color="#FFFFFF" />
  
  <Layout type="Row" justify="space-between" align="center">
    <Component type="Body" text="<DataBinding source='workout.date' format='formatDate' />" />
    <Component type="Body" text="<DataBinding source='workout.duration' format='formatTime' />" />
  </Layout>
</Layout>
```

### Schema Example

```xml
username: <DataType type="string" required="true" min="3" max="20" />
email: <DataType type="string" required="true" pattern="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" />
workouts: <Relationship type="OneToMany" target="Workout" field="userId" cascade="delete" />
```

## Best Practices

1. Use code descriptors for precise UI elements, data structures, and actions
2. Keep natural language for overall flow and complex instructions
3. Be consistent with descriptor usage across similar components
4. Group related components within appropriate Layout descriptors
5. Use descriptive field names for data sources and targets
6. Include testID attributes for important interactive components

## Usage With AI Assistants

When providing instructions to AI coding assistants:

1. Introduce the Code Descriptor system early in your conversation
2. Explicitly mention: "Follow the Code Descriptor syntax for precise implementation"
3. For complex views, provide both descriptors and natural language explanation
4. When reviewing generated code, verify that all descriptors were implemented correctly
