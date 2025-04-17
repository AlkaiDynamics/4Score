/**
 * Jest setup file for 4-Score Fitness app
 * Configures Firebase to use emulators during testing
 */

// Import Firebase
const firebase = require('firebase/app');
require('firebase/auth');
require('firebase/firestore');
require('firebase/storage');

// Mock implementation for firebase
jest.mock('firebase/app', () => {
  const firebaseMock = {
    initializeApp: jest.fn(),
    apps: [],
    auth: jest.fn(() => ({
      signInWithEmailAndPassword: jest.fn(),
      createUserWithEmailAndPassword: jest.fn(),
      signOut: jest.fn(),
      onAuthStateChanged: jest.fn(),
      currentUser: null,
      sendPasswordResetEmail: jest.fn(),
    })),
    firestore: jest.fn(() => ({
      collection: jest.fn(() => ({
        doc: jest.fn(() => ({
          get: jest.fn(),
          set: jest.fn(),
          update: jest.fn(),
          delete: jest.fn(),
        })),
        where: jest.fn(() => ({
          get: jest.fn(),
        })),
        add: jest.fn(),
        get: jest.fn(),
      })),
    })),
    storage: jest.fn(() => ({
      ref: jest.fn(() => ({
        put: jest.fn(),
        getDownloadURL: jest.fn(),
        delete: jest.fn(),
      })),
    })),
  };
  return firebaseMock;
});

// Initialize Firebase with test configuration
const firebaseConfig = {
  apiKey: 'test-api-key',
  authDomain: 'test-auth-domain',
  projectId: 'test-project-id',
  storageBucket: 'test-storage-bucket',
  messagingSenderId: 'test-messaging-sender-id',
  appId: 'test-app-id',
  measurementId: 'test-measurement-id',
};

// Initialize Firebase if not already initialized
if (!firebase.apps.length) {
  firebase.initializeApp(firebaseConfig);
}

// Configure Firebase to use emulators
if (process.env.NODE_ENV === 'test') {
  // Auth emulator
  firebase.auth().useEmulator('http://localhost:9099');
  
  // Firestore emulator
  firebase.firestore().useEmulator('localhost', 8080);
  
  // Storage emulator
  firebase.storage().useEmulator('localhost', 9199);
}

// Global test setup
beforeEach(() => {
  // Clear all mocks before each test
  jest.clearAllMocks();
});

// Set up additional global test utilities
global.fetch = jest.fn();

// Add custom matchers if needed
expect.extend({
  // Add custom matchers here
});
