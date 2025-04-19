import React, { useState } from 'react';
import styled from 'styled-components';
import { Link, useNavigate } from 'react-router-dom';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import Card from '../../components/shared/Card';
import Input from '../../components/shared/Input';
import Button from '../../components/shared/Button';
import { ROUTES } from '../../config/constants';
import { loginUser, AuthError } from '../../utils/firebase/auth';
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

const RememberMeContainer = styled.div`
  display: flex;
  align-items: center;
  gap: ${({ theme }) => theme.spacing.sm};
  margin-top: ${({ theme }) => theme.spacing.sm};
`;

const Checkbox = styled.input`
  accent-color: ${({ theme }) => theme.colors.primary.navy};
`;

const Login: React.FC = () => {
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  const validationSchema = Yup.object({
    email: Yup.string()
      .email('Please enter a valid email address')
      .required('Email is required'),
    password: Yup.string()
      .required('Password is required')
      .min(8, 'Password must be at least 8 characters')
  });

  const formik = useFormik({
    initialValues: {
      email: '',
      password: '',
      rememberMe: false
    },
    validationSchema,
    onSubmit: async (values) => {
      setLoading(true);
      setError(null);

      try {
        const result = await loginUser(values.email, values.password);
        
        if ('code' in result) {
          const authError = result as AuthError;
          setError(authError.visual);
        } else {
          // Login successful
          if (values.rememberMe) {
            localStorage.setItem('rememberMe', 'true');
          }
          navigate(ROUTES.HOME);
        }
      } catch (err) {
        setError('An unexpected error occurred. Please try again.');
      } finally {
        setLoading(false);
      }
    }
  });

  return (
    <AuthContainer>
      <AuthCard>
        <Form onSubmit={formik.handleSubmit} noValidate>
          <Title>Welcome Back</Title>
          
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

          <RememberMeContainer>
            <Checkbox
              type="checkbox"
              id="rememberMe"
              name="rememberMe"
              checked={formik.values.rememberMe}
              onChange={formik.handleChange}
            />
            <label htmlFor="rememberMe">Remember me</label>
          </RememberMeContainer>

          <Button
            type="submit"
            disabled={loading || !formik.isValid}
            aria-busy={loading}
          >
            {loading ? 'Signing in...' : 'Sign In'}
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

          <LinkText to={ROUTES.FORGOT_PASSWORD}>
            Forgot your password?
          </LinkText>

          <LinkText to={ROUTES.REGISTER}>
            Don't have an account? Sign up
          </LinkText>
        </Form>
      </AuthCard>
    </AuthContainer>
  );
};

export default Login;
