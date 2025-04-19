# 4-Score Fitness App - Project Structure

## Root Directory Structure

```
4score_fit/
├── .git/                  # Git repository
├── .gitignore            # Git ignore rules
├── .windsurfrules        # Windsurf deployment rules
├── LICENSE               # Project license
├── README.md            # Project overview
├── admin_kb/            # Administrative knowledge base
│   └── dev intruct/     # Development instructions
├── assets/              # Application assets
│   ├── icons/          # Application icons
│   ├── images/         # Image resources
│   ├── logos/          # Logo variations
│   └── mockups/        # Design mockups
├── docs/               # Project documentation
│   ├── api/           # API documentation
│   ├── guides/        # User guides
│   └── technical/     # Technical documentation
├── public/             # Public static files
│   ├── favicon/       # Favicon files
│   ├── fonts/         # Web fonts
│   └── static/        # Other static assets
├── src/               # Source code
│   ├── components/    # React components
│   ├── hooks/        # Custom React hooks
│   ├── pages/        # Page components
│   ├── styles/       # Global styles
│   └── utils/        # Utility functions
├── tests/             # Test files
│   ├── unit/         # Unit tests
│   ├── integration/  # Integration tests
│   └── e2e/          # End-to-end tests
└── wireframes/        # Wireframe designs
    ├── _templates/    # Shared templates
    ├── core/         # Core experience
    ├── forge/        # Workout module
    ├── optimize/     # Nutrition module
    ├── unite/        # Social module
    ├── recover/      # Recovery module
    └── [other modules as previously defined]
```

## Key Directories

### /src
Contains the actual application source code, organized by feature and functionality.

### /wireframes
Contains all wireframe designs and documentation, organized by feature modules.

### /assets
Contains application assets like images, icons, and other media files.

### /docs
Contains project documentation, including technical docs and user guides.

### /public
Contains static files served directly to clients.

### /tests
Contains all test files, organized by test type.

## Development Guidelines

1. Keep source code in `/src`
2. Store all design files in `/wireframes`
3. Place static assets in `/public`
4. Document features in `/docs`
5. Maintain tests in `/tests`
6. Keep application assets in `/assets`

## Module Organization

Each feature module follows a standard structure:
```
module_name/
├── components/     # Module-specific components
├── hooks/         # Custom hooks
├── utils/         # Utility functions
├── types/         # TypeScript types
└── tests/         # Module tests
```

## Asset Organization

Assets are organized by type and feature:
```
assets/
├── icons/         # UI icons
├── images/        # Content images
├── logos/         # Brand logos
└── mockups/       # Design mockups
```

## Documentation Structure

Documentation is organized by purpose:
```
docs/
├── api/           # API documentation
├── guides/        # User guides
└── technical/     # Technical documentation
```
