import React, { useState } from 'react';
import styled from 'styled-components';
import { Link, useNavigate } from 'react-router-dom';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import Card from '../../components/shared/Card';
import Input from '../../components/shared/Input';
import Button from '../../components/shared/Button';
import { ROUTES } from '../../config/constants';
import { registerUser, AuthError } from '../../utils/firebase/auth';
import { motion, AnimatePresence } from 'framer-motion';

const AuthContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  padding: ${({ theme }) => theme.spacing.lg};
  background-color: ${({ theme }) => theme.colors.background.dark};
`;

const AuthCard = styled(Card)`
  width: 100%;
  max-width: 400px;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
  gap: ${({ theme }) => theme.spacing.md};
`;

const Title = styled.h1`
  font-family: ${({ theme }) => theme.typography.fontFamilies.heading};
  font-size: ${({ theme }) => theme.typography.fontSize['2xl']};
  color: ${({ theme }) => theme.colors.text.primary};
  margin-bottom: ${({ theme }) => theme.spacing.lg};
  text-align: center;
`;

const LinkText = styled(Link)`
  color: ${({ theme }) => theme.colors.primary.navy};
  text-decoration: none;
  text-align: center;
  margin-top: ${({ theme }) => theme.spacing.md};
  
  &:hover {
    text-decoration: underline;
  }
`;

const ErrorMessage = styled(motion.div)`
  color: ${({ theme }) => theme.colors.error};
  background-color: ${({ theme }) => theme.colors.error}20;
  padding: ${({ theme }) => theme.spacing.sm};
  border-radius: ${({ theme }) => theme.borderRadius.sm};
  text-align: center;
  margin-top: ${({ theme }) => theme.spacing.sm};
`;

const PasswordToggle = styled.button`
  background: none;
  border: none;
  color: ${({ theme }) => theme.colors.text.secondary};
  cursor: pointer;
  position: absolute;
  right: ${({ theme }) => theme.spacing.md};
  top: 50%;
  transform: translateY(-50%);
  padding: ${({ theme }) => theme.spacing.xs};
  
  &:hover {
    color: ${({ theme }) => theme.colors.text.primary};
  }
`;

const PasswordStrength = styled.div<{ strength: number }>`
  height: 4px;
  background: ${({ theme, strength }) => {
    if (strength === 0) return theme.colors.error;
    if (strength === 1) return theme.colors.warning;
    if (strength === 2) return theme.colors.success;
    return theme.colors.text.secondary;
  }};
  width: ${({ strength }) => (strength + 1) * 33.33}%;
  transition: all 0.3s ease;
  border-radius: ${({ theme }) => theme.borderRadius.sm};
`;

const PasswordStrengthText = styled.span`
  font-size: ${({ theme }) => theme.typography.fontSize.sm};
  color: ${({ theme }) => theme.colors.text.secondary};
`;

const TermsContainer = styled.div`
  display: flex;
  align-items: flex-start;
  gap: ${({ theme }) => theme.spacing.sm};
  margin-top: ${({ theme }) => theme.spacing.md};
`;

const Checkbox = styled.input`
  accent-color: ${({ theme }) => theme.colors.primary.navy};
  margin-top: 4px;
`;

const TermsText = styled.label`
  font-size: ${({ theme }) => theme.typography.fontSize.sm};
  color: ${({ theme }) => theme.colors.text.secondary};
  
  a {
    color: ${({ theme }) => theme.colors.primary.navy};
    text-decoration: none;
    
    &:hover {
      text-decoration: underline;
    }
  }
