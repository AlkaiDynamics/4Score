# Example View Annotations

## Viewport Specifications
- Desktop: 1440x900
- Tablet: 768x1024
- Mobile: 375x812

## Components & States

### Header
- Default state
- Scrolled state (condensed)
- Mobile menu state

### Navigation
- Default state
- Active state
- Hover state
- Mobile collapsed state

### Interactive Elements
- Buttons
  - Default
  - Hover
  - Active
  - Disabled
- Input Fields
  - Empty
  - Focused
  - Filled
  - Error
  - Success

## Animations & Transitions
1. Page Load
   - Header fade in (0.3s ease-in)
   - Content stagger up (0.5s ease-out)
   - Navigation fade in (0.4s ease-in)

2. State Changes
   - Button hover (0.2s ease)
   - Input focus (0.3s ease)
   - Menu toggle (0.4s ease-in-out)

## Responsive Behavior
### Desktop to Tablet
- Navigation becomes condensed
- Grid changes from 4 to 2 columns
- Sidebar becomes top bar

### Tablet to Mobile
- Navigation becomes bottom bar
- Grid becomes single column
- Header simplifies

## Accessibility Considerations
- Color contrast ratios maintained
- Touch targets minimum 44x44px
- Keyboard navigation support
- Screen reader compatibility

## Performance Notes
- Image lazy loading
- Component lazy loading
- Animation throttling on mobile

## Implementation Notes
- Use system fonts as fallback
- SVG icons preferred
- Progressive enhancement approach
- Mobile-first development
