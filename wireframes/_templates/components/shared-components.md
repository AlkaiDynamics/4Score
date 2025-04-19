# Shared Components Library

## Typography Components

### Headlines
```xml
<Component 
  type="Headline" 
  font="Mandrel Ext"
  weight="Extra-bold"
  size="36"
  color="#DAE1E9"
  align="center"
/>
```

### Body Text
```xml
<Component 
  type="Body"
  font="Poppins"
  weight="Regular"
  size="16"
  color="#DAE1E9"
  align="left"
/>
```

## Interactive Elements

### Primary Button
```xml
<Component
  type="Button"
  text="[Button Text]"
  font="Poppins"
  weight="SemiBold"
  size="16"
  color="#FFFFFF"
  background="#520606"
  align="center"
  padding="12 24"
  onPress="[Action]"
/>
```

### Secondary Button
```xml
<Component
  type="Button"
  text="[Button Text]"
  font="Poppins"
  weight="SemiBold"
  size="16"
  color="#96854A"
  background="transparent"
  border="2px solid #96854A"
  align="center"
  padding="12 24"
  onPress="[Action]"
/>
```

### Input Field
```xml
<Component
  type="Input"
  placeholder="[Placeholder Text]"
  font="Poppins"
  size="16"
  color="#DAE1E9"
  background="#171717"
  border="2px solid #96854A"
  padding="12 16"
/>
```

## Layout Components

### Card Container
```xml
<Layout
  type="Card"
  background="#171717"
  border="1px solid #96854A"
  borderRadius="8"
  padding="16"
  margin="8"
>
  [Child Components]
</Layout>
```

### Navigation Bar
```xml
<Layout
  type="Navigation"
  background="#520606"
  padding="16 24"
  align="center"
  justify="space-between"
>
  [Navigation Items]
</Layout>
```

### Grid Layout
```xml
<Layout
  type="Grid"
  columns="2"
  gap="16"
  padding="16"
  background="#171717"
>
  [Grid Items]
</Layout>
```

## Data Display

### Progress Bar
```xml
<Component
  type="Progress"
  value="[0-100]"
  height="8"
  background="#171717"
  fillColor="#5D2121"
  borderRadius="4"
/>
```

### Stats Card
```xml
<Layout
  type="Card"
  background="#171717"
  padding="16"
  margin="8"
>
  <Component type="Title" text="[Stat Name]" size="18" color="#96854A" />
  <Component type="Headline" text="[Value]" size="24" color="#DAE1E9" />
  <Component type="Caption" text="[Description]" size="14" color="#DAE1E9" />
</Layout>
```

### Timer Display
```xml
<Component
  type="Timer"
  font="Mandrel Ext"
  size="48"
  color="#DAE1E9"
  align="center"
  background="#171717"
  padding="24"
/>
```

## Icons & Images

### Presidential Seal
```xml
<Component
  type="Image"
  source="presidential-seal.png"
  opacity="0.15"
  size="64"
  position="absolute"
/>
```

### Navigation Icon
```xml
<Component
  type="Icon"
  name="[icon-name]"
  size="24"
  color="#96854A"
/>
```

## Common Patterns

### Form Group
```xml
<Layout
  type="FormGroup"
  direction="column"
  spacing="16"
  margin="0 0 24 0"
>
  <Component type="Label" text="[Label Text]" />
  <Component type="Input" />
  <Component type="Caption" text="[Helper Text]" color="#96854A" />
</Layout>
```

### Action Bar
```xml
<Layout
  type="ActionBar"
  direction="row"
  justify="space-between"
  align="center"
  padding="16"
  background="#171717"
>
  [Action Buttons]
</Layout>
```