`;

const Register: React.FC = () => {
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  const calculatePasswordStrength = (password: string): number => {
    if (!password) return -1;
    let strength = 0;
    if (password.length >= 8) strength++;
    if (/[A-Z]/.test(password) && /[a-z]/.test(password)) strength++;
    if (/[0-9]/.test(password) || /[^A-Za-z0-9]/.test(password)) strength++;
    return strength;
  };

  const validationSchema = Yup.object({
    name: Yup.string()
      .required('Name is required')
      .min(2, 'Name must be at least 2 characters'),
    email: Yup.string()
      .email('Please enter a valid email address')
      .required('Email is required'),
    password: Yup.string()
      .required('Password is required')
      .min(8, 'Password must be at least 8 characters')
      .matches(/[A-Z]/, 'Password must contain at least one uppercase letter')
      .matches(/[a-z]/, 'Password must contain at least one lowercase letter')
      .matches(/[0-9]/, 'Password must contain at least one number'),
    confirmPassword: Yup.string()
      .oneOf([Yup.ref('password')], 'Passwords must match')
      .required('Please confirm your password'),
    terms: Yup.boolean()
      .oneOf([true], 'You must accept the terms and conditions')
  });

  const formik = useFormik({
    initialValues: {
      name: '',
      email: '',
      password: '',
      confirmPassword: '',
      terms: false
    },
    validationSchema,
    onSubmit: async (values) => {
      setLoading(true);
      setError(null);

      try {
        const result = await registerUser(values.email, values.password, values.name);
        
        if ('code' in result) {
          const authError = result as AuthError;
          setError(authError.visual);
        } else {
          // Registration successful
          navigate(ROUTES.HOME);
        }
      } catch (err) {
        setError('An unexpected error occurred. Please try again.');
      } finally {
        setLoading(false);
      }
    }
  });

  const passwordStrength = calculatePasswordStrength(formik.values.password);

  return (
    <AuthContainer>
      <AuthCard>
        <Form onSubmit={formik.handleSubmit} noValidate>
          <Title>Create Account</Title>
          
          <Input
            type="text"
            name="name"
            placeholder="Full Name"
            value={formik.values.name}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.name ? formik.errors.name : undefined}
            disabled={loading}
            aria-label="Full name"
          />

          <Input
            type="email"
            name="email"
            placeholder="Email"
            value={formik.values.email}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.email ? formik.errors.email : undefined}
            disabled={loading}
            aria-label="Email address"
          />

          <div style={{ position: 'relative' }}>
            <Input
              type={showPassword ? 'text' : 'password'}
              name="password"
              placeholder="Password"
              value={formik.values.password}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={formik.touched.password ? formik.errors.password : undefined}
              disabled={loading}
              aria-label="Password"
            />
            <PasswordToggle
              type="button"
              onClick={() => setShowPassword(!showPassword)}
              aria-label={showPassword ? 'Hide password' : 'Show password'}
            >
              {showPassword ? '👁️' : '👁️‍🗨️'}
            </PasswordToggle>
          </div>

          {formik.values.password && (
            <>
              <PasswordStrength strength={passwordStrength} />
              <PasswordStrengthText>
                Password strength: {' '}
                {passwordStrength === 0 && 'Weak'}
                {passwordStrength === 1 && 'Medium'}
                {passwordStrength === 2 && 'Strong'}
              </PasswordStrengthText>
            </>
          )}

          <Input
            type={showPassword ? 'text' : 'password'}
            name="confirmPassword"
            placeholder="Confirm Password"
            value={formik.values.confirmPassword}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.confirmPassword ? formik.errors.confirmPassword : undefined}
            disabled={loading}
            aria-label="Confirm password"
          />

          <TermsContainer>
            <Checkbox
              type="checkbox"
              id="terms"
              name="terms"
              checked={formik.values.terms}
              onChange={formik.handleChange}
            />
            <TermsText htmlFor="terms">
              I agree to the <Link to={ROUTES.TERMS}>Terms of Service</Link> and{' '}
              <Link to={ROUTES.PRIVACY}>Privacy Policy</Link>
            </TermsText>
          </TermsContainer>

          <Button
            type="submit"
            disabled={loading || !formik.isValid}
            aria-busy={loading}
          >
            {loading ? 'Creating Account...' : 'Create Account'}
          </Button>

          <AnimatePresence>
            {error && (
              <ErrorMessage
                initial={{ opacity: 0, y: -10 }}
                animate={{ opacity: 1, y: 0 }}
                exit={{ opacity: 0, y: -10 }}
                role="alert"
              >
                {error}
              </ErrorMessage>
            )}
          </AnimatePresence>

          <LinkText to={ROUTES.LOGIN}>
            Already have an account? Sign in
          </LinkText>
        </Form>
      </AuthCard>
    </AuthContainer>
  );
};

export default Register;
