/**
 * Email Validator Test
 * 
 * This test focuses on validating the email format logic used in our authentication system.
 * Following the one-test-at-a-time approach for systematic testing.
 */

// Email validation function that mirrors our Kotlin implementation
function validateEmail(email) {
  if (!email || email.length === 0) return false;
  
  const emailPattern = /[a-zA-Z0-9+._%\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\-]{0,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{0,25})+/;
  return emailPattern.test(email);
}

describe('Email Validator', () => {
  test('validates correct email formats', () => {
    // Valid email addresses should pass validation
    expect(validateEmail('user@example.com')).toBe(true);
    expect(validateEmail('user.name@example.com')).toBe(true);
    expect(validateEmail('user+tag@example.com')).toBe(true);
    expect(validateEmail('user-name@example.co.uk')).toBe(true);
  });

  test('rejects incorrect email formats', () => {
    // Invalid email addresses should fail validation
    expect(validateEmail('')).toBe(false);
    expect(validateEmail('userexample.com')).toBe(false);
    expect(validateEmail('user@')).toBe(false);
    expect(validateEmail('@example.com')).toBe(false);
    expect(validateEmail('user@example')).toBe(false);
  });
});
