# The Range - Specific Components

## Quick Stats Card
```xml
<Component type="StatsCard">
  <DataBinding
    source="userStats"
    format="percentage"
    default="0"
  />
  <Layout type="Card" background="#171717" padding="16">
    <Component 
      type="Title" 
      text="[Stat Name]"
      size="18"
      color="#96854A"
    />
    <Component 
      type="Value"
      text="[Stat Value]"
      size="36"
      color="#DAE1E9"
    />
    <Component 
      type="Progress"
      value="[0-100]"
      height="4"
      background="#520606"
    />
  </Layout>
</Component>
```

## F.O.U.R. Framework Card
```xml
<Component type="FourCard">
  <DataBinding
    source="fourMetrics"
    field="[forge|optimize|unite|recover]"
  />
  <Layout 
    type="Card"
    background="#171717"
    padding="16"
    onPress="<Action type='Navigation' target='[Section]View' />"
  >
    <Layout type="Row" justify="space-between">
      <Component 
        type="Title"
        text="[Section Name]"
        color="#96854A"
      />
      <Component 
        type="Icon"
        name="[section-icon]"
        color="#96854A"
      />
    </Layout>
    <Component 
      type="Body"
      text="[Status Text]"
      color="#DAE1E9"
    />
    <Component 
      type="Progress"
      value="[0-100]"
      height="4"
    />
  </Layout>
</Component>
```

## Blog Preview Card
```xml
<Component type="BlogCard">
  <DataBinding
    source="featuredBlogs"
    limit="3"
  />
  <Layout 
    type="Card"
    width="280"
    margin="0 8 0 0"
    onPress="<Action type='Navigation' target='BlogDetail' params='{id}' />"
  >
    <Component 
      type="Image"
      source="[blog-image]"
      height="160"
      fit="cover"
    />
    <Layout type="Content" padding="16">
      <Component 
        type="Title"
        text="[Blog Title]"
        size="18"
        lines="2"
      />
      <Component 
        type="Body"
        text="[Preview Text]"
        size="14"
        lines="3"
      />
      <Layout type="Row" margin="8 0 0 0">
        <Component 
          type="Caption"
          text="[Read Time]"
          color="#96854A"
        />
        <Component 
          type="Icon"
          name="arrow-right"
          color="#96854A"
        />
      </Layout>
    </Layout>
  </Layout>
</Component>
```

## Schedule Item
```xml
<Component type="ScheduleItem">
  <DataBinding
    source="dailySchedule"
    sort="startTime"
  />
  <Layout type="ListItem" padding="12">
    <Layout type="Row" justify="space-between">
      <Layout type="Column">
        <Component 
          type="Body"
          text="[Time] - [Activity]"
          weight="SemiBold"
        />
        <Component 
          type="Caption"
          text="[Category]"
          color="#96854A"
        />
      </Layout>
      <Component 
        type="Icon"
        name="[category-icon]"
        color="#96854A"
      />
    </Layout>
  </Layout>
</Component>
```

## Bottom Navigation Item
```xml
<Component type="NavItem">
  <Layout 
    type="Column"
    align="center"
    padding="8 16"
    onPress="<Action type='Navigation' target='[Screen]' />"
  >
    <Component 
      type="Icon"
      name="[icon-name]"
      size="24"
      color="{active ? '#96854A' : '#DAE1E9'}"
    />
    <Component 
      type="Caption"
      text="[Label]"
      size="12"
      color="{active ? '#96854A' : '#DAE1E9'}"
    />
  </Layout>
</Component>
```

## Loading States

### Stats Card Skeleton
```xml
<Layout type="Card" background="#171717" padding="16">
  <Component 
    type="Skeleton"
    width="80"
    height="18"
    margin="0 0 8 0"
  />
  <Component 
    type="Skeleton"
    width="120"
    height="36"
  />
</Layout>
```

### F.O.U.R. Card Skeleton
```xml
<Layout type="Card" background="#171717" padding="16">
  <Layout type="Row" justify="space-between">
    <Component 
      type="Skeleton"
      width="100"
      height="24"
    />
    <Component 
      type="Skeleton"
      width="24"
      height="24"
      borderRadius="12"
    />
  </Layout>
  <Component 
    type="Skeleton"
    width="160"
    height="16"
    margin="8 0"
  />
</Layout>
```
