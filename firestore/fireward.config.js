/**
 * Fireward configuration file for 4-Score Fitness app
 * Defines Firestore security rules in a type-safe manner
 */

// Define types
const types = `
// User profile type
type UserProfile {
  userId: string;
  displayName: string;
  email: string;
  photoUrl?: string;
  height?: string;
  weight?: string;
  fitnessGoal?: string;
  createdAt: timestamp;
  updatedAt: timestamp;
}

// Workout type
type Workout {
  id: string;
  userId: string;
  name: string;
  description: string;
  exercises: Exercise[];
  duration: number;
  difficulty: string;
  category: string;
  createdAt: timestamp;
  updatedAt: timestamp;
}

// Exercise type
type Exercise {
  id: string;
  name: string;
  description: string;
  muscleGroups: string[];
  difficulty: string;
  instructions: string[];
  imageUrl?: string;
  videoUrl?: string;
}

// Nutrition type
type Meal {
  id: string;
  userId: string;
  name: string;
  description: string;
  foods: Food[];
  mealTime: string;
  date: timestamp;
  createdAt: timestamp;
  updatedAt: timestamp;
}

// Food type
type Food {
  id: string;
  name: string;
  calories: number;
  protein: number;
  carbs: number;
  fat: number;
  servingSize: string;
  servings: number;
}

// Social post type
type SocialPost {
  id: string;
  userId: string;
  content: string;
  imageUrl?: string;
  likes: number;
  comments: number;
  createdAt: timestamp;
  updatedAt: timestamp;
}

// Comment type
type Comment {
  id: string;
  postId: string;
  userId: string;
  content: string;
  createdAt: timestamp;
  updatedAt: timestamp;
}

// Recovery activity type
type RecoveryActivity {
  id: string;
  userId: string;
  name: string;
  description: string;
  category: string;
  date: string;
  duration: string;
  rating: number;
  notes?: string;
  createdAt: timestamp;
  updatedAt: timestamp;
}

// Sleep data type
type SleepData {
  id: string;
  userId: string;
  date: timestamp;
  bedtime: timestamp;
  wakeTime: timestamp;
  duration: number;
  quality: number;
  notes?: string;
  createdAt: timestamp;
  updatedAt: timestamp;
}
`;

// Define rules
const rules = `
// Allow read/write to authenticated users only
match /users/{userId} {
  allow read: if request.auth != null && request.auth.uid == userId;
  allow write: if request.auth != null && request.auth.uid == userId;
}

// User profiles
match /userProfiles/{userId} {
  allow read: if request.auth != null && request.auth.uid == userId;
  allow write: if request.auth != null && request.auth.uid == userId;
}

// Workouts
match /workouts/{workoutId} {
  allow read: if request.auth != null;
  allow write: if request.auth != null && request.auth.uid == resource.data.userId;
}

// Exercises
match /exercises/{exerciseId} {
  allow read: if request.auth != null;
  allow write: if request.auth != null && request.auth.token.admin == true;
}

// Meals
match /meals/{mealId} {
  allow read: if request.auth != null && request.auth.uid == resource.data.userId;
  allow write: if request.auth != null && request.auth.uid == resource.data.userId;
}

// Social posts
match /socialPosts/{postId} {
  allow read: if request.auth != null;
  allow create: if request.auth != null && request.auth.uid == request.resource.data.userId;
  allow update, delete: if request.auth != null && request.auth.uid == resource.data.userId;
}

// Comments
match /comments/{commentId} {
  allow read: if request.auth != null;
  allow create: if request.auth != null && request.auth.uid == request.resource.data.userId;
  allow update, delete: if request.auth != null && request.auth.uid == resource.data.userId;
}

// Recovery activities
match /recoveryActivities/{activityId} {
  allow read: if request.auth != null && request.auth.uid == resource.data.userId;
  allow write: if request.auth != null && request.auth.uid == resource.data.userId;
}

// Sleep data
match /sleepData/{dataId} {
  allow read: if request.auth != null && request.auth.uid == resource.data.userId;
  allow write: if request.auth != null && request.auth.uid == resource.data.userId;
}
`;

module.exports = {
  types,
  rules,
  firestore: {
    rules: {
      source: rules,
      target: './firestore.rules',
    },
  },
};
