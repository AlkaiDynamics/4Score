# Wireframe Template Guidelines

## File Format
- Use `.fig` files for Figma designs
- Export to `.png` for previews
- Include mobile and desktop variants

## Naming Convention
```
[section]-[view]-[variant].fig
Example: auth-landing-desktop.fig
```

## Required Files for Each View
1. Source File
   - Editable design file (.fig)
   - All components properly named
   - Using shared styles and components

2. Preview Images
   - Desktop version (.png)
   - Mobile version (.png)
   - Tablet version (if applicable)

3. Components File
   - Reusable components specific to the view
   - Documented states and variants

4. Annotations File
   - Interaction notes
   - Animation specifications
   - Responsive behavior
   - State transitions

## Directory Structure Example
```
view-name/
├── source/
│   └── view-name.fig
├── previews/
│   ├── view-name-desktop.png
│   ├── view-name-mobile.png
│   └── view-name-tablet.png
├── components/
│   └── view-specific-components.fig
└── annotations/
    └── view-name-annotations.md
```

## Required Metadata
Each wireframe should include:
- Viewport dimensions
- Color scheme used
- Typography specifications
- Component states
- Interactive elements
- Responsive breakpoints

## Style Guide Integration
- Use colors from main palette
- Follow typography system
- Maintain consistent spacing
- Use standard component library
- Follow interaction patterns
