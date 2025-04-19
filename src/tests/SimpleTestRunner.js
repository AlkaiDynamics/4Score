/**
 * Simple Test Runner
 * 
 * This is a basic test runner that can execute simple tests without requiring
 * the full Android build system. It follows our accessibility-first approach
 * by providing clear visual feedback and step-by-step execution.
 */

// Email validation test
console.log('RUNNING TEST: Email Validation');
console.log('----------------------------');

// Email validation pattern (extracted from LoginViewModel)
const emailPattern = /[a-zA-Z0-9+._%\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\-]{0,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{0,25})+/;

/**
 * Validate email format
 */
function validateEmail(email) {
  return email && email.length > 0 && emailPattern.test(email);
}

// Test valid emails
const validEmails = [
  'user@example.com',
  'user.name@example.com',
  'user+tag@example.com',
  'user-name@example.co.uk'
];

console.log('Testing valid emails:');
let allValid = true;
validEmails.forEach(email => {
  const isValid = validateEmail(email);
  console.log(`  ${email}: ${isValid ? '✓ PASS' : '✗ FAIL'}`);
  if (!isValid) allValid = false;
});

if (allValid) {
  console.log('✓ All valid emails passed validation');
} else {
  console.log('✗ Some valid emails failed validation');
}

// Test invalid emails
const invalidEmails = [
  '',                  // Empty string
  'userexample.com',   // Missing @
  'user@',             // Missing domain
  '@example.com',      // Missing username
  'user@example'       // Missing TLD
];

console.log('\nTesting invalid emails:');
let allInvalid = true;
invalidEmails.forEach(email => {
  const isValid = validateEmail(email);
  console.log(`  ${email}: ${!isValid ? '✓ PASS' : '✗ FAIL'}`);
  if (isValid) allInvalid = false;
});

if (allInvalid) {
  console.log('✓ All invalid emails correctly failed validation');
} else {
  console.log('✗ Some invalid emails incorrectly passed validation');
}

// Overall test result
console.log('\nTEST RESULT:');
if (allValid && allInvalid) {
  console.log('✓ PASS - Email validation is working correctly');
} else {
  console.log('✗ FAIL - Email validation has issues that need to be fixed');
}

// Password strength test
console.log('\n\nRUNNING TEST: Password Strength');
console.log('----------------------------');

// Password strength levels (matching our Kotlin enum)
const PasswordStrength = {
  WEAK: 'WEAK',
  MEDIUM: 'MEDIUM',
  STRONG: 'STRONG',
  VERY_STRONG: 'VERY_STRONG'
};

/**
 * Calculate password strength based on complexity
 * This matches the logic in RegisterViewModel
 */
function calculatePasswordStrength(password) {
  if (!password || password.length === 0) return PasswordStrength.WEAK;
  
  let score = 0;
  
  // Length check
  if (password.length >= 8) score++;
  if (password.length >= 12) score++;
  
  // Character variety checks
  if (/\d/.test(password)) score++; // Has digit
  if (/[a-z]/.test(password)) score++; // Has lowercase
  if (/[A-Z]/.test(password)) score++; // Has uppercase
  if (/[^a-zA-Z0-9]/.test(password)) score++; // Has special char
  
  // Debug output to help diagnose the issue
  console.log(`  [Debug] Password: "${password}", Score: ${score}`);
  
  if (score <= 2) return PasswordStrength.WEAK;
  if (score <= 4) return PasswordStrength.MEDIUM;
  if (score < 6) return PasswordStrength.STRONG;
  return PasswordStrength.VERY_STRONG;
}

// Test weak passwords
const weakPasswords = [
  '',                // Empty
  'pass',            // Too short
  '12345678',        // Only digits, but long enough
  'abcdefgh'         // Only lowercase, but long enough
];

console.log('Testing weak passwords:');
let allWeak = true;
weakPasswords.forEach(password => {
  const strength = calculatePasswordStrength(password);
  const isWeak = strength === PasswordStrength.WEAK;
  console.log(`  "${password}": ${strength} ${isWeak ? '✓ PASS' : '✗ FAIL'}`);
  if (!isWeak) allWeak = false;
});

// Test medium passwords
const mediumPasswords = [
  'Password1',       // Uppercase, lowercase, and digit
  'abcdef123',       // Lowercase and digits
  'ABCDEF123',       // Uppercase and digits
  'Abcdefgh'         // Uppercase and lowercase
];

console.log('\nTesting medium passwords:');
let allMedium = true;
mediumPasswords.forEach(password => {
  const strength = calculatePasswordStrength(password);
  const isMedium = strength === PasswordStrength.MEDIUM;
  console.log(`  "${password}": ${strength} ${isMedium ? '✓ PASS' : '✗ FAIL'}`);
  if (!isMedium) allMedium = false;
});

// Test strong passwords
const strongPasswords = [
  'Password1!',          // Upper, lower, digit, symbol
  'Abcdef123!',          // Upper, lower, digit, symbol
  'SuperSecurePass1',    // Upper, lower, digit, and 12+ chars
  'abcdefgh123!'         // Lower, digit, symbol, and 12+ chars
];

console.log('\nTesting strong passwords:');
let allStrong = true;
strongPasswords.forEach(password => {
  const strength = calculatePasswordStrength(password);
  const isStrong = strength === PasswordStrength.STRONG;
  console.log(`  "${password}": ${strength} ${isStrong ? '✓ PASS' : '✗ FAIL'}`);
  if (!isStrong) allStrong = false;
});

// Test very strong passwords
const veryStrongPasswords = [
  'SuperSecurePass1!@#',     // Upper, lower, digit, symbol, and 12+ chars
  'This1sAVeryStr0ng!Pass',  // Upper, lower, digit, symbol, and 12+ chars
  'P@ssw0rd123!SECURE',      // Upper, lower, digit, symbol, and 12+ chars
  'Abcdefg12345!@#$%'        // Upper, lower, digit, symbol, and 12+ chars
];

console.log('\nTesting very strong passwords:');
let allVeryStrong = true;
veryStrongPasswords.forEach(password => {
  const strength = calculatePasswordStrength(password);
  const isVeryStrong = strength === PasswordStrength.VERY_STRONG;
  console.log(`  "${password}": ${strength} ${isVeryStrong ? '✓ PASS' : '✗ FAIL'}`);
  if (!isVeryStrong) allVeryStrong = false;
});

// Overall test result
console.log('\nTEST RESULT:');
if (allWeak && allMedium && allStrong && allVeryStrong) {
  console.log('✓ PASS - Password strength calculation is working correctly');
} else {
  console.log('✗ FAIL - Password strength calculation has issues that need to be fixed');
  
  if (!allWeak) console.log('  - Issues with weak password detection');
  if (!allMedium) console.log('  - Issues with medium password detection');
  if (!allStrong) console.log('  - Issues with strong password detection');
  if (!allVeryStrong) console.log('  - Issues with very strong password detection');
}

// Overall test summary
console.log('\n\nTEST SUMMARY');
console.log('============');
console.log(`Email Validation: ${allValid && allInvalid ? '✓ PASS' : '✗ FAIL'}`);
console.log(`Password Strength: ${allWeak && allMedium && allStrong && allVeryStrong ? '✓ PASS' : '✗ FAIL'}`);
