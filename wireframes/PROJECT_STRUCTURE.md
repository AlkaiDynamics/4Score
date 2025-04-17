# 4-Score Fitness App - Project Structure

## Directory Organization

Each feature section follows this standard structure:
```
feature_name/
├── feature_view/
│   ├── components/         # Reusable component definitions
│   ├── annotations/        # Detailed component and layout annotations
│   ├── source/            # Source files for wireframes
│   └── feature_mockups/   # Wireframe mockups and previews
```

## Complete Project Structure

```
wireframes/
├── _templates/            # Shared templates and components
│   ├── components/
│   └── example-view/
│
├── core/                  # Core Experience
│   ├── range_homeview/    # The Range (Home)
│   ├── profile_view/      # User Profile
│   ├── settings_view/     # User Settings
│   └── account_view/      # User Account
│
├── forge/                 # Workout Module
│   ├── workout_planner/
│   ├── workout_detail/
│   ├── active_workout/
│   ├── workout_calendar/
│   └── workout_tracker/
│
├── optimize/              # Nutrition Module
│   ├── nutrition_planning/
│   ├── nutrition_calendar/
│   ├── instacart_ordering/
│   ├── nutrition_supplement/
│   └── nutrition_tracker/
│
├── unite/                 # Social Module
│   ├── social_hub/
│   ├── social_calendar/
│   ├── pony_express/
│   └── community/
│
├── recover/               # Rest & Recovery Module
│   ├── sleep_tracker/
│   ├── sleep_log/
│   ├── sleep_timer/
│   └── sleep_schedule/
│
├── liberty-bells/         # Timers Collection
│   └── timer_collection/
│
├── frontier/              # Challenges
│   └── challenges/
│
├── census/               # Analytics
│   └── analytics/
│
├── apparatus/            # Form Check
│   └── form_check/
│
├── pioneers/             # Coaching Platform
│   └── coaching/
│
├── auth/                 # Authentication
│   ├── landing/
│   ├── signin/
│   ├── signup/
│   ├── reset_password/
│   └── signout/
│
├── shopping/             # E-commerce
│   ├── subscription_tiers/
│   ├── store/
│   └── checkout/
│
└── additional/           # Additional Features
    ├── about/
    ├── calendar/
    ├── events/
    └── swolemate/
```

## File Structure Within Each View

Each view directory contains:

### components/
- `specific-components.md`: View-specific component definitions
- Additional component documentation

### annotations/
- `view-annotations.md`: Detailed layout and interaction specifications
- State diagrams and flow documentation

### source/
- Source files for wireframe creation
- Asset source files

### feature_mockups/
- Desktop view (1440x900)
- Tablet view (768x1024)
- Mobile view (375x812)
- Image specifications
- Preview documentation

## Shared Resources

### _templates/
- Common components
- Layout patterns
- Design system elements
- Example implementations

## Design System Integration

All views implement:

1. Typography System
   - Mandrel Ext (headers)
   - Poppins (body)

2. Color Palette
   - Primary: #520606 (Navy Blue)
   - Secondary: #5D2121 (Deep Red)
   - Accent: #96854A (Metallic Gold)
   - Background: #171717
   - Text: #DAE1E9

3. Common Elements
   - Presidential seal watermark
   - Navigation patterns
   - Card layouts
   - Form elements

## Development Guidelines

1. Always follow the Code Descriptor System
2. Maintain consistent naming conventions
3. Document all component variations
4. Include responsive design specifications
5. Keep mockups in sync with annotations
