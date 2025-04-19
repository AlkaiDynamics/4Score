/**
 * Email validator module
 * Extracted from our authentication logic for testing
 */

/**
 * Validates an email address format
 * @param {string} email - The email address to validate
 * @returns {boolean} - Whether the email is valid
 */
function validateEmail(email) {
  if (!email || email.length === 0) return false;
  
  // This pattern matches the one used in our Kotlin LoginViewModel
  const emailPattern = /[a-zA-Z0-9+._%\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\-]{0,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{0,25})+/;
  return emailPattern.test(email);
}

module.exports = {
  validateEmail
};
