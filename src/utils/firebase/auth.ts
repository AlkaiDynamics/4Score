import {
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  signOut,
  sendPasswordResetEmail,
  updateProfile,
  onAuthStateChanged,
  User
} from '@firebase/auth';
import { auth } from './config';

export interface AuthError {
  code: string;
  message: string;
  visual: string; // User-friendly error message
}

// Helper function to get user-friendly error messages
const getVisualErrorMessage = (code: string): string => {
  switch (code) {
    case 'auth/user-not-found':
      return 'No account found with this email. Please check your email or create a new account.';
    case 'auth/wrong-password':
      return 'Incorrect password. Please try again or reset your password.';
    case 'auth/email-already-in-use':
      return 'An account already exists with this email. Please try logging in instead.';
    case 'auth/weak-password':
      return 'Password is too weak. Please use at least 8 characters with numbers and symbols.';
    case 'auth/network-request-failed':
      return 'Network error. Please check your internet connection and try again.';
    case 'auth/too-many-requests':
      return 'Too many attempts. Please wait a few minutes before trying again.';
    default:
      return 'An error occurred. Please try again later.';
  }
};

// Register new user
export const registerUser = async (
  email: string,
  password: string,
  displayName: string
): Promise<User | AuthError> => {
  try {
    const userCredential = await createUserWithEmailAndPassword(auth, email, password);
    await updateProfile(userCredential.user, { displayName });
    return userCredential.user;
  } catch (error: any) {
    return {
      code: error.code,
      message: error.message,
      visual: getVisualErrorMessage(error.code)
    };
  }
};

// Login user
export const loginUser = async (
  email: string,
  password: string
): Promise<User | AuthError> => {
  try {
    const userCredential = await signInWithEmailAndPassword(auth, email, password);
    return userCredential.user;
  } catch (error: any) {
    return {
      code: error.code,
      message: error.message,
      visual: getVisualErrorMessage(error.code)
    };
  }
};

// Logout user
export const logoutUser = async (): Promise<void | AuthError> => {
  try {
    await signOut(auth);
  } catch (error: any) {
    return {
      code: error.code,
      message: error.message,
      visual: getVisualErrorMessage(error.code)
    };
  }
};

// Reset password
export const resetPassword = async (email: string): Promise<void | AuthError> => {
  try {
    await sendPasswordResetEmail(auth, email);
  } catch (error: any) {
    return {
      code: error.code,
      message: error.message,
      visual: getVisualErrorMessage(error.code)
    };
  }
};

// Auth state observer
export const subscribeToAuthChanges = (callback: (user: User | null) => void) => {
  return onAuthStateChanged(auth, callback);
};
