// User Types
export interface User {
  id: string;
  email: string;
  username: string;
  profile: UserProfile;
  preferences: UserPreferences;
  stats: UserStats;
  subscriptionTier: SubscriptionTier;
}

export interface UserProfile {
  firstName: string;
  lastName: string;
  avatar?: string;
  bio?: string;
  location?: string;
  joinDate: Date;
}

export interface NotificationSettings {
  email: boolean;
  push: boolean;
  workout: boolean;
  social: boolean;
  marketing: boolean;
}

export interface PrivacySettings {
  profileVisibility: 'public' | 'friends' | 'private';
  activitySharing: boolean;
  locationSharing: boolean;
}

export interface UserPreferences {
  notifications: NotificationSettings;
  privacy: PrivacySettings;
  theme: 'light' | 'dark';
  units: 'imperial' | 'metric';
}

export interface UserStats {
  workoutsCompleted: number;
  totalTime: number;
  streakDays: number;
  level: number;
  experience: number;
}

// F.O.U.R. Framework Types
export interface WorkoutSchedule {
  frequency: number;
  days: ('monday' | 'tuesday' | 'wednesday' | 'thursday' | 'friday' | 'saturday' | 'sunday')[];
  preferredTime?: string;
  duration: number;
}

export interface WorkoutPlan {
  id: string;
  userId: string;
  name: string;
  description?: string;
  exercises: Exercise[];
  schedule: WorkoutSchedule;
  difficulty: 'beginner' | 'intermediate' | 'advanced';
  estimatedDuration: number;
}

export interface Exercise {
  id: string;
  name: string;
  type: ExerciseType;
  sets: ExerciseSet[];
  notes?: string;
  formVideo?: string;
}

export interface ExerciseSet {
  reps: number;
  weight?: number;
  duration?: number;
  restTime: number;
}

export interface Meal {
  id: string;
  name: string;
  ingredients: string[];
  nutrients: MacroTargets;
  calories: number;
  prepTime: number;
  cookTime: number;
}

export interface MacroTargets {
  protein: number;
  carbs: number;
  fats: number;
  fiber: number;
}

export type DietaryRestriction = 
  | 'vegetarian'
  | 'vegan'
  | 'gluten-free'
  | 'dairy-free'
  | 'keto'
  | 'paleo';

export interface NutritionPlan {
  id: string;
  userId: string;
  meals: Meal[];
  macros: MacroTargets;
  calories: number;
  restrictions: DietaryRestriction[];
}

export interface SocialConnection {
  id: string;
  userId: string;
  connectionId: string;
  type: 'friend' | 'coach' | 'teammate';
  status: 'pending' | 'accepted' | 'blocked';
  since: Date;
}

export interface RecoveryLog {
  id: string;
  userId: string;
  date: Date;
  sleepDuration: number;
  sleepQuality: number;
  stressLevel: number;
  notes?: string;
}

// Feature Types
export interface Reward {
  id: string;
  type: 'badge' | 'points' | 'achievement';
  name: string;
  description: string;
  value?: number;
  icon?: string;
}

export interface Challenge {
  id: string;
  name: string;
  description: string;
  type: ChallengeType;
  startDate: Date;
  endDate: Date;
  participants: string[];
  rewards: Reward[];
}

export interface Interval {
  duration: number;
  type: 'work' | 'rest';
  intensity?: 'low' | 'medium' | 'high';
}

export interface Timer {
  id: string;
  type: 'workout' | 'interval' | 'rest' | 'meditation';
  duration: number;
  intervals?: Interval[];
}

export interface Metric {
  name: string;
  value: number;
  unit: string;
  timestamp: Date;
}

export interface Analytics {
  userId: string;
  period: 'day' | 'week' | 'month' | 'year';
  metrics: Metric[];
}

// Enum Types
export enum ExerciseType {
  Strength = 'strength',
  Cardio = 'cardio',
  Flexibility = 'flexibility',
  Balance = 'balance'
}

export enum SubscriptionTier {
  Free = 'free',
  Premium = 'premium',
  Elite = 'elite'
}

export enum ChallengeType {
  Individual = 'individual',
  Team = 'team',
  Global = 'global'
}

// Utility Types
export type ID = string;
export type Timestamp = number;
export type ImageUrl = string;
export type VideoUrl = string;
