declare global {
  namespace NodeJS {
    interface ProcessEnv {
      NODE_ENV: 'development' | 'production' | 'test';
      REACT_APP_API_URL: string;
      REACT_APP_FIREBASE_API_KEY: string;
      REACT_APP_FIREBASE_AUTH_DOMAIN: string;
      REACT_APP_FIREBASE_PROJECT_ID: string;
      REACT_APP_FIREBASE_STORAGE_BUCKET: string;
      REACT_APP_FIREBASE_MESSAGING_SENDER_ID: string;
      REACT_APP_FIREBASE_APP_ID: string;
    }
  }
}

export const APP_CONFIG = {
  name: '4-Score Fitness',
  version: '1.0.0',
  environment: process.env.NODE_ENV || 'development',
}

export const API_CONFIG = {
  baseUrl: process.env.REACT_APP_API_URL || 'http://localhost:3000',
  timeout: 10000,
  retryAttempts: 3,
}

export const FIREBASE_CONFIG = {
  apiKey: process.env.REACT_APP_FIREBASE_API_KEY,
  authDomain: process.env.REACT_APP_FIREBASE_AUTH_DOMAIN,
  projectId: process.env.REACT_APP_FIREBASE_PROJECT_ID,
  storageBucket: process.env.REACT_APP_FIREBASE_STORAGE_BUCKET,
  messagingSenderId: process.env.REACT_APP_FIREBASE_MESSAGING_SENDER_ID,
  appId: process.env.REACT_APP_FIREBASE_APP_ID,
}

export const ROUTES = {
  HOME: '/',
  LOGIN: '/login',
  REGISTER: '/register',
  FORGOT_PASSWORD: '/forgot-password',
  RESET_PASSWORD: '/reset-password',
  TERMS: '/terms',
  PRIVACY: '/privacy',
  PROFILE: '/profile',
  SETTINGS: '/settings',
  
  // Core feature routes
  FORGE: {
    ROOT: '/forge',
    WORKOUT: '/forge/workout',
    HISTORY: '/forge/history',
    PROGRAMS: '/forge/programs'
  },
  OPTIMIZE: {
    ROOT: '/optimize',
    NUTRITION: '/optimize/nutrition',
    MEAL_PLAN: '/optimize/meal-plan',
    TRACKING: '/optimize/tracking'
  },
  RECOVER: {
    ROOT: '/recover',
    SLEEP: '/recover/sleep',
    STRESS: '/recover/stress',
    MOBILITY: '/recover/mobility'
  },
  UNITE: {
    ROOT: '/unite',
    COMMUNITY: '/unite/community',
    CHALLENGES: '/unite/challenges',
    LEADERBOARD: '/unite/leaderboard'
  }
} as const;

export const AUTH_CONFIG = {
  tokenKey: '4score_auth_token',
  refreshTokenKey: '4score_refresh_token',
  tokenExpiry: 3600, // 1 hour
  sessionTimeout: 1800, // 30 minutes
}

export const WORKOUT_CONFIG = {
  maxSets: 10,
  restTimers: {
    short: 60,
    medium: 90,
    long: 120,
  },
  difficultyLevels: ['beginner', 'intermediate', 'advanced'] as const,
}

export const NOTIFICATION_TYPES = {
  SUCCESS: 'success',
  ERROR: 'error',
  WARNING: 'warning',
  INFO: 'info',
} as const;

export const FILE_CONFIG = {
  maxSize: 5 * 1024 * 1024, // 5MB
  allowedTypes: ['image/jpeg', 'image/png', 'image/gif', 'video/mp4'] as const,
  uploadPath: 'uploads/',
}

export const CACHE_CONFIG = {
  ttl: 3600, // 1 hour
  prefix: '4score_cache_',
  version: '1',
}
