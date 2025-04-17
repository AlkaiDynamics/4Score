# The Range (Home View) Annotations

## Layout Structure

### Header Section
```xml
<Layout type="Header" background="#520606" padding="16">
  <Component 
    type="Image"
    source="presidential-seal.png"
    position="absolute"
    opacity="0.15"
  />
  <Component
    type="Title"
    text="The Range"
    font="Mandrel Ext"
    weight="Extra-bold"
    size="24"
    color="#DAE1E9"
    align="center"
  />
</Layout>
```

### Quick Stats Dashboard
```xml
<Layout type="Grid" columns="2" gap="16" padding="16">
  <Layout type="Card">
    <Component type="Title" text="Today's Progress" size="18" color="#96854A" />
    <Component type="Headline" text="75%" size="36" color="#DAE1E9" />
    <Component type="Progress" value="75" />
  </Layout>
  <Layout type="Card">
    <Component type="Title" text="Streak" size="18" color="#96854A" />
    <Component type="Headline" text="7 Days" size="36" color="#DAE1E9" />
    <Component type="Icon" name="fire" color="#5D2121" />
  </Layout>
</Layout>
```

### F.O.U.R. Framework Grid
```xml
<Layout type="Grid" columns="2" gap="16" padding="16">
  <!-- Forge Section -->
  <Layout 
    type="Card" 
    background="#171717" 
    onPress="<Action type='Navigation' target='ForgeView' />"
  >
    <Component type="Title" text="Forge" color="#96854A" />
    <Component type="Body" text="Next Workout in 2h" />
    <Component type="Icon" name="dumbbell" />
  </Layout>
  
  <!-- Optimize Section -->
  <Layout 
    type="Card" 
    background="#171717"
    onPress="<Action type='Navigation' target='OptimizeView' />"
  >
    <Component type="Title" text="Optimize" color="#96854A" />
    <Component type="Body" text="Meal Plan Ready" />
    <Component type="Icon" name="nutrition" />
  </Layout>
  
  <!-- Unite Section -->
  <Layout 
    type="Card" 
    background="#171717"
    onPress="<Action type='Navigation' target='UniteView' />"
  >
    <Component type="Title" text="Unite" color="#96854A" />
    <Component type="Body" text="3 New Messages" />
    <Component type="Icon" name="community" />
  </Layout>
  
  <!-- Recover Section -->
  <Layout 
    type="Card" 
    background="#171717"
    onPress="<Action type='Navigation' target='RecoverView' />"
  >
    <Component type="Title" text="Recover" color="#96854A" />
    <Component type="Body" text="Sleep Score: 85" />
    <Component type="Icon" name="moon" />
  </Layout>
</Layout>
```

### Featured Blog Articles
```xml
<Layout type="ScrollView" horizontal={true} padding="16">
  <Layout type="Card" width="280" margin="0 8 0 0">
    <Component type="Image" source="blog1.jpg" height="160" />
    <Component type="Title" text="Mastering the F.O.U.R. System" />
    <Component type="Body" text="Learn how to optimize your fitness journey..." />
  </Layout>
  <!-- More blog cards... -->
</Layout>
```

### Calendar Widget
```xml
<Layout type="Card" padding="16" margin="16">
  <Component type="Title" text="Today's Schedule" color="#96854A" />
  <Layout type="List">
    <Layout type="ListItem">
      <Component type="Body" text="6:00 AM - Morning Workout" />
      <Component type="Caption" text="Forge Session" color="#5D2121" />
    </Layout>
    <!-- More schedule items... -->
  </Layout>
</Layout>
```

### Bottom Navigation
```xml
<Layout 
  type="Navigation" 
  position="fixed" 
  bottom="0" 
  background="#520606"
>
  <Component type="Icon" name="home" color="#96854A" />
  <Component type="Icon" name="profile" />
  <Component type="Icon" name="discover" />
  <Component type="Icon" name="settings" />
</Layout>
```

## States & Interactions

### Loading State
- Show skeleton loading for cards
- Maintain layout structure
- Progressive loading of images

### Error States
- Connection error message
- Retry button
- Fallback content

### Navigation
- Tap animations on cards (scale: 0.98)
- Smooth transitions between views
- Bottom tab highlight effects

## Responsive Behavior

### Desktop (>1024px)
- 4-column grid for F.O.U.R. sections
- Side-by-side layout for blog and calendar
- Larger touch targets

### Tablet (768px - 1024px)
- 2-column grid layout
- Scrollable blog section
- Condensed calendar view

### Mobile (<768px)
- Single column for stats
- 2x2 grid for F.O.U.R. sections
- Full-width cards
- Sticky bottom navigation

## Accessibility

- Minimum touch target size: 44x44px
- High contrast text
- Clear visual hierarchy
- Screen reader support
- Keyboard navigation support

## Performance Considerations

- Lazy load images
- Virtualized lists for long content
- Cached data for quick loading
- Optimized animations
- Preload critical assets
